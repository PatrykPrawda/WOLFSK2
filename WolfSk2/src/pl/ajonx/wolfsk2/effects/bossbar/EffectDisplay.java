package pl.gempxplay.wolfsk2.collections.bossbar.elements;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.gempxplay.wolfsk2.WolfSk2;
import pl.gempxplay.wolfsk2.collections.bossbar.BossHealthBar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffectDisplay extends Effect {

    private Expression<Player> player;
    private Expression<String> text;
    private Expression<String> color;
    private Expression<Number> time;
    private Expression<Number> progress;

    protected void execute(Event event) {

    	Number pt = 0;
        final Player player = this.player.getSingle(event);
        String text = this.text.getSingle(event);
        String color = this.color.getSingle(event);
        float percent = (float) this.progress.getSingle(event);
        pt = this.time.getSingle(event);
        if (player == null || text == null)
            return;
        
        if(percent > 100)
        	percent = 100;
        if(percent < 0)
        	percent = 0;
        
        BossHealthBar.addBossBar(color, player, text, percent / 100);
        if(pt.intValue() > 0 && pt != null) {
            Bukkit.getScheduler().runTaskLater(WolfSk2.plugin, new Runnable() {
                @Override
                public void run() {
                    BossHealthBar.removeBossBar(player);
                }
            }, pt.intValue() * 20);
        }
    }

    @SuppressWarnings("unchecked")
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        this.color = (Expression<String>) expressions[0];
        this.player = (Expression<Player>) expressions[1];
        this.text = (Expression<String>) expressions[2];
        this.progress = (Expression<Number>) expressions[3];
        this.time = (Expression<Number>) expressions[4];
        return true;
    }

    public String toString(Event e, boolean bool) {
        return this.getClass().getName();
    }
}