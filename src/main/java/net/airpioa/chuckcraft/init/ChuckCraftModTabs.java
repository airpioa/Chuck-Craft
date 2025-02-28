
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airpioa.chuckcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.airpioa.chuckcraft.ChuckCraftMod;

public class ChuckCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChuckCraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHUCK = REGISTRY.register("chuck",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.chuck_craft.chuck")).icon(() -> new ItemStack(Items.MUSIC_DISC_PIGSTEP)).displayItems((parameters, tabData) -> {
				tabData.accept(ChuckCraftModBlocks.SPEAKER.get().asItem());
				tabData.accept(ChuckCraftModItems.SPEAKER_GRILL.get());
				tabData.accept(ChuckCraftModBlocks.OAK_PANEL.get().asItem());
			}).build());
}
