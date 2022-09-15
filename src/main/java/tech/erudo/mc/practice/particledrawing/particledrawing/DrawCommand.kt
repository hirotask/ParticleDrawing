package tech.erudo.mc.practice.particledrawing.particledrawing

import dev.jorel.commandapi.annotations.Command
import dev.jorel.commandapi.annotations.Default
import dev.jorel.commandapi.annotations.Subcommand
import dev.jorel.commandapi.annotations.arguments.ABooleanArgument
import dev.jorel.commandapi.annotations.arguments.AMultiLiteralArgument
import org.bukkit.Particle
import org.bukkit.entity.Player
import tech.erudo.mc.practice.particledrawing.particledrawing.ParticleDrawing.Companion.eventPlayer
import tech.erudo.mc.practice.particledrawing.particledrawing.ParticleDrawing.Companion.instance
import tech.erudo.mc.practice.particledrawing.particledrawing.ParticleDrawing.Companion.model

@Command("draw")
object DrawCommand {
    private val helpMsgs = arrayOf(
        "Helpです"
    )
    private val drawing = Drawing(instance)
    @JvmStatic
    @Default
    fun draw(player: Player) {
        if (eventPlayer.contains(player)) {
            player.sendMessage("パーティクルが出なくなりました")
            eventPlayer.minus(player)
        } else {
            player.sendMessage("パーティクルが出るようになりました")
            eventPlayer.plus(player)
        }
    }

    @JvmStatic
    @Subcommand("help")
    fun help(player: Player) {
        player.sendMessage(*helpMsgs)
    }

    @JvmStatic
    @Subcommand("model")
    fun model(
        player: Player,
        @AMultiLiteralArgument(
            "CIRCLE",
            "SPIRAL",
            "CONICSPIRAL",
            "CYLINDERSPIRAL",
            "SPIRALSPHERE",
            "ASTEROID",
            "HEART",
            "LISSAJOUS",
            "LIMASON",
            "CYCLOID"
        ) modelName: String
    ) {
        model = DrawingModel.valueOf(modelName)
        player.sendMessage("描画する図形を" + modelName + "に変更")
    }

    @JvmStatic
    @Subcommand("circle")
    fun circle(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimCircle<Any?>(loc, Particle.NOTE, null, 3.0, 50, 0.0, 0.0, 0.0)
        } else {
            drawing.drawCircle<Any?>(loc, Particle.SPELL_INSTANT, null, 3.0, 50, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("spiral")
    fun spiral(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimSpiral<Any?>(loc, Particle.NOTE, null, 0.2, 300, 0.0, 0.0, 0.0)
        } else {
            drawing.drawSpiral<Any?>(loc, Particle.SPELL_INSTANT, null, 0.2, 300, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("conicspiral")
    fun conicSpiral(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimConicSpiral<Any?>(loc, Particle.NOTE, null, 0.2, 300, 0.0, 0.0, 0.0)
        } else {
            drawing.drawConicSpiral<Any?>(loc, Particle.SPELL_INSTANT, null, 0.2, 300, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("cylinderspiral")
    fun cylinderspiral(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimCyliderSpiral<Any?>(loc, Particle.NOTE, null, 2.0, 300, 0.0, 0.0, 0.0)
        } else {
            drawing.drawCylinderSpiral<Any?>(loc, Particle.SPELL_INSTANT, null, 2.0, 300, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("spiralsphere")
    fun spiralSphere(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimSpiralSphere<Any?>(loc, Particle.NOTE, null, 2.0, 400, 0.0, 0.0, 0.0)
        } else {
            drawing.drawSpiralSphere<Any?>(loc, Particle.SPELL_INSTANT, null, 2.0, 400, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("asteroid")
    fun asteroid(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimAsteroid<Any?>(loc, Particle.NOTE, null, 2.0, 100, 0.0, 0.0, 0.0)
        } else {
            drawing.drawAsteroid<Any?>(loc, Particle.SPELL_INSTANT, null, 2.0, 100, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("heart")
    fun heart(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimHeart<Any?>(loc, Particle.NOTE, null, 1.0, 100, 0.0, 0.0, 0.0)
        } else {
            drawing.drawHeart<Any?>(loc, Particle.SPELL_INSTANT, null, 1.0, 100, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("lissajous")
    fun lissajous(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimLissajous<Any?>(
                loc,
                Particle.NOTE,
                null,
                2.0,
                3.0,
                2.0,
                1.0,
                Math.PI / 6,
                100,
                0.0,
                0.0,
                0.0
            )
        } else {
            drawing.drawLissajous<Any?>(
                loc,
                Particle.SPELL_INSTANT,
                null,
                2.0,
                3.0,
                2.0,
                1.0,
                Math.PI / 6,
                100,
                0.0,
                0.0,
                0.0
            )
        }
    }

    @JvmStatic
    @Subcommand("limason")
    fun limason(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimLimason<Any?>(loc, Particle.NOTE, null, 1.0, 100, 0.0, 0.0, 0.0)
        } else {
            drawing.drawLimason<Any?>(loc, Particle.SPELL_INSTANT, null, 1.0, 100, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("cycloid")
    fun cycloid(player: Player, @ABooleanArgument isAnim: Boolean) {
        val loc = player.location
        if (isAnim) {
            drawing.drawAnimCycloid<Any?>(loc, Particle.NOTE, null, 1.0, 3.0, 100, 0.0, 0.0, 0.0)
        } else {
            drawing.drawCycloid<Any?>(loc, Particle.SPELL_INSTANT, null, 1.0, 3.0, 100, 0.0, 0.0, 0.0)
        }
    }

    @JvmStatic
    @Subcommand("star")
    fun star(player: Player) {
        val loc = player.location
        val a = 0.81
        val b = 0.14
        val xmax = Math.sqrt(-(1 / Math.pow(b, 2.0)) * Math.log(2 * Math.pow(Math.E, -Math.pow(a, 2.0)) - 1))
        drawing.drawStar<Any?>(loc, Particle.SPELL_INSTANT, null, 0.81, 0.14, 1.0, 0.1 * xmax, 5, 100, 0.0, 0.0, 0.0)
    }
}