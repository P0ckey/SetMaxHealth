package lyu.leo.setmaxhealth;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (args[0].equals("all")) {
                for(Player all:Bukkit.getOnlinePlayers()){
                    all.setMaxHealth(Double.parseDouble(args[1]));
                }
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.AQUA + "Everyone's max health has been set to " + args[1] + "!");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage("Everyone's max health has been set to " + args[1] + "!");
                }
            } else {
                Player p = Bukkit.getServer().getPlayer(args[0]);
                p.setMaxHealth(Double.parseDouble(args[1]));
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.AQUA + args[0] + "'s max health has been set to " + args[1] + "!");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage(args[0] + "'s max health has been set to " + args[1] + "!");
                }
            }
        }
        catch(Exception e) {
            if(sender instanceof Player){
                sender.sendMessage(ChatColor.RED + "Please use the correct format /setmaxhealth <player> <value>");
            }
            else{
                Bukkit.getConsoleSender().sendMessage("Please use the correct format /setmaxhealth <player> <value>");
            }
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return true;
    }

}
