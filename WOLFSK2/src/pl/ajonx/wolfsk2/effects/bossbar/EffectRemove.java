package pl.ajonx.wolfsk2.effects.bossbar;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import pl.oneguardstudio.wolfapi.display.Display;

public class EffectRemove extends Effect {

    private Expression<Player> player;

    protected void execute(Event event) {
        Player player = this.player.getSingle(event);
        if (player == null) {
            return;
        }
        Display.RemoveBossBar(player);
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.player = (Expression<Player>) expressions[0];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}

