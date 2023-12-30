package lyu.leo.setmaxhealth;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class SetMaxHealth extends JavaPlugin implements Listener {

    public FileConfiguration config = this.getConfig();
    public static List<String> bypassPlayers = new ArrayList<String>();
    public static double defaultHealth = 0.0;

    public static String addLocked(String playername) {
        if(!bypassPlayers.contains(playername)) {
            bypassPlayers.add(playername);
            return "success";
        }
        else{
            return "exists";
        }
    }

    public static String removeLocked(String playername) {
        if(bypassPlayers.contains(playername)) {
            bypassPlayers.remove(playername);
            return "success";
        }
        else{
            return "exists";
        }
    }

    public static Boolean inLocked(String playername) {
        if(bypassPlayers.contains(playername)){
            return true;
        }
        return false;
    }

    @Override
    public void onEnable() {
        config.addDefault("defaultHealth", 20.0);
        config.addDefault("bypass-users", new ArrayList<String>() {
        });
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info("SetMaxHealth has been loaded!");
        this.getCommand("SetMaxHealth").setExecutor(new SetCommand());
        this.getCommand("SetLocked").setExecutor(new AddRemoveLockedCommand());
        getServer().getPluginManager().registerEvents(this,this);
        bypassPlayers = getConfig().getStringList("bypass-users");
        defaultHealth = getConfig().getDouble("defaultHealth");

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!bypassPlayers.contains(player.getName())){
            player.setMaxHealth(defaultHealth);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("SetMaxHealth stopped!");
        this.getConfig().set("bypass-users", bypassPlayers);
        this.saveConfig();
    }
}
