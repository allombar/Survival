package be.symbiosis.survivalgame.commands;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.Utils;
import be.symbiosis.survivalgame.managers.game.GameManager;
import be.symbiosis.survivalgame.managers.players.PlayerGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddPoint implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            PlayerGame p = SurvivalCore.getPlayerGameManager().getPlayerGame(((Player) sender).getUniqueId());
            GameManager game = SurvivalCore.getGameManager();
            game.addPointToTeam(p.team);
            int index = 0;
            for (int item : game.teamPoints) {
                Bukkit.broadcastMessage(SurvivalCore.getTeamManager().getTeamByIndex(index++) + " point: " + item);
            }
        }
        return false;
    }
}
