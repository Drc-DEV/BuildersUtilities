package xyz.tehbrian.buildersutilities.inventories;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.tehbrian.buildersutilities.util.BannerUtils;
import xyz.tehbrian.buildersutilities.util.ItemUtils;
import xyz.tehbrian.buildersutilities.util.MessageUtils;

/*
    TODO: Add back button.
    I'm not quite sure how we would implement it,
    but it's definitely top priority in terms of
    making the plugin visibly better, because currently if you
    make a bad decision you essentially have to restart.
 */

/*
    TODO: Clean up this code.
    It's all a mess.
 */
public class BannerInventory {

    private BannerInventory() {
    }

    public static Inventory generateBaseInventory() {
        Inventory inv = Bukkit.createInventory(null, 54, MessageUtils.getMessage("messages.inventories.banner.base_inventory_name"));

        for (int x = 0; x < inv.getSize(); x++) {
            inv.setItem(x, ItemUtils.create(XMaterial.LIGHT_GRAY_STAINED_GLASS_PANE.parseMaterial(), 1, "&7"));
        }

        inv.setItem(12, ItemUtils.createHead(MessageUtils.getMessage("heads.banner.randomize"), 1, MessageUtils.getMessage("messages.inventories.banner.randomize")));
        inv.setItem(14, ItemUtils.create(XMaterial.BARRIER.parseMaterial(), 1, MessageUtils.getMessage("messages.inventories.banner.cannot_get_banner")));

        inv.setItem(28, ItemUtils.create(XMaterial.BLACK_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(29, ItemUtils.create(XMaterial.RED_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(30, ItemUtils.create(XMaterial.GREEN_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(31, ItemUtils.create(XMaterial.BROWN_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(32, ItemUtils.create(XMaterial.BLUE_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(33, ItemUtils.create(XMaterial.PURPLE_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(34, ItemUtils.create(XMaterial.CYAN_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(35, ItemUtils.create(XMaterial.LIGHT_GRAY_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));

        inv.setItem(37, ItemUtils.create(XMaterial.GRAY_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(38, ItemUtils.create(XMaterial.PINK_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(39, ItemUtils.create(XMaterial.LIME_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(40, ItemUtils.create(XMaterial.YELLOW_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(41, ItemUtils.create(XMaterial.LIGHT_BLUE_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(42, ItemUtils.create(XMaterial.MAGENTA_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(43, ItemUtils.create(XMaterial.ORANGE_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(44, ItemUtils.create(XMaterial.WHITE_BANNER.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));

        return inv;
    }

    public static Inventory generateColorInventory(ItemStack oldBanner) {
        Inventory inv = Bukkit.createInventory(null, 54, MessageUtils.getMessage("messages.inventories.banner.color_inventory_name"));

        for (int x = 0; x < inv.getSize(); x++) {
            inv.setItem(x, ItemUtils.create(XMaterial.LIGHT_GRAY_STAINED_GLASS_PANE.parseMaterial(), 1, "&7"));
        }

        inv.setItem(12, ItemUtils.createHead(MessageUtils.getMessage("heads.banner.randomize"), 1, MessageUtils.getMessage("messages.inventories.banner.randomize")));
        inv.setItem(14, oldBanner);

        inv.setItem(28, ItemUtils.create(XMaterial.BLACK_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(29, ItemUtils.create(XMaterial.RED_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(30, ItemUtils.create(XMaterial.GREEN_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(31, ItemUtils.create(XMaterial.BROWN_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(32, ItemUtils.create(XMaterial.BLUE_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(33, ItemUtils.create(XMaterial.PURPLE_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(34, ItemUtils.create(XMaterial.CYAN_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(35, ItemUtils.create(XMaterial.LIGHT_GRAY_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));

        inv.setItem(37, ItemUtils.create(XMaterial.GRAY_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(38, ItemUtils.create(XMaterial.PINK_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(39, ItemUtils.create(XMaterial.LIME_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(40, ItemUtils.create(XMaterial.YELLOW_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(41, ItemUtils.create(XMaterial.LIGHT_BLUE_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(42, ItemUtils.create(XMaterial.MAGENTA_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(43, ItemUtils.create(XMaterial.ORANGE_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));
        inv.setItem(44, ItemUtils.create(XMaterial.WHITE_DYE.parseMaterial(), 1, MessageUtils.getMessageList("messages.inventories.banner.select")));

        return inv;
    }

    public static Inventory generatePatternInventory(ItemStack oldBanner, DyeColor dyeColor) {
        Inventory inv = Bukkit.createInventory(null, 54, MessageUtils.getMessage("messages.inventories.banner.pattern_inventory_name"));

        for (int x = 0; x < inv.getSize(); x++) {
            inv.setItem(x, ItemUtils.create(XMaterial.LIGHT_GRAY_STAINED_GLASS_PANE.parseMaterial(), 1, "&7"));
        }

        inv.setItem(3, ItemUtils.createHead(MessageUtils.getMessage("heads.banner.randomize"), 1, MessageUtils.getMessage("messages.inventories.banner.randomize")));
        inv.setItem(5, oldBanner);

        Material base;

        switch (dyeColor) {
            case WHITE:
            case LIGHT_GRAY:
            case LIME:
            case LIGHT_BLUE:
            case YELLOW:
                base = XMaterial.BLACK_BANNER.parseMaterial();
                break;
            default:
                base = XMaterial.WHITE_BANNER.parseMaterial();
                break;
        }

        for (int x = 9; x < (BannerUtils.getAllPatternTypes().size() + 9); x++) {
            inv.setItem(x, BannerUtils.createBanner(base, MessageUtils.getMessageList("messages.inventories.banner.select"), new Pattern(dyeColor, BannerUtils.getAllPatternTypes().get(x - 9))));
        }

        return inv;
    }
}
