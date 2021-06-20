package pl.gempxplay.wolfsk2.collections.actionbar;

import pl.gempxplay.wolfsk2.collections.actionbar.elements.EffectDisplay;
import pl.gempxplay.wolfsk2.register.RegisterManager;
import pl.gempxplay.wolfsk2.utils.doc.Documentation;
import pl.gempxplay.wolfsk2.utils.doc.Element;
import pl.gempxplay.wolfsk2.utils.doc.Type;

public class ActionBarElements {

    public static void RegisterActionBarEffects() {

        Documentation.addElement(new Element(Type.DESC)
                .collection("ActionBar")
                .name("ActionBar")
                .desc("This function display action bar for player")
        );

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