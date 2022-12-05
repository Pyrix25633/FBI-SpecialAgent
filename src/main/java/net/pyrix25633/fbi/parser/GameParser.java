package net.pyrix25633.fbi.parser;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.component.GUIComponent;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;
import org.json.JSONObject;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class GameParser {
    private static final String POSKEY = "position", HBKEY = "hitBox", PRTKEY = "positionRelativeTo";
    private static final String XKEY = "x", YKEY = "y", HKEY = "height", WKEY = "width";

    /**
     * Constructor
     */
    public GameParser() {}

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
            content.append(line);
        }
        JSONObject object = new JSONObject(content.toString());
        Main.gameClient.getWindow().empty();
        object.keySet().forEach(key -> {
            JSONObject json = object.getJSONObject(key);
            JSONObject pos = json.getJSONObject(POSKEY);
            JSONObject hb = json.getJSONObject(HBKEY);
            JSONObject prt = json.getJSONObject(PRTKEY);
            Main.gameClient.getWindow().add(new GUIComponent(UUID.fromString(key),
                    new Position.Float(pos.getFloat(XKEY), pos.getFloat(YKEY)),
                    new HitBox.Float(hb.getFloat(WKEY), hb.getFloat(HKEY)),
                    PositionRelativeTo.X.fromString(prt.getString(XKEY)),
                    PositionRelativeTo.Y.fromString(prt.getString(YKEY))));
        });
    }
}