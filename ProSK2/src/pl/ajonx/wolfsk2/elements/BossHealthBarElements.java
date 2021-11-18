package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.bossbar.EffectDisplay;
import pl.ajonx.wolfsk2.effects.bossbar.EffectRemove;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class BossHealthBarElements {

    public static void RegisterBossBarEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("BossBar")
                .name("Display")
                .desc("# Display bossbar")
                .example(new String[]{
                        "display [color] bossbar for [player] with text [text]",
                        "display [color] bossbar for [player] with text [text] and progress [number]",
                        "display [color] bossbar for [player] with text [text] for [number] seconds"
                })
                .usage(new String[]{
                        "display %string% bossbar for %player% with text %string% [and progress %float% [for %number% seconds]]"
                })
        , EffectDisplay.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("BossBar")
                        .name("Remove")
                        .desc("# Remove bossbar")
                        .example(new String[]{
                                "remove bossbar for [player]",
                        })
                        .usage(new String[]{
                                "remove bossbar for %player%"
                        })
                , EffectRemove.class);
    }
}

