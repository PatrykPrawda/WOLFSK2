package pl.ajonx.wolfsk2;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import pl.ajonx.wolfsk2.effects.Hologram;

public class Events implements Listener {
	@EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
		if(event.getEntityType().equals(EntityType.ARMOR_STAND)) {
			Hologram.checkHolograms(event.getEntity());
		}
	}

}
