package tech.erudo.mc.practice.particledrawing.particledrawing;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EventListener implements Listener {

    private JavaPlugin plugin;


    public EventListener(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR ||
        e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            Player player = e.getPlayer();
            Location loc = player.getLocation();

            float yaw = player.getLocation().getYaw();
            double rotY = - Math.toRadians(yaw);

            Drawing drawing = new Drawing(plugin);
            drawing.drawCircle(loc, Particle.COMPOSTER,null, 1,100,Math.PI / 2, rotY,0);

        }
    }
}
