package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.loader.EffectFile;
import pl.ajonx.wolfsk2.effects.loader.EffectFolder;
import pl.ajonx.wolfsk2.effects.loader.EffectPlugin;
import pl.ajonx.wolfsk2.effects.loader.EffectString;
import pl.ajonx.wolfsk2.effects.loader.EffectUrl;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class LoaderElements {

    public static void RegisterLoaderEffects() {

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Loader")
                        .name("File")
                        .desc("# Load content of file as script")
                        .example("load script from file [path]")
                        .usage(new String[]{
                                "load script from file %string%"
                        })
                , EffectFile.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Loader")
                        .name("Folder")
                        .desc("# Load Skript's file from folder")
                        .example("load scripts from folder [path]")
                        .usage(new String[]{
                                "load scripts from folder %string%"
                        })
                , EffectFolder.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Loader")
                        .name("Plugin")
                        .desc("# Enable/Disable plugin")
                        .example(new String[]{
                                "enable plugin [file]",
                                "disable plugin [name]"
                        })
                        .usage(new String[]{
                                "enable plugin %string%",
                                "disable plugin %string%"
                        })
                , EffectPlugin.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Loader")
                        .name("String")
                        .desc("# Load script from string")
                        .example("load script from [string]")
                        .usage(new String[]{
                                "load script from %string%"
                        })
                , EffectString.class);

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Loader")
                        .name("URL")
                        .desc("# Load content of url as script")
                        .example("load script from url [url]")
                        .usage(new String[]{
                                "load script from url %string%"
                        })
                , EffectUrl.class);
    }
}