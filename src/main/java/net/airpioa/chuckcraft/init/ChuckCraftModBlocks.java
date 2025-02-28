
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airpioa.chuckcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.airpioa.chuckcraft.block.SpeakerBlock;
import net.airpioa.chuckcraft.block.OakPanelBlock;
import net.airpioa.chuckcraft.ChuckCraftMod;

public class ChuckCraftModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ChuckCraftMod.MODID);
	public static final DeferredBlock<Block> SPEAKER = REGISTRY.register("speaker", SpeakerBlock::new);
	public static final DeferredBlock<Block> OAK_PANEL = REGISTRY.register("oak_panel", OakPanelBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
