package me.hi;
//spawn no breaking blocks
//spawn no placing blocks
//spawn no flint and steel

//spawn no blockburn
//spawn no blockspread
//no chest opening in spawn

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpawnProtection  implements Listener {


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getWorld().getName().equals("Factions")) {
            Location loc = event.getBlock().getLocation();

            double x1 = 83.0, y1 = 0.0, z1 = -82.0;
            double x2 = -82.0, y2 = 256.0, z2 = 83.0;

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


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Location loc = event.getBlock().getLocation();

        // Check if the event is in the world named "factions"
        if (!loc.getWorld().getName().equals("Factions")) {
            return; // Exit the method if it's not in the correct world
        }

        double x1 = 83.0, y1 = 0.0, z1 = -82.0;
        double x2 = -82.0, y2 = 256.0, z2 = 83.0;

        // Calculate the min and max coordinates
        double minX = Math.min(x1, x2);
        double minY = Math.min(y1, y2);
        double minZ = Math.min(z1, z2);
        double maxX = Math.max(x1, x2);
        double maxY = Math.max(y1, y2);
        double maxZ = Math.max(z1, z2);

        // Check if the location is within the specified area
        if (loc.getX() >= minX && loc.getX() <= maxX &&
                loc.getY() >= minY && loc.getY() <= maxY &&
                loc.getZ() >= minZ && loc.getZ() <= maxZ) {
            event.setCancelled(true); // Cancel the event to prevent block breaking
        }
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getPlayer().getWorld().getName().equals("Factions")) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                Material itemType = event.getItem() != null ? event.getItem().getType() : null;
                if (itemType == Material.FLINT_AND_STEEL) {
                    Location loc;
                    if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        loc = event.getClickedBlock().getLocation();
                    } else {
                        loc = event.getPlayer().getLocation();
                    }

                    double x1 = 83.0, y1 = 0.0, z1 = -82.0;
                    double x2 = -82.0, y2 = 256.0, z2 = 83.0;

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
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        Location loc = event.getBlock().getLocation();

        // Check if the event is in the world named "factions"
        if (!loc.getWorld().getName().equals("factions")) {
            return; // Exit the method if it's not in the correct world
        }

        double x1 = 83.0, y1 = 0.0, z1 = -82.0;
        double x2 = -82.0, y2 = 256.0, z2 = 83.0;

        // Calculate the min and max coordinates
        double minX = Math.min(x1, x2);
        double minY = Math.min(y1, y2);
        double minZ = Math.min(z1, z2);
        double maxX = Math.max(x1, x2);
        double maxY = Math.max(y1, y2);
        double maxZ = Math.max(z1, z2);

        // Check if the location is within the specified area
        if (loc.getX() >= minX && loc.getX() <= maxX &&
                loc.getY() >= minY && loc.getY() <= maxY &&
                loc.getZ() >= minZ && loc.getZ() <= maxZ) {
            event.setCancelled(true); // Cancel the event to prevent the block from burning
        }
    }

    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event) {
        Location loc = event.getBlock().getLocation();

        // Check if the event is in the world named "factions"
        if (!loc.getWorld().getName().equals("factions")) {
            return; // Exit the method if it's not in the correct world
        }

        double x1 = 83.0, y1 = 0.0, z1 = -82.0;
        double x2 = -82.0, y2 = 256.0, z2 = 83.0;

        // Calculate the min and max coordinates
        double minX = Math.min(x1, x2);
        double minY = Math.min(y1, y2);
        double minZ = Math.min(z1, z2);
        double maxX = Math.max(x1, x2);
        double maxY = Math.max(y1, y2);
        double maxZ = Math.max(z1, z2);

        // Check if the location is within the specified area
        if (loc.getX() >= minX && loc.getX() <= maxX &&
                loc.getY() >= minY && loc.getY() <= maxY &&
                loc.getZ() >= minZ && loc.getZ() <= maxZ) {
            event.setCancelled(true); // Cancel the event to prevent block spreading
        }
    }


}

