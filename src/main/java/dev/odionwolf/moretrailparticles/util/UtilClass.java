package dev.odionwolf.moretrailparticles.util;

import dev.odionwolf.moretrailparticles.gui.ParticlesGUI;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class UtilClass {

    public HashMap<UUID, Particle> playerParticleList = new HashMap<>();
    public int countNeeded = 1;

    public void selectParticle(Player player, String particleInput) {

        switch (particleInput) {
            case "ASH" -> {
                playerParticleList.put(player.getUniqueId(), Particle.ASH);
            }
            case "BARRIER" -> {
                playerParticleList.put(player.getUniqueId(), Particle.BARRIER);
            }
            case "CLOUD" -> {
                playerParticleList.put(player.getUniqueId(), Particle.CLOUD);
                countNeeded = 0;
            }
            case "CRIT" -> {
                playerParticleList.put(player.getUniqueId(), Particle.CRIT);
                countNeeded = 0;
            }
            case "SMALL CAMPFIRE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.CAMPFIRE_COSY_SMOKE); //SMOKE
                countNeeded = 0;
            }
            case "LARGE CAMPIRE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.CAMPFIRE_SIGNAL_SMOKE); //SMOKE
                countNeeded = 0;
            }
            case "CRIMSON SPORE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.CRIMSON_SPORE); // SMALL RED SPECKS SPORES
            }
            case "CRIT MAGIC" -> {
                playerParticleList.put(player.getUniqueId(), Particle.CRIT_MAGIC);
                countNeeded = 0;
            }
            case "DAMAGE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.DAMAGE_INDICATOR); // DARK RED HEARTS
                countNeeded = 0;
            }
            case "DRAGON BREATH" -> {
                playerParticleList.put(player.getUniqueId(), Particle.DRAGON_BREATH);
                countNeeded = 0;
            }
            case "DUST TRANSITION" -> {
                playerParticleList.put(player.getUniqueId(), Particle.DUST_COLOR_TRANSITION); //<-------------- TAKES MORE DATA new Particle.DustTransition(Color.fromRGB(245, 96, 66), Color.fromRGB(245, 221, 66), 5));
            }
            case "DOLPHIN" -> {
                playerParticleList.put(player.getUniqueId(), Particle.DOLPHIN); // SOLID SMALL SOLID BLUE PARTICLES
            }
            case "ELECTRIC SPARK" -> {
                playerParticleList.put(player.getUniqueId(), Particle.ELECTRIC_SPARK); // NICE WHITE/YELLOW SQUARE SPARKLE
                countNeeded = 0;
            }
            case "ENCHANTMENT" -> {
                playerParticleList.put(player.getUniqueId(), Particle.ENCHANTMENT_TABLE);
                countNeeded = 0;
            }
            case "END ROD" -> {
                playerParticleList.put(player.getUniqueId(), Particle.END_ROD);
                countNeeded = 0;
            }
            case "EXPLOSION HUGE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.EXPLOSION_HUGE);
            }
            case "EXPLOSION LARGE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.EXPLOSION_LARGE);
            }
            case "EXPLOSION" -> {
                playerParticleList.put(player.getUniqueId(), Particle.EXPLOSION_NORMAL);
                countNeeded = 0;
            }
            case "FALLING SPORE BLOSSOM" -> {
                playerParticleList.put(player.getUniqueId(), Particle.FALLING_SPORE_BLOSSOM); // SOLID SMALL SOLID GREEN PARTICLES
            }
            case "FLAME" -> {
                playerParticleList.put(player.getUniqueId(), Particle.FLAME);
                countNeeded = 0;
            }
            case "FLASH" -> {
                playerParticleList.put(player.getUniqueId(), Particle.FLASH); // FLASH BANG
            }
            case "GLOW SPARKLE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.GLOW); // NICE BLUE/GREEN SQUARE SPARKLE
            }
            case "GLOW INK" -> {
                playerParticleList.put(player.getUniqueId(), Particle.GLOW_SQUID_INK); // GREEN CLOUD PARTICLE
            }
            case "HEARTS" -> {
                playerParticleList.put(player.getUniqueId(), Particle.HEART); //NORMAL RED HEARTS
            }
            case "LAVA" -> {
                playerParticleList.put(player.getUniqueId(), Particle.LAVA); //LAVA PARTICLE
            }
            case "PORTAL" -> {
                playerParticleList.put(player.getUniqueId(), Particle.PORTAL); //PURPLE PARTICLES GOING INTO A CENTERAL POINT
                countNeeded = 0;
            }
            case "REDSTONE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.REDSTONE);  //<-------------- TAKES MORE DATA new Particle.DustOptions(Color.fromBGR(red, green, blue), 1));
            }
            case "REVERSE PORTAL" -> {
                playerParticleList.put(player.getUniqueId(), Particle.REVERSE_PORTAL); //PURPLE PARTICLES GOING OUT OF A CENTERAL POINT
                countNeeded = 0;
            }
            case "BLUE SPARKLE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SCRAPE); // MORE NICE BLUE/GREEN SQUARE SPARKLE
                countNeeded = 0;
            }
            case "SLIME" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SLIME);
            }
            case "SMALL FLAME" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SMALL_FLAME); // SMALL FLAMES
                countNeeded = 0;
            }
            case "LARGE SMOKE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SMOKE_LARGE);
                countNeeded = 0;
            }
            case "SMOKE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SMOKE_NORMAL);
                countNeeded = 0;
            }
            case "SNEEZE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SNEEZE); // GREEN TRANSPARENT CLOUD PARTICLE
            }
            case "SNOW" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SNOW_SHOVEL); // SNOW BLOCK PARTICLES
            }
            case "SNOWFLAKE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SNOWFLAKE); // SMALL WHITE CLOUDS
            }
            case "BLUE FLAME" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SOUL_FIRE_FLAME); // FLAME BUT BLUE VERSION
                countNeeded = 0;
            }
            case "SOUL FACES" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SOUL); //BROWN SOUL FACES
                countNeeded = 0;
            }
            case "SPELLS" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SPELL);
            }
            case "SPELLS MOB" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SPELL_MOB);
            }
            case "SPELLS WITCH" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SPELL_WITCH);
            }
            case "WHITE CLOUD" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SPIT); //ANOTHER WHITE CLOUD
                countNeeded = 0;
            }
            case "SPREADING SPORE BLOSSOM" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SPORE_BLOSSOM_AIR); // SOLID SMALL SOLID GREEN PARTICLES WHICH NATERALLY SPREAD OUT
            }
            case "SQUID INK" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SQUID_INK); // BLACK CLOUD
                countNeeded = 0;
            }
            case "SWEEPING ATTACK" -> {
                playerParticleList.put(player.getUniqueId(), Particle.SWEEP_ATTACK); // SWEEP ATTACK
            }
            case "TOTEM" -> {
                playerParticleList.put(player.getUniqueId(), Particle.TOTEM); //GREEN AND YELLOW PARTICLES SURROUND TOTEM
                countNeeded = 0;
            }
            case "VILLAGER HAPPY" -> {
                playerParticleList.put(player.getUniqueId(), Particle.VILLAGER_HAPPY);
            }
            case "VILLAGER ANGRY" -> {
                playerParticleList.put(player.getUniqueId(), Particle.VILLAGER_ANGRY);
            }
            case "VIBRATION" -> {
                playerParticleList.put(player.getUniqueId(), Particle.VIBRATION); //<-------------- TAKES MORE DATA new Vibration(loc, new Vibration.Destination.EntityDestination(player), 1000));
            }
            case "WARPED SPORE" -> {
                playerParticleList.put(player.getUniqueId(), Particle.WARPED_SPORE); // SMALL DARK BLUE SPECKS SPORES
            }
            case "WAX ON" -> {
                playerParticleList.put(player.getUniqueId(), Particle.WAX_ON); // ORANGE Sparkles
                countNeeded = 0;
            }
            case "WAX OFF" -> {
                playerParticleList.put(player.getUniqueId(), Particle.WAX_OFF); // WHITE/YELLOW Sparkles
                countNeeded = 0;
            }
            case "WHITE ASH" -> {
                playerParticleList.put(player.getUniqueId(), Particle.WHITE_ASH); // SMALL WHITE SPECS
            }
        }

        playerParticleList.get(player.getUniqueId());

    }

    public static void sendMessage(CommandSender player, String message) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

}
