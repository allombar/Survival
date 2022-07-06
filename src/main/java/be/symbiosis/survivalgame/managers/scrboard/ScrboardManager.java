package be.symbiosis.survivalgame.managers.scrboard;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.managers.players.PlayerGame;
import be.symbiosis.survivalgame.managers.teams.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScrboardManager {
    public static void updateScoreboard(Player player) {
        ScoreboardManager scoreboardManager =  Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("general", "dummy", "Mon scoreboard");

        objective.setDisplayName(ChatColor.GOLD + ">- Statistiques -<");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        final Score v = objective.getScore("§7§m----------------------------");
        final Score teamS = objective.getScore("| Score des teams |");
        final Score teamRed = objective.getScore(ChatColor.RED + "Joueurs rouges: " + TeamManager.redTeam.size());
        final Score teamYellow = objective.getScore(ChatColor.YELLOW + "Joueurs jaunes: " + TeamManager.yellowTeam.size());
        final Score teamGreen = objective.getScore(ChatColor.GREEN + "Joueurs verts: " + TeamManager.greenTeam.size());
        final Score teamBlue = objective.getScore(ChatColor.BLUE + "Joueurs bleus: " + TeamManager.blueTeam.size());
        final Score v2 = objective.getScore("§7§m----------------------------");
        final Score party = objective.getScore("| Game | ");
        final Score ob = objective.getScore("Objective: ");
        final Score totalp = objective.getScore("Players: "+Bukkit.getOnlinePlayers());
        final Score v3 = objective.getScore("7§m----------------------------");

        v.setScore(10);
        teamS.setScore(9);
        teamRed.setScore(8);
        teamYellow.setScore(7);
        teamGreen.setScore(6);
        teamBlue.setScore(5);
        v2.setScore(4);
        party.setScore(3);
        ob.setScore(2);
        totalp.setScore(1);
        v3.setScore(0);

        PlayerGame playerGame = SurvivalCore.getPlayerGameManager().getPlayerGame(player.getUniqueId());
        if (playerGame.team != null) {
            for (PlayerGame p : SurvivalCore.getTeamManager().getAllPlayers())
            p.getPlayer().setScoreboard(scoreboard);
        }
    }
}
