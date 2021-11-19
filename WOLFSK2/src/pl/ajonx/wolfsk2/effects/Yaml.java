package pl.ajonx.wolfsk2.effects;

import pl.ajonx.wolfsk2.WolfSk2;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Yaml {
	

	public static void createYaml(String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
		saveYaml(fileYamlConfig, file);
	}
	
	public static void deleteYaml(String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		if(file.exists())
			file.delete();
	}
	
	public static void setYaml(String name, String value, String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
		if(value.matches("[0-9]+")) {
			int intValue = Integer.parseInt(value);
			fileYamlConfig.set(name, intValue);
		} else
			fileYamlConfig.set(name, value);
		saveYaml(fileYamlConfig, file);
	}
	
	public static void removeYaml(String name, String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
		fileYamlConfig.set(name, null);
		saveYaml(fileYamlConfig, file);
		
	}
	
	public static String getYamlString(String name, String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
		return fileYamlConfig.getString(name);
	}
	public static Number getYamlNumber(String name, String fileName) {
		File file = new File(WolfSk2.plugin.getDataFolder().getParentFile() + "/" + fileName + ".yml");
		FileConfiguration fileYamlConfig = YamlConfiguration.loadConfiguration(file);
		return fileYamlConfig.getInt(name);
	}
	
	 public static void saveYaml(FileConfiguration yamlConfig, File yamlFile) {
		 try {
			 yamlConfig.save(yamlFile);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
}
