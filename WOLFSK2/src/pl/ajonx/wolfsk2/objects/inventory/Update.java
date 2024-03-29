package pl.ajonx.wolfsk2.objects.inventory;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.objects.Inventories;

import org.bukkit.event.Event;

public class Update extends Effect {

    private Expression<String> name;

    protected void execute(Event event) {

        String name = (String) this.name.getSingle(event);
        if (name == null) {
            return;
        }

        Inventories.get(name).updateInv();

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Register Items";
    }
}









