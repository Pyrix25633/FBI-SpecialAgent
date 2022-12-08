package net.pyrix25633.fbi.resource;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.component.IdentifiableComponent;
import net.pyrix25633.fbi.component.IdentifiableGUIComponent;
import net.pyrix25633.fbi.component.TextComponent;
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
    public static final String POSITION = "position", HIT_BOX = "hitBox", POSITION_RELATIVE_TO = "positionRelativeTo",
            TYPE = "type", TEXTURE = "texture", TEXT = "text";
    public static final String X = "x", Y = "y", HEIGHT = "height", WIDTH = "width";
    public static final String COMPONENTS = "components", STARTING_POSITION = "startingPosition";

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
            String type;
            try {type = json.getString(TYPE);}
            catch(Exception ignored) {type = "";}
            UUID uuid = UUID.fromString(key);
            Position.Float position = Position.Float.fromJSON(json.getJSONObject(POSITION));
            HitBox.Float hitBox = HitBox.Float.fromJSON(json.getJSONObject(HIT_BOX));
            PositionRelativeTo positionRelativeTo = PositionRelativeTo.fromJSON(json.getJSONObject(POSITION_RELATIVE_TO));
            Main.client.getWindow().add(switch(type) {
                case TEXT -> new TextComponent(uuid, position, hitBox, positionRelativeTo, json.getString(TEXT));
                default -> new IdentifiableGUIComponent(uuid, position, hitBox, positionRelativeTo,
                        new Texture(getImage(json.getString(TEXTURE))));
            });
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
        JSONObject startingPosition = object.getJSONObject(STARTING_POSITION);
        JSONObject components = object.getJSONObject(COMPONENTS);
        components.keySet().forEach(key -> {
            JSONObject json = components.getJSONObject(key);
            Main.server.getWorld().add(new IdentifiableComponent(UUID.fromString(key),
                    Position.Float.fromJSON(json.getJSONObject(POSITION)),
                    HitBox.Float.fromJSON(json.getJSONObject(HIT_BOX)),
                    new Texture(getImage(json.getString(TEXTURE)))));
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