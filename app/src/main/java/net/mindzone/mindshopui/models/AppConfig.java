package net.mindzone.mindshopui.models;

import java.io.Serializable;

public class AppConfig implements Serializable {
    public int offline;
    public String offlineMessage;
    public String colorPrimary;
    public String colorScheme; // It's string now, but should be changed to ThemeType. Java doesnt like "." so we need to change in firestore, but we need to change in Swift too

    @Override
    public String toString() {
        String result = offline + "," + offlineMessage + "," + colorPrimary + "," + colorScheme;
        return result;
    }

}

