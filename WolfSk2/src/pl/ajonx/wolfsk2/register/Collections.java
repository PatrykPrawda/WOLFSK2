package pl.gempxplay.wolfsk2.register;

import pl.gempxplay.wolfsk2.WolfSk2;
import pl.gempxplay.wolfsk2.WolfSk2Log;
import pl.gempxplay.wolfsk2.collections.actionbar.ActionBarElements;
import pl.gempxplay.wolfsk2.collections.bossbar.BossHealthBarElements;
import pl.gempxplay.wolfsk2.objects.inventory.InventoryElements;

public class Collections {

    public static void registerComplex() {
        BossHealthBarElements.RegisterBossBarEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_bossbar"));
        ActionBarElements.RegisterActionBarEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_actionbar"));
        InventoryElements.RegisterInventoryEffects();
        WolfSk2Log.sendLog("&f[ &aOK &f] " + WolfSk2.language.getString("collections_registred_inventory"));
    }
}
