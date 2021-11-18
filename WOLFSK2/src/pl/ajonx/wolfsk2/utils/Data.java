package pl.ajonx.wolfsk2.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import pl.ajonx.wolfsk2.WolfSk2;

import java.io.File;

public class Data {

    //public static boolean debug;
    public static String lang;

    private static File CFG = new File(WolfSk2.plugin.getDataFolder(), "config.yml");

    public static void load() {
        loadConfig();
    }

    private static void loadConfig() {
        loadDefaultFiles(new String[]{ "config.yml" });
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(CFG);

        //debug = yaml.getBoolean("debug");
        lang = yaml.getString("language");

        //WolfSk.debug = debug;
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