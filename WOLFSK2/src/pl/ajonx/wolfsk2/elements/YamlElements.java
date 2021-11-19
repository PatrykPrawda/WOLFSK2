package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.yaml.Create;
import pl.ajonx.wolfsk2.effects.yaml.Delete;
import pl.ajonx.wolfsk2.effects.yaml.RemoveValue;
import pl.ajonx.wolfsk2.effects.yaml.SetValue;
import pl.ajonx.wolfsk2.expressions.yaml.GetNumberValue;
import pl.ajonx.wolfsk2.expressions.yaml.GetStringValue;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class YamlElements {

    public static void RegisterYamlEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Yaml")
                .name("Create")
                .desc("# Create file and directory")
                .example(new String[]{
                        "create yaml [text]"
                })
                .usage(new String[]{
                        "create yaml %string%"
                })
        , Create.class);
        
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Yaml")
                .name("Delete")
                .desc("# Delete file")
                .example(new String[]{
                        "delete yaml [text]"
                })
                .usage(new String[]{
                        "delete yaml %string%"
                })
        , Delete.class);
        
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Yaml")
                .name("Set")
                .desc("# Set value")
                .example(new String[]{
                        "set yaml value [text] for [text] in [text]"
                })
                .usage(new String[]{
                        "set yaml value %string% for %string% in %string%"
                })
        , SetValue.class);
        
        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                .collection("Yaml")
                .name("Remove")
                .desc("# Remove value")
                .example(new String[]{
                        "remove yaml value for [text] in [text]"
                })
                .usage(new String[]{
                        "remove yaml value for %string% in %string%"
                })
        , RemoveValue.class);
        
        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Yaml")
                .version("Return (string) value from yaml file")
                .desc("# Return value")
                .example("yaml text [text] from [text]")
                .usage(new String[]{
                        "yaml text %string% from %string%"
                }), GetStringValue.class, String.class);
        
        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Yaml")
                .version("Return (number) value from yaml file")
                .desc("# Return value")
                .example("yaml number [text] from [text]")
                .usage(new String[]{
                        "yaml number %string% from %string%"
                }), GetNumberValue.class, Number.class);
    }
}
