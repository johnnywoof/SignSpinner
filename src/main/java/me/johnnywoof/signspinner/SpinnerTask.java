package me.johnnywoof.signspinner;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.material.Directional;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

public class SpinnerTask extends BukkitRunnable {
    private final Block block;

    public SpinnerTask(Block block) {
        this.block = block;
    }

    @Override
    public void run() {

        BlockState state = block.getState();

        if (state instanceof Sign) {

            MaterialData data = state.getData();

            if (data instanceof Directional) {

                Directional directional = (Directional) data;

                directional.setFacingDirection(directional.getFacing().getOppositeFace());

                state.update();

            }

        } else {

            this.cancel();

        }

    }

}
