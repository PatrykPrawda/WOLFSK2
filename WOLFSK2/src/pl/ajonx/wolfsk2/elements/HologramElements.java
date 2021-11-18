package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.hologram.EffectDisplay;
import pl.ajonx.wolfsk2.effects.hologram.EffectDisplayBelow;
import pl.ajonx.wolfsk2.effects.hologram.EffectRemove;
import pl.ajonx.wolfsk2.effects.hologram.EffectUpdate;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class HologramElements {
    public static void RegisterHologramEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Hologram")
                .name("Create")
                .desc("# Create hologram")
                .example(new String[]{
                        "create hologram [text] with text [text] on [location]",
                        "create hologram [text] with text [text] on [location] for [number] seconds"
                })
                .usage(new String[]{
                        "create hologram %string% with text %string% on %location% [for %number% seconds]"
                })
        , EffectDisplay.class);
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Hologram")
                .name("Create")
                .desc("# Create hologram below other")
                .example(new String[]{
                        "create hologram [text] with text [text] below [text]",
                        "create hologram [text] with text [text] below [text] for [number] seconds"
                })
                .usage(new String[]{
                        "create hologram %string% with text %string% below %string% [for %number% seconds]"
                })
        , EffectDisplayBelow.class);
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Hologram")
                .name("Remove")
                .desc("# Remove hologram")
                .example(new String[]{
                        "remove hologram [text]"
                })
                .usage(new String[]{
                        "remove hologram %string%"
                })
        , EffectRemove.class);
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Hologram")
                .name("Update")
                .desc("# Update hologram")
                .example(new String[]{
                        "update [text] in hologram [text]"
                })
                .usage(new String[]{
                        "update %string% in hologram %string%"
                })
        , EffectUpdate.class);
    }
}

