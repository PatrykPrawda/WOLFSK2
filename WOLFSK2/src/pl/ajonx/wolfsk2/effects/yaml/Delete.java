package pl.ajonx.wolfsk2.effects.yaml;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Yaml;

public class Delete extends Effect {
	
    private Expression<String> file;
    
    protected void execute(Event event) {
    	if(this.file.getSingle(event) != null)
    		Yaml.deleteYaml(this.file.getSingle(event));
    }
	
    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.file = (Expression<String>) expressions[0];
        return true;
    }
    
    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }

}
