package xyz.tehbrian.buildersutilities.listeners.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.tehbrian.buildersutilities.inventories.ArmorColorInventory;
import xyz.tehbrian.buildersutilities.util.ItemUtils;
import xyz.tehbrian.buildersutilities.util.MessageUtils;

import java.util.Objects;
import java.util.Random;

@SuppressWarnings("unused")
public class ArmorColorInventoryListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryClick(InventoryClickEvent event) {
        if (!Objects.equals(event.getClickedInventory(), event.getView().getTopInventory())) return;

        if (!event.getView().getTitle().equals(MessageUtils.getMessage("messages.inventories.armor_color.inventory_name")))
            return;
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player) event.getWhoClicked();

        int slot = event.getRawSlot();

        Inventory inventory = event.getClickedInventory();

        ItemStack item = inventory.getItem(slot);
        Objects.requireNonNull(item);

        event.setCancelled(true);

        switch (slot) {
            case 10:
            case 19:
            case 28:
            case 37:
                player.getInventory().addItem(ItemUtils.removeName(Objects.requireNonNull(event.getCurrentItem()).clone()));
                break;
            case 31:
            case 33:
            case 32:
                if (event.getClick() == ClickType.LEFT && item.getAmount() < 33) {
                    item.setAmount(item.getAmount() + 1);
                } else if (event.getClick() == ClickType.RIGHT && item.getAmount() > 1) {
                    item.setAmount(item.getAmount() - 1);
                } else if (event.getClick() == ClickType.SHIFT_LEFT && item.getAmount() < 30) {
                    item.setAmount(item.getAmount() + 4);
                } else if (event.getClick() == ClickType.SHIFT_LEFT) {
                    item.setAmount(33);
                } else if (event.getClick() == ClickType.SHIFT_RIGHT && item.getAmount() > 4) {
                    item.setAmount(item.getAmount() - 4);
                } else if (event.getClick() == ClickType.SHIFT_RIGHT) {
                    item.setAmount(1);
                }
                break;
            case 22:
            case 23:
            case 24:
                Objects.requireNonNull(inventory.getItem(slot + 9)).setAmount(new Random().nextInt(33) + 1);
                break;
            default:
                return;
        }

        inventory.setItem(slot, item);

        ArmorColorInventory.update(event.getClickedInventory());
    }
}
