package pl.gempxplay.wolfsk2.collections.bossbar;

import pl.gempxplay.wolfsk2.collections.bossbar.elements.EffectDisplay;
import pl.gempxplay.wolfsk2.collections.bossbar.elements.EffectRemove;
import pl.gempxplay.wolfsk2.register.RegisterManager;
import pl.gempxplay.wolfsk2.utils.doc.Documentation;
import pl.gempxplay.wolfsk2.utils.doc.Element;
import pl.gempxplay.wolfsk2.utils.doc.Type;

public class BossHealthBarElements {

    public static void RegisterBossBarEffects() {

        Documentation.addElement(new Element(Type.DESC)
                .collection("BossBar")
                .name("BossBar")
                .desc("This function display boss bar for player (support colors, variables, progress and display time)")
        );

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

