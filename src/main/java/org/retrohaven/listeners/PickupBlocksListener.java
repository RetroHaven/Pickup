// this controls getting blocks you cannot normally get in beta minecraft
package org.retrohaven.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PickupBlocksListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();

        // Check if the player has the right tool and permission for each block type
        if (block.getType() == Material.GRASS) {
            if (player.getItemInHand().getType() == Material.GOLD_SPADE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);  // Prevent normal block breaking
                block.setType(Material.AIR);  // Set block to air
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GRASS, 1));
            }
        }

        if (block.getType() == Material.GLASS) {
            if (player.getItemInHand().getType() == Material.GOLD_PICKAXE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS, 1));
            }
        }

        if (block.getType() == Material.GLOWSTONE) {
            if (player.getItemInHand().getType() == Material.GOLD_PICKAXE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLOWSTONE, 1));
            }
        }

        if (block.getType() == Material.ICE) {
            if (player.getItemInHand().getType() == Material.GOLD_PICKAXE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.ICE, 1));
            }
        }

        if (block.getType() == Material.SNOW_BLOCK) {
            if (player.getItemInHand().getType() == Material.GOLD_SPADE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SNOW_BLOCK, 1));
            }
        }

        if (block.getType() == Material.SNOW) {
            if (player.getItemInHand().getType() == Material.GOLD_SPADE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.SNOW, 1));
            }
        }

        if (block.getType() == Material.COBBLESTONE_STAIRS) {
            if (player.getItemInHand().getType() == Material.GOLD_PICKAXE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE_STAIRS, 1));
            }
        }

        if (block.getType() == Material.WOOD_STAIRS) {
            if (player.getItemInHand().getType() == Material.GOLD_SWORD && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.WOOD_STAIRS, 1));
            }
        }

        if (block.getType() == Material.CLAY) {
            if (player.getItemInHand().getType() == Material.GOLD_SPADE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CLAY, 1));
            }
        }

        if (block.getType() == Material.CAKE_BLOCK) {
            if (player.getItemInHand().getType() == Material.GOLD_PICKAXE && player.hasPermission("pickup.use")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CAKE_BLOCK, 1));
            }
        }
    }
}
