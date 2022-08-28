package tech.erudo.mc.practice.particledrawing.particledrawing.drawing;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public class Circle {

    public void drawCircle(Location origin, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i ++) {
            double angle = i * 2 * Math.PI / points;
            Vector point = new Vector(radius * Math.cos(angle), 0, radius * Math.sin(angle));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            // spawn something at origin
            origin.getWorld().spawnParticle(Particle.REDSTONE, origin, 10);
            origin.subtract(point);
        }
    }

    private void rotX(Vector point, double angle) {
        double y = point.getY();
        point.setY(y * Math.cos(angle) - point.getZ() * Math.sin(angle));
        point.setZ(y * Math.sin(angle) + point.getZ() * Math.cos(angle));
    }

    private void rotY(Vector point, double angle) {
        double z = point.getZ();
        point.setZ(z * Math.cos(angle) - point.getX() * Math.sin(angle));
        point.setX(z * Math.sin(angle) + point.getX() * Math.cos(angle));
    }

    private void rotZ(Vector point, double angle) {
        double x = point.getX();
        point.setX(x * Math.cos(angle) - point.getY() * Math.sin(angle));
        point.setY(x * Math.sin(angle) + point.getY() * Math.cos(angle));
    }
}
