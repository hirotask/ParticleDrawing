package tech.erudo.mc.practice.particledrawing.particledrawing

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.util.Vector
import kotlin.math.cos
import kotlin.math.sin

/**
 * パーティクルで様々な形を作り描画してくれるクラス
 */
class Drawing(private val plugin: JavaPlugin) {
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
    fun <T> drawCircle(
        origin: Location,
        particle: Particle? = Particle.SPELL_INSTANT,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 2 * Math.PI / points
            val point = Vector(radius * Math.cos(t), 0.0, radius * Math.sin(t))
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            // spawn something at origin
            origin.world.spawnParticle<T>(particle!!, origin, 10, data)
            origin.subtract(point)
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
    fun <T> drawAnimCircle(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 2 * Math.PI / points
                    val point = Vector(radius * Math.cos(t), 0.0, radius * Math.sin(t))
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    // spawn something at origin
                    origin.world.spawnParticle<T>(particle!!, origin, 10, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawSpiral(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 8 * Math.PI / points
            val point = Vector(radius * t * Math.sin(t), 0.0, radius * t * Math.cos(t))
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimSpiral(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 8 * Math.PI / points
                    val point = Vector(radius * t * Math.sin(t), 0.0, radius * t * Math.cos(t))
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    // spawn something at origin
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawConicSpiral(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 8 * Math.PI / points
            val point = Vector(radius * t * Math.sin(t), radius * t, radius * t * Math.cos(t))
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimConicSpiral(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 8 * Math.PI / points
                    val point = Vector(radius * t * Math.sin(t), radius * t, radius * t * Math.cos(t))
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawCylinderSpiral(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 8 * Math.PI / points
            val point = Vector(radius * Math.sin(t), radius * t, radius * Math.cos(t))
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimCyliderSpiral(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 8 * Math.PI / points
                    val point = Vector(radius * Math.sin(t), radius * t, radius * Math.cos(t))
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawSpiralSphere(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 8 * Math.PI / points
            val point = Vector(
                radius * Math.sin(t / 10 * Math.PI),
                radius * Math.sin(t % 10 * Math.PI) * Math.cos(t / 10 * Math.PI),
                radius * Math.cos(t % 10 * Math.PI) * Math.cos(t / 10 * Math.PI)
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimSpiralSphere(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 8 * Math.PI / points
                    val point = Vector(
                        radius * Math.sin(t / 10 * Math.PI),
                        radius * Math.sin(t % 10 * Math.PI) * Math.cos(t / 10 * Math.PI),
                        radius * Math.cos(t % 10 * Math.PI) * Math.cos(t / 10 * Math.PI)
                    )
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawAsteroid(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 8 * Math.PI / points
            val point = Vector(
                radius * Math.pow(Math.cos(t), 3.0),
                0.0,
                radius * Math.pow(Math.sin(t), 3.0)
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimAsteroid(
        origin: Location,
        particle: Particle?,
        data: T,
        radius: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 8 * Math.PI / points
                    val point = Vector(
                        radius * Math.pow(Math.cos(t), 3.0),
                        0.0,
                        radius * Math.pow(Math.sin(t), 3.0)
                    )
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawHeart(
        origin: Location,
        particle: Particle?,
        data: T,
        size: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 2 * Math.PI / points
            val point = Vector(
                size * (16 * Math.pow(Math.sin(t), 3.0)) / 3,
                0.0,
                size * (13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)) / 3
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimHeart(
        origin: Location,
        particle: Particle?,
        data: T,
        size: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 2 * Math.PI / points
                    val point = Vector(
                        size * (16 * Math.pow(Math.sin(t), 3.0)) / 3,
                        0.0,
                        size * (13 * Math.cos(t) - 5 * Math.cos(2 * t) - 2 * Math.cos(3 * t) - Math.cos(4 * t)) / 3
                    )
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 10, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawLissajous(
        origin: Location,
        particle: Particle?,
        data: T,
        A: Double,
        B: Double,
        a: Double,
        b: Double,
        delta: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 2 * Math.PI / points
            val point = Vector(
                A * Math.sin(a * t + delta),
                0.0,
                B * Math.sin(b * t)
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 10, data)
            origin.subtract(point)
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
    fun <T> drawAnimLissajous(
        origin: Location,
        particle: Particle?,
        data: T,
        A: Double,
        B: Double,
        a: Double,
        b: Double,
        delta: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 2 * Math.PI / points
                    val point = Vector(
                        A * Math.sin(a * t + delta),
                        0.0,
                        B * Math.sin(b * t)
                    )
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawLimason(
        origin: Location,
        particle: Particle?,
        data: T,
        size: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * 2 * Math.PI / points
            val point = Vector(
                size * (1 + 2 * Math.cos(t)) * Math.cos(t),
                0.0,
                size * (1 + 2 * Math.cos(t)) * Math.sin(t)
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimLimason(
        origin: Location,
        particle: Particle?,
        data: T,
        size: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * 2 * Math.PI / points
                    val point = Vector(
                        size * (1 + 2 * Math.cos(t)) * Math.cos(t),
                        0.0,
                        size * (1 + 2 * Math.cos(t)) * Math.sin(t)
                    )
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
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
    fun <T> drawCycloid(
        origin: Location,
        particle: Particle?,
        data: T,
        a: Double,
        scrollNum: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        for (i in 0 until points) {
            val t = i * scrollNum * 2 * Math.PI / points
            val point = Vector(
                a * (t - Math.sin(t)),
                0.0,
                a * (1 - Math.cos(t))
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
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
    fun <T> drawAnimCycloid(
        origin: Location,
        particle: Particle?,
        data: T,
        a: Double,
        scrollNum: Double,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        object : BukkitRunnable() {
            var i = 0
            override fun run() {
                if (i < points) {
                    val t = i * scrollNum * 2 * Math.PI / points
                    val point = Vector(
                        a * (t - Math.sin(t)),
                        0.0,
                        a * (1 - Math.cos(t))
                    )
                    rotX(point, rotX)
                    rotY(point, rotY)
                    rotZ(point, rotZ)
                    origin.add(point)
                    origin.world.spawnParticle<T>(particle!!, origin, 1, data)
                    origin.subtract(point)
                } else {
                    cancel()
                }
                i++
            }
        }.runTaskTimer(plugin, 0, 1)
    }

    fun <T> drawStar(
        origin: Location,
        particle: Particle?,
        data: T,
        a: Double,
        b: Double,
        c: Double,
        r0: Double,
        n: Int,
        points: Int,
        rotX: Double,
        rotY: Double,
        rotZ: Double
    ) {
        val xmax = Math.sqrt(-(1 / Math.pow(b, 2.0)) * Math.log(2 * Math.pow(Math.E, -Math.pow(a, 2.0)) - 1))
        for (i in 0 until points) {
            val t = i * 2 * Math.PI / points
            val r = r0 + 1 / c * Math.sqrt(
                -Math.log(
                    2 * Math.pow(Math.E, -Math.pow(a, 2.0)) - Math.pow(
                        Math.E, -Math.pow(b, 2.0) * Math.pow(xmax, 2.0) * Math.pow(
                            Math.sin((t - Math.PI / 2) * n / 2), 2.0
                        )
                    )
                )
            )
            val point = Vector(
                r * Math.cos(t),
                0.0,
                r * Math.sin(t)
            )
            rotX(point, rotX)
            rotY(point, rotY)
            rotZ(point, rotZ)
            origin.add(point)
            origin.world.spawnParticle<T>(particle!!, origin, 1, data)
            origin.subtract(point)
        }
    }

    /**
     * 与えたVectorをX軸回りでtだけ回転させる
     *
     * @param point: 回転させたいVector
     * @param t:     角度
     */
    private fun rotX(point: Vector, t: Double) {
        val y = point.y
        point.y = y * cos(t) - point.z * sin(t)
        point.z = y * sin(t) + point.z * cos(t)
    }

    /**
     * 与えたVectorをY軸回りでtだけ回転させる
     *
     * @param point: 回転させたいVector
     * @param t:     角度
     */
    private fun rotY(point: Vector, t: Double) {
        val z = point.z
        point.z = z * cos(t) - point.x * sin(t)
        point.x = z * sin(t) + point.x * cos(t)
    }

    /**
     * 与えたVectorをZ軸回りでtだけ回転させる
     *
     * @param point: 回転させたいVector
     * @param t:     角度
     */
    private fun rotZ(point: Vector, t: Double) {
        val x = point.x
        point.x = x * cos(t) - point.y * sin(t)
        point.y = x * sin(t) + point.y * cos(t)
    }
}