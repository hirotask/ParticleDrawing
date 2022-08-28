package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.CommandAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class ParticleDrawing extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandAPI.registerCommand(DrawCommand.class);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
