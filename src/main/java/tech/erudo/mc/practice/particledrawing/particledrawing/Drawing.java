package tech.erudo.mc.practice.particledrawing.particledrawing;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public class Drawing {
    public void drawCircle(Location origin, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i ++) {
            double t = i * 2 * Math.PI / points;
            Vector point = new Vector(radius * Math.cos(t), 0, radius * Math.sin(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            // spawn something at origin
            origin.getWorld().spawnParticle(Particle.SPELL_INSTANT, origin, 10);
            origin.subtract(point);
        }
    }

    public void drawSpiral(Location origin, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * t * Math.sin(t), 0, radius * t * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(Particle.SPELL_INSTANT, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    public void drawConicSpiral(Location origin, double radius, int points, double rotX, double rotY, double rotZ) {
        for(int i=0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * t * Math.sin(t), radius * t, radius * t * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(Particle.SPELL_INSTANT, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    public void drawCylinderSpiral(Location origin, double radius, int points, double rotX, double rotY, double rotZ) {
        for(int i=0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius*Math.sin(t), radius*t, radius*Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(Particle.SPELL_INSTANT, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }



    private void rotX(Vector point, double t) {
        double y = point.getY();
        point.setY(y * Math.cos(t) - point.getZ() * Math.sin(t));
        point.setZ(y * Math.sin(t) + point.getZ() * Math.cos(t));
    }

    private void rotY(Vector point, double t) {
        double z = point.getZ();
        point.setZ(z * Math.cos(t) - point.getX() * Math.sin(t));
        point.setX(z * Math.sin(t) + point.getX() * Math.cos(t));
    }

    private void rotZ(Vector point, double t) {
        double x = point.getX();
        point.setX(x * Math.cos(t) - point.getY() * Math.sin(t));
        point.setY(x * Math.sin(t) + point.getY() * Math.cos(t));
    }

}
