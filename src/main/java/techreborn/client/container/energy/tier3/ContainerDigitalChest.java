package techreborn.client.container.energy.tier3;

import net.minecraft.entity.player.EntityPlayer;
import reborncore.client.gui.slots.SlotFake;
import reborncore.client.gui.slots.SlotInput;
import reborncore.client.gui.slots.SlotOutput;
import techreborn.client.container.base.ContainerBase;
import techreborn.tiles.energy.tier3.TileDigitalChest;

public class ContainerDigitalChest extends ContainerBase {

	public ContainerDigitalChest(TileDigitalChest tileEntity, EntityPlayer player) {
		super(tileEntity, player);

		addSlotToContainer(new SlotInput(tileEntity.getInventory(), getNextSlotIndex(), 80, 17));
		addSlotToContainer(new SlotOutput(tileEntity.getInventory(), getNextSlotIndex(), 80, 53));
		addSlotToContainer(new SlotFake(tileEntity.getInventory(), getNextSlotIndex(), 59, 42, false, false, Integer.MAX_VALUE));
	}
}