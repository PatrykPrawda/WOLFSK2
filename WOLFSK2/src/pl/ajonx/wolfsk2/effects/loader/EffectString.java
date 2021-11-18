package pl.ajonx.wolfsk2.effects.loader;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Loader;

import org.bukkit.event.Event;

public class EffectString extends Effect {

    private Expression<String> s;

    protected void execute(Event event) {
        String s = this.s.getSingle(event);
        if (s == null) {
            return;
        }
        Loader.loadString(s);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.s = (Expression<String>) expressions[0];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return this.getClass().getName();
    }
}