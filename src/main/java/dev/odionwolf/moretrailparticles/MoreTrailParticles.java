package dev.odionwolf.moretrailparticles;

import dev.odionwolf.moretrailparticles.commands.ParticleCommand;
import dev.odionwolf.moretrailparticles.gui.ParticlesGUI;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoreTrailParticles extends JavaPlugin {

    ParticleCommand particleCommand;
    ParticlesGUI particlesGUI;

    @Override
    public void onEnable() {
        particleCommand = new ParticleCommand(this);
        particlesGUI = new ParticlesGUI(this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
