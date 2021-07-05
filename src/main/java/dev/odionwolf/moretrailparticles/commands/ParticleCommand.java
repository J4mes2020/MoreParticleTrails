package dev.odionwolf.moretrailparticles.commands;

import dev.odionwolf.moretrailparticles.MoreTrailParticles;
import dev.odionwolf.moretrailparticles.gui.ParticlesGUI;
import dev.odionwolf.moretrailparticles.tabcompletion.TabComplete;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticleCommand implements CommandExecutor {

    MoreTrailParticles moreTrailParticles;
    ParticlesGUI particlesGUI;

    public ParticleCommand(MoreTrailParticles moreTrailParticles) {
        this.moreTrailParticles = moreTrailParticles;
        particlesGUI = new ParticlesGUI(moreTrailParticles);
        Bukkit.getPluginManager().registerEvents(particlesGUI, moreTrailParticles);
        moreTrailParticles.getCommand("moretrails").setExecutor(this);
        moreTrailParticles.getCommand("moretrails").setTabCompleter(new TabComplete());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            particlesGUI.InventoryManager(player);

        }

        return false;
    }
}