package cc.unilock.sinytra1343.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@ModifyReturnValue(method = "getAttributeValue", at = @At("RETURN"))
	private double getAttributeValue(double original, Holder<Attribute> attribute) {
		return attribute.is(NeoForgeMod.SWIM_SPEED::is) ? 1.0D : original;
	}
}
