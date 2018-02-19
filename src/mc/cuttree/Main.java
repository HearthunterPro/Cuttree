package mc.cuttree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin{

	
	@SuppressWarnings("unchecked")
	public void onEnable(){
		getCommand("ct").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new wood(), this);
		File file = new File(getDataFolder() + "//config.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(file.exists()){
			List<String> list = (List<String>) cfg.getList("worldEnable");
			if(list != null){
				wood w = new wood();
				w.setlistw(list);
			} else {
				ConsoleCommandSender con = Bukkit.getConsoleSender();
				con.sendMessage(ChatColor.RED + "[Cuttree]: Error Plugin not Found worldEnable list in config");
			}
		} else {
			ArrayList<String> list = new ArrayList<String>();
			list.add("world");
			cfg.set("worldEnable", list);
			
			try {
				cfg.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			wood w = new wood();
			w.setlistw(list);
			
			ConsoleCommandSender con = Bukkit.getConsoleSender();
			con.sendMessage("Create config file in : " + getDataFolder() + "//config.yml");
		}
	}
	
	
	public void Disable(){
		
	}
	
}
