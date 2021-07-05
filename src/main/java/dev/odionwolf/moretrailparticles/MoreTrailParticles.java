package dev.odionwolf.moretrailparticles;

import dev.odionwolf.moretrailparticles.commands.ParticleCommand;
import dev.odionwolf.moretrailparticles.tabcompletion.TabComplete;
import dev.odionwolf.moretrailparticles.util.UtilClass;
import org.bukkit.plugin.java.JavaPlugin;

public final class MoreTrailParticles extends JavaPlugin {

    @Override
    public void onEnable() {
        new ParticleCommand(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
