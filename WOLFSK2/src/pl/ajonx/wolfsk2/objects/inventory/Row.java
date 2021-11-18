package pl.ajonx.wolfsk2.objects.inventory;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.WolfSk2Log;
import pl.ajonx.wolfsk2.objects.Inventories;

import org.bukkit.event.Event;

public class Row extends Effect {

    private Expression<String> name;
    private Expression<Number> row;

    protected void execute(Event event) {

        String name = this.name.getSingle(event);
        Number row = this.row.getSingle(event);
        if (name == null || row == null) {
            return;
        }
        int i = row.intValue();

        if (!(i <= 6 || i >= 1)) {
        	WolfSk2Log.sendLog("&f[ &fObjects&6&lInventory &f] Row can be number between 1 and 6!");
            return;
        }
        Inventories.get(name).setRow(i);

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.row = (Expression<Number>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Register Row";
    }
}

