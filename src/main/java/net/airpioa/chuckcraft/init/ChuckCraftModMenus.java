
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.airpioa.chuckcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.airpioa.chuckcraft.world.inventory.ChuckUIMenu;
import net.airpioa.chuckcraft.ChuckCraftMod;

public class ChuckCraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ChuckCraftMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<ChuckUIMenu>> CHUCK_UI = REGISTRY.register("chuck_ui", () -> IMenuTypeExtension.create(ChuckUIMenu::new));
}
