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


            switch (ParticleDrawing.model) {
                case CIRCLE -> drawing.drawCircle(loc, Particle.COMPOSTER, null, 3, 100, Math.PI / 2, rotY, 0);
                case SPIRAL -> drawing.drawSpiral(loc, Particle.COMPOSTER, null, 0.3, 100, Math.PI / 2, rotY, 0);
                case CONICSPIRAL ->  drawing.drawConicSpiral(loc,Particle.COMPOSTER,null,0.3,100,Math.PI / 2, rotY, 0);
                case CYLINDERSPIRAL -> drawing.drawCylinderSpiral(loc, Particle.COMPOSTER, null, 2,100,Math.PI / 2, rotY, 0);
                case ASTEROID -> drawing.drawAsteroid(loc, Particle.COMPOSTER, null, 2,100, Math.PI / 2, rotY, 0);
                case CYCLOID -> drawing.drawCycloid(loc, Particle.COMPOSTER, null, 1, 3, 100, - Math.PI / 2, rotY - Math.PI / 2, 0);
                case HEART -> drawing.drawHeart(loc, Particle.COMPOSTER, null, 1, 100, - Math.PI / 2, rotY, 0);
                case LIMASON -> drawing.drawLimason(loc, Particle.COMPOSTER, null, 2, 100, 0, rotY, Math.PI / 2);
                case LISSAJOUS -> drawing.drawLissajous(loc, Particle.COMPOSTER, null, 2,3,2,1,Math.PI / 6, 100, 0, rotY, Math.PI / 2);
                default -> drawing.drawSpiralSphere(loc, Particle.COMPOSTER, null,2, 400, 0, 0, 0);

            }



        }
    }
}
