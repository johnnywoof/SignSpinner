package me.johnnywoof.signspinner;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SignSpinner extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        this.getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler(ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent event) {

        if (event.hasBlock() && event.getAction() == Action.RIGHT_CLICK_BLOCK
                && event.getClickedBlock().getType() == Material.SIGN_POST
                && event.getPlayer().hasPermission("signspinner.spin")) {

            new SpinnerTask(event.getClickedBlock()).runTaskTimer(this, 0, 20);

        }

    }

}
