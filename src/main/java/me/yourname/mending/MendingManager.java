package me.yourname.mending;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MendingManager {

    private static final String TAG = ChatColor.GRAY + "Mending";

    public static boolean has(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        return meta.hasLore() && meta.getLore().contains(TAG);
    }

    public static void apply(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();

        if (!lore.contains(TAG)) lore.add(TAG);

        meta.setLore(lore);
        item.setItemMeta(meta);
    }
}