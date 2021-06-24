package com.masterquentus.mythiccraft.tileentity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.masterquentus.mythiccraft.init.ItemInit;
import com.masterquentus.mythiccraft.init.ModTileEntityTypes;
import com.masterquentus.mythiccraft.objects.blocks.PedestalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class MobSlayerTileEntity extends TileEntity implements ITickableTileEntity {
	public int x, y, z, tick;
	boolean initialized = false;

	public MobSlayerTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

	}

	public MobSlayerTileEntity() {
		super(ModTileEntityTypes.MOB_SLAYER.get());
	}

	boolean active = false;
	int delay = 0;

	int timer = 0;
	boolean isActive = true;

	@Override
	public void tick() {
		if (!this.level.isClientSide() && this.isActive) {
			this.timer++;
			if (this.timer > 20) {
				this.timer = 0;

				this.hurtMobs();
			}
		}
	}

	final int RANGE = 5;

	private void hurtMobs() {
		BlockPos topCorner = this.worldPosition.offset(RANGE, RANGE, RANGE);
		BlockPos bottomCorner = this.worldPosition.offset(-RANGE, -RANGE, -RANGE);
		AxisAlignedBB box = new AxisAlignedBB(topCorner, bottomCorner);

		List<Entity> entities = this.level.getEntities(null, box);
		for (Entity target : entities) {
			if (target instanceof LivingEntity && !(target instanceof PlayerEntity)) {
				target.hurt(DamageSource.MAGIC, 3);
			}
		}
	}

	@SuppressWarnings("unused")
	private void execute() {
		int index = 0;
		Block[] blocksRemoved = new Block[9];
		for (int x = 0; x < 3; x++) {
			for (int z = 0; z < 3; z++) {
				BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
				blocksRemoved[index] = this.level.getBlockState(posToBreak).getBlock();
				destroyBlock(posToBreak, true, null);
				index++;
			}
		}
		this.y--;
	}

	@SuppressWarnings("deprecation")
	private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
		BlockState blockstate = level.getBlockState(pos);
		if (blockstate.isAir(level, pos))
			return false;
		else {
			FluidState ifluidstate = level.getFluidState(pos);
			level.levelEvent(2001, pos, Block.getId(blockstate));
			if (dropBlock) {
				TileEntity tileentity = blockstate.hasTileEntity() ? level.getBlockEntity(pos) : null;
				Block.dropResources(blockstate, level, this.worldPosition.offset(0, 1.5, 0), tileentity, entity,
						ItemStack.EMPTY);
			}
			return level.setBlock(pos, ifluidstate.createLegacyBlock(), 3);
		}
	}

	@SuppressWarnings("unused")
	private int calcPowerLevel() {
		int total = 0;
		List<Item> heldItems = new ArrayList<>();
		List<BlockPos> pedestals = ImmutableList.of(this.worldPosition.north(4).east(4),
				this.worldPosition.north(4).west(4), this.worldPosition.south(4).east(4),
				this.worldPosition.south(4).west(4));
		for (BlockPos pos : pedestals) {
			BlockState state = this.level.getBlockState(pos);

			if (!(state.getBlock() instanceof PedestalBlock))
				return 0;

			total += ((PedestalBlock) state.getBlock()).getTier();
			PedestalTileEntity tile = (PedestalTileEntity) this.level.getBlockEntity(pos);
			heldItems.add(tile.getItem().getItem());
		}

		boolean hasCorrectRunes = heldItems.remove(ItemInit.purple_rune.get())
				&& heldItems.remove(ItemInit.red_rune.get()) && heldItems.remove(ItemInit.red_rune.get())
				&& heldItems.remove(ItemInit.purple_rune.get());
		return hasCorrectRunes ? total : 0;
	}

	public void toggle() {
		this.isActive = !this.isActive;
	}

	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		nbt.putBoolean("active", this.isActive);
		return super.save(nbt);
	}

	@Override
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.isActive = nbt.getBoolean("active");
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbtTag = new CompoundNBT();
		// save data to nbt
		return new SUpdateTileEntityPacket(this.worldPosition, -1, nbtTag);

	}
}