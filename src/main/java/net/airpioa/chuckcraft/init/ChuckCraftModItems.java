
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airpioa.chuckcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.airpioa.chuckcraft.item.SpeakerGrillItem;
import net.airpioa.chuckcraft.ChuckCraftMod;

public class ChuckCraftModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ChuckCraftMod.MODID);
	public static final DeferredItem<Item> SPEAKER = block(ChuckCraftModBlocks.SPEAKER);
	public static final DeferredItem<Item> SPEAKER_GRILL = REGISTRY.register("speaker_grill", SpeakerGrillItem::new);
	public static final DeferredItem<Item> OAK_PANEL = block(ChuckCraftModBlocks.OAK_PANEL);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
