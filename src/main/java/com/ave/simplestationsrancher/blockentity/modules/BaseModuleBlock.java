package com.ave.simplestationsrancher.blockentity.modules;

import com.ave.simplestationscore.partblock.PartBlock;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlock;
import com.ave.simplestationsrancher.blockentity.BaseRancherBlockEntity;
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
            player.openMenu(module, module.getBlockPos());
            return ItemInteractionResult.SUCCESS;
        }
        var type = ModuleType.fromItem(stack.getItem());
        if (type == ModuleType.EMPTY)
            return ItemInteractionResult.SUCCESS;

        replace(level, pos, type, module.getControllerPos());
        if (!player.isCreative())
            stack.shrink(1);
        level.playSound(null, pos, SoundEvents.METAL_PLACE, SoundSource.BLOCKS);
        return ItemInteractionResult.CONSUME;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level.isClientSide)
            return state;
        var be = (BaseModuleEntity) level.getBlockEntity(pos);
        if (be.type != ModuleType.EMPTY.id)
            return state;
        return super.playerWillDestroy(level, pos, state, player);
    }

    private static void replace(Level level, BlockPos pos, ModuleType type, BlockPos controllerPos) {
        var block = type.station.getBlock().defaultBlockState();
        level.setBlock(pos, block, 3);
        var newBlock = (BaseModuleEntity) level.getBlockEntity(pos);
        newBlock.setControllerPos(controllerPos);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        var be = (BaseModuleEntity) level.getBlockEntity(pos);
        var controllerPos = be.getControllerPos();
        var replace = controllerPos != null && be.type != ModuleType.EMPTY.id;
        super.onRemove(state, level, pos, newState, isMoving);
        if (!replace)
            return;
        dropModule(level, be, pos);
        var controllerBe = level.getBlockEntity(controllerPos);
        if (controllerBe instanceof BaseRancherBlockEntity)
            BaseRancherBlock.resetNeighboors(level, controllerPos);
    }

    private static void dropModule(Level level, BaseModuleEntity module, BlockPos pos) {
        level.playSound(null, pos, SoundEvents.METAL_BREAK, SoundSource.BLOCKS);
        var type = ModuleType.fromId(module.type);
        var item = type.station.getItem();
        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item));
        Containers.dropContents(level, pos, module.inventory.getAsList());
    }
}
