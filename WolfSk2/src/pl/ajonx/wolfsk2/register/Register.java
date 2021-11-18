package pl.gempxplay.wolfsk2.register;

import pl.gempxplay.wolfsk2.WolfSk2;
import pl.gempxplay.wolfsk2.WolfSk2Log;

public class Register {
    public static void register() {
    	
        /*Classes.registerClasses();
        PlayerEvents.registerPlayerEvents();
        EntityEvents.registerEntityEvents();
        FileEvents.registerFileEvents();
        Events.registerEvents(); 
        Conditions.registerConditions();
        Effects.registerEffects();
        Expressions.register();
        EventValue.registerEventValues();
        Objects.registerObjects();*/
    	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK &8*-*-*-*-*-*-*-*-*");
    	WolfSk2Log.sendLog("&f");
    	WolfSk2Log.sendLog("&f" + WolfSk2.language.getString("collections_registering_elements"));
    	Collections.registerComplex();
    	WolfSk2Log.sendLog("&a" + WolfSk2.language.getString("collections_registred_correctly"));
    	WolfSk2Log.sendLog("&f");
    	WolfSk2Log.sendLog("&8*-*-*-*-*-*-*-*-* &7WOLF&9&lSK &8*-*-*-*-*-*-*-*-*");
    }
}
