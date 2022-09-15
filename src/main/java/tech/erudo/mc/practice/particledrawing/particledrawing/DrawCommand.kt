package tech.erudo.mc.practice.particledrawing.particledrawing;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Subcommand;
import dev.jorel.commandapi.annotations.arguments.ABooleanArgument;
import dev.jorel.commandapi.annotations.arguments.AMultiLiteralArgument;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

@Command("draw")
public class DrawCommand {

    private static final String[] helpMsgs = {
            "Helpです"
    };

    private static final Drawing drawing = new Drawing(ParticleDrawing.Companion.getInstance$ParticleDrawing());

    @Default
    public static void draw(Player player) {
        if(ParticleDrawing.Companion.getEventPlayer().contains(player)) {
            player.sendMessage("パーティクルが出なくなりました");
            ParticleDrawing.Companion.getEventPlayer().remove(player);
        } else {
            player.sendMessage("パーティクルが出るようになりました");
            ParticleDrawing.Companion.getEventPlayer().add(player);
        }
    }

    @Subcommand("help")
    public static void help(Player player) {
        player.sendMessage(helpMsgs);
    }


    @Subcommand("model")
    public static void model(Player player, @AMultiLiteralArgument({
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
    }) String modelName) {
        ParticleDrawing.Companion.setModel(DrawingModel.valueOf(modelName));
        player.sendMessage("描画する図形を" + modelName + "に変更");
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

    @Subcommand("star")
    public static void star(Player player) {
        Location loc = player.getLocation();
        double a = 0.81;
        double b = 0.14;
        double xmax = Math.sqrt(-(1 / Math.pow(b, 2)) * Math.log(2 * Math.pow(Math.E, -Math.pow(a, 2)) - 1));
        drawing.drawStar(loc, Particle.SPELL_INSTANT, null, 0.81, 0.14, 1, 0.1 * xmax, 5, 100, 0,0,0);
    }

}
