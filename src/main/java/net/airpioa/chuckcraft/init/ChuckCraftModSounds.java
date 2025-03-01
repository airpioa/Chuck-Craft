
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airpioa.chuckcraft.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.airpioa.chuckcraft.ChuckCraftMod;

public class ChuckCraftModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ChuckCraftMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> CHUCK_OPEN_CONFIG = REGISTRY.register("chuck_open_config", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("chuck_craft", "chuck_open_config")));
}
