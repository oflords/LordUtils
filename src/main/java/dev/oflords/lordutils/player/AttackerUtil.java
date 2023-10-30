package dev.oflords.lordutils.player;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AttackerUtil {
    public static Player getLightAttacker(EntityDamageByEntityEvent event) {
        Player attacker;

        if (event.getDamager() instanceof Player) {
            attacker = (Player) event.getDamager();
        } else if (event.getDamager() instanceof Projectile) {
            return null;
        } else {
            // event.setCancelled(true);
            return null;
        }

        return attacker;
    }

    public static Player getAttacker(EntityDamageByEntityEvent event) {
        Player attacker;

        if (event.getDamager() instanceof Player) {
            attacker = (Player) event.getDamager();
        } else if (event.getDamager() instanceof Projectile) {
            if (((Projectile) event.getDamager()).getShooter() instanceof Player) {
                attacker = (Player) ((Projectile) event.getDamager()).getShooter();
            } else {
                // event.setCancelled(true);
                return null;
            }
        } else {
            // event.setCancelled(true);
            return null;
        }

        return attacker;
    }
}
