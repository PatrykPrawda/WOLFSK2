package pl.ajonx.wolfsk2.effects.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.effects.Gui;

public class EffectDisplay extends Effect {

    private Expression<String> name;
    private Expression<Player> player;

    protected void execute(Event event) {

        String name = (String) this.name.getSingle(event);
        Player p = (Player) this.player.getSingle(event);
        if (name == null || p == null) {
            return;
        }

        Gui inv = Gui.get(name);
        Gui.get(name).updateInv();
        inv.display(p);

    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.name = (Expression<String>) expressions[0];
        this.player = (Expression<Player>) expressions[1];
        return true;
    }

    public String toString(Event event, boolean bool) {
        return "[Inventory] Display";
    }
}
