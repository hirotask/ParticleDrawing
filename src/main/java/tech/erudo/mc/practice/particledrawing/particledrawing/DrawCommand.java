package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Subcommand;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tech.erudo.mc.practice.particledrawing.particledrawing.drawing.Circle;

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
        circle.drawCircle(loc, 3, 50, 0,0,0);
    }

}
