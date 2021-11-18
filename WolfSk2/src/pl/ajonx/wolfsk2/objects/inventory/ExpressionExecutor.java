package pl.gempxplay.wolfsk2.objects.inventory.elements;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import pl.gempxplay.wolfsk2.objects.inventory.Inventories;

import org.bukkit.event.Event;

public class ExpressionExecutor extends SimpleExpression<String> {

    private Expression<String> name;
    private Expression<Integer> slot;

    protected String[] get(Event event) {

        String name = (String) this.name.getSingle(event);
        int i = (int) this.slot.getSingle(event);
        if (name == null) {
            return null;
        }

        String exc = Inventories.get(name).getLore(i);
        if (exc == null) {
            exc = "console";
        }

        return new String[]{ exc };

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.slot = (Expression<Integer>) expressions[1];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return "[Inventory] Get Executor";
    }
}


	


