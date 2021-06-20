package pl.gempxplay.wolfsk2;

import org.bukkit.plugin.java.JavaPlugin;

import pl.gempxplay.wolfsk2.utils.IOUtils;

public class WolfSk2Update extends JavaPlugin {
	
    public static void IsUpdateAvailable() {
        final Thread thread = new Thread() {
            public void run() {
                String latest = IOUtils.getContent("https://wolfsk2.outr-studio.pl/plugin/version.txt");
                if (latest == null || latest.isEmpty()) {
                	WolfSk2Log.sendLog(WolfSk2.tag + WolfSk2.language.getString("updater_cant_connect"));
                }
                else if (latest.equalsIgnoreCase(WolfSk2.plugin.getDescription().getVersion())) {
                	WolfSk2Log.sendLog(WolfSk2.tag + WolfSk2.language.getString("updater_latest_version"));
                }
                else {
                	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK &8*-*-*-*-*-*-*-*-*");
                	WolfSk2Log.sendLog("&f");
        			WolfSk2Log.sendLog("&f" + WolfSk2.language.getString("updater_update_line0"));
        			WolfSk2Log.sendLog("&e&l" + WolfSk2.language.getString("updater_update_line1"));
        			WolfSk2Log.sendLog("&f");
        			WolfSk2Log.sendLog("&f               " + WolfSk2.language.getString("updater_update_line2"));
        			WolfSk2Log.sendLog("&f               &9&l" + WolfSk2.plugin.getDescription().getVersion());
        			WolfSk2Log.sendLog("&f              " + WolfSk2.language.getString("updater_update_line3"));
        			WolfSk2Log.sendLog("&f               &9&l" + latest);
        			WolfSk2Log.sendLog("&f");
        			WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK &8*-*-*-*-*-*-*-*-*");
                }
            }
        };
        thread.start();
    }
	
}
