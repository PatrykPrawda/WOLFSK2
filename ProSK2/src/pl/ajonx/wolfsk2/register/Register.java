package pl.ajonx.wolfsk2.register;

import pl.ajonx.wolfsk2.WolfSk2;
import pl.ajonx.wolfsk2.WolfSk2Log;
import pl.ajonx.wolfsk2.elements.ActionBarElements;
import pl.ajonx.wolfsk2.elements.BossHealthBarElements;
import pl.ajonx.wolfsk2.elements.GuiElements;
import pl.ajonx.wolfsk2.elements.HologramElements;
import pl.ajonx.wolfsk2.elements.LoaderElements;
import pl.ajonx.wolfsk2.elements.YmlElements;
import pl.ajonx.wolfsk2.objects.inventory.InventoryElements;

public class Register {
    public static void register() {
    	
    	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
    	WolfSk2Log.sendLog("&f");
    	WolfSk2Log.sendLog("&f" + WolfSk2.language.getString("registering_elements"));
        BossHealthBarElements.RegisterBossBarEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_bossbar"));
        ActionBarElements.RegisterActionBarEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_actionbar"));
        LoaderElements.RegisterLoaderEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_loader"));
        HologramElements.RegisterHologramEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_hologram"));
        YmlElements.RegisterYmlEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_yml"));
        if(WolfSk2.beta) {
	        GuiElements.RegisterGuiEffects();
	        WolfSk2Log.sendLog("&f[ &aOK &f] Gui elements registred (TEST).");
        }
        InventoryElements.RegisterInventoryEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("objects_registred_inventory"));

    	WolfSk2Log.sendLog("&a" + WolfSk2.language.getString("all_registred_correctly"));
    	WolfSk2Log.sendLog("&f");
    	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK2 &8*-*-*-*-*-*-*-*-*");
    }
}
