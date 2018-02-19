package mc.cuttree;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class wood implements Listener {

	static List<String> worldlist = new ArrayList<String>();
	
	public void setlistw(List<String> list){
		worldlist = list;
	}
	
	@SuppressWarnings("deprecation")
	public void cut(BlockBreakEvent e,Location loc){
		boolean b = false;
		for(String l : worldlist){
			String wn = e.getBlock().getLocation().getWorld().getName();
			if(l.equals(wn)){
				b = true;
			}
		}
		
		
		if(b){
			Block block = loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
			if(block.getType() == Material.LOG){
				block.setType(Material.AIR);
				Location loc2 = new Location(loc.getWorld(), loc.getBlockX()+0.5,loc.getBlockY()+1,loc.getBlockZ()+0.5);
				loc.getWorld().spawnFallingBlock(loc2, Material.LOG,e.getBlock().getData());
				
				Location ln = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
				
				cut(e,ln);
				
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void cut2(BlockBreakEvent e,Location loc){
		boolean b = false;
		for(String l : worldlist){
			String wn = e.getBlock().getLocation().getWorld().getName();
			if(l.equals(wn)){
				b = true;
			}
		}
		
		if(b){
			Block block = loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
			if(block.getType() == Material.LOG_2){
				block.setType(Material.AIR);
				Location loc2 = new Location(loc.getWorld(), loc.getBlockX()+0.5,loc.getBlockY()+1,loc.getBlockZ()+0.5);
				loc.getWorld().spawnFallingBlock(loc2, Material.LOG_2,e.getBlock().getData());
				
				Location ln = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
				
				cut2(e,ln);
				
				
			}
		}
	}
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreakWood(BlockBreakEvent e){
		if(e.getBlock().getType() == Material.LOG){
			Location loc = e.getBlock().getLocation();
			int a = 1;
			
			if(e.getPlayer().isSneaking()){
				a = 0;
			}
			
			if(a == 1){
				Block block = loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
				if(block.getType() == Material.LOG){
					block.setType(Material.AIR);
					Location loc2 = new Location(loc.getWorld(), loc.getBlockX()+0.5,loc.getBlockY()+1,loc.getBlockZ()+0.5);
					loc.getWorld().spawnFallingBlock(loc2, Material.LOG,e.getBlock().getData());
					
					Location ln = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
					
					cut(e,ln);
					
				}
			}
			
		}
		
		if(e.getBlock().getType() == Material.LOG_2){
			Location loc = e.getBlock().getLocation();
			int a = 1;
			
			if(e.getPlayer().isSneaking()){
				a = 0;
			}
			
			if(a == 1){
				Block block = loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
				if(block.getType() == Material.LOG_2){
					block.setType(Material.AIR);
					Location loc2 = new Location(loc.getWorld(), loc.getBlockX()+0.5,loc.getBlockY()+1,loc.getBlockZ()+0.5);
					loc.getWorld().spawnFallingBlock(loc2, Material.LOG_2,e.getBlock().getData());
					
					Location ln = new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY()+1, loc.getBlockZ());
					
					cut2(e,ln);
				}
			}
			
		}
		
		
		
		
		
	}
	
	
	
}
