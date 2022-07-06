package be.symbiosis.survivalgame.managers.teams;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.managers.players.PlayerGame;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TeamManager {
    public static ArrayList<PlayerGame> blueTeam;
    public static ArrayList<PlayerGame> redTeam;
    public static ArrayList<PlayerGame> yellowTeam;
    public static ArrayList<PlayerGame> greenTeam;

    public TeamManager() {
        redTeam = new ArrayList<>();
        blueTeam = new ArrayList<>();
        yellowTeam = new ArrayList<>();
        greenTeam = new ArrayList<>();
    }

    public ArrayList<PlayerGame> getAllPlayers() {
        ArrayList<PlayerGame> Players = new ArrayList<>();
        Players.addAll(redTeam);
        Players.addAll(blueTeam);
        Players.addAll(yellowTeam);
        Players.addAll(greenTeam);

        return Players;
    }

    public int getPlayerCountTeamType(TeamType type)
    {
        if (type.equals(TeamType.BLUE)) {
            return blueTeam.size();
        }

        if (type.equals(TeamType.RED)) {
            return redTeam.size();
        }

        if (type.equals(TeamType.YELLOW)) {
            return yellowTeam.size();
        }

        if (type.equals(TeamType.GREEN)) {
            return greenTeam.size();
        }
        return 0;
    }

    public boolean canEnterOnTeam(TeamType type) {
        if (type.equals(TeamType.BLUE)) {
            return blueTeam.size() < 5;
        }

        if (type.equals(TeamType.RED)) {
            return redTeam.size() < 5;
        }

        if (type.equals(TeamType.YELLOW)) {
            return yellowTeam.size() < 5;
        }

        if (type.equals(TeamType.GREEN)) {
            return greenTeam.size() < 5;
        }
        return false;
    }

    public static void addUser(PlayerGame user) {
        if (user.team.equals(TeamType.BLUE)) {
            blueTeam.add(user);
        } else if (user.team.equals(TeamType.RED)) {
            redTeam.add(user);
        } else if (user.team.equals(TeamType.YELLOW)) {
            yellowTeam.add(user);
        } else if (user.team.equals(TeamType.GREEN)) {
            greenTeam.add(user);
        }
    }

    public static void onUserLeave(PlayerGame user) {
        if (user.team.equals(TeamType.BLUE)) {
            blueTeam.remove(user);
        } else if (user.team.equals(TeamType.RED)) {
            redTeam.remove(user);
        } else if (user.team.equals(TeamType.YELLOW)) {
            yellowTeam.remove(user);
        } else if (user.team.equals(TeamType.GREEN)) {
            greenTeam.remove(user);
        }
    }

    public static int getTeamById(TeamType team) {
        int teamId;
        switch (team) {
            case RED:
                teamId = 1;
                break;
            case GREEN:
                teamId = 2;
                break;
            case BLUE:
                teamId = 3;
                break;
            case YELLOW:
                teamId = 4;
                break;
            default:
                teamId = 0;
        }
        return teamId;
    }

    public static TeamType getTeamByIndex(int index) {
        TeamType nbTeam;
        switch (index) {
            case 1:
                nbTeam = TeamType.RED;
                break;
            case 2:
                nbTeam = TeamType.GREEN;
                break;
            case 3:
                nbTeam = TeamType.BLUE;
                break;
            case 4:
                nbTeam = TeamType.YELLOW;
                break;
            default:
                nbTeam = TeamType.NONE;
                break;
        }
        return nbTeam;
    }

    public static void addPlayerInTeam(Player player, TeamType Type) {
        PlayerGame p = SurvivalCore.getPlayerGameManager().getPlayerGame(player.getUniqueId());

        if (p.team != TeamType.NONE) {
            onUserLeave(p);
        }
        p.team = Type;

        addUser(p);
    }
}
