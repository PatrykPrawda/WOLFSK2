package pl.ajonx.wolfsk2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import pl.ajonx.wolfsk2.effects.Hologram;
import pl.ajonx.wolfsk2.register.Register;

public class WolfSk2 extends JavaPlugin {
	
	public static WolfSk2 plugin;
	
	public static boolean WolfAPI = false;
	
	// PREFIX
	public static String tag = "&f[ &7WOLF&9&lSK2 &f] ";
	
	// BETA
	public static boolean beta = false;
	
	// CONFIGURATION FILE
	FileConfiguration config = this.getConfig();
	
	// DATA FOLDER
	public static File dataFolder;
	
	// LANGUAGE
	private File langFile;
    public static FileConfiguration language;
    
	// GET TRANSLATION
	public String GetTranslation(String name) {
		return config.getString(name);
	}
	
    private void GetLanguage(String languageName) {
    	langFile = new File(getDataFolder() + "/resources/lang/", languageName + ".yml");
        if (langFile.exists()) {
        	langFile.delete();
        }
        langFile.getParentFile().mkdirs();
        saveResource("resources/lang/" + languageName + ".yml", false);

        language = new YamlConfiguration();
            try {
				language.load(langFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	
	@Override
	public void onLoad() {
		
		plugin = this;
		
		WolfSk2Log.sendLog("&7~ &fcreated by &9&lPatryk Prawda&f aka &9&lAJONX &7~");
		
		GetLanguage("English");
		GetLanguage("Polish");
		GetLanguage("French");
		
		config.addDefault("language", "English");
		config.options().copyDefaults(true);
	    saveConfig();
	    
	    File dataDirectory = new File(getDataFolder() + "/data/");
	    if(!dataDirectory.exists())
	    	dataDirectory.mkdir();
		
		if(config.getString("language").equalsIgnoreCase("English") ||
				config.getString("language").equalsIgnoreCase("Polish") ||
				config.getString("language").equalsIgnoreCase("French")) {
			GetLanguage(config.getString("language"));
		} else {
			GetLanguage("English");
			WolfSk2Log.sendLog(tag + "&cLanguage '&f" + config.getString("language") + "&c' not exist.");
		}
		
		WolfSk2Log.sendLog(tag + "&f" + language.getString("plugin_language") + " &9&l" + language.getString("lang_name") + " &fv&9&l" + language.getString("lang_version") + " &fby &9&l" + language.getString("lang_author"));
		
		WolfSk2Log.sendLog(tag + "&a" + language.getString("plugin_starting"));
	}
	
	@Override
	public void onEnable() {
		WolfSk2Update.IsUpdateAvailable();
        for (Plugin p : Bukkit.getPluginManager().getPlugins()) {
            if (p.getName().toLowerCase().equalsIgnoreCase("skript")) {
                Skript.registerAddon(this);
            }
            if (p.getName().toLowerCase().equalsIgnoreCase("wolfapi")) {
                WolfAPI = true;
            }
        }
        Register.register();
        getServer().getPluginManager().registerEvents(new Events(), this);
        Hologram.removeAllHolograms();
        Hologram.loadAllHolograms();
	}
	
	@Override
	public void onDisable() {
		WolfSk2Log.sendLog(tag + "&c" + language.getString("plugin_disabling"));
		WolfSk2Log.sendLog(tag + "&c" + language.getString("plugin_disabled"));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return super.onCommand(sender, command, label, args);
	}

}
