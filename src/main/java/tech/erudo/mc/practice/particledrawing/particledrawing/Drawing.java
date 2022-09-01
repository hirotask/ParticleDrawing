package tech.erudo.mc.practice.particledrawing.particledrawing;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * パーティクルで様々な形を作り描画してくれるクラス
 */
public class Drawing {

    private JavaPlugin plugin;

    public Drawing(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    /**
     * 指定したパーティクルで円を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   円の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawCircle(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 2 * Math.PI / points;
            Vector point = new Vector(radius * Math.cos(t), 0, radius * Math.sin(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            // spawn something at origin
            origin.getWorld().spawnParticle(particle, origin, 10);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする円を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   円の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawAnimCircle(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {

        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
                    double t = i * 2 * Math.PI / points;
                    Vector point = new Vector(radius * Math.cos(t), 0, radius * Math.sin(t));
                    rotX(point, rotX);
                    rotY(point, rotY);
                    rotZ(point, rotZ);
                    origin.add(point);
                    // spawn something at origin
                    origin.getWorld().spawnParticle(particle, origin, 1);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }
                i++;
            }
        }.runTaskTimer(plugin, 0, 1);


    }

    /**
     * 指定したパーティクルで渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawSpiral(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * t * Math.sin(t), 0, radius * t * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawAnimSpiral(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {

        new BukkitRunnable() {
            int i = 0;

            @Override
            public void run() {
                if (i < points) {
                    double t = i * 8 * Math.PI / points;
                    Vector point = new Vector(radius * t * Math.sin(t), 0, radius * t * Math.cos(t));
                    rotX(point, rotX);
                    rotY(point, rotY);
                    rotZ(point, rotZ);
                    origin.add(point);
                    // spawn something at origin
                    origin.getWorld().spawnParticle(particle, origin, 1);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);


    }

    /**
     * 指定したパーティクルで円錐形の渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawConicSpiral(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * t * Math.sin(t), radius * t, radius * t * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする円錐形の渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawAnimConicSpiral(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
                    double t = i * 8 * Math.PI / points;
                    Vector point = new Vector(radius * t * Math.sin(t), radius * t, radius * t * Math.cos(t));
                    rotX(point, rotX);
                    rotY(point, rotY);
                    rotZ(point, rotZ);
                    origin.add(point);
                    origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルで円柱形の渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawCylinderSpiral(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * Math.sin(t), radius * t, radius * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルで渦巻からなる球形を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   球の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawSpiralSphere(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(
                    radius * Math.sin(t / 10 * Math.PI),
                    radius * Math.sin((t % 10) * Math.PI) * Math.cos(t / 10 * Math.PI),
                    radius * Math.cos((t % 10) * Math.PI) * Math.cos(t / 10 * Math.PI)
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアステロイドを描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param radius:   アステロイドの半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawAsteroid(Location origin, Particle particle, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(
                    radius * Math.pow(Math.cos(t), 3),
                    0,
                    radius * Math.pow(Math.sin(t), 3)
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでハートを描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param size:     大きさ（１がデフォルト）
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawHeart(Location origin, Particle particle, double size, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 2 * Math.PI / points;
            Vector point = new Vector(
                    size * (16 * Math.pow(Math.sin(t), 3)) / 3,
                    0,
                    size * (13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)) / 3
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでリサージュ曲線を描画するメソッド
     * 数式は以下の通り
     * x = Asin(at + δ)
     * y = Bsin(bt)
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param A:        パラメータA
     * @param B:        パラメータB
     * @param a:        パラメータa
     * @param b:        パラメータb
     * @param delta:    パラメータδ
     * @param points:   図形を表す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawLissajous(Location origin, Particle particle, double A, double B, double a, double b, double delta, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 2 * Math.PI / points;
            Vector point = new Vector(
                    A * Math.sin(a * t + delta),
                    0,
                    B * Math.sin(b * t)
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでリマソン曲線を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param size:     大きさ（１がデフォルト）
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public void drawLimason(Location origin, Particle particle, double size, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 2 * Math.PI / points;
            Vector point = new Vector(
                    size * (1 + 2 * Math.cos(t)) * Math.cos(t),
                    0,
                    size * (1 + 2 * Math.cos(t)) * Math.sin(t)
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでリサージュ曲線を描画するメソッド
     * 数式は以下の通り
     * x = a(t - sin(t))
     * y = a(1 - cos(t))
     *
     * @param origin:        描画するLocation
     * @param particle:      パーティクルの種類
     * @param a:             一回転の長さ
     * @param scrollNum:回転回数
     * @param points:        図形を成す点の数
     * @param rotX:          X軸回りに回転する角度
     * @param rotY:          Y軸回りに回転する角度
     * @param rotZ:          Z軸回りに回転する角度
     */
    public void drawCycloid(Location origin, Particle particle, double a, double scrollNum, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * scrollNum * 2 * Math.PI / points;
            Vector point = new Vector(
                    a * (t - Math.sin(t)),
                    0,
                    a * (1 - Math.cos(t))
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, 0, 0, 0);
            origin.subtract(point);
        }
    }


    /**
     * 与えたVectorをX軸回りでtだけ回転させる
     *
     * @param point: 回転させたいVector
     * @param t:     角度
     */
    private void rotX(Vector point, double t) {
        double y = point.getY();
        point.setY(y * Math.cos(t) - point.getZ() * Math.sin(t));
        point.setZ(y * Math.sin(t) + point.getZ() * Math.cos(t));
    }

    /**
     * 与えたVectorをY軸回りでtだけ回転させる
     *
     * @param point: 回転させたいVector
     * @param t:     角度
     */
    private void rotY(Vector point, double t) {
        double z = point.getZ();
        point.setZ(z * Math.cos(t) - point.getX() * Math.sin(t));
        point.setX(z * Math.sin(t) + point.getX() * Math.cos(t));
    }

    /**
     * 与えたVectorをZ軸回りでtだけ回転させる
     *
     * @param point: 回転させたいVector
     * @param t:     角度
     */
    private void rotZ(Vector point, double t) {
        double x = point.getX();
        point.setX(x * Math.cos(t) - point.getY() * Math.sin(t));
        point.setY(x * Math.sin(t) + point.getY() * Math.cos(t));
    }

}
