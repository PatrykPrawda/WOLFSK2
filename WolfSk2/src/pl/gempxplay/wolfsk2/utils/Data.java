package pl.gempxplay.wolfsk2.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import pl.gempxplay.wolfsk2.WolfSk2;

import java.awt.image.BufferedImage;
import java.io.File;

public class Data {

    public static String motd;
    public static BufferedImage iconImage;
    public static File iconFile;
    public static Integer fakeMaxPlayers;

    public static boolean doc;
    public static boolean debug;
    public static boolean mcstats;
    public static String lang;
    public static boolean useIDs;
    public static boolean notifyUpdate;

    private static File CFG = new File(WolfSk2.plugin.getDataFolder(), "config.yml");

    public static void load() {
        loadConfig();
    }

    private static void loadConfig() {
        loadDefaultFiles(new String[]{ "config.yml" });
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(CFG);

        //doc = yaml.getBoolean("doc");
        //mcstats = yaml.getBoolean("mcstats-enable");
        //debug = yaml.getBoolean("debug");
        lang = yaml.getString("language");

        //WolfSk.debug = debug;
        //WolfSk.lang = lang;
        //WolfSk.useIDs = useIDs;
        //WolfSk.notifyUpdate = notifyUpdate;
    }

    public static void loadDefaultFiles(String[] names) {
        for (String name : names) {
            File file = new File(WolfSk2.plugin.getDataFolder() + File.separator + name);
            if (!file.exists()) {
                WolfSk2.plugin.saveResource(name, true);
            }
        }
    }

}