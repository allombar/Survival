package be.symbiosis.survivalgame.managers.players;

import be.symbiosis.survivalgame.managers.teams.TeamType;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerGame {
    private final Player _playerGame;
    public TeamType team;

    public PlayerGame(Player player) {
        this._playerGame = player;
        this.team = TeamType.NONE;
    }

    public Player getPlayer() {
        return _playerGame;
    }

    public UUID getId() {
        return _playerGame.getUniqueId();
    }
}