package pl.ajonx.wolfsk2.effects;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBar {
		public static Object texts;
		
	    public static void sendActionBar(Player player, String message) {
	        message = ChatColor.translateAlternateColorCodes('&', message);
	        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
	    }
}
