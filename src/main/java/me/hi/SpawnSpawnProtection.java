package me.hi;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class SpawnSpawnProtection implements Listener {


    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damaged = (Player) event.getEntity();
            Location loc = damaged.getLocation();

            if (loc.getWorld().getName().equals("Factions")) {

                double x1 = 24.0, y1 = 42.0, z1 = -12.0;
                double x2 = 45.0, y2 = 37.0, z2 = 13.0;

                // Calculate the min and max coordinates
                double minX = Math.min(x1, x2);
                double minY = Math.min(y1, y2);
                double minZ = Math.min(z1, z2);
                double maxX = Math.max(x1, x2);
                double maxY = Math.max(y1, y2);
                double maxZ = Math.max(z1, z2);

                if (loc.getX() >= minX && loc.getX() <= maxX &&
                        loc.getY() >= minY && loc.getY() <= maxY &&
                        loc.getZ() >= minZ && loc.getZ() <= maxZ) {
                    event.setCancelled(true);

                }
            }
        }
    }

    @EventHandler
    public void onRodDamage(EntityDamageByEntityEvent event) {
        // Coordinates defining the area
        double x1 = 24.0, y1 = 42.0, z1 = -12.0;
        double x2 = 45.0, y2 = 37.0, z2 = 13.0;

        // Calculate the min and max coordinates
        double minX = Math.min(x1, x2);
        double minY = Math.min(y1, y2);
        double minZ = Math.min(z1, z2);
        double maxX = Math.max(x1, x2);
        double maxY = Math.max(y1, y2);
        double maxZ = Math.max(z1, z2);

        // Check if the damager is a fishing rod hook
        if (event.getDamager() instanceof org.bukkit.entity.FishHook) {
            Location loc = event.getEntity().getLocation();

            if (loc.getWorld().getName().equals("Factions")) {
                // Check if the location is within the specified area
                if (loc.getX() >= minX && loc.getX() <= maxX &&
                        loc.getY() >= minY && loc.getY() <= maxY &&
                        loc.getZ() >= minZ && loc.getZ() <= maxZ) {
                    event.setCancelled(true);
                }
            }
        }
    }


    @EventHandler
    public void onPlayerBowDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) event.getDamager();
            if (arrow.getShooter() instanceof Player) {
                Player damaged = (Player) event.getEntity();
                Location loc = damaged.getLocation();

                if (!loc.getWorld().getName().equals("Factions")) {
                    return; // Exit the method if it's not in the correct world
                }

                double x1 = 24.0, y1 = 42.0, z1 = -12.0;
                double x2 = 45.0, y2 = 37.0, z2 = 13.0;

                // Calculate the min and max coordinates
                double minX = Math.min(x1, x2);
                double minY = Math.min(y1, y2);
                double minZ = Math.min(z1, z2);
                double maxX = Math.max(x1, x2);
                double maxY = Math.max(y1, y2);
                double maxZ = Math.max(z1, z2);

                if (loc.getX() >= minX && loc.getX() <= maxX &&
                        loc.getY() >= minY && loc.getY() <= maxY &&
                        loc.getZ() >= minZ && loc.getZ() <= maxZ) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerFireDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Location loc = player.getLocation();

            if (!loc.getWorld().getName().equals("Factions")) {
                return; // Exit the method if it's not in the correct world
            }

            double x1 = 24.0, y1 = 42.0, z1 = -12.0;
            double x2 = 45.0, y2 = 37.0, z2 = 13.0;

            // Calculate the min and max coordinates
            double minX = Math.min(x1, x2);
            double minY = Math.min(y1, y2);
            double minZ = Math.min(z1, z2);
            double maxX = Math.max(x1, x2);
            double maxY = Math.max(y1, y2);
            double maxZ = Math.max(z1, z2);

            if (loc.getX() >= minX && loc.getX() <= maxX &&
                    loc.getY() >= minY && loc.getY() <= maxY &&
                    loc.getZ() >= minZ && loc.getZ() <= maxZ &&
                    (event.getCause() == EntityDamageEvent.DamageCause.FIRE ||
                            event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK ||
                            event.getCause() == EntityDamageEvent.DamageCause.LAVA)) {
                event.setCancelled(true);
            }
        }
    }


    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Location loc = player.getLocation();

            // Check if the player is in the correct world
            if (!loc.getWorld().getName().equals("Factions")) {
                return; // Exit the method if it's not in the correct world
            }

            // Define the protected area coordinates
            double x1 = 24.0, y1 = 42.0, z1 = -12.0;
            double x2 = 45.0, y2 = 37.0, z2 = 13.0;

            // Calculate the min and max coordinates
            double minX = Math.min(x1, x2);
            double minY = Math.min(y1, y2);
            double minZ = Math.min(z1, z2);
            double maxX = Math.max(x1, x2);
            double maxY = Math.max(y1, y2);
            double maxZ = Math.max(z1, z2);

            // Check if the player is within the protected area
            if (loc.getX() >= minX && loc.getX() <= maxX &&
                    loc.getY() >= minY && loc.getY() <= maxY &&
                    loc.getZ() >= minZ && loc.getZ() <= maxZ) {
                event.setCancelled(true); // Cancel the hunger reduction
            }
        }
    }



}


