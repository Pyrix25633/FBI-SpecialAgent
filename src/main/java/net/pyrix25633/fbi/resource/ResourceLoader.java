package net.pyrix25633.fbi.resource;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.component.IdentifiableComponent;
import net.pyrix25633.fbi.component.IdentifiableGUIComponent;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;
import org.json.JSONObject;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class ResourceLoader {
    public static final String POSKEY = "position", HBKEY = "hitBox", PRTKEY = "positionRelativeTo";
    public static final String XKEY = "x", YKEY = "y", HKEY = "height", WKEY = "width";
    public static final String COMPKEY = "components", SPOSKEY = "startingPosition";

    /**
     * Constructor
     */
    public ResourceLoader() {}

    /**
     * Method to load a gui from a json file
     * @param file The name of the file, without "gui/" and ".json"
     * @throws IOException If file does not exist
     */
    public void loadGUI(String file) throws IOException {
        file = "gui/" + file + ".json";
        FileReader reader = new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(file)).getFile());
        BufferedReader buffered = new BufferedReader(reader);
        StringBuilder content = new StringBuilder();
        String line;
        while((line = buffered.readLine()) != null){
            content.append(line.replace("  ", "").replace(": ", ":").replace(", ", ","));
        }
        JSONObject object = new JSONObject(content.toString());
        Main.client.getWindow().empty();
        object.keySet().forEach(key -> {
            JSONObject json = object.getJSONObject(key);
            Main.client.getWindow().add(new IdentifiableGUIComponent(UUID.fromString(key),
                    Position.Float.fromJSON(json.getJSONObject(POSKEY)),
                    HitBox.Float.fromJSON(json.getJSONObject(HBKEY)),
                    PositionRelativeTo.fromJSON(json.getJSONObject(PRTKEY))));
        });
    }

    /**
     * Method to load a world from a json file
     * @param file The name of the file, without "world/" and ".json"
     * @throws IOException If file does not exist
     */
    public void loadWorld(String file) throws IOException {
        file = "world/" + file + ".json";
        FileReader reader = new FileReader(Objects.requireNonNull(getClass().getClassLoader().getResource(file)).getFile());
        BufferedReader buffered = new BufferedReader(reader);
        StringBuilder content = new StringBuilder();
        String line;
        while((line = buffered.readLine()) != null){
            content.append(line.replace("  ", "").replace(": ", ":").replace(", ", ","));
        }
        JSONObject object = new JSONObject(content.toString());
        Main.server.getWorld().empty();
        Main.server.disconnectClient(Main.client.getConnectedClient().getUUID());
        JSONObject startingPosition = object.getJSONObject(SPOSKEY);
        JSONObject components = object.getJSONObject(COMPKEY);
        components.keySet().forEach(key -> {
            JSONObject json = components.getJSONObject(key);
            Main.server.getWorld().add(new IdentifiableComponent(UUID.fromString(key),
                    Position.Float.fromJSON(json.getJSONObject(POSKEY)),
                    HitBox.Float.fromJSON(json.getJSONObject(HBKEY))));
        });
        Main.client.connect();
        Main.client.getConnectedClient().getPosition().set(Position.Float.fromJSON(startingPosition));
        Main.server.getWorld().add(Main.client.getConnectedClient().getPlayer());
        Main.client.refreshHelper();
    }
}