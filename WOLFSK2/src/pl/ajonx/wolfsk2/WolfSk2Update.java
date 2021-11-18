package pl.ajonx.wolfsk2;

import org.bukkit.plugin.java.JavaPlugin;

import pl.ajonx.wolfsk2.utils.IOUtils;

public class WolfSk2Update extends JavaPlugin {
	
    public static void IsUpdateAvailable() {
        final Thread thread = new Thread() {
            public void run() {
                String latest = IOUtils.getContent("https://pastebin.com/raw/RAu94d3m");
                if (latest == null || latest.isEmpty()) {
                	WolfSk2Log.sendLog(WolfSk2.tag + WolfSk2.language.getString("updater_cant_connect"));
                }
                else if (latest.equalsIgnoreCase(WolfSk2.plugin.getDescription().getVersion())) {
                	WolfSk2Log.sendLog(WolfSk2.tag + WolfSk2.language.getString("updater_latest_version"));
                }
                else {
                	CheckVersion(WolfSk2.plugin.getDescription().getVersion(), latest, latest);
                }
            }
        };
        thread.start();
    }
    
    public static void CheckVersion(String usedVersion, String latestVersion, String latest) {
    	if(usedVersion.contains(".")) {
    		usedVersion = usedVersion.replace(".", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(usedVersion.contains("_")) {
    		usedVersion = usedVersion.replace("_", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	}else if(usedVersion.contains(" ")) {
    		usedVersion = usedVersion.replace(" ", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(latestVersion.contains(".")) {
    		latestVersion = latestVersion.replace(".", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(latestVersion.contains("_")) {
    		latestVersion = latestVersion.replace("_", "");
    		CheckVersion(usedVersion, latestVersion, latest);
    	} else if(latestVersion.contains(" ")) {
    		latestVersion = latestVersion.replace(" ", "");
    		CheckVersion(latestVersion, latestVersion, latest);
    	} else {
    		try {
	    		if(Integer.parseInt(usedVersion) < Integer.parseInt(latestVersion)) {
	            	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
	            	WolfSk2Log.sendLog("&f");
	    			WolfSk2Log.sendLog("&f" + WolfSk2.language.getString("updater_update_line0"));
	    			WolfSk2Log.sendLog("&e&l" + WolfSk2.language.getString("updater_update_line1"));
	    			WolfSk2Log.sendLog("&f");
	    			WolfSk2Log.sendLog("&f               " + WolfSk2.language.getString("updater_update_line2"));
	    			WolfSk2Log.sendLog("&f               &9&l" + WolfSk2.plugin.getDescription().getVersion());
	    			WolfSk2Log.sendLog("&f              " + WolfSk2.language.getString("updater_update_line3"));
	    			WolfSk2Log.sendLog("&f               &9&l" + latest);
	    			WolfSk2Log.sendLog("&f");
	    			WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
	    		} else {
	    			WolfSk2.beta = true;
	            	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
	            	WolfSk2Log.sendLog("&f");
	    			WolfSk2Log.sendLog("&f" + WolfSk2.language.getString("updater_prerealese_build_line1"));
	    			WolfSk2Log.sendLog("&9&l" + WolfSk2.language.getString("updater_prerealese_build_line2"));
	    			WolfSk2Log.sendLog("&f");
	    			WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
	    		}
    		}
    		catch(Exception e) {
            	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
            	WolfSk2Log.sendLog("&f");
    			WolfSk2Log.sendLog("&c&l" + WolfSk2.language.getString("updater_error"));
    			WolfSk2Log.sendLog("&4" + WolfSk2.language.getString("error") + " - " + e.getMessage());
    			WolfSk2Log.sendLog("&f");
    			WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
    		}
    	}
    }
	
}
