package dev.odionwolf.moretrailparticles.util;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class UtilClass {

    public HashMap<UUID, Particle> playerParticleList = new HashMap<>();


    public void selectParticle(Player player, String particleInput) {

        switch (particleInput) {
            case "ASH" -> playerParticleList.put(player.getUniqueId(), Particle.ASH);
            case "BARRIER" -> playerParticleList.put(player.getUniqueId(), Particle.BARRIER);
            case "CLOUD" -> playerParticleList.put(player.getUniqueId(), Particle.CLOUD);
            case "CRIT" -> playerParticleList.put(player.getUniqueId(), Particle.CRIT);
            case "SMALL CAMPFIRE" -> playerParticleList.put(player.getUniqueId(), Particle.CAMPFIRE_COSY_SMOKE); //SMOKE
            case "LARGE CAMPIRE" -> playerParticleList.put(player.getUniqueId(), Particle.CAMPFIRE_SIGNAL_SMOKE); //SMOKE
            case "CRIMSON SPORE" -> playerParticleList.put(player.getUniqueId(), Particle.CRIMSON_SPORE); // SMALL RED SPECKS SPORES
            case "CRIT MAGIC" -> playerParticleList.put(player.getUniqueId(), Particle.CRIT_MAGIC);
            case "DAMAGE" -> playerParticleList.put(player.getUniqueId(), Particle.DAMAGE_INDICATOR); // DARK RED HEARTS
            case "DRAGON BREATH" -> playerParticleList.put(player.getUniqueId(), Particle.DRAGON_BREATH);
            case "DUST TRANSITION" -> playerParticleList.put(player.getUniqueId(), Particle.DUST_COLOR_TRANSITION); //<-------------- TAKES MORE DATA new Particle.DustTransition(Color.fromRGB(245, 96, 66), Color.fromRGB(245, 221, 66), 5));
            case "DOLPHIN" -> playerParticleList.put(player.getUniqueId(), Particle.DOLPHIN); // SOLID SMALL SOLID BLUE PARTICLES
            case "ELECTRIC SPARK" -> playerParticleList.put(player.getUniqueId(), Particle.ELECTRIC_SPARK); // NICE WHITE/YELLOW SQUARE SPARKLE
            case "ENCHANTMENT" -> playerParticleList.put(player.getUniqueId(), Particle.ENCHANTMENT_TABLE);
            case "END ROD" -> playerParticleList.put(player.getUniqueId(), Particle.END_ROD);
            case "EXPLOSION HUGE" -> playerParticleList.put(player.getUniqueId(), Particle.EXPLOSION_HUGE);
            case "EXPLOSION LARGE" -> playerParticleList.put(player.getUniqueId(), Particle.EXPLOSION_LARGE);
            case "EXPLOSION" -> playerParticleList.put(player.getUniqueId(), Particle.EXPLOSION_NORMAL);
            case "FALLING SPORE BLOSSOM" -> playerParticleList.put(player.getUniqueId(), Particle.FALLING_SPORE_BLOSSOM); // SOLID SMALL SOLID GREEN PARTICLES
            case "FLAME" -> playerParticleList.put(player.getUniqueId(), Particle.FLAME);
            case "FLASH" -> playerParticleList.put(player.getUniqueId(), Particle.FLASH); // FLASH BANG
            case "GLOW SPARKLE" -> playerParticleList.put(player.getUniqueId(), Particle.GLOW); // NICE BLUE/GREEN SQUARE SPARKLE
            case "GLOW INK" -> playerParticleList.put(player.getUniqueId(), Particle.GLOW_SQUID_INK); // GREEN CLOUD PARTICLE
            case "HEARTS" -> playerParticleList.put(player.getUniqueId(), Particle.HEART); //NORMAL RED HEARTS
            case "LAVA" -> playerParticleList.put(player.getUniqueId(), Particle.LAVA); //LAVA PARTICLE
            case "PORTAL" -> playerParticleList.put(player.getUniqueId(), Particle.PORTAL); //PURPLE PARTICLES GOING INTO A CENTERAL POINT
            case "REDSTONE" -> playerParticleList.put(player.getUniqueId(), Particle.REDSTONE);  //<-------------- TAKES MORE DATA new Particle.DustOptions(Color.fromBGR(red, green, blue), 1));
            case "REVERSE PORTAL" -> playerParticleList.put(player.getUniqueId(), Particle.REVERSE_PORTAL); //PURPLE PARTICLES GOING OUT OF A CENTERAL POINT
            case "BLUE SPARKLE" -> playerParticleList.put(player.getUniqueId(), Particle.SCRAPE); // MORE NICE BLUE/GREEN SQUARE SPARKLE
            case "SLIME" -> playerParticleList.put(player.getUniqueId(), Particle.SLIME);
            case "SMALL FLAME" -> playerParticleList.put(player.getUniqueId(), Particle.SMALL_FLAME); // SMALL FLAMES
            case "LARGE SMOKE" -> playerParticleList.put(player.getUniqueId(), Particle.SMOKE_LARGE);
            case "SMOKE" -> playerParticleList.put(player.getUniqueId(), Particle.SMOKE_NORMAL);
            case "SNEEZE" -> playerParticleList.put(player.getUniqueId(), Particle.SNEEZE); // GREEN TRANSPARENT CLOUD PARTICLE
            case "SNOW" -> playerParticleList.put(player.getUniqueId(), Particle.SNOW_SHOVEL); // SNOW BLOCK PARTICLES
            case "SNOWFLAKE" -> playerParticleList.put(player.getUniqueId(), Particle.SNOWFLAKE); // SMALL WHITE CLOUDS
            case "BLUE FLAME" -> playerParticleList.put(player.getUniqueId(), Particle.SOUL_FIRE_FLAME); // FLAME BUT BLUE VERSION
            case "SOUL FACES" -> playerParticleList.put(player.getUniqueId(), Particle.SOUL); //BROWN SOUL FACES
            case "SPELLS" -> playerParticleList.put(player.getUniqueId(), Particle.SPELL);
            case "SPELLS MOB" -> playerParticleList.put(player.getUniqueId(), Particle.SPELL_MOB);
            case "SPELLS WITCH" -> playerParticleList.put(player.getUniqueId(), Particle.SPELL_WITCH);
            case "WHITE CLOUD" -> playerParticleList.put(player.getUniqueId(), Particle.SPIT); //ANOTHER WHITE CLOUD
            case "SPREADING SPORE BLOSSOM" -> playerParticleList.put(player.getUniqueId(), Particle.SPORE_BLOSSOM_AIR); // SOLID SMALL SOLID GREEN PARTICLES WHICH NATERALLY SPREAD OUT
            case "SQUID INK" -> playerParticleList.put(player.getUniqueId(), Particle.SQUID_INK); // BLACK CLOUD
            case "SWEEPING ATTACK" -> playerParticleList.put(player.getUniqueId(), Particle.SWEEP_ATTACK); // SWEEP ATTACK
            case "TOTEM" -> playerParticleList.put(player.getUniqueId(), Particle.TOTEM); //GREEN AND YELLOW PARTICLES SURROUND TOTEM
            case "VILLAGER HAPPY" -> playerParticleList.put(player.getUniqueId(), Particle.VILLAGER_HAPPY);
            case "VILLAGER ANGRY" -> playerParticleList.put(player.getUniqueId(), Particle.VILLAGER_ANGRY);
            case "VIBRATION" -> playerParticleList.put(player.getUniqueId(), Particle.VIBRATION); //<-------------- TAKES MORE DATA new Vibration(loc, new Vibration.Destination.EntityDestination(player), 1000));
            case "WARPED SPORE" -> playerParticleList.put(player.getUniqueId(), Particle.WARPED_SPORE); // SMALL DARK BLUE SPECKS SPORES
            case "WAX ON" -> playerParticleList.put(player.getUniqueId(), Particle.WAX_ON); // ORANGE Sparkles
            case "WAX OFF" -> playerParticleList.put(player.getUniqueId(), Particle.WAX_OFF); // WHITE/YELLOW Sparkles
            case "WHITE ASH" -> playerParticleList.put(player.getUniqueId(), Particle.WHITE_ASH); // SMALL WHITE SPECS
        }

    }

    public static void sendMessage(CommandSender player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
