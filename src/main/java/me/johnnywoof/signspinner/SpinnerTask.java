package me.johnnywoof.signspinner;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
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

            byte data = state.getRawData();

            if (++data > 15)
                data = 0;

            state.setRawData(data);

            state.update(true, false);

        } else {

            this.cancel();

        }

    }

}
