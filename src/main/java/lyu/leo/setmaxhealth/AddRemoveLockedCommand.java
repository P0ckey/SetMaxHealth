package lyu.leo.setmaxhealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddRemoveLockedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (args[0].toUpperCase().equals("ADD")) {
            String result = SetMaxHealth.addLocked(args[1]);
            if(result.equals("success")){
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.AQUA + args[1] + " has been added to the locked players.");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage(args[1] + " has been added to the locked players.");
                }
            }
            else{
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.RED + args[1] + " is already in the locked players.");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage(args[1] + " is already in the locked players.");
                }
            }
        }
        else if (args[0].toUpperCase().equals("REMOVE")) {
            String result = SetMaxHealth.removeLocked(args[1]);
            if(result.equals("success")){
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.AQUA + args[1] + " has been removed from the locked players.");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage(args[1] + " has been removed from the locked players.");
                }
            }
            else{
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.RED + args[1] + " is not in the locked players.");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage(args[1] + " is not in the locked players.");
                }
            }
        }

        return true;
    }
}
