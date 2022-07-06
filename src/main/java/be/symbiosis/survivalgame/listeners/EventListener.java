package be.symbiosis.survivalgame.listeners;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.SurvivalGame;
import be.symbiosis.survivalgame.Utils;
import be.symbiosis.survivalgame.managers.players.PlayerGame;
import be.symbiosis.survivalgame.managers.scrboard.ScrboardManager;
import be.symbiosis.survivalgame.managers.teams.TeamManager;
import be.symbiosis.survivalgame.managers.teams.TeamType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle("§bBienvenue dans ", "§3§lSurvival Game !", 10, 70,20);
        SurvivalCore.getPlayerGameManager().addPlayer(player);
        ScrboardManager.updateScoreboard(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        SurvivalCore.getPlayerGameManager().removePlayer(player);
        ScrboardManager.updateScoreboard(player);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        InventoryView inventory = event.getView();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        if (current == null) return;

        if (inventory.getTitle() == "§2• §fSurvival Team") {
            event.setCancelled(true);

            if (current.getType() == Material.RED_BED) {
                TeamManager.addPlayerInTeam(player, TeamType.RED);
                player.closeInventory();
            }
            if (current.getType() == Material.YELLOW_BED) {
                TeamManager.addPlayerInTeam(player, TeamType.YELLOW);
                player.closeInventory();
            }
            if (current.getType() == Material.GREEN_BED) {
                TeamManager.addPlayerInTeam(player, TeamType.GREEN);
                player.closeInventory();
            }
            if (current.getType() == Material.BLUE_BED) {
                TeamManager.addPlayerInTeam(player, TeamType.BLUE);
                player.closeInventory();
            }

            ScrboardManager.updateScoreboard(player);
        }
    }
}
