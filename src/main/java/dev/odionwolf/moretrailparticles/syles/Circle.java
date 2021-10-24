package dev.odionwolf.moretrailparticles.syles;

import dev.odionwolf.moretrailparticles.util.UtilClass;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Circle extends BukkitRunnable {

    Player player;
    World world;
    Particle particle;
    UtilClass utilClass = new UtilClass();

    public Circle(Player player, World world, Particle particle) {

        this.player = player;
        this.world = world;
        this.particle = particle;

    }

    public void spawnCirle() {

        Location playerLoc = player.getLocation();
        Location particleLocation;

        for (int angles = 0; angles <= 360; angles++) {

            double x = 2 * Math.sin(angles);
            double z = 2 * Math.cos(angles);

            particleLocation = new Location(world, playerLoc.getX()+x, playerLoc.getY(), playerLoc.getZ()+z);

            world.spawnParticle(particle, particleLocation, utilClass.countNeeded);
            
        }
    }

    @Override
    public void run() {
        spawnCirle();
    }
}
