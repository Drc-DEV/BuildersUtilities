package xyz.tehbrian.buildersutilities.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.tehbrian.buildersutilities.managers.PlayerOptionsManager;
import xyz.tehbrian.buildersutilities.util.ItemUtils;
import xyz.tehbrian.buildersutilities.util.MessageUtils;

public class OptionsInventory {

    private OptionsInventory() {
    }

    public static Inventory generate(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, MessageUtils.getMessage("msg.options.inventory_name"));

        for (int x = 0; x < inv.getSize(); x++) {
            inv.setItem(x, ItemUtils.create(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1, "&7"));
        }

        update(inv, player);

        return inv;
    }

    public static void update(Inventory inv, Player p) {
        ItemStack GREEN_GLASS_PANE = ItemUtils.create(Material.LIME_STAINED_GLASS_PANE, 1, "&7");
        ItemStack ORANGE_GLASS_PANE = ItemUtils.create(Material.ORANGE_STAINED_GLASS_PANE, 1, "&7");
        ItemStack RED_GLASS_PANE = ItemUtils.create(Material.RED_STAINED_GLASS_PANE, 1, "&7");

        if (PlayerOptionsManager.getEnabledTrapdoorToggle(p)) {
            inv.setItem(1, GREEN_GLASS_PANE);
            inv.setItem(10, ItemUtils.create(Material.IRON_TRAPDOOR, 1, MessageUtils.getMessage("msg.options.toggle_iron_trapdoor"), MessageUtils.getMessageList("msg.options.enabled")));
            inv.setItem(19, GREEN_GLASS_PANE);
        } else {
            inv.setItem(1, RED_GLASS_PANE);
            inv.setItem(10, ItemUtils.create(Material.IRON_TRAPDOOR, 1, MessageUtils.getMessage("msg.options.toggle_iron_trapdoor"), MessageUtils.getMessageList("msg.options.disabled")));
            inv.setItem(19, RED_GLASS_PANE);
        }

        if (PlayerOptionsManager.getEnabledSlabBreak(p)) {
            inv.setItem(2, GREEN_GLASS_PANE);
            inv.setItem(11, ItemUtils.create(Material.STONE_SLAB, 1, MessageUtils.getMessage("msg.options.custom_slab_breaking"), MessageUtils.getMessageList("msg.options.enabled")));
            inv.setItem(20, GREEN_GLASS_PANE);
        } else {
            inv.setItem(2, RED_GLASS_PANE);
            inv.setItem(11, ItemUtils.create(Material.STONE_SLAB, 1, MessageUtils.getMessage("msg.options.custom_slab_breaking"), MessageUtils.getMessageList("msg.options.disabled")));
            inv.setItem(20, RED_GLASS_PANE);
        }

        if (PlayerOptionsManager.getEnabledTerracottaRotate(p)) {
            inv.setItem(3, GREEN_GLASS_PANE);
            inv.setItem(12, ItemUtils.create(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, MessageUtils.getMessage("msg.options.rotate_glazed_terracotta"), MessageUtils.getMessageList("msg.options.enabled")));
            inv.setItem(21, GREEN_GLASS_PANE);
        } else {
            inv.setItem(3, RED_GLASS_PANE);
            inv.setItem(12, ItemUtils.create(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 1, MessageUtils.getMessage("msg.options.rotate_glazed_terracotta"), MessageUtils.getMessageList("msg.options.disabled")));
            inv.setItem(21, RED_GLASS_PANE);
        }

        if (p.hasPermission("buildersutilities.nightvision")) {
            if (PlayerOptionsManager.getEnabledNightVision(p)) {
                inv.setItem(5, GREEN_GLASS_PANE);
                inv.setItem(14, ItemUtils.create(Material.ENDER_EYE, 1, MessageUtils.getMessage("msg.options.night_vision"), MessageUtils.getMessageList("msg.options.enabled")));
                inv.setItem(23, GREEN_GLASS_PANE);
            } else {
                inv.setItem(5, RED_GLASS_PANE);
                inv.setItem(14, ItemUtils.create(Material.ENDER_EYE, 1, MessageUtils.getMessage("msg.options.night_vision"), MessageUtils.getMessageList("msg.options.disabled")));
                inv.setItem(23, RED_GLASS_PANE);
            }
        } else {
            inv.setItem(5, ORANGE_GLASS_PANE);
            inv.setItem(14, ItemUtils.create(Material.ENDER_EYE, 1, MessageUtils.getMessage("msg.options.night_vision"), MessageUtils.getMessageList("msg.options.no_permission")));
            inv.setItem(23, ORANGE_GLASS_PANE);
        }

        if (p.hasPermission("buildersutilities.noclip")) {
            if (PlayerOptionsManager.getEnabledNoClip(p)) {
                inv.setItem(6, GREEN_GLASS_PANE);
                inv.setItem(15, ItemUtils.create(Material.COMPASS, 1, MessageUtils.getMessage("msg.options.noclip"), MessageUtils.getMessageList("msg.options.enabled")));
                inv.setItem(24, GREEN_GLASS_PANE);
            } else {
                inv.setItem(6, RED_GLASS_PANE);
                inv.setItem(15, ItemUtils.create(Material.COMPASS, 1, MessageUtils.getMessage("msg.options.noclip"), MessageUtils.getMessageList("msg.options.disabled")));
                inv.setItem(24, RED_GLASS_PANE);
            }
        } else {
            inv.setItem(6, ORANGE_GLASS_PANE);
            inv.setItem(15, ItemUtils.create(Material.COMPASS, 1, MessageUtils.getMessage("msg.options.noclip"), MessageUtils.getMessageList("msg.options.no_permission")));
            inv.setItem(24, ORANGE_GLASS_PANE);
        }

        if (p.hasPermission("buildersutilities.advancedfly")) {
            if (PlayerOptionsManager.getEnabledAdvancedFly(p)) {
                inv.setItem(7, GREEN_GLASS_PANE);
                inv.setItem(16, ItemUtils.create(Material.FEATHER, 1, MessageUtils.getMessage("msg.options.advanced_fly"), MessageUtils.getMessageList("msg.options.enabled")));
                inv.setItem(25, GREEN_GLASS_PANE);
            } else {
                inv.setItem(7, RED_GLASS_PANE);
                inv.setItem(16, ItemUtils.create(Material.FEATHER, 1, MessageUtils.getMessage("msg.options.advanced_fly"), MessageUtils.getMessageList("msg.options.disabled")));
                inv.setItem(25, RED_GLASS_PANE);
            }
        } else {
            inv.setItem(7, ORANGE_GLASS_PANE);
            inv.setItem(16, ItemUtils.create(Material.FEATHER, 1, MessageUtils.getMessage("msg.options.advanced_fly"), MessageUtils.getMessageList("msg.options.no_permission")));
            inv.setItem(25, ORANGE_GLASS_PANE);
        }
    }
}
