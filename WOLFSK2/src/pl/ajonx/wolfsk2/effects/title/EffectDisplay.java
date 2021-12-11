package pl.ajonx.wolfsk2.effects.title;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import pl.oneguardstudio.wolfapi.display.Display;

public class EffectDisplay extends Effect {

    private Expression<Player> player;
    private Expression<String> title;
    private Expression<String> subtitle;

    protected void execute(Event event) {

        if(this.player == null || this.title == null)
            return;
        
        final Player player = this.player.getSingle(event);
        
        if(this.subtitle != null)
        	Display.displayTitleAndSubTitle(player, this.title.getSingle(event), this.subtitle.getSingle(event), 0, 0, 0);
        else
        	Display.displayTitleAndSubTitle(player, this.title.getSingle(event), null, 0, 0, 0);
    }

    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.title = (Expression<String>) expressions[1];
        this.subtitle = (Expression<String>) expressions[2];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}