package pl.gempxplay.wolfsk2.objects.inventory.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.gempxplay.wolfsk2.objects.inventory.Inventories;

import org.bukkit.event.Event;

public class RemoveCommand extends Effect {

    private Expression<String> name;
    private Expression<Number> slot;

    protected void execute(Event event) {

        String name = (String) this.name.getSingle(event);
        Number slot = (Number) this.slot.getSingle(event);
        if (name == null || slot == null) {
            return;
        }

        int i = slot.intValue();
        Inventories.get(name).removeCommand(i);

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.slot = (Expression<Number>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Remove Lore";
    }
}










