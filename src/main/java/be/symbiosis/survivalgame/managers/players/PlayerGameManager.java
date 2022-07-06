package be.symbiosis.survivalgame.managers.players;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerGameManager {
    private final HashMap<UUID, PlayerGame> _players;
    public PlayerGameManager() {
        this._players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        if (_players.get(player.getUniqueId()) == null)
            _players.put(player.getUniqueId(), new PlayerGame(player));
    }

    public void removePlayer(Player player) {
        if (_players.get(player.getUniqueId()) != null)
            _players.remove(player.getUniqueId());
    }

    public PlayerGame getPlayerGame(UUID uuid) {
        if(!_players.containsKey(uuid)) {
            return null;
        }

        PlayerGame player = _players.get(uuid);
        return player;
    }
}
