package me.blake852369;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

class EventClick implements Listener{
    public EventClick(GuiCore plugin) {
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    public HashMap<Player, ArrayList<Block>> using = new HashMap<Player, ArrayList<Block>>();
    public ArrayList<String> mute = new ArrayList<String>();    
    @EventHandler
    public void clickItem(InventoryClickEvent event){
        
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        Player target = Bukkit.getPlayer(event.getInventory().getName());
        if(using.containsKey(player)){
        if(target.isOnline()){
        if(item.getType() != Material.AIR){
        if(item.getItemMeta().getDisplayName().contains("Mute")){
            if(!mute.contains(target.getName())){
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mute " + target.getName());
            player.closeInventory();
            player.sendMessage(ChatColor.GREEN + "Successfuly Muted: " + target.getName());
            mute.add(target.getName());
            using.remove(player);
        }else if(mute.contains(target.getName())){
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "mute " + target.getName());
            player.closeInventory();
            player.sendMessage(ChatColor.GREEN + "Successfuly UnMuted: " + target.getName());
            using.remove(player);
            mute.remove(target.getName());
        }
            
            
            
        }else if(item.getItemMeta().getDisplayName().contains("Kick")){
            player.sendMessage(ChatColor.GREEN + "Successfuly Kicked: " + target.getName());
            target.kickPlayer(ChatColor.RED + "You Have Been Kicked From The Server!");
            using.remove(player);
        
        
        }else if(item.getItemMeta().getDisplayName().contains("Ban")){
            player.sendMessage(ChatColor.GREEN + "Successfuly Banned: " + target.getName());
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "ban " + target.getName());
            using.remove(player);
        }
        
        
        
        
        
        
        
       }
    }
    }

    }







}
