package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.yml.Create;
import pl.ajonx.wolfsk2.effects.yml.Set;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class YmlElements {

    public static void RegisterYmlEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Yml")
                .name("Create")
                .desc("# Create file")
                .example(new String[]{
                        "create file [text]"
                })
                .usage(new String[]{
                        "create file %string%"
                })
        , Create.class);
        
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Yml")
                .name("Set")
                .desc("# Set file")
                .example(new String[]{
                        "set yml [text] value [text] in [text]"
                })
                .usage(new String[]{
                        "set yml %string% value %string% in %string%"
                })
        , Set.class);
    }
}
