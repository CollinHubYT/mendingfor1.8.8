package me.yourname.mending;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class MendingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length != 2) return false;

        Player p = Bukkit.getPlayer(args[1]);
        if (p == null) return true;

        MendingManager.apply(p.getItemInHand());
        return true;
    }
}