package net.hasanchik.neutroneum.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class MetalDetectorItem extends Item {
    //TODO: find better way of storing detectable blocks
    public static final int animationFrames = 31;
    protected static HashMap<String, String> detectableBlocks = new HashMap<>();
    protected Integer closestOreDistance = 0;

    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    private void print(String message, Player player) {
        player.sendSystemMessage(Component.literal(message));
    }
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            this.closestOreDistance = RandomSource.createNewThreadLocalInstance().nextInt(animationFrames);
            print("test " + this.getClosestOreDistance(), player);
        }

        return  super.use(level, player, hand);
    }

    public int getClosestOreDistance() {
        System.out.println(this.closestOreDistance);
        return this.closestOreDistance;
    }
}
