package mc.cuttree;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		boolean iscom = true;
		
		if(sender instanceof Player){
			iscom = false;
		}
		Player p = null;
		ConsoleCommandSender con = null;
		
		if(iscom){
			con = (ConsoleCommandSender) sender;
		} else {
			p = (Player) sender;
		}
		
		if(cmd.getName().equalsIgnoreCase("ct")){
			if(iscom){
				con.sendMessage(ChatColor.RED + "not have Commands");
			} else {
				p.sendMessage(ChatColor.YELLOW + "Version Plugin: 1.0");
				p.sendMessage(ChatColor.YELLOW + "Plugin by: CushyPro");
				p.sendMessage(ChatColor.YELLOW + "no commands, you edit config file in folder plugins");
			}
		}
		
		
		return false;
	}

}
