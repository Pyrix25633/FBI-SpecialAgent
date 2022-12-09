package net.pyrix25633.fbi.resource;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.component.IdentifiableComponent;
import net.pyrix25633.fbi.component.IdentifiableGUIComponent;
import net.pyrix25633.fbi.component.TextComponent;
import net.pyrix25633.fbi.util.Color;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.*;
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

    private final HashMap<String, String> translations;
    private final HashMap<String, BufferedImage> images;
    private final HashMap<String, HashMap<Color, BufferedImage>> coloredImages;
    private final HashMap<Character, HashMap<Color, Texture>> charTextures;

    /**
     * Constructor
     */
    public ResourceLoader() throws IOException {
        translations = new HashMap<>();
        images = new HashMap<>();
        coloredImages = new HashMap<>();
        charTextures = new HashMap<>();
        JSONObject translationsJson = getJSONObjectFromFile("lang/translations.json");
        translationsJson.keySet().forEach(key -> {
            String t = translationsJson.getString(key);
            translations.put(key, t);
        });
        JSONObject fontJson = getJSONObjectFromFile("textures/font.json");
        fontJson.keySet().forEach(key -> {
            JSONObject charObj = fontJson.getJSONObject(key);
            Position.Integer start = Position.Integer.fromJSON(charObj);
            Position.Integer end = new Position.Integer(start.getX() + 8, start.getY() + 8);
            HashMap<Color, Texture> coloredChar = new HashMap<>();
            char v = '0';
            for(int i = 0; i < 9; i++) {
                Color color = Color.fromChar(v);
                coloredChar.put(color, new PartialTexture(getColoredImage("font", color), start, end));
                v++;
            }
            charTextures.put(key.charAt(0), coloredChar);
        });
    }

    /**
     * Method to get a <code>String</code> translation
     * @param k The <code>String</code> key
     * @return The <code>String</code> translation
     */
    public String getTranslation(String k) {
        String t = translations.get(k);
        if(t == null) t = "";
        return t;
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
     * Method to get a colored <code>BufferedImage</code>
     * @param file The name of the file, without "textures/" and ".png"
     * @param color The <code>Color</code>
     * @return The colored <code>BufferedImage</code>
     */
    public BufferedImage getColoredImage(String file, Color color) {
        HashMap<Color, BufferedImage> i = coloredImages.computeIfAbsent(file, k -> new HashMap<>());
        BufferedImage b = i.get(color);
        if(b == null) {
            b = cloneImage(getImage(file));
            replaceWhiteWithColor(b, color);
            i.put(color, b);
        }
        return b;
    }

    /**
     * Method to get a Texture of a given character
     * @param character The <code>Character</code>
     * @param color The <code>Color</code>
     * @return The <code>Texture</code>
     */
    public Texture getCharTexture(Character character, Color color) {
        return charTextures.get(character).get(color);
    }

    /**
     * Method to load a gui from a json file
     * @param file The name of the file, without "gui/" and ".json"
     * @throws IOException If file does not exist
     */
    public void loadGUI(String file) throws IOException {
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
                case TEXT -> new TextComponent(uuid, position, hitBox, positionRelativeTo, getTranslation(json.getString(TEXT)));
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
        while((line = buffered.readLine()) != null) {
            content.append(line);
        }
        return new JSONObject(content.toString());
    }

    /**
     * Method to clone a <code>BufferedImage</code>
     * @param source The <code>BufferedImage</code> source
     * @return The cloned <code>BufferedImage</code>
     */
    private BufferedImage cloneImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics2D g = b.createGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    /**
     * Method to replace all white pixels of an image
     * @param image The <code>BufferedImage</code>
     * @param color The <code>Color</code>
     */
    private void replaceWhiteWithColor(BufferedImage image, Color color) {
        for(int x = 0; x < image.getWidth(); x++) {
            for(int y = 0; y < image.getHeight(); y++) {
                if(image.getRGB(x, y) == 0xFFFFFFFF) {
                    image.setRGB(x, y, color.toRGB());
                }
            }
        }
    }
}