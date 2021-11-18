package pl.ajonx.wolfsk2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WolfSk2Log extends JavaPlugin {

	public static void sendLog(String message) {
		String msg = message;
		msg = msg.replace("&", "§");
		Bukkit.getConsoleSender().sendMessage(msg);
	}
	
}
