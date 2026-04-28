package me.yourname.mending;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MendingListener implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onXP(PlayerExpChangeEvent e) {

        Player p = e.getPlayer();
        int xp = e.getAmount();

        List<ItemStack> items = new ArrayList<>();

        ItemStack hand = p.getItemInHand();
        if (hand != null) items.add(hand);

        for (ItemStack i : p.getInventory().getArmorContents()) {
            if (i != null) items.add(i);
        }

        if (items.isEmpty()) return;

        ItemStack item = items.get(random.nextInt(items.size()));

        short dmg = item.getDurability();
        if (dmg <= 0) return;

        int repair = Math.min(dmg, xp * 2);
        item.setDurability((short) (dmg - repair));

        e.setAmount(xp - repair / 2);
    }
}