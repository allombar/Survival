package be.symbiosis.survivalgame;

import be.symbiosis.survivalgame.managers.players.PlayerGame;
import be.symbiosis.survivalgame.managers.teams.TeamManager;
import be.symbiosis.survivalgame.managers.teams.TeamType;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class Utils {
    public static ItemStack setItem(Material material, String name) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta itemM = item.getItemMeta();
        itemM.setDisplayName(name);
        item.setItemMeta(itemM);
        return item;
    }

    public static String checkTeam(TeamType type) {
        if (type.equals(TeamType.BLUE)) {
            return "Joueurs bleus";
        }

        if (type.equals(TeamType.RED)) {
            return "Joueurs rouges";
        }

        if (type.equals(TeamType.YELLOW)) {
            return "Joueurs jaunes";
        }

        if (type.equals(TeamType.GREEN)) {
            return "Joueurs verts";
        }
        return "";
    }
}
