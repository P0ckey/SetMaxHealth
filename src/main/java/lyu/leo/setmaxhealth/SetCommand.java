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
import java.util.Set;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (args[0].equals("all")) {
                for(Player player:Bukkit.getOnlinePlayers()){
                    if(SetMaxHealth.inLocked(player.getName())){
                        if (args.length==3){
                            if(args[2].toUpperCase().equals("BYPASS")){
                                player.setMaxHealth(Double.parseDouble(args[1]));
                                if(sender instanceof Player){
                                    sender.sendMessage(ChatColor.AQUA + player.getName() + "'s lock has been bypassed and max health has been changed to " + args[1] + ".");
                                }
                                else{
                                    Bukkit.getConsoleSender().sendMessage(player.getName() + "'s lock has been bypassed and max health has been changed to " + args[1] + ".");
                                }
                            }
                            else{
                                if(sender instanceof Player){
                                    sender.sendMessage(ChatColor.RED + player.getName() + " is in the locked list, add the keyword 'bypass' at the end of the command to also change their max health.");
                                }
                                else{
                                    Bukkit.getConsoleSender().sendMessage(player.getName() + " is in the locked list, add the keyword 'bypass' at the end of the command to also change their max health.");
                                }
                            }
                        }
                        else{
                            if(sender instanceof Player){
                                sender.sendMessage(ChatColor.RED + player.getName() + " is in the locked list, add the keyword 'bypass' at the end of the command to also change their max health.");
                            }
                            else{
                                Bukkit.getConsoleSender().sendMessage(player.getName() + " is in the locked list, add the keyword 'bypass' at the end of the command to also change their max health.");
                            }
                        }
                    }
                    else{
                        player.setMaxHealth(Double.parseDouble(args[1]));
                    }
                }
                if(sender instanceof Player){
                    sender.sendMessage(ChatColor.AQUA + "Everyone's max health has been set to " + args[1] + ".");
                }
                else{
                    Bukkit.getConsoleSender().sendMessage("Everyone's max health has been set to " + args[1] + ".");
                }
                SetMaxHealth.defaultHealth=Double.parseDouble(args[1]);
            } else {
                Player p = Bukkit.getServer().getPlayer(args[0]);
                if(SetMaxHealth.inLocked(p.getName())){
                    if (args.length==3){
                        if(args[2].toUpperCase().equals("BYPASS")){
                            p.setMaxHealth(Double.parseDouble(args[1]));
                            if(sender instanceof Player){
                                sender.sendMessage(ChatColor.AQUA + args[0] + "'s lock has been bypassed and max health has been changed to " + args[1] + ".");
                            }
                            else{
                                Bukkit.getConsoleSender().sendMessage(args[0] + "'s lock has been bypassed and max health has been changed to " + args[1] + ".");
                            }
                        }
                        else{
                            if(sender instanceof Player){
                                sender.sendMessage(ChatColor.RED + args[0] + " is in the locked list, add the keyword 'bypass' at the end of the command to change their max health.");
                            }
                            else{
                                Bukkit.getConsoleSender().sendMessage(args[0] + " is in the locked list, add the keyword 'bypass' at the end of the command to change their max health.");
                            }
                            return false;
                        }
                    }
                    else{
                        if(sender instanceof Player){
                            sender.sendMessage(ChatColor.RED + args[0] + " is in the locked list, add the keyword 'bypass' at the end of the command to change their max health.");
                        }
                        else{
                            Bukkit.getConsoleSender().sendMessage(args[0] + " is in the locked list, add the keyword 'bypass' at the end of the command to change their max health.");
                        }
                    }
                }
                else{
                    p.setMaxHealth(Double.parseDouble(args[1]));
                    if(sender instanceof Player){
                        sender.sendMessage(ChatColor.AQUA + args[0] + "'s max health has been changed to " + args[1] + ".");
                    }
                    else {
                        Bukkit.getConsoleSender().sendMessage(args[0] + "'s max health has been changed to " + args[1] + ".");
                    }
                }
            }
        }
        catch(Exception e) {
            if(sender instanceof Player){
                sender.sendMessage(ChatColor.RED + "Please use the correct format /setmaxhealth <player> <value> [optional: bypass]");
            }
            else{
                Bukkit.getConsoleSender().sendMessage("Please use the correct format /setmaxhealth <player> <value> [optional: bypass]");
            }
            Bukkit.getConsoleSender().sendMessage(e.toString());
        }
        return true;
    }

}
