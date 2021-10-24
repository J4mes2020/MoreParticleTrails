package dev.odionwolf.moretrailparticles.syles.moving;

import dev.odionwolf.moretrailparticles.gui.ParticlesGUI;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class NotMovingRunnable extends BukkitRunnable {

    Player player;
    World world;
    ParticlesGUI particlesGUI;


    public NotMovingRunnable(Player player, ParticlesGUI particlesGUI) {

        this.player = player;
        this.world = player.getWorld();
        this.particlesGUI = particlesGUI;

    }

    public HashMap<UUID, Location> playerPreviousLocation = new HashMap<>();

    @Override
    public void run() {

        int x = (int) player.getLocation().getX();
        int y = (int) player.getLocation().getY();
        int z = (int) player.getLocation().getZ();

        if (!playerPreviousLocation.containsKey(player.getUniqueId())) {

            playerPreviousLocation.put(player.getUniqueId(), new Location(world, x,y,z));
            return;
        }

        if (x >= getPreviousX(player)+1 && x <= getPreviousX(player)-1
                || (y >= getPreviousY(player)+1) && (y <= getPreviousY(player)-1)
                || (z >= getPreviousZ(player)+1) && (z <= getPreviousZ(player)-1)) {

            particlesGUI.getTask().cancel();
            particlesGUI.setStyle(player, particlesGUI.getStyle(player));

        }



    }

    private int getPreviousX(Player player) {
        return (int) playerPreviousLocation.get(player.getUniqueId()).getX();
    }

    private int getPreviousY(Player player) {
        return (int) playerPreviousLocation.get(player.getUniqueId()).getY();
    }

    private int getPreviousZ(Player player) {
        return (int) playerPreviousLocation.get(player.getUniqueId()).getZ();
    }
}
