package pl.ajonx.wolfsk2.effects.gui;

import org.bukkit.event.Event;

import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Gui;

public class EffectAddItem extends Effect {

    private Expression<String> name;
    private Expression<Number> slot;
    private Expression<ItemType> item;
    private Expression<String> itemName;
    private Expression<String> lore;

    protected void execute(Event event) {

        String name = this.name.getSingle(event);
        Number slot = this.slot.getSingle(event);
        ItemType item = this.item.getSingle(event);
        String itemName = this.itemName.getSingle(event);
        String lore = this.lore.getSingle(event);
        if (name == null || slot == null || item == null) {
            return;
        }

        int i = slot.intValue();
        Gui.get(name).setItem(i, item); // item.getItemMeta().setDisplayName(name)
        if(itemName != null)
        	Gui.get(name).setCustomName(i, itemName);
        if(lore != null)
        	Gui.get(name).setLore(i, lore);

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
    	this.name = (Expression<String>) expressions[0];
        this.slot = (Expression<Number>) expressions[1];
    	this.item = (Expression<ItemType>) expressions[2];
    	this.itemName = (Expression<String>) expressions[3];
    	this.lore = (Expression<String>) expressions[4];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] setItem";
    }
}
