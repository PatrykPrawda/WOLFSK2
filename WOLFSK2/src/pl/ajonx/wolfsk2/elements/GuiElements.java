package pl.ajonx.wolfsk2.elements;

import pl.ajonx.wolfsk2.documentation.Element;
import pl.ajonx.wolfsk2.documentation.Type;
import pl.ajonx.wolfsk2.effects.gui.EffectAddItem;
import pl.ajonx.wolfsk2.effects.gui.EffectCreate;
import pl.ajonx.wolfsk2.effects.gui.EffectDisplay;
import pl.ajonx.wolfsk2.register.RegisterManager;

public class GuiElements {
	public static void RegisterGuiEffects() {
	
	    RegisterManager.registerEffect(new Element(Type.COLLECTION)
	            .collection("GUI")
	            .name("Create")
	            .desc("# Create gui")
	            .example(new String[]{
	                    "make new gui [text] with [number] rows"
	            })
	            .usage(new String[]{
	                    "make new gui %string% with %number% rows"
	            })
	    , EffectCreate.class);
	    
	    RegisterManager.registerEffect(new Element(Type.COLLECTION)
	            .collection("GUI")
	            .name("Display")
	            .desc("# Display gui")
	            .example(new String[]{
	                    "open gui [text] for [player]"
	            })
	            .usage(new String[]{
	                    "open gui %string% for %player%"
	            })
	    , EffectDisplay.class);
	    
	    RegisterManager.registerEffect(new Element(Type.COLLECTION)
	            .collection("GUI")
	            .name("Add item")
	            .desc("# Add item to gui")
	            .example(new String[]{
	                    "add to gui [text] on slot [number] item [itemtype]",
	                    "add to gui [text] on slot [number] item [itemtype] with name [text]",
	                    "add to gui [text] on slot [number] item [itemtype] with name [text] and lore [text]"
	            })
	            .usage(new String[]{
	                    "add to gui %string% on slot %number% item %itemtype% [with name %string% [and lore %string%]]"
	            })
	    , EffectAddItem.class);
	}
}