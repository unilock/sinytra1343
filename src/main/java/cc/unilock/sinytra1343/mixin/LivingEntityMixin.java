package cc.unilock.sinytra1343.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@ModifyReturnValue(method = "getAttributeValue", at = @At("RETURN"))
	private double getAttributeValue(double original, Holder<Attribute> attribute) {
		// TODO: this prevents all items that modify these attributes from having any effect
		if (original < 0.1D) {
			if (attribute.is(NeoForgeMod.SWIM_SPEED::is)) {
				return 1.0D;
			}
			if (attribute.is(NeoForgeMod.NAMETAG_DISTANCE::is)) {
				return 64.0D;
			}
			if (attribute.is(NeoForgeMod.CREATIVE_FLIGHT::is)) {
				// TODO: this breaks "angel rings"
				if (((LivingEntity) (Object) this) instanceof Player player && player.isCreative()) {
					return 1.0D;
				}
			}
		}
		return original;
	}
}
