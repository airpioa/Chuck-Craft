
package net.airpioa.chuckcraft.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.FastColor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.airpioa.chuckcraft.procedures.SpeakerBlockDestroyedByPlayerProcedure;
import net.airpioa.chuckcraft.block.entity.SpeakerBlockEntity;

import com.mojang.serialization.MapCodec;

public class SpeakerBlock extends FallingBlock implements EntityBlock {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	public static final MapCodec<SpeakerBlock> CODEC = simpleCodec(properties -> new SpeakerBlock());

	public MapCodec<SpeakerBlock> codec() {
		return CODEC;
	}

	public SpeakerBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.HEAVY_CORE).strength(1f, 10f).noOcclusion().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return FastColor.ARGB32.opaque(-13421773);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(-1, 0, 0, 17, 16, 2), box(-1, 0, 2, 17, 2, 14), box(-1, 14, 2, 17, 16, 14), box(14, 2, 2, 16, 14, 14), box(0, 2, 2, 2, 14, 14), box(-1, 0, 14, 17, 16, 16));
			case NORTH -> Shapes.or(box(-1, 0, 14, 17, 16, 16), box(-1, 0, 2, 17, 2, 14), box(-1, 14, 2, 17, 16, 14), box(0, 2, 2, 2, 14, 14), box(14, 2, 2, 16, 14, 14), box(-1, 0, 0, 17, 16, 2));
			case EAST -> Shapes.or(box(0, 0, -1, 2, 16, 17), box(2, 0, -1, 14, 2, 17), box(2, 14, -1, 14, 16, 17), box(2, 2, 0, 14, 14, 2), box(2, 2, 14, 14, 14, 16), box(14, 0, -1, 16, 16, 17));
			case WEST -> Shapes.or(box(14, 0, -1, 16, 16, 17), box(2, 0, -1, 14, 2, 17), box(2, 14, -1, 14, 16, 17), box(2, 2, 14, 14, 14, 16), box(2, 2, 0, 14, 14, 2), box(0, 0, -1, 2, 16, 17));
			case UP -> Shapes.or(box(-1, 0, 0, 17, 2, 16), box(-1, 2, 0, 17, 14, 2), box(-1, 2, 14, 17, 14, 16), box(0, 2, 2, 2, 14, 14), box(14, 2, 2, 16, 14, 14), box(-1, 14, 0, 17, 16, 16));
			case DOWN -> Shapes.or(box(-1, 14, 0, 17, 16, 16), box(-1, 2, 14, 17, 14, 16), box(-1, 2, 0, 17, 14, 2), box(0, 2, 2, 2, 14, 14), box(14, 2, 2, 16, 14, 14), box(-1, 0, 0, 17, 2, 16));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getNearestLookingDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return true;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		SpeakerBlockDestroyedByPlayerProcedure.execute();
		return retval;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SpeakerBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof SpeakerBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}
