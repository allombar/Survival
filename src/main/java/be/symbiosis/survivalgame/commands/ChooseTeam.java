package be.symbiosis.survivalgame.commands;

import be.symbiosis.survivalgame.SurvivalCore;
import be.symbiosis.survivalgame.Utils;
import be.symbiosis.survivalgame.managers.players.PlayerGame;
import be.symbiosis.survivalgame.managers.teams.TeamType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ChooseTeam implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            PlayerGame p = SurvivalCore.getPlayerGameManager().getPlayerGame(player.getUniqueId());

            if(p.team == TeamType.NONE)
            {
                Inventory inventory = Bukkit.createInventory(null, 9, "§2• §fSurvival Team");


                inventory.setItem(2, Utils.setItem(Material.RED_BED, "§2• §fTeam Rouge"));
                inventory.setItem(3, Utils.setItem(Material.YELLOW_BED, "§2• §fTeam Jaune"));
                inventory.setItem(5, Utils.setItem(Material.GREEN_BED, "§2• §fTeam Verte"));
                inventory.setItem(6, Utils.setItem(Material.BLUE_BED, "§2• §fTeam Bleu"));

                p.getPlayer().openInventory(inventory);
                return false;
            } else {
                player.sendMessage("Tu es déjà dans la team " + p.team.name());
            }

        }
        return false;
    }
}
