package pl.ajonx.wolfsk2.objects.inventory;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.objects.Inventories;

import org.bukkit.event.Event;

public class ExpressionFirstEmpty extends SimpleExpression<Integer> {

    private Expression<String> name;

    protected Integer[] get(Event event) {
        String name = this.name.getSingle(event);
        if (name == null) {
            return null;
        }
        return new Integer[]{ Inventories.get(name).getFirstEmpty() };
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<? extends Integer> getReturnType() {
        return Integer.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}

	

