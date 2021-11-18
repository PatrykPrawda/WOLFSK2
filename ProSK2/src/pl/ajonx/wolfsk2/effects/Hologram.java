package pl.ajonx.wolfsk2.effects;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import pl.ajonx.wolfsk2.WolfSk2;
import pl.ajonx.wolfsk2.WolfSk2Log;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Hologram {
	public static Object texts;
	
	private static boolean timer = false;
	
	static File hologramYml = new File(WolfSk2.plugin.getDataFolder() + "/data/holograms.yml");
	static FileConfiguration hologramYmlConfig = YamlConfiguration.loadConfiguration(hologramYml);
	
	public static void createHologramBelow(String name, String text, String location, int time) {
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null) {
				if(hologramYmlConfig.getString("hologram." + i + ".name").equalsIgnoreCase(location))
					createHologram(name, text, new Location(Bukkit.getWorld(hologramYmlConfig.getString("hologram." + i + ".location.world")), hologramYmlConfig.getDouble("hologram." + i + ".location.x"), hologramYmlConfig.getDouble("hologram." + i + ".location.y") - 0.25f, hologramYmlConfig.getDouble("hologram." + i + ".location.z")), time);
			}
		}
	}
	
	public static void createHologram(String name, String text, Location location, int time) {
		Objects.requireNonNull(name, "hologram");
		Objects.requireNonNull(text, "&7WOLF&9&lSK2");
		
		int lastEmptyId = 0;
		
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") == null && hologramYmlConfig.getString("hologram." + i + ".text") == null) {
				lastEmptyId = i;
				break;
			}
		}
		
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null && hologramYmlConfig.getString("hologram." + i + ".name").equalsIgnoreCase(name)) {
                for (Entity en : location.getChunk().getEntities()) {
                    if (en.getCustomName() != null) {
                        if (en.getCustomName().equalsIgnoreCase(hologramYmlConfig.getString("hologram." + i + ".text"))) {
                            en.remove();
                            hologramYmlConfig.set("hologram." + i, null);
                            saveHolograms(hologramYmlConfig, hologramYml);
                        }
                    }
                }
			}
		}
		
        text = ChatColor.translateAlternateColorCodes('&', text);
		
        Location l = new Location(location.getWorld(), location.getX(), location.getY() + 1.5f, location.getZ());
		ArmorStand h = (ArmorStand) location.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);
		h.setVisible(false);
		h.setGravity(false);
		h.setInvulnerable(true);
		h.setCustomName(text);
		h.setCustomNameVisible(true);
		h.setMarker(true); // DODANE;
		if(WolfSk2.beta)
			WolfSk2Log.sendLog("&aCreated hologram &fnamed &6" + name + "&f with &ftext &6" + text);
		if(!hologramYml.exists()) {
			try {
				hologramYml.createNewFile();
			} catch (IOException e) {
				WolfSk2Log.sendLog(WolfSk2.tag + "&c" + WolfSk2.language.getString("file_cant_create") + ": &f" + WolfSk2.plugin.getDataFolder() + "/data/holograms.yml");
				e.printStackTrace();
			}
		}
		hologramYmlConfig.set("hologram." + lastEmptyId + ".name", name);
		hologramYmlConfig.set("hologram." + lastEmptyId + ".location.world", location.getWorld().getName());
		hologramYmlConfig.set("hologram." + lastEmptyId + ".location.x", location.getX());
		hologramYmlConfig.set("hologram." + lastEmptyId + ".location.y", location.getY());
		hologramYmlConfig.set("hologram." + lastEmptyId + ".location.z", location.getZ());
		hologramYmlConfig.set("hologram." + lastEmptyId + ".text", text);
		if(time > 1)
			hologramYmlConfig.set("hologram." + lastEmptyId + ".time", time);
		saveHolograms(hologramYmlConfig, hologramYml);
		if(!timer)
			RunTimer();
	}
	
	private static void RunTimer() {
		if(!timer)
			timer = true;
        Bukkit.getScheduler().runTaskLater(WolfSk2.plugin, new Runnable() {
            @Override
            public void run() {
            	RunTimer();
        		for(int i = 0; i < hologramYml.length(); i++) {
        			if(hologramYmlConfig.getString("hologram." + i + ".name") != null && hologramYmlConfig.getString("hologram." + i + ".text") != null && hologramYmlConfig.getString("hologram." + i + ".time") != null) {
        				if(hologramYmlConfig.getInt("hologram." + i + ".time") <= 0)
        					removeHologram(hologramYmlConfig.getString("hologram." + i + ".name"));
        				else
        					hologramYmlConfig.set("hologram." + i + ".time", hologramYmlConfig.getInt("hologram." + i + ".time") - 1);
        			}
        		}
        		saveHolograms(hologramYmlConfig, hologramYml);
            }
        }, 20);
	}
	
	 public static void saveHolograms(FileConfiguration ymlConfig, File ymlFile) {
		 try {
			 ymlConfig.save(ymlFile);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
	public static void removeHologram(String name) {
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null && hologramYmlConfig.getString("hologram." + i + ".name").equalsIgnoreCase(name)) {
				Location l = new Location(Bukkit.getWorld(hologramYmlConfig.getString("hologram." + i + ".location.world")), hologramYmlConfig.getDouble("hologram." + i + ".location.x"), hologramYmlConfig.getDouble("hologram." + i + ".location.y"), hologramYmlConfig.getDouble("hologram." + i + ".location.z"));
                for (Entity en : l.getChunk().getEntities()) {
                    if (en.getCustomName() != null) {
                        if (en.getCustomName().equalsIgnoreCase(hologramYmlConfig.getString("hologram." + i + ".text"))) {
                            en.remove();
                            hologramYmlConfig.set("hologram." + i, null);
                            saveHolograms(hologramYmlConfig, hologramYml);
                        }
                    }
                }
			}
		}
	}
	
	public static void removeAllHolograms() {
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null && hologramYmlConfig.getString("hologram." + i + ".text") != null) {
				Location l = new Location(Bukkit.getWorld(hologramYmlConfig.getString("hologram." + i + ".location.world")), hologramYmlConfig.getDouble("hologram." + i + ".location.x"), hologramYmlConfig.getDouble("hologram." + i + ".location.y"), hologramYmlConfig.getDouble("hologram." + i + ".location.z"));
                for (Entity en : l.getChunk().getEntities()) {
                    if (en.getCustomName() != null) {
                        if (en.getCustomName().equalsIgnoreCase(hologramYmlConfig.getString("hologram." + i + ".text"))) {
                            en.remove();
                        }
                    }
                }
			}
		}
	}
	
	public static void loadAllHolograms() {
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null && hologramYmlConfig.getString("hologram." + i + ".text") != null) {
				createHologram(hologramYmlConfig.getString("hologram." + i + ".name"), hologramYmlConfig.getString("hologram." + i + ".text"), new Location(Bukkit.getWorld(hologramYmlConfig.getString("hologram." + i + ".location.world")), hologramYmlConfig.getDouble("hologram." + i + ".location.x"), hologramYmlConfig.getDouble("hologram." + i + ".location.y"), hologramYmlConfig.getDouble("hologram." + i + ".location.z")), hologramYmlConfig.getInt("hologram." + i + ".text"));
			}
		}
	}
	
	public static void updateHologram(String text, String name) {
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null && hologramYmlConfig.getString("hologram." + i + ".name").equalsIgnoreCase(name)) {
				Location l = new Location(Bukkit.getWorld(hologramYmlConfig.getString("hologram." + i + ".location.world")), hologramYmlConfig.getDouble("hologram." + i + ".location.x"), hologramYmlConfig.getDouble("hologram." + i + ".location.y"), hologramYmlConfig.getDouble("hologram." + i + ".location.z"));
				createHologram(name, text, l, hologramYmlConfig.getInt("hologram." + i + ".time"));
				if(WolfSk2.beta)
					WolfSk2Log.sendLog("&aUpdated hologram &fnamed &6" + name + "&f with &ftext &6" + text);
				break;
			}
		}
	}
	
	public static void checkHolograms(LivingEntity entity) {
		if(WolfSk2.beta)
			WolfSk2Log.sendLog("&aKilled ARMOR_STAND, checking holograms...");
		for(int i = 0; i < hologramYml.length(); i++) {
			if(hologramYmlConfig.getString("hologram." + i + ".name") != null) {
				Location l = new Location(Bukkit.getWorld(hologramYmlConfig.getString("hologram." + i + ".location.world")), hologramYmlConfig.getDouble("hologram." + i + ".location.x"), hologramYmlConfig.getDouble("hologram." + i + ".location.y"), hologramYmlConfig.getDouble("hologram." + i + ".location.z"));
				if(entity.getLocation().equals(l) && entity.getCustomName().equalsIgnoreCase(hologramYmlConfig.getString("hologram." + i + ".text"))) {
					createHologram(hologramYmlConfig.getString("hologram." + i + ".name"), hologramYmlConfig.getString("hologram." + i + ".text"), l, hologramYmlConfig.getInt("hologram." + i + "time"));
				}
			}
		}
	}
}

