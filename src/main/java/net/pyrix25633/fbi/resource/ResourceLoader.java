package net.pyrix25633.fbi.resource;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.component.IdentifiableComponent;
import net.pyrix25633.fbi.component.IdentifiableGUIComponent;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class ResourceLoader {
    public static final String POSKEY = "position", HBKEY = "hitBox", PRTKEY = "positionRelativeTo";
    public static final String XKEY = "x", YKEY = "y", HKEY = "height", WKEY = "width";
    public static final String COMPKEY = "components", SPOSKEY = "startingPosition", TEXKEY = "texture";

    private final HashMap<String, BufferedImage> images;
    private final HashMap<Character, Texture> charTextures;

    /**
     * Constructor
     */
    public ResourceLoader() throws IOException {
        images = new HashMap<>();
        charTextures = new HashMap<>();
        JSONObject fontJson = getJSONObjectFromFile("textures/font.json");
        fontJson.keySet().forEach(key -> {
            JSONObject charObj = fontJson.getJSONObject(key);
            Position.Integer start = Position.Integer.fromJSON(charObj);
            Position.Integer end = new Position.Integer(start.getX() + 8, start.getY() + 8);
            charTextures.put(key.charAt(0), new PartialTexture(getImage("font"), start, end));
        });
    }

    /**
     * Method to get a <code>BufferedImage</code>
     * @param file The name of the file, without "textures/" and ".png"
     * @return The <code>BufferedImage</code>
     */
    public BufferedImage getImage(String file) {
        file = "textures/" + file + ".png";
        BufferedImage image = images.get(file);
        if(image == null) {
            try {
                image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(file)));
                images.put(file, image);
            } catch(Exception ignored) {}
        }
        return image;
    }

    /**
     * Method to get a Texture of a given character
     * @param character The <code>Character</code>
     * @return The <code>Texture</code>
     */
    public Texture getCharTexture(Character character) {
        return charTextures.get(character);
    }

    /**
     * Method to load a gui from a json file
     * @param file The name of the file, without "gui/" and ".json"
     * @throws IOException If file does not exist
     */
    public void loadGUI(String file) throws IOException {
        //TODO: TextComponent loading
        file = "gui/" + file + ".json";
        JSONObject object = getJSONObjectFromFile(file);
        Main.client.getWindow().empty();
        object.keySet().forEach(key -> {
            JSONObject json = object.getJSONObject(key);
            Main.client.getWindow().add(new IdentifiableGUIComponent(UUID.fromString(key),
                    Position.Float.fromJSON(json.getJSONObject(POSKEY)),
                    HitBox.Float.fromJSON(json.getJSONObject(HBKEY)),
                    PositionRelativeTo.fromJSON(json.getJSONObject(PRTKEY)),
                    new Texture(getImage(json.getString(TEXKEY)))));
        });
    }

    /**
     * Method to load a world from a json file
     * @param file The name of the file, without "world/" and ".json"
     * @throws IOException If file does not exist
     */
    public void loadWorld(String file) throws IOException {
        file = "world/" + file + ".json";
        JSONObject object = getJSONObjectFromFile(file);
        Main.server.getWorld().empty();
        Main.server.disconnectClient(Main.client.getConnectedClient().getUUID());
        JSONObject startingPosition = object.getJSONObject(SPOSKEY);
        JSONObject components = object.getJSONObject(COMPKEY);
        components.keySet().forEach(key -> {
            JSONObject json = components.getJSONObject(key);
            Main.server.getWorld().add(new IdentifiableComponent(UUID.fromString(key),
                    Position.Float.fromJSON(json.getJSONObject(POSKEY)),
                    HitBox.Float.fromJSON(json.getJSONObject(HBKEY)),
                    new Texture(getImage(json.getString(TEXKEY)))));
        });
        Main.client.connect();
        Main.client.getConnectedClient().getPosition().set(Position.Float.fromJSON(startingPosition));
        Main.server.getWorld().add(Main.client.getConnectedClient().getPlayer());
        Main.client.refreshHelper();
    }

    /**
     * Method to get a <code>JSONObject</code> from a file
     * @param file The file name
     * @return The <code>JSONObject</code>
     * @throws IOException If file does not exist
     */
    private JSONObject getJSONObjectFromFile(String file) throws IOException {
        FileReader reader = new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(file)).getFile());
        BufferedReader buffered = new BufferedReader(reader);
        StringBuilder content = new StringBuilder();
        String line;
        while((line = buffered.readLine()) != null){
            content.append(line.replace("  ", "").replace(": ", ":").replace(", ", ","));
        }
        return new JSONObject(content.toString());
    }
}