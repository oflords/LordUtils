package dev.oflords.lordutils.player;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerStateUtil {
    public static void reset(Player player) {
        reset(player, true);
    }

    public static void reset(Player player, boolean resetHeldSlot) {
        player.setWalkSpeed(0.2F);
        player.setFlySpeed(0.1F);
        player.setMaxHealth(20.0D);
        player.setHealth(player.getMaxHealth());
        player.setSaturation(20.0F);
        player.setFallDistance(0.0F);
        player.setFoodLevel(20);
        player.setFireTicks(0);
        player.setExp(0.0F);
        player.setLevel(0);
        player.setMaximumNoDamageTicks(20);
        player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));
        player.getInventory().setArmorContents(new ItemStack[4]);
        player.getInventory().setContents(new ItemStack[36]);
        if (player.getOpenInventory().getTopInventory().getType() == InventoryType.CRAFTING) {
            player.getOpenInventory().getTopInventory().clear();
        }
        player.setAllowFlight(false);
        player.setFlying(false);
        player.setGameMode(GameMode.SURVIVAL);

        if (resetHeldSlot) {
            player.getInventory().setHeldItemSlot(0);
        }

        if (player.getItemOnCursor() != null) {
            player.setItemOnCursor(new ItemStack(Material.AIR));
        }

        if (player.getOpenInventory() != null) {
            player.closeInventory();
        }

        player.updateInventory();
    }

    public static void spectator(Player player) {
        reset(player);

        player.setGameMode(GameMode.CREATIVE);
        player.teleport(player.getLocation().add(0, 1, 0));
        player.setAllowFlight(true);
        player.setFlying(true);
        player.setFlySpeed(0.2F);
        player.updateInventory();
    }

    public static void denyMovement(Player player) {
        player.setVelocity(new Vector(0, 0.1, 0));
        player.setWalkSpeed(0.0F);
        player.setFlySpeed(0.0F);
        player.setFoodLevel(0);
        player.setSaturation(0);
        player.setSprinting(false);
        player.setAllowFlight(false);
        player.setFlying(false);
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 200));
    }

    public static void allowMovement(Player player) {
        player.setWalkSpeed(0.2F);
        player.setFlySpeed(0.0001F);
        player.setFoodLevel(20);
        player.setSprinting(true);
        player.removePotionEffect(PotionEffectType.JUMP);
        player.setAllowFlight(false);
        player.setFlying(false);
    }
}
