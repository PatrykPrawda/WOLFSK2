package pl.ajonx.wolfsk2.expressions.yaml;

import org.bukkit.event.Event;

import pl.oneguardstudio.wolfapi.yaml.Yaml;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class GetNumberValue extends SimpleExpression<Number> {
	
    private Expression<String> name;
    private Expression<String> file;

    protected Number[] get(Event event) {
    	if(this.name.getSingle(event) != null && this.file.getSingle(event) != null)
    		return new Number[]{ Yaml.GetYamlIntValue(this.name.getSingle(event), this.file.getSingle(event)) };
    	else
    		return new Number[] { null };
    }

    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
    	this.name = (Expression<String>) expressions[0];
        this.file = (Expression<String>) expressions[1];
    	return true;
    }

    public boolean isSingle() {
        return true;
    }

    public Class<Number> getReturnType() {
        return Number.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}