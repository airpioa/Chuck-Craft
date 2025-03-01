
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airpioa.chuckcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.airpioa.chuckcraft.ChuckCraftMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ChuckCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChuckCraftMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CHUCK = REGISTRY.register("chuck",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.chuck_craft.chuck")).icon(() -> new ItemStack(ChuckCraftModItems.CHUCK_ITEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ChuckCraftModBlocks.SPEAKER.get().asItem());
				tabData.accept(ChuckCraftModItems.SPEAKER_GRILL.get());
				tabData.accept(ChuckCraftModBlocks.OAK_PANEL.get().asItem());
				tabData.accept(ChuckCraftModItems.CHUCK_ITEM.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ChuckCraftModItems.CHUCK_ITEM.get());
		}
	}
}
