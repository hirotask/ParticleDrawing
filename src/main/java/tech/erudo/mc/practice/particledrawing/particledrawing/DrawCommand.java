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

    @Default
    public static void draw(CommandSender sender) {
        sender.sendMessage(helpMsgs);
    }

    @Subcommand("circle")
    public static void circle(Player player) {
        Location loc = player.getLocation();
        Drawing circle = new Drawing();
        circle.drawCircle(loc,3, 50, Math.PI / 2,0,0);
    }

    @Subcommand("spiral")
    public static void spiral(Player player) {
        Location loc = player.getLocation();
        Drawing spiral = new Drawing();
        spiral.drawSpiral(loc, 0.4, 300, 0, 0,0);
    }

}
