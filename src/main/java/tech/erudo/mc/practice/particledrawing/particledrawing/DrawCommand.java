package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Subcommand;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("draw")
public class DrawCommand {

    private static final String[] helpMsgs = {
            "Helpです"
    };

    private static final Drawing drawing = new Drawing();

    @Default
    public static void draw(CommandSender sender) {
        sender.sendMessage(helpMsgs);
    }

    @Subcommand("circle")
    public static void circle(Player player) {
        Location loc = player.getLocation();
        drawing.drawCircle(loc,3, 50, Math.PI / 2,0,0);
    }

    @Subcommand("spiral")
    public static void spiral(Player player) {
        Location loc = player.getLocation();
        drawing.drawSpiral(loc, 0.2, 300, 0, 0,0);
    }

    @Subcommand("conicspiral")
    public static void conicSpiral(Player player) {
        Location loc = player.getLocation();
        drawing.drawConicSpiral(loc, 0.2, 300, 0, 0,0);
    }

    @Subcommand("cylinderspiral")
    public static void cylinderspiral(Player player) {
        Location loc = player.getLocation();
        drawing.drawCylinderSpiral(loc, 2, 300, 0, 0,0);
    }

    @Subcommand("spiralsphere")
    public static void spiralSphere(Player player) {
        Location loc = player.getLocation();
        drawing.drawSpiralSphere(loc, 2, 400, 0, 0,0);
    }

    @Subcommand("asteroid")
    public static void asteroid(Player player) {
        Location loc = player.getLocation();
        drawing.drawAsteroid(loc, 2, 100, 0, 0,0);
    }

}
