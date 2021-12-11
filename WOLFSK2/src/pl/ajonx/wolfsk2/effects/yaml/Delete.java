package pl.ajonx.wolfsk2.effects.yaml;

import org.bukkit.event.Event;

import pl.oneguardstudio.wolfapi.yaml.Yaml;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class Delete extends Effect {
	
    private Expression<String> file;
    
    protected void execute(Event event) {
    	if(this.file.getSingle(event) != null)
    		Yaml.deleteYamlFile(this.file.getSingle(event));
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
