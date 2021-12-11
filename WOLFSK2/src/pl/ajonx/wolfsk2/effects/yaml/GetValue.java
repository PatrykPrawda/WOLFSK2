package pl.ajonx.wolfsk2.effects.yaml;

import org.bukkit.event.Event;

import pl.oneguardstudio.wolfapi.yaml.Yaml;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

public class GetValue extends Effect {
	
    private Expression<String> name;
    private Expression<String> file;
    
    protected void execute(Event event) {
    	if(this.name.getSingle(event) != null && this.file.getSingle(event) != null)
    		Yaml.removeYamlValue(this.name.getSingle(event), this.file.getSingle(event));
    }
	
    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.file = (Expression<String>) expressions[1];
        return true;
    }
    
    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }

}
