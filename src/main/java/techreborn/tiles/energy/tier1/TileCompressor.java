package techreborn.tiles.energy.tier1;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import reborncore.api.power.EnumPowerTier;
import reborncore.api.recipe.IRecipeCrafterProvider;
import reborncore.common.container.RebornContainer;
import reborncore.common.recipes.RecipeCrafter;
import reborncore.common.tile.TileMachineInventory;
import techreborn.api.Reference;
import techreborn.client.container.energy.tier1.ContainerCompressor;
import techreborn.init.ModBlocks;

public class TileCompressor extends TileMachineInventory implements IRecipeCrafterProvider {

	public RecipeCrafter crafter;

	public TileCompressor() {
		super(EnumPowerTier.LOW, 1000, 0, 1, "TileCompressor", 6, 64);
		int[] inputs = new int[1];
		inputs[0] = 0;
		int[] outputs = new int[1];
		outputs[0] = 1;
		crafter = new RecipeCrafter(Reference.compressorRecipe, this, 2, 1, getInventory(), inputs, outputs);
	}

	@Override
	public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
		return new ItemStack(ModBlocks.compressor, 1);
	}

	//	// ISidedInventory
	//	@Override
	//	public int[] getSlotsForFace(EnumFacing side)
	//	{
	//		return side == EnumFacing.DOWN ? new int[] { 0, 1, 2 } : new int[] { 0, 1, 2 };
	//	}
	//
	//	@Override
	//	public boolean canInsertItem(int slotIndex, ItemStack itemStack, EnumFacing side)
	//	{
	//		if (slotIndex == 2)
	//			return false;
	//		return isItemValidForSlot(slotIndex, itemStack);
	//	}
	//
	//	@Override
	//	public boolean canExtractItem(int slotIndex, ItemStack itemStack, EnumFacing side)
	//	{
	//		return slotIndex == 2;
	//	}

	public int getProgressScaled(int scale) {
		if (crafter.currentTickTime != 0) {
			return crafter.currentTickTime * scale / crafter.currentNeededTicks;
		}
		return 0;
	}

	@Override
	public RecipeCrafter getRecipeCrafter() {
		return this.crafter;
	}

	@Override
	public RebornContainer getContainer() {
		return RebornContainer.getContainerFromClass(ContainerCompressor.class, this);
	}
}
