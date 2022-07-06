package be.symbiosis.survivalgame;

import be.symbiosis.survivalgame.commands.AddPoint;
import be.symbiosis.survivalgame.commands.ChooseTeam;
import be.symbiosis.survivalgame.listeners.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public class SurvivalGame extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("team").setExecutor(new ChooseTeam());
        getCommand("addpoint").setExecutor(new AddPoint());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        new SurvivalCore(this);
    }
}
