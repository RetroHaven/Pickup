package org.retrohaven.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.minecraft.server.TileEntityMobSpawner;
import org.bukkit.craftbukkit.CraftWorld;
import java.util.Arrays;
import java.util.List;

public class SetSpawnerCommand implements CommandExecutor {

    private final List<String> validMobs = Arrays.asList(
        "Pig", "Sheep", "Cow", "Chicken", "Zombie", "Creeper", "Skeleton", "Spider", "Squid", "Slime"
    );

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("pickup.setspawner")) {
            player.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }

        if (args.length < 1 || args.length > 2) {
            player.sendMessage("§cUsage: /setspawner <mob> [player]");
            player.sendMessage("§7Valid mobs: " + String.join(", ", validMobs));
            return true;
        }

        String mobType = args[0].substring(0, 1).toUpperCase() + args[0].substring(1).toLowerCase();

        if (!validMobs.contains(mobType)) {
            player.sendMessage("§cInvalid mob type! Try: " + String.join(", ", validMobs));
            return true;
        }

        Player targetPlayer = player;
        if (args.length == 2) {
            if (!player.hasPermission("pickup.setspawner.others")) {
                player.sendMessage("§cYou don't have permission to change other players' spawners!");
                return true;
            }
            
            targetPlayer = Bukkit.getPlayer(args[1]);

            if (targetPlayer == null) {
                player.sendMessage("§cPlayer not found or offline!");
                return true;
            }
        }

        Block targetBlock = targetPlayer.getTargetBlock(null, 5);

        if (targetBlock.getType() != Material.MOB_SPAWNER) {
            player.sendMessage("§cYou must be looking at a mob spawner!");
            return true;
        }

        try {
            TileEntityMobSpawner spawner = (TileEntityMobSpawner) ((CraftWorld) targetPlayer.getWorld())
                    .getHandle()
                    .getTileEntity(targetBlock.getX(), targetBlock.getY(), targetBlock.getZ());

            spawner.mobName = mobType; // Set the spawner type

            player.sendMessage("§aSpawner changed to: " + mobType);

            // Log change in console if it does not do this then fuck it i will remove it
            Bukkit.getLogger().info("[SpawnerPickup] " + player.getName() + " changed a spawner to " + mobType 
                + " at (" + targetBlock.getX() + ", " + targetBlock.getY() + ", " + targetBlock.getZ() + ")");

            // Notify target player if different
            if (targetPlayer != player) {
                targetPlayer.sendMessage("§eYour spawner was changed to " + mobType + " by " + player.getName() + "!");
            }

        } catch (Exception e) {
            player.sendMessage("§cError: Unable to change spawner type!");
            e.printStackTrace();
        }

        return true;
    }
}
