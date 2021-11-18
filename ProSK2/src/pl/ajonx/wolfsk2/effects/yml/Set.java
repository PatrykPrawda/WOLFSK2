package pl.ajonx.wolfsk2.effects.yml;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Yml;

public class Set extends Effect {
	
    private Expression<String> name;
    private Expression<String> value;
    private Expression<String> file;
    
    protected void execute(Event event) {
    	Yml.setYml(this.name.getSingle(event), this.value.getSingle(event), this.file.getSingle(event));
    }
	
    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.value = (Expression<String>) expressions[1];
        this.file = (Expression<String>) expressions[2];
        return true;
    }
    
    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }

}
