package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Subcommand;
import dev.jorel.commandapi.annotations.arguments.ABooleanArgument;
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
    public static void circle(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimCircle(loc, Particle.NOTE, null,3, 50, 0,0,0);
        } else {
            drawing.drawCircle(loc, Particle.SPELL_INSTANT,null, 3, 50, 0, 0, 0);
        }

    }

    @Subcommand("spiral")
    public static void spiral(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimSpiral(loc, Particle.NOTE, null,0.2, 300, 0, 0, 0);
        } else {
            drawing.drawSpiral(loc, Particle.SPELL_INSTANT, null,0.2, 300, 0, 0, 0);
        }
    }

    @Subcommand("conicspiral")
    public static void conicSpiral(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimConicSpiral(loc, Particle.NOTE, null,0.2, 300, 0, 0, 0);
        } else {
            drawing.drawConicSpiral(loc, Particle.SPELL_INSTANT, null,0.2, 300, 0, 0, 0);
        }
    }

    @Subcommand("cylinderspiral")
    public static void cylinderspiral(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimCyliderSpiral(loc, Particle.NOTE, null,2, 300, 0, 0, 0);
        } else {
            drawing.drawCylinderSpiral(loc, Particle.SPELL_INSTANT, null,2, 300, 0, 0, 0);

        }
    }

    @Subcommand("spiralsphere")
    public static void spiralSphere(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimSpiralSphere(loc, Particle.NOTE, null,2, 400, 0, 0, 0);
        } else {
            drawing.drawSpiralSphere(loc, Particle.SPELL_INSTANT, null,2, 400, 0, 0, 0);

        }
    }

    @Subcommand("asteroid")
    public static void asteroid(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimAsteroid(loc, Particle.NOTE, null,2, 100, 0, 0, 0);
        } else {
            drawing.drawAsteroid(loc, Particle.SPELL_INSTANT, null,2, 100, 0, 0, 0);

        }
    }

    @Subcommand("heart")
    public static void heart(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimHeart(loc, Particle.NOTE, null,1, 100, 0, 0, 0);
        } else {
            drawing.drawHeart(loc, Particle.SPELL_INSTANT, null,1, 100, 0, 0, 0);
        }
    }

    @Subcommand("lissajous")
    public static void lissajous(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimLissajous(loc, Particle.NOTE, null,2,3,2,1,Math.PI / 6,100,0,0,0);
        } else {
            drawing.drawLissajous(loc, Particle.SPELL_INSTANT, null,2,3,2,1,Math.PI / 6,100,0,0,0);

        }
    }

    @Subcommand("limason")
    public static void limason(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimLimason(loc, Particle.NOTE, null,1, 100, 0,0,0);
        } else {
            drawing.drawLimason(loc, Particle.SPELL_INSTANT, null,1, 100, 0,0,0);

        }
    }

    @Subcommand("cycloid")
    public static void cycloid(Player player, @ABooleanArgument boolean isAnim) {
        Location loc = player.getLocation();
        if(isAnim) {
            drawing.drawAnimCycloid(loc, Particle.NOTE, null,1, 3, 100,0,0,0);
        } else {
            drawing.drawCycloid(loc, Particle.SPELL_INSTANT, null,1, 3, 100,0,0,0);

        }
    }

}
