package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.CommandAPI;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public final class ParticleDrawing extends JavaPlugin {

    private static ParticleDrawing INSTANCE;

    public static DrawingModel model = DrawingModel.CIRCLE;
    public static Set<Player> eventPlayer = new HashSet<>();

    @Override
    public void onEnable() {
        INSTANCE = this;
        CommandAPI.registerCommand(DrawCommand.class);
        new EventListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ParticleDrawing getInstance() {
        return INSTANCE;
    }


}
