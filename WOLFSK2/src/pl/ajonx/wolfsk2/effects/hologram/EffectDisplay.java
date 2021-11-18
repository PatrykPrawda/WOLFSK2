package pl.ajonx.wolfsk2.effects.hologram;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Hologram;

import org.bukkit.Location;

public class EffectDisplay extends Effect {

    private Expression<String> name;
    private Expression<String> text;
    private Expression<Number> time;
    private Expression<Location> location;

    protected void execute(Event event) {

    	Number pt = 0;
        String text = this.text.getSingle(event);
        String name = this.name.getSingle(event);
        pt = this.time.getSingle(event);
        Location location = this.location.getSingle(event);
        if(pt.intValue() <= 0)
        	pt = 0;
        if (name == null || text == null)
            return;
        
        Hologram.createHologram(name, text, location, pt.intValue());
    }

    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.text = (Expression<String>) expressions[1];
        this.location = (Expression<Location>) expressions[2];
        this.time = (Expression<Number>) expressions[3];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}
