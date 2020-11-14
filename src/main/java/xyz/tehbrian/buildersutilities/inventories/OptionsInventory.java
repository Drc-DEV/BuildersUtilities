package xyz.tehbrian.buildersutilities.inventories;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.tehbrian.buildersutilities.BuildersUtilities;
import xyz.tehbrian.buildersutilities.managers.PlayerData;
import xyz.tehbrian.buildersutilities.util.ItemUtils;
import xyz.tehbrian.buildersutilities.util.MessageUtils;

import java.util.ArrayList;
import java.util.List;

public class OptionsInventory {

    private static final ItemStack GREEN = ItemUtils.create(XMaterial.LIME_STAINED_GLASS_PANE.parseMaterial(), 1, "&7");
    private static final ItemStack ORANGE = ItemUtils.create(XMaterial.ORANGE_STAINED_GLASS_PANE.parseMaterial(), 1, "&7");
    private static final ItemStack RED = ItemUtils.create(XMaterial.RED_STAINED_GLASS_PANE.parseMaterial(), 1, "&7");

    private OptionsInventory() {
    }

    public static Inventory generate(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, MessageUtils.getMessage("messages.inventories.options.inventory_name"));

        for (int x = 0; x < inv.getSize(); x++) {
            inv.setItem(x, ItemUtils.create(XMaterial.LIGHT_GRAY_STAINED_GLASS_PANE.parseMaterial(), 1, "&7"));
        }

        update(inv, player);

        return inv;
    }

    public static void update(Inventory inv, Player p) {
        PlayerData playerData = BuildersUtilities.getInstance().getPlayerDataManager().getPlayerData(p);

        if (playerData.hasIronTrapdoorToggleEnabled()) {
            inv.setItem(1, GREEN);
            inv.setItem(10, createCustomItem(XMaterial.IRON_TRAPDOOR.parseMaterial(), "iron_trapdoor_toggle", "enabled"));
            inv.setItem(19, GREEN);
        } else {
            inv.setItem(1, RED);
            inv.setItem(10, createCustomItem(XMaterial.IRON_TRAPDOOR.parseMaterial(), "iron_trapdoor_toggle", "disabled"));
            inv.setItem(19, RED);
        }

        if (playerData.hasDoubleSlabBreakEnabled()) {
            inv.setItem(2, GREEN);
            inv.setItem(11, createCustomItem(XMaterial.STONE_SLAB.parseMaterial(), "double_slab_break", "enabled"));
            inv.setItem(20, GREEN);
        } else {
            inv.setItem(2, RED);
            inv.setItem(11, createCustomItem(XMaterial.STONE_SLAB.parseMaterial(), "double_slab_break", "disabled"));
            inv.setItem(20, RED);
        }

        if (playerData.hasGlazedTerracottaRotateEnabled()) {
            inv.setItem(3, GREEN);
            inv.setItem(12, createCustomItem(XMaterial.LIGHT_BLUE_GLAZED_TERRACOTTA.parseMaterial(), "glazed_terracotta_rotate", "enabled"));
            inv.setItem(21, GREEN);
        } else {
            inv.setItem(3, RED);
            inv.setItem(12, createCustomItem(XMaterial.LIGHT_BLUE_GLAZED_TERRACOTTA.parseMaterial(), "glazed_terracotta_rotate", "disabled"));
            inv.setItem(21, RED);
        }

        if (p.hasPermission("buildersutilities.nightvision")) {
            if (playerData.hasNightVisionEnabled()) {
                inv.setItem(5, GREEN);
                inv.setItem(14, createCustomItem(XMaterial.ENDER_EYE.parseMaterial(), "night_vision", "enabled"));
                inv.setItem(23, GREEN);
            } else {
                inv.setItem(5, RED);
                inv.setItem(14, createCustomItem(XMaterial.ENDER_EYE.parseMaterial(), "night_vision", "disabled"));
                inv.setItem(23, RED);
            }
        } else {
            inv.setItem(5, ORANGE);
            inv.setItem(14, createCustomItem(XMaterial.ENDER_EYE.parseMaterial(), "night_vision", "no_permission"));
            inv.setItem(23, ORANGE);
        }

        if (p.hasPermission("buildersutilities.noclip")) {
            if (playerData.hasNoClipEnabled()) {
                inv.setItem(6, GREEN);
                inv.setItem(15, createCustomItem(XMaterial.COMPASS.parseMaterial(), "no_clip", "enabled"));
                inv.setItem(24, GREEN);
            } else {
                inv.setItem(6, RED);
                inv.setItem(15, createCustomItem(XMaterial.COMPASS.parseMaterial(), "no_clip", "disabled"));
                inv.setItem(24, RED);
            }
        } else {
            inv.setItem(6, ORANGE);
            inv.setItem(15, createCustomItem(XMaterial.COMPASS.parseMaterial(), "no_clip", "no_permission"));
            inv.setItem(24, ORANGE);
        }

        if (p.hasPermission("buildersutilities.advancedfly")) {
            if (playerData.hasAdvancedFlyEnabled()) {
                inv.setItem(7, GREEN);
                inv.setItem(16, createCustomItem(XMaterial.FEATHER.parseMaterial(), "advanced_fly", "enabled"));
                inv.setItem(25, GREEN);
            } else {
                inv.setItem(7, RED);
                inv.setItem(16, createCustomItem(XMaterial.FEATHER.parseMaterial(), "advanced_fly", "disabled"));
                inv.setItem(25, RED);
            }
        } else {
            inv.setItem(7, ORANGE);
            inv.setItem(16, createCustomItem(XMaterial.FEATHER.parseMaterial(), "advanced_fly", "no_permission"));
            inv.setItem(25, ORANGE);
        }
    }

    /*
        TODO: This isn't great.
        While it's better than what we had before, ideally we shouldn't
        have magic strings, and I don't like how redundant this system still is.
     */
    private static ItemStack createCustomItem(Material material, String optionKey, String statusKey) {
        String name = MessageUtils.getMessage("messages.inventories.options." + optionKey + ".name");

        List<String> lore = new ArrayList<>();
        lore.addAll(MessageUtils.getMessageList("messages.inventories.options." + optionKey + ".description"));
        lore.addAll(MessageUtils.getMessageList("messages.inventories.options.status." + statusKey));

        return ItemUtils.create(material, 1, name, lore);
    }
}
