package be.symbiosis.survivalgame;
import be.symbiosis.survivalgame.managers.game.GameManager;
import be.symbiosis.survivalgame.managers.players.PlayerGameManager;
import be.symbiosis.survivalgame.managers.scrboard.ScrboardManager;
import be.symbiosis.survivalgame.managers.teams.TeamManager;

public class SurvivalCore {
    private static SurvivalGame _instance;
    private static GameManager _gameManager;
    private static PlayerGameManager _playerGame;
    private static TeamManager _teamManager;
    public SurvivalCore(SurvivalGame instance) {
        _instance = instance;
        _gameManager = new GameManager();
        _playerGame = new PlayerGameManager();
        _teamManager = new TeamManager();
    }

    public static SurvivalGame getInstance() {
        return _instance;
    }
    public static GameManager getGameManager() {
        return _gameManager;
    }

    public static PlayerGameManager getPlayerGameManager() {
        return _playerGame;
    }

    public static TeamManager getTeamManager() {
        return _teamManager;
    }

}
