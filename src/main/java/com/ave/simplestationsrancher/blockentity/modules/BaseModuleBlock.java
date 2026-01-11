package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationscore.partblock.PartBlock;
import com.ave.simplestationsrancher.enums.ModuleType;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BaseModuleBlock extends PartBlock {
    public BaseModuleBlock(Properties props) {
        super(props);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BaseModuleEntity(pos, state);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return false;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hit) {
        var be = level.getBlockEntity(pos);
        if (!(be instanceof BaseModuleEntity module))
            return ItemInteractionResult.SUCCESS;
        if (module.type != ModuleType.EMPTY.id) {
            player.openMenu(module);
            return ItemInteractionResult.SUCCESS;
        }
        var type = ModuleType.fromItem(stack.getItem());
        if (type == ModuleType.EMPTY)
            return ItemInteractionResult.SUCCESS;

        replace(level, pos, type, module.getControllerPos());
        stack.shrink(1);
        level.playSound(null, pos, SoundEvents.METAL_PLACE, SoundSource.BLOCKS);
        return ItemInteractionResult.CONSUME;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        return state;
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity be,
            ItemStack tool) {
        if (!(be instanceof BaseModuleEntity module) || level.isClientSide)
            return;

        if (module.type != ModuleType.EMPTY.id) {
            dropModule(level, module);
            replace(level, pos, ModuleType.EMPTY, module.getControllerPos());
            level.playSound(null, pos, SoundEvents.METAL_BREAK, SoundSource.BLOCKS);
            return;
        }

        var controllerPos = module.getControllerPos();
        if (controllerPos != null)
            level.destroyBlock(controllerPos, !player.isCreative());
    }

    private static void replace(Level level, BlockPos pos, ModuleType type, BlockPos controllerPos) {
        var block = type.station.getBlock().defaultBlockState();
        level.setBlock(pos, block, 3);
        var newBlock = (BaseModuleEntity) level.getBlockEntity(pos);
        newBlock.setControllerPos(controllerPos);
    }

    public static void dropModule(Level level, BaseModuleEntity module) {
        if (module.type == ModuleType.EMPTY.id)
            return;
        var type = ModuleType.fromId(module.type);
        var item = type.station.getItem();
        Containers.dropItemStack(level, module.getBlockPos().getX(), module.getBlockPos().getY(),
                module.getBlockPos().getZ(), new ItemStack(item));
        Containers.dropContents(level, module.getBlockPos(), module.inventory.getAsList());
    }
}
