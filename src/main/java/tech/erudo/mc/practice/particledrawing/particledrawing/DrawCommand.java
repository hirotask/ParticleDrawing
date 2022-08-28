package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Subcommand;
import dev.jorel.commandapi.annotations.arguments.AParticleArgument;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.erudo.mc.practice.particledrawing.particledrawing.drawing.Circle;
import tech.erudo.mc.practice.particledrawing.particledrawing.drawing.Spiral;

@Command("draw")
public class DrawCommand {

    private static final String[] helpMsgs = {
            "Helpです"
    };

    @Default
    public static void draw(CommandSender sender) {
        sender.sendMessage(helpMsgs);
    }

    @Subcommand("circle")
    public static void circle(Player player) {
        Location loc = player.getLocation();
        Circle circle = new Circle();
        circle.drawCircle(loc, Particle.SPELL, 3, 50, Math.PI / 2,0,0);
    }

    @Subcommand("spiral")
    public static void spiral(Player player) {
        Location loc = player.getLocation();
        Spiral spiral = new Spiral();
        spiral.drawSpiral(loc, 0.4, 300);
    }

}
