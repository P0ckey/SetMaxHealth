package lyu.leo.setmaxhealth;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class SetMaxHealth extends JavaPlugin implements Listener {

    FileConfiguration config = this.getConfig();
    public List<String> players = new ArrayList<String>();

    @Override
    public void onEnable() {
        config.addDefault("defaultHealth", 20.0);
        config.addDefault("users", new ArrayList<String>() {
        });
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info("SetMaxHealth has been loaded!");
        this.getCommand("SetMaxHealth").setExecutor(new SetCommand());
        getServer().getPluginManager().registerEvents(this,this);
        players = getConfig().getStringList("users");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!players.contains(player.getUniqueId().toString())){
            player.setMaxHealth(config.getDouble("defaultHealth"));
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("SetMaxHealth stopped!");
        this.getConfig().set("users",players);
        this.saveConfig();
    }
}
