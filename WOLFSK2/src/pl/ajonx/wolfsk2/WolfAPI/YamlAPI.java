package pl.ajonx.wolfsk2.WolfAPI;

import pl.ajonx.wolfsk2.effects.Yaml;

public class YamlAPI {
	
	 /**
	 * This void create new YAML (.yml) file and required directory if not exist
	 * in plugins directory example CreateYamlFile("MyPlugin/file"); create
	 * Plugins/MyPligin/file.yml
	 * (all parametres are required)
	 */
	public static void CreateYamlFile(String YamlFileName) {
		if(YamlFileName != null)
			Yaml.createYaml(YamlFileName);
	}
	 /**
	 * This void delete YAML (.yml) file ONLY! example DeleteYamlFile("MyPlugin/file");
	 * delete file "file.yml" in Plugins/MyPligin/file.yml
	 * (all parametres are required)
	 */
	public static void DeleteYamlFile(String YamlFileName) {
		if(YamlFileName != null)
			Yaml.deleteYaml(YamlFileName);
	}
	
	 /**
	 * This void set YAML (.yml) value to file, example SetYamlValue("my.value", "0", "MyPlugin/file");
	 * this function automatically detect if value is String or int
	 * (all parametres are required)
	 */
	public static void SetYamlValue(String name, String value, String YamlFileName) {
		if(name != null && value != null && YamlFileName != null)
			Yaml.setYaml(name, value, YamlFileName);
	}
	 /**
	 * This void remove YAML (.yml) value from file, example RemoveYamlValue("my.value", "MyPlugin/file");
	 * (all parametres are required)
	 */
	public static void RemoveYamlValue(String name, String YamlFileName) {
		if(name != null && YamlFileName != null)
			Yaml.removeYaml(name, YamlFileName);
	}
	
	 /**
	 * This void get YAML (.yml) value from file, example GetYamlStringValue("my.value", "MyPlugin/file");
	 * (all parametres are required) [CAN RETURN NULL]
	 */
	public static String GetYamlStringValue(String name, String YamlFileName) {
		if(name != null && YamlFileName != null)
			return Yaml.getYamlString(name, YamlFileName);
		else
			return null;
	}
	 /**
	 * This void get YAML (.yml) value from file, example GetYamlStringValue("my.value", "MyPlugin/file");
	 * (all parametres are required)
	 */
	public static int GetYamlIntValue(String name, String YamlFileName) {
		if(name != null && YamlFileName != null) {
			int result = Integer.parseInt(Yaml.getYamlString(name, YamlFileName));
			return result;
		} else
			return -999999;
	}
	
}
