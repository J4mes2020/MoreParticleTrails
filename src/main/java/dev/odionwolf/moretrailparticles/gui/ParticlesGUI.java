package dev.odionwolf.moretrailparticles.gui;

import dev.odionwolf.moretrailparticles.MoreTrailParticles;
import dev.odionwolf.moretrailparticles.syles.Circle;
import dev.odionwolf.moretrailparticles.syles.Cylinder;
import dev.odionwolf.moretrailparticles.syles.moving.MovingStyle;
import dev.odionwolf.moretrailparticles.syles.moving.NotMovingRunnable;
import dev.odionwolf.moretrailparticles.util.UtilClass;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

public class ParticlesGUI implements Listener {

    UtilClass utilClass = new UtilClass();
    MoreTrailParticles moreTrailParticles;


    HashMap<UUID, Particle> playerParticle = utilClass.playerParticleList;
    HashMap<UUID, String> playerParticleStyle = new HashMap<>();

    Inventory particleInventoryPg1;
    Inventory particleInventoryPg2;
    Inventory styleInventoryPg1;
    BukkitTask task;
    int period = 10;


    ItemStack submit = createItem(Material.GREEN_STAINED_GLASS_PANE, "#1ce302", "Submit", "Submit");
    ItemStack nextPg = createItem(Material.RED_STAINED_GLASS_PANE, "#de4343", "Next Page", "Next");
    ItemStack previousPg = createItem(Material.RED_STAINED_GLASS_PANE, "#de4343", "Previous Page", "Previous");

    public ParticlesGUI(MoreTrailParticles moreTrailParticles) {
        this.moreTrailParticles = moreTrailParticles;
        Bukkit.getPluginManager().registerEvents(this, moreTrailParticles);

    }

    public void InventoryManager(Player player) {
        createParticleGUI(player);


    }


    @EventHandler
    public void onClick(InventoryClickEvent event) {

        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();

        if (item != null) {

            if (event.getInventory() == particleInventoryPg1 || event.getInventory() == particleInventoryPg2) {

                event.setCancelled(true);
                UtilClass.sendMessage(player, "&a" + item.getItemMeta().getLocalizedName() + " Selected");

                if (item.isSimilar(submit)) {
                    if (playerParticle.containsKey(player.getUniqueId())) {
                        UtilClass.sendMessage(player, "&aSubmitted");
                        createStyleGUI(player);
                        return;
                    } else {
                        UtilClass.sendMessage(player, "&cPlease select a particle!");
                    }
                }


                if (item.isSimilar(nextPg)) {
                    player.openInventory(particleInventoryPg2);
                    return;
                }

                if (item.isSimilar(previousPg)) {
                    player.openInventory(particleInventoryPg1);
                    return;

                }

                utilClass.selectParticle(player, item.getItemMeta().getLocalizedName());
            }

            if (event.getInventory() == styleInventoryPg1 && playerParticle.containsKey(player.getUniqueId())) {
                selectStyle(player, item.getItemMeta().getLocalizedName());
            }

        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        if (getTask() != null) {

            Player player = event.getPlayer();

            Location beforeLocation = event.getFrom();
            Location afterLocation = event.getTo();

            if (beforeLocation.distance(afterLocation) >= 1 || isMoving(player)) {

                getTask().cancel();
                task = new MovingStyle(player, player.getWorld(), getParticle(player), moreTrailParticles).runTaskTimer(moreTrailParticles, 0, period);
            }

        }

    }

    public boolean isMoving(Player player) {

        return player.isSprinting() || player.isSwimming() || player.isSneaking() || player.isGliding() || player.isRiptiding();
    }



    private ItemStack createItem(Material material, String color, String nameDisplay, String nameLocal) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        // Set the name of the item
        meta.setLocalizedName(nameLocal);
        meta.setDisplayName(ChatColor.of(color) + "" + ChatColor.BOLD + nameDisplay);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);

        return item;
    }

    public void selectStyle(Player player, String itemName) {

        setStyle(player, itemName);
        UtilClass.sendMessage(player, "&a" + itemName + " Selected");
        player.closeInventory();

    }


    void createStyleGUI(Player player) {
        styleInventoryPg1 = Bukkit.createInventory(null, 54,
                ChatColor.translateAlternateColorCodes('&', "&2TrailParticles Styles Pg 1"));

        styleInventoryPg1.addItem(createItem(Material.SLIME_BALL, "#fc632b", "Circle", "Circle"));
        styleInventoryPg1.addItem(createItem(Material.CLAY_BALL, "#dffc03", "Cylinder", "Cylinder"));
        styleInventoryPg1.addItem(createItem(Material.FIRE_CHARGE, "#6f319e", "Helix", "Helix"));


        styleInventoryPg1.setItem(49, submit);
        player.openInventory(styleInventoryPg1);


    }


    void createParticleGUI(Player player) {
        particleInventoryPg1 = Bukkit.createInventory(null, 54,
                ChatColor.translateAlternateColorCodes('&', "&2TrailParticles Particles Pg 1"));

        particleInventoryPg2 = Bukkit.createInventory(null, 54,
                ChatColor.translateAlternateColorCodes('&', "&2TrailParticles Particles Pg 2"));

        particleInventoryPg1.addItem(createItem(Material.BASALT, "#545454", "ASH", "ASH"));
        particleInventoryPg1.addItem(createItem(Material.BARRIER, "#eb1a1a", "BARRIER", "BARRIER"));
        particleInventoryPg1.addItem(createItem(Material.WHITE_WOOL, "#e0e0e0", "CLOUD", "CLOUD"));
        particleInventoryPg1.addItem(createItem(Material.DIAMOND_SWORD, "#b87121", "CRIT", "CRIT"));
        particleInventoryPg1.addItem(createItem(Material.CAMPFIRE, "#cc6c00", "SMALL CAMPFIRE", "SMALL CAMPFIRE"));
        particleInventoryPg1.addItem(createItem(Material.SOUL_CAMPFIRE, "#8a4900", "LARGE CAMPFIRE", "LARGE CAMPFIRE"));
        particleInventoryPg1.addItem(createItem(Material.CRIMSON_ROOTS, "#d63e02", "CRIMSON SPORE", "CRIMSON SPORE"));
        particleInventoryPg1.addItem(createItem(Material.POTION, "#4542ff", "CRIT MAGIC", "CRIT MAGIC"));
        particleInventoryPg1.addItem(createItem(Material.NETHERITE_SWORD, "#c70046", "DAMAGE", "DAMAGE"));
        particleInventoryPg1.addItem(createItem(Material.DRAGON_BREATH, "#d400a2", "DRAGON BREATH", "DRAGON BREATH"));
        particleInventoryPg1.addItem(createItem(Material.GLOWSTONE_DUST, "#00f5f5", "DUST TRANSITION", "DUST TRANSITION"));
        particleInventoryPg1.addItem(createItem(Material.SEA_LANTERN, "#4d9aff", "DOLPHIN", "DOLPHIN"));
        particleInventoryPg1.addItem(createItem(Material.LIGHTNING_ROD, "#F9C322", "ELECTRIC SPARK", "ELECTRIC SPARK"));
        particleInventoryPg1.addItem(createItem(Material.END_ROD, "#fffbab", "END ROD", "END ROD"));
        particleInventoryPg1.addItem(createItem(Material.TNT, "#ff2e2e", "EXPLOSION HUGE", "EXPLOSION HUGE"));
        particleInventoryPg1.addItem(createItem(Material.TNT, "#ff6161", "EXPLOSION LARGE", "EXPLOSION LARGE"));
        particleInventoryPg1.addItem(createItem(Material.TNT, "#ff9e9e", "EXPLOSION", "EXPLOSION"));
        particleInventoryPg1.addItem(createItem(Material.SPORE_BLOSSOM, "#6dff59", "FALLING SPORE BLOSSOM", "FALLING SPORE BLOSSOM"));
        particleInventoryPg1.addItem(createItem(Material.BLAZE_ROD, "#cf352e", "FLAME", "FLAME"));
        particleInventoryPg1.addItem(createItem(Material.FLINT_AND_STEEL, "#fffde3", "FLASH", "FLASH"));
        particleInventoryPg1.addItem(createItem(Material.SPECTRAL_ARROW, "#00e874", "GLOW SPARKLE", "GLOW SPARKLE"));
        particleInventoryPg1.addItem(createItem(Material.GLOW_INK_SAC, "#00ab7d", "GLOW INK", "GLOW INK"));
        particleInventoryPg1.addItem(createItem(Material.HEART_OF_THE_SEA, "#e31b23", "HEARTS", "HEARTS"));
        particleInventoryPg1.addItem(createItem(Material.LAVA_BUCKET, "#c42f12", "LAVA", "LAVA"));
        particleInventoryPg1.addItem(createItem(Material.END_PORTAL_FRAME, "#eb00df", "PORTAL", "PORTAL"));
        particleInventoryPg1.addItem(createItem(Material.REDSTONE, "#bd0404", "REDSTONE", "REDSTONE"));
        particleInventoryPg1.addItem(createItem(Material.END_PORTAL_FRAME, "#6000fa", "REVERSE PORTAL", "REVERSE PORTAL"));
        particleInventoryPg1.addItem(createItem(Material.NETHER_STAR, "#1887d6", "BLUE SPARKLE", "BLUE SPARKLE"));
        particleInventoryPg1.addItem(createItem(Material.SLIME_BALL, "#1fcf3c", "SLIME", "SLIME"));
        particleInventoryPg1.addItem(createItem(Material.FIRE_CHARGE, "#de3f31", "SMALL FLAME", "SMALL FLAME"));
        particleInventoryPg1.addItem(createItem(Material.SMOKER, "#7d7d7d", "LARGE SMOKE", "LARGE SMOKE"));
        particleInventoryPg1.addItem(createItem(Material.SMOOTH_STONE, "#bfbdbd", "SMOKE", "SMOKE"));
        particleInventoryPg1.addItem(createItem(Material.GREEN_DYE, "#138f1d", "SNEEZE", "SNEEZE"));
        particleInventoryPg1.addItem(createItem(Material.POWDER_SNOW_BUCKET, "#f7f7f7", "SNOW", "SNOW"));
        particleInventoryPg1.addItem(createItem(Material.SNOW_BLOCK, "#ffffff", "SNOWFLAKE", "SNOWFLAKE"));
        particleInventoryPg1.addItem(createItem(Material.SOUL_TORCH, "#73ffe1", "BLUE FLAME", "BLUE FLAME"));
        particleInventoryPg1.setItem(49, submit);
        particleInventoryPg1.setItem(50, nextPg);
        player.openInventory(particleInventoryPg1);

        particleInventoryPg2.addItem(createItem(Material.SOUL_SOIL, "#17b042", "SOUL FACES", "SOUL FACES"));
        particleInventoryPg2.addItem(createItem(Material.STICK, "#8b26ff", "SPELLS", "SPELLS"));
        particleInventoryPg2.addItem(createItem(Material.BLAZE_POWDER, "#ba26ff", "SPELLS MOB", "SPELLS MOB"));
        particleInventoryPg2.addItem(createItem(Material.WITHER_ROSE, "#f64dff", "SPELLS WITCH", "SPELLS WITCH"));
        particleInventoryPg2.addItem(createItem(Material.SKELETON_SKULL, "#ffffff", "WHITE CLOUD", "WHITE CLOUD"));
        particleInventoryPg2.addItem(createItem(Material.ENCHANTING_TABLE, "#6c43a1", "ENCHANTMENT", "ENCHANTMENT"));
        particleInventoryPg2.addItem(createItem(Material.SPORE_BLOSSOM, "#00bf3f", "SPREADING SPORE BLOSSOM", "SPREADING SPORE BLOSSOM"));
        particleInventoryPg2.addItem(createItem(Material.INK_SAC, "#292929", "SQUID INK", "SQUID INK"));
        particleInventoryPg2.addItem(createItem(Material.IRON_SWORD, "#adadad", "SWEEPING ATTACK", "SWEEPING ATTACK"));
        particleInventoryPg2.addItem(createItem(Material.TOTEM_OF_UNDYING, "#e6a519", "TOTEM", "TOTEM"));
        particleInventoryPg2.addItem(createItem(Material.EMERALD, "#47e02f", "VILLAGER HAPPY", "VILLAGER HAPPY"));
        particleInventoryPg2.addItem(createItem(Material.FIRE_CORAL, "#c93416", "VILLAGER ANGRY", "VILLAGER ANGRY"));
        particleInventoryPg2.addItem(createItem(Material.SHULKER_SHELL, "#ed62fc", "VIBRATION", "VIBRATION"));
        particleInventoryPg2.addItem(createItem(Material.WARPED_ROOTS, "#4bbf9a", "WARPED SPORE", "WARPED SPORE"));
        particleInventoryPg2.addItem(createItem(Material.HONEYCOMB, "#ffae00", "WAX ON", "WAX ON"));
        particleInventoryPg2.addItem(createItem(Material.HONEY_BOTTLE, "#9be610", "WAX OFF", "WAX OFF"));
        particleInventoryPg2.addItem(createItem(Material.WHITE_DYE, "#ffffff", "WHITE ASH", "WHITE ASH"));
        particleInventoryPg2.setItem(49, submit);
        particleInventoryPg2.setItem(48, previousPg);
    }

    public Particle getParticle(Player player) {

        return playerParticle.get(player.getUniqueId());
    }

    public void setStyle(Player player, String style) {

        switch (style) {

            case "Circle" -> task = new Circle(player, player.getWorld(), getParticle(player)).runTaskTimer(moreTrailParticles, 0, period);
            case "Cylinder" -> task = new Cylinder(player, player.getWorld(), getParticle(player)).runTaskTimer(moreTrailParticles, 0, period);

        }
        new NotMovingRunnable(player, this).runTaskTimer(moreTrailParticles, 0, period);

        playerParticleStyle.put(player.getUniqueId(), style);
    }

    public String getStyle(Player player) {
        return playerParticleStyle.get(player.getUniqueId());
    }

    public BukkitTask getTask() {

        return task;

    }


}
