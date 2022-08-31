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

    private static final Drawing drawing = new Drawing(ParticleDrawing.getInstance());

    @Default
    public static void draw(CommandSender sender) {
        sender.sendMessage(helpMsgs);
    }

    @Subcommand("circle")
    public static void circle(Player player) {
        Location loc = player.getLocation();
        drawing.drawCircle(loc, Particle.SPELL_INSTANT, 3, 50, Math.PI / 2, 0, 0);
    }

    @Subcommand("animcircle")
    public static void animCircle(Player player) {
        Location loc = player.getLocation();
        drawing.drawAnimCircle(loc, Particle.SPELL_INSTANT, 3, 50, 0,0,0,false);
    }

    @Subcommand("spiral")
    public static void spiral(Player player) {
        Location loc = player.getLocation();
        drawing.drawSpiral(loc, Particle.SPELL_INSTANT, 0.2, 300, 0, 0, 0);
    }

    @Subcommand("conicspiral")
    public static void conicSpiral(Player player) {
        Location loc = player.getLocation();
        drawing.drawConicSpiral(loc, Particle.SPELL_INSTANT, 0.2, 300, 0, 0, 0);
    }

    @Subcommand("cylinderspiral")
    public static void cylinderspiral(Player player) {
        Location loc = player.getLocation();
        drawing.drawCylinderSpiral(loc, Particle.SPELL_INSTANT, 2, 300, 0, 0, 0);
    }

    @Subcommand("spiralsphere")
    public static void spiralSphere(Player player) {
        Location loc = player.getLocation();
        drawing.drawSpiralSphere(loc, Particle.SPELL_INSTANT, 2, 400, 0, 0, 0);
    }

    @Subcommand("asteroid")
    public static void asteroid(Player player) {
        Location loc = player.getLocation();
        drawing.drawAsteroid(loc, Particle.SPELL_INSTANT, 2, 100, 0, 0, 0);
    }

    @Subcommand("heart")
    public static void heart(Player player) {
        Location loc = player.getLocation();
        drawing.drawHeart(loc, Particle.SPELL_INSTANT, 1, 100, 0, 0, 0);
    }

    @Subcommand("lissajous")
    public static void lissajous(Player player) {
        Location loc = player.getLocation();
        drawing.drawLissajous(loc, Particle.SPELL_INSTANT, 2,3,2,1,Math.PI / 6,100,0,0,0);
    }

    @Subcommand("limason")
    public static void limason(Player player) {
        Location loc = player.getLocation();
        drawing.drawLimason(loc, Particle.SPELL_INSTANT, 1, 100, 0,0,0);
    }

    @Subcommand("cycloid")
    public static void cycloid(Player player) {
        Location loc = player.getLocation();
        drawing.drawCycloid(loc, Particle.SPELL_INSTANT, 1, 3, 100,0,0,0);
    }

}
