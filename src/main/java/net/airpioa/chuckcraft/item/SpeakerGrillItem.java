
package net.airpioa.chuckcraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SpeakerGrillItem extends Item {
	public SpeakerGrillItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
