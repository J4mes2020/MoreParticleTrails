package dev.odionwolf.moretrailparticles.runnables;

import dev.odionwolf.moretrailparticles.MoreTrailParticles;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class SpawnParticleRunnable extends BukkitRunnable {

    MoreTrailParticles moreTrailParticles;
    World world;
    Player player;
    HashMap<UUID, Particle> playerParticleHashMap;

    public SpawnParticleRunnable(MoreTrailParticles moreTrailParticles, World world, Player player, HashMap<UUID, Particle> playerHash) {
        this.moreTrailParticles = moreTrailParticles;
        this.playerParticleHashMap = playerHash;
        this.player = player;
        this.world = world;
    }

    @Override
    public void run() {

        Location location = player.getLocation();
        world.spawnParticle(playerParticleHashMap.get(player.getUniqueId()), location, 0);


    }


}

