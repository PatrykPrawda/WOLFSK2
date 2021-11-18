package pl.ajonx.wolfsk2.effects;

import pl.ajonx.wolfsk2.WolfSk2;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Yml {
	

	public static void createYml(String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYmlConfig = YamlConfiguration.loadConfiguration(file);
		saveYml(fileYmlConfig, file);
	}
	
	public static void setYml(String name, String value, String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYmlConfig = YamlConfiguration.loadConfiguration(file);
		fileYmlConfig.set(name, value);
		saveYml(fileYmlConfig, file);
	}
	
	 public static void saveYml(FileConfiguration ymlConfig, File ymlFile) {
		 try {
			 ymlConfig.save(ymlFile);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
}
