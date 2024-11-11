package net.mcreator.mythcraft.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;

public class BloodSyctheToolInInventoryTickProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(2, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
	}
}
