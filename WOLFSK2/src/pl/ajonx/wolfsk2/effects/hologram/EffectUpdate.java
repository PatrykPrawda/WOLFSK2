package pl.ajonx.wolfsk2.effects.hologram;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Hologram;

public class EffectUpdate extends Effect {

    private Expression<String> text;
    private Expression<String> name;

    protected void execute(Event event) {

        String text = this.text.getSingle(event);
        String name = this.name.getSingle(event);
        if (name == null)
            return;
        
        Hologram.updateHologram(text, name);
    }

    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.text = (Expression<String>) expressions[0];
        this.name = (Expression<String>) expressions[1];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}
