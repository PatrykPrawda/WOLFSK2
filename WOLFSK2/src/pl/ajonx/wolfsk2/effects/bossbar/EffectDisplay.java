package pl.ajonx.wolfsk2.effects.bossbar;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import pl.ajonx.wolfsk2.WolfSk2;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import pl.oneguardstudio.wolfapi.display.Display;

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
        
		BarColor barColor = BarColor.PURPLE;
		color = color.toUpperCase();
		if(color.equalsIgnoreCase("PURPLE"))
			barColor = BarColor.PURPLE;
		if(color.equalsIgnoreCase("WHITE"))
			barColor = BarColor.WHITE;
		if(color.equalsIgnoreCase("RED"))
			barColor = BarColor.RED;
		if(color.equalsIgnoreCase("GREEN"))
			barColor = BarColor.GREEN;
		if(color.equalsIgnoreCase("YELLOW"))
			barColor = BarColor.YELLOW;
		if(color.equalsIgnoreCase("PINK"))
			barColor = BarColor.PINK;
        
        Display.displayBossBar(player, color, Math.round(percent), barColor);
        if(pt.intValue() > 1) {
            Bukkit.getScheduler().runTaskLater(WolfSk2.plugin, new Runnable() {
                @Override
                public void run() {
                	Display.removeBossBar(player);
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