package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.title.EffectDisplay;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class TitleAndSubTitleElements {

    public static void RegisterTitleAndSubtitleEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("TitleAndSubTitle")
                .name("Display")
                .desc("# Display title and subtitle")
                .example(new String[]{
                        "display title for [player] with text [text]",
                        "display title for [player] with text [text] and subtitle [text]"
                })
                .usage(new String[]{
                        "display title for %player% with text %string%[ and subtitle %-string%]"
                })
        , EffectDisplay.class);
    }
	
}
