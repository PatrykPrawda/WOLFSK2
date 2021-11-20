package pl.ajonx.wolfsk2.expressions.yaml;

import pl.oneguardstudio.wolfapi.yaml.Yaml;

import ch.njol.skript.doc.NoDoc;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

import org.bukkit.event.Event;

@NoDoc
public class GetStringValue extends SimpleExpression<String> {
	
    private Expression<String> name;
    private Expression<String> file;

    protected String[] get(Event event) {
    	if(this.name.getSingle(event) != null && this.file.getSingle(event) != null)
    		return new String[]{ Yaml.GetYamlStringValue(this.name.getSingle(event), this.file.getSingle(event)) };
    	else
    		return new String[] { "null" };
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

    public Class<? extends String> getReturnType() {
        return String.class;
    }

    public String toString(Event event, boolean b) {
        return this.getClass().getName();
    }
}
