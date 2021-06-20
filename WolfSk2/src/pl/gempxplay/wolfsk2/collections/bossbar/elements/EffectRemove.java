package pl.gempxplay.wolfsk2.collections.bossbar.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.gempxplay.wolfsk2.collections.bossbar.BossHealthBar;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffectRemove extends Effect {

    private Expression<Player> player;

    protected void execute(Event event) {
        Player player = this.player.getSingle(event);
        if (player == null) {
            return;
        }
        BossHealthBar.removeBossBar(player);
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

