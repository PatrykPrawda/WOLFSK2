package pl.ajonx.wolfsk2.effects;

import pl.ajonx.wolfsk2.WolfSk2;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Yaml {
	

	public static void createYaml(String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYmlConfig = YamlConfiguration.loadConfiguration(file);
		saveYaml(fileYmlConfig, file);
	}
	
	public static void setYaml(String name, String value, String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYmlConfig = YamlConfiguration.loadConfiguration(file);
		if(value.matches("[0-9]+")) {
			int intValue = Integer.parseInt(value);
			fileYmlConfig.set(name, intValue);
		} else
			fileYmlConfig.set(name, value);
		saveYaml(fileYmlConfig, file);
	}
	
	 public static void saveYaml(FileConfiguration ymlConfig, File ymlFile) {
		 try {
			 ymlConfig.save(ymlFile);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
}
