package net.hasanchik.neutroneum.item.custom.MetalDetectorItem;

import net.hasanchik.neutroneum.util.BlockUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;

public class MetalDetectorItem extends Item {
    public static final int animationFrames = 31;
    protected static HashMap<String, String[]> detectableBlocks = new HashMap<>();
    protected Integer closestOreDistance = 0;
    protected int searchDistance = 10;
    //protected int

    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    private void print(String message, Player player) {
        player.sendSystemMessage(Component.literal(message));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            BlockPos playerBlockPos = BlockPos.containing(player.getPosition(1));
            BlockState[] blocks = BlockUtils.getAllBlocksInBox(playerBlockPos, this.searchDistance, true, level);
            for (int i = 0; i < blocks.length; i++) {
                if (blocks[i] != null) {
                    //print(blocks[i].toString(), player);
                }
            }


            this.closestOreDistance = RandomSource.createNewThreadLocalInstance().nextInt(animationFrames);
            print("test " + this.getClosestOreDistance(), player);
        }

        return  super.use(level, player, hand);
    }

    private static Tuple<Integer, BlockState> getClosestBlockWithId(ResourceLocation blockId, BlockState[] blocks) {
        for(int i = 0; i < blocks.length; i++) {
            BlockState block = blocks[i];

        }
        return new Tuple<>(null, null);
    }

    public int getClosestOreDistance() {
        //System.out.println(this.closestOreDistance);
        return this.closestOreDistance;
    }

    public void setSearchDistance(int searchDistance) {
        this.searchDistance = searchDistance;
    }
}
