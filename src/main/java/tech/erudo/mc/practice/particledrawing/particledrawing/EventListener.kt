package tech.erudo.mc.practice.particledrawing.particledrawing

import org.bukkit.Particle
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class EventListener(private val plugin: JavaPlugin) : Listener {
    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        if (e.action == Action.RIGHT_CLICK_AIR ||
            e.action == Action.RIGHT_CLICK_BLOCK
        ) {
            val player = e.player
            if (!ParticleDrawing.eventPlayer.contains(player)) {
                return
            }
            val loc = player.location
            val yaw = player.location.yaw
            val rotY = -Math.toRadians(yaw.toDouble())
            val drawing = Drawing(plugin)
            when (ParticleDrawing.model) {
                DrawingModel.CIRCLE -> drawing.drawCircle<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    3.0,
                    100,
                    Math.PI / 2,
                    rotY,
                    0.0
                )
                DrawingModel.SPIRAL -> drawing.drawSpiral<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    0.3,
                    100,
                    Math.PI / 2,
                    rotY,
                    0.0
                )
                DrawingModel.CONICSPIRAL -> drawing.drawConicSpiral<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    0.3,
                    100,
                    Math.PI / 2,
                    rotY,
                    0.0
                )
                DrawingModel.CYLINDERSPIRAL -> drawing.drawCylinderSpiral<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    2.0,
                    100,
                    Math.PI / 2,
                    rotY,
                    0.0
                )
                DrawingModel.ASTEROID -> drawing.drawAsteroid<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    2.0,
                    100,
                    Math.PI / 2,
                    rotY,
                    0.0
                )
                DrawingModel.CYCLOID -> drawing.drawCycloid<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    1.0,
                    3.0,
                    100,
                    -Math.PI / 2,
                    rotY - Math.PI / 2,
                    0.0
                )
                DrawingModel.HEART -> drawing.drawHeart<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    1.0,
                    100,
                    -Math.PI / 2,
                    rotY,
                    0.0
                )
                DrawingModel.LIMASON -> drawing.drawLimason<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    2.0,
                    100,
                    0.0,
                    rotY,
                    Math.PI / 2
                )
                DrawingModel.LISSAJOUS -> drawing.drawLissajous<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    2.0,
                    3.0,
                    2.0,
                    1.0,
                    Math.PI / 6,
                    100,
                    0.0,
                    rotY,
                    Math.PI / 2
                )
                DrawingModel.SPIRALSPHERE -> drawing.drawSpiralSphere<Any?>(
                    loc,
                    Particle.COMPOSTER,
                    null,
                    2.0,
                    400,
                    0.0,
                    0.0,
                    0.0
                )

                else -> drawing.drawSpiralSphere<Any?>(loc, Particle.COMPOSTER, null, 2.0, 400, 0.0, 0.0, 0.0)
            }
        }
    }
}