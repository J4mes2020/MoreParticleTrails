package dev.odionwolf.moretrailparticles.syles;

import dev.odionwolf.moretrailparticles.util.UtilClass;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Cylinder extends BukkitRunnable {

    Player player;
    World world;
    Particle particle;
    UtilClass utilClass = new UtilClass();

    public Cylinder(Player player, World world, Particle particle) {

        this.player = player;
        this.world = world;
        this.particle = particle;

    }

    public void spawnCylinder() {

        Location playerLoc = player.getLocation();
        Location particleLocation;

        for (int angles = 0; angles <= 360; angles++) {
            for (double y = 0; y <= player.getHeight(); y+= 0.5) {

                double x = 2 * Math.sin(angles);
                double z = 2 * Math.cos(angles);
                if (y == player.getHeight()) {
                    y = 0;
                }

                particleLocation = new Location(world, playerLoc.getX() + x, playerLoc.getY() + y, playerLoc.getZ() + z);

                world.spawnParticle(particle, particleLocation, utilClass.countNeeded);

            }
        }
    }

    @Override
    public void run() {
        spawnCylinder();
    }
}
