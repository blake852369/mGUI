//this is property of the account holder of Minecraft account of blake852369 and is made by him
package me.blake852369;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GuiCore extends JavaPlugin {
    public Permission staff = new Permission("mGui.staff");
    
    

	@Override
	public void onEnable() {	
            PluginManager pm = getServer().getPluginManager();
            pm.addPermission(staff);
            new EventClick (this);
        }
	
	@Override
	public void onDisable() {
		
	}
	public Inventory menu;
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("manage")) {
			Player player = (Player) sender;
                        if(player.hasPermission(staff) == true){
                            if(Bukkit.getOnlinePlayers().toString().contains(args[0])){
                            ItemStack mute = new ItemStack(Material.IRON_FENCE, 1);
                            ItemMeta mutem = mute.getItemMeta();
                            mutem.setDisplayName(ChatColor.GRAY + "Mute " + args[0]);
                            mute.setItemMeta(mutem);
                            
                            ItemStack kick = new ItemStack(Material.BEACON, 1);
                            ItemMeta kickm = kick.getItemMeta();
                            kickm.setDisplayName(ChatColor.RED + "Kick " + args[0]);
                            kick.setItemMeta(kickm);
                            
                            ItemStack ban = new ItemStack(Material.BEDROCK, 1);
                            ItemMeta banm = ban.getItemMeta();
                            banm.setDisplayName(ChatColor.RED + "Ban " + args[0]);
                            ban.setItemMeta(banm);
                            
                            menu = Bukkit.createInventory(null, 9, args[0]);
                            menu.clear();
                            menu.setItem(2, mute);
                            menu.setItem(4, kick);
                            menu.setItem(6, ban);
                            player.openInventory(menu);
                            me.blake852369.EventClick listener = new me.blake852369.EventClick(this);
                            listener.using.put(player, null);
                            }else{
                                player.sendMessage(ChatColor.RED + "This Player Isn't Online Right Now!");
                            }
                        }









                


                



return true;
                }

return false;
        }






















}

	
