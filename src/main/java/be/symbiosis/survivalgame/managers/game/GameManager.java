package be.symbiosis.survivalgame.managers.game;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.Utils;
import be.symbiosis.survivalgame.managers.teams.TeamType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class GameManager {
    public int[] teamPoints;
    private static boolean gameStarted;
    private String gameName;

    public GameManager() {
        teamPoints = new int[5];
        gameStarted = false;
        gameName = null;
    }

    public void addPointToTeam(TeamType team) {
        this.addPointToTeam(team, 1);
    }

    public void addPointToTeam(TeamType team, int points)
    {
        int teamId = SurvivalCore.getTeamManager().getTeamById(team);
        System.out.println("My team id: " +teamId);
        int points1 = this.teamPoints[teamId] += points;
        if (points1 < 0)
        {
            points1 = 0;
        }

        if (points1 > 999)
        {
            points1 = 999;
        }

        this.teamPoints[teamId] = points1;
    }

    public TeamType getWinningTeam()
    {
        TeamType nbTeam = null;
        int maxPoints = 0;
        for (int i = 1; i < 5; ++i)
        {
            if (this.teamPoints[i] == maxPoints)
            {
                nbTeam = TeamType.NONE;
            }

            if (this.teamPoints[i] > maxPoints && this.teamPoints[i] > 0)
            {
                maxPoints = this.teamPoints[i];
                nbTeam = SurvivalCore.getTeamManager().getTeamByIndex(i);
            }
        }
        return nbTeam;
    }

}
