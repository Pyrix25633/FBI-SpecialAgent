package net.pyrix25633.fbi;

import net.pyrix25633.fbi.client.Client;
import net.pyrix25633.fbi.component.Component;
import net.pyrix25633.fbi.component.GUIComponent;
import net.pyrix25633.fbi.resource.ResourceLoader;
import net.pyrix25633.fbi.server.Server;

import java.io.IOException;
import java.util.UUID;

public class Main {
    public static Client client;
    public static Server server;
    public static ResourceLoader resourceLoader;

    /**
     * Program entrypoint
     * @param args Program arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        server = new Server();
        resourceLoader = new ResourceLoader();
        client = new Client();

        resourceLoader.loadGUI("main");
        resourceLoader.loadWorld("training");

        while(true) {
            server.processMovements();
            client.repaint();
            Thread.sleep(1000 / 60);
        }
    }

    public static UUID generateUUID(Component component) {
        return (component instanceof GUIComponent) ? client.getWindow().generateUUID() : server.generateUUID();
    }
}