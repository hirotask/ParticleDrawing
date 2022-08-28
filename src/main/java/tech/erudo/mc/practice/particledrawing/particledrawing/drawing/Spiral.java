package tech.erudo.mc.practice.particledrawing.particledrawing.drawing;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

/**
 * 渦巻を表示するためのクラス
 */
public class Spiral {

    public void drawSpiral(Location origin, double radius, int points) {
        for (int i = 0; i < points; i++) {
            double angle = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * angle * Math.sin(angle), 0, radius * angle * Math.cos(angle));
            origin.add(point);
            origin.getWorld().spawnParticle(Particle.SPELL_INSTANT, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }
}
