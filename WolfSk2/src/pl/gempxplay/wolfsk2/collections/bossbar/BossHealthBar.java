package pl.gempxplay.wolfsk2.collections.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import java.util.*;

public class BossHealthBar {

	public static BossBar[] boss = new BossBar[99];
	public static Player[] players = new Player[999999];
	public static Object texts;
	
	
	public static void addBossBar(String color, Player player, String title, float progress) {
		Objects.requireNonNull(player, "player");
		Objects.requireNonNull(title, "&7WOLF&9&lSK 2");
		Objects.requireNonNull(color, "WHITE");
		
        title = ChatColor.translateAlternateColorCodes('&', title);
		
		BarColor barColor = BarColor.PURPLE;
		color = color.toUpperCase();
		if(color.equalsIgnoreCase("PURPLE"))
			barColor = BarColor.PURPLE;
		if(color.equalsIgnoreCase("WHITE"))
			barColor = BarColor.WHITE;
		if(color.equalsIgnoreCase("RED"))
			barColor = BarColor.RED;
		if(color.equalsIgnoreCase("GREEN"))
			barColor = BarColor.GREEN;
		if(color.equalsIgnoreCase("YELLOW"))
			barColor = BarColor.YELLOW;
		if(color.equalsIgnoreCase("PINK"))
			barColor = BarColor.PINK;
		
		
		for (int i = 0; i < players.length; i++) {
			if(players[i] == null && boss[i] == null) {
				players[i] = player;
				boss[i] = Bukkit.createBossBar(title, barColor, BarStyle.SOLID);
				boss[i].addPlayer(player);
				boss[i].setProgress((float)progress);
				boss[i].setVisible(true);
				break;
			}
		}
	}
	public static void removeBossBar(Player player) {
		Objects.requireNonNull(player, "player");
		for (int i = 0; i < players.length; i++) {
			if(players[i] == player && boss[i] != null) {
				players[i] = null;
				boss[i].removePlayer(player);
				boss[i].setVisible(false);
				boss[i] = null;
				break;
			}
		}
	}

}
