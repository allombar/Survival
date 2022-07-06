package be.symbiosis.survivalgame.runnables;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.managers.players.PlayerGame;
import be.symbiosis.survivalgame.managers.scrboard.ScrboardManager;
import org.bukkit.scheduler.BukkitRunnable;

public class CycleGame extends BukkitRunnable {

    int timer = 130;
    int event = 30;
    @Override
    public void run() {
        if(timer == 0) {
            this.cancel();
        }
        if(event == 0) {

        }
        for(PlayerGame p : SurvivalCore.getTeamManager().getAllPlayers()) {
            ScrboardManager.updateScoreboard(p.getPlayer());
        }
    }
}
