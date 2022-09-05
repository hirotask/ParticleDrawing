package tech.erudo.mc.practice.particledrawing.particledrawing;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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
     * @param data      :    パーティクルのデータ
     * @param radius:   円の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawCircle(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 2 * Math.PI / points;
            Vector point = new Vector(radius * Math.cos(t), 0, radius * Math.sin(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            // spawn something at origin
            origin.getWorld().spawnParticle(particle, origin, 10, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする円を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   円の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimCircle(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {

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
                    origin.getWorld().spawnParticle(particle, origin, 10, data);
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
     * @param data      :    パーティクルのデータ
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawSpiral(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * t * Math.sin(t), 0, radius * t * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimSpiral(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {

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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
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
     * @param data      :    パーティクルのデータ
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawConicSpiral(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * t * Math.sin(t), radius * t, radius * t * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする円錐形の渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimConicSpiral(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
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
     * @param data      :    パーティクルのデータ
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawCylinderSpiral(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        for (int i = 0; i < points; i++) {
            double t = i * 8 * Math.PI / points;
            Vector point = new Vector(radius * Math.sin(t), radius * t, radius * Math.cos(t));
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする円柱形の渦巻を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   渦巻の真ん中の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimCyliderSpiral(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
                    double t = i * 8 * Math.PI / points;
                    Vector point = new Vector(radius * Math.sin(t), radius * t, radius * Math.cos(t));
                    rotX(point, rotX);
                    rotY(point, rotY);
                    rotZ(point, rotZ);
                    origin.add(point);
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルで渦巻からなる球形を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   球の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawSpiralSphere(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
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
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションする渦巻からなる球形を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   球の半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimSpiralSphere(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルでアステロイドを描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   アステロイドの半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAsteroid(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
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
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションするアステロイドを描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param radius:   アステロイドの半径
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimAsteroid(Location origin, Particle particle, T data, double radius, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルでハートを描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param size:     大きさ（１がデフォルト）
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawHeart(Location origin, Particle particle, T data, double size, int points, double rotX, double rotY, double rotZ) {
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
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションするハートを描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param size:     大きさ（１がデフォルト）
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimHeart(Location origin, Particle particle, T data, double size, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
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
                    origin.getWorld().spawnParticle(particle, origin, 10, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルでリサージュ曲線を描画するメソッド
     * 数式は以下の通り
     * x = Asin(at + δ)
     * y = Bsin(bt)
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
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
    public <T> void drawLissajous(Location origin, Particle particle, T data, double A, double B, double a, double b, double delta, int points, double rotX, double rotY, double rotZ) {
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
            origin.getWorld().spawnParticle(particle, origin, 10, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションするリサージュ曲線を描画するメソッド
     * 数式は以下の通り
     * x = Asin(at + δ)
     * y = Bsin(bt)
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
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
    public <T> void drawAnimLissajous(Location origin, Particle particle, T data, double A, double B, double a, double b, double delta, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルでリマソン曲線を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param size:     大きさ（１がデフォルト）
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawLimason(Location origin, Particle particle, T data, double size, int points, double rotX, double rotY, double rotZ) {
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
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでアニメーションするリマソン曲線を描画するメソッド
     *
     * @param origin:   描画するLocation
     * @param particle: パーティクルの種類
     * @param data      :    パーティクルのデータ
     * @param size:     大きさ（１がデフォルト）
     * @param points:   図形を成す点の数
     * @param rotX:     X軸回りに回転する角度
     * @param rotY:     Y軸回りに回転する角度
     * @param rotZ:     Z軸回りに回転する角度
     */
    public <T> void drawAnimLimason(Location origin, Particle particle, T data, double size, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    /**
     * 指定したパーティクルでサイクロイドを描画するメソッド
     *
     * @param origin:    描画するLocation
     * @param particle:  パーティクルの種類
     * @param data       :    パーティクルのデータ
     * @param a:         一回転の長さ
     * @param scrollNum: 回転回数
     * @param points:    図形を成す点の数
     * @param rotX:      X軸回りに回転する角度
     * @param rotY:      Y軸回りに回転する角度
     * @param rotZ:      Z軸回りに回転する角度
     */
    public <T> void drawCycloid(Location origin, Particle particle, T data, double a, double scrollNum, int points, double rotX, double rotY, double rotZ) {
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
            origin.getWorld().spawnParticle(particle, origin, 1, data);
            origin.subtract(point);
        }
    }

    /**
     * 指定したパーティクルでサイクロイドを描画するメソッド
     *
     * @param origin:    描画するLocation
     * @param particle:  パーティクルの種類
     * @param data       :    パーティクルのデータ
     * @param a:         一回転の長さ
     * @param scrollNum: 回転回数
     * @param points:    図形を成す点の数
     * @param rotX:      X軸回りに回転する角度
     * @param rotY:      Y軸回りに回転する角度
     * @param rotZ:      Z軸回りに回転する角度
     */
    public <T> void drawAnimCycloid(Location origin, Particle particle, T data, double a, double scrollNum, int points, double rotX, double rotY, double rotZ) {
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                if (i < points) {
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
                    origin.getWorld().spawnParticle(particle, origin, 1, data);
                    origin.subtract(point);
                } else {
                    this.cancel();
                }

                i++;
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public <T> void drawStar(
            Location origin,
            Particle particle,
            T data,
            double a,
            double b,
            double c,
            double r0,
            int n,
            int points,
            double rotX,
            double rotY,
            double rotZ
    ) {
        double xmax = Math.sqrt(-(1 / Math.pow(b, 2)) * Math.log(2 * Math.pow(Math.E, -Math.pow(a, 2)) - 1));
        for (int i = 0; i < points; i++) {
            double t = i * 2 * Math.PI / points;
            double r = r0 + 1 / c * Math.sqrt(-Math.log(2 * Math.pow(Math.E, -Math.pow(a, 2)) - Math.pow(Math.E, -Math.pow(b, 2) * Math.pow(xmax, 2) * Math.pow(Math.sin((t - Math.PI / 2) * n / 2), 2))));
            Vector point = new Vector(
                    r * Math.cos(t),
                    0,
                    r * Math.sin(t)
            );
            rotX(point, rotX);
            rotY(point, rotY);
            rotZ(point, rotZ);
            origin.add(point);
            origin.getWorld().spawnParticle(particle, origin, 1, data);
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
