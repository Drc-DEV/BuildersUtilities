package xyz.tehbrian.buildersutilities.listeners;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import xyz.tehbrian.buildersutilities.BuildersUtilities;

import java.util.Objects;

@SuppressWarnings("unused")
public class SettingsListener implements Listener {

    private final BuildersUtilities main;

    public SettingsListener(BuildersUtilities main) {
        this.main = main;
    }

    @EventHandler
    public void onSpectatorTeleport(PlayerTeleportEvent event) {
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.SPECTATE) {
            if (!event.getPlayer().hasPermission("buildersutilities.tpgm3")) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {
        if (main.getConfig().getBoolean("settings.disable_physics")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (main.getConfig().getBoolean("settings.disable_entity_explode")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByEntityExplode(EntityDamageEvent event) {
        if (main.getConfig().getBoolean("settings.disable_entity_explode")) {
            if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {
        if (main.getConfig().getBoolean("settings.disable_block_explode")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEntityDamageByBlockExplode(EntityDamageEvent event) {
        if (main.getConfig().getBoolean("settings.disable_block_explode")) {
            if (event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {
        if (main.getConfig().getBoolean("settings.disable_leaves_decay")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFarmlandTrample(PlayerInteractEvent event) {
        if (main.getConfig().getBoolean("settings.disable_farmland_trample")) {
            if (event.getAction() == Action.PHYSICAL) {
                if (Objects.requireNonNull(event.getClickedBlock()).getType() == XMaterial.FARMLAND.parseMaterial()) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onDragonEggTeleport(BlockFromToEvent event) {
        if (main.getConfig().getBoolean("settings.disable_dragon_egg_teleport")) {
            if (event.getBlock().getType() == XMaterial.DRAGON_EGG.parseMaterial()) {
                event.setCancelled(true);
            }
        }
    }
}
