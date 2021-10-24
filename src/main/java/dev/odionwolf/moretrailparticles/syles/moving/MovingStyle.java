package dev.odionwolf.moretrailparticles.syles.moving;

import dev.odionwolf.moretrailparticles.MoreTrailParticles;
import dev.odionwolf.moretrailparticles.gui.ParticlesGUI;
import dev.odionwolf.moretrailparticles.util.UtilClass;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class MovingStyle extends BukkitRunnable {

    Player player;
    World world;
    Particle particle;
    UtilClass utilClass = new UtilClass();
    MoreTrailParticles moreTrailParticles;
    ParticlesGUI particlesGUI;

    public MovingStyle(Player player, World world, Particle particle, MoreTrailParticles moreTrailParticles) {

        this.player = player;
        this.world = world;
        this.particle = particle;
        this.moreTrailParticles = moreTrailParticles;
        particlesGUI = new ParticlesGUI(moreTrailParticles);

    }

    public void spawnMovingStyle() {

        world.spawnParticle(particle, player.getLocation(), utilClass.countNeeded);
    }


    @Override
    public void run() {
        spawnMovingStyle();
    }
}
