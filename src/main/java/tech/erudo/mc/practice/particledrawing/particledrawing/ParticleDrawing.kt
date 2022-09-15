package tech.erudo.mc.practice.particledrawing.particledrawing

import dev.jorel.commandapi.CommandAPI
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class ParticleDrawing : JavaPlugin() {
    companion object {
        internal lateinit var instance: ParticleDrawing
        var model = DrawingModel.CIRCLE
        var eventPlayer: Set<Player> = HashSet()
    }

    init {
        instance = this
    }

    override fun onEnable() {
        CommandAPI.registerCommand(DrawCommand::class.java)
        EventListener(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }


}