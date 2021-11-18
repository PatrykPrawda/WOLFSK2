package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.actionbar.EffectDisplay;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class ActionBarElements {

    public static void RegisterActionBarEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("ActionBar")
                .name("Display")
                .desc("# Display actionbar")
                .example(new String[]{
                        "display actionbar for [player] with text [text]"
                })
                .usage(new String[]{
                        "display actionbar for %player% with text %string%"
                })
        , EffectDisplay.class);
    }
}