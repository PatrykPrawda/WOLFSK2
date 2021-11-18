package pl.ajonx.wolfsk2.effects.actionbar;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.ActionBar;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffectDisplay extends Effect {

    private Expression<Player> player;
    private Expression<String> text;

    protected void execute(Event event) {

        final Player player = this.player.getSingle(event);
        String text = this.text.getSingle(event);
        if (player == null || text == null)
            return;
        
        ActionBar.sendActionBar(player, text);
    }

    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        this.text = (Expression<String>) expressions[1];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}