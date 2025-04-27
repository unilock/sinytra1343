package cc.unilock.sinytra1343.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@Mixin(targets = "org/sinytra/connector/mod/compat/LazyEntityAttributes")
@Pseudo
public class LazyEntityAttributesMixin {
	@Inject(method = "lambda$updateAttributeSuppliers$4", at = @At("TAIL"))
	private static void lambda$tail(EntityType<? extends LivingEntity> entityType, AttributeSupplier value, CallbackInfo ci, @Local AtomicBoolean madeMutable) {
		if (!madeMutable.get()) {
			((AttributeSupplierAccessor) value).setInstances(new HashMap<>(((AttributeSupplierAccessor) value).getInstances()));
			madeMutable.set(true);
		}
		if (value.hasAttribute(NeoForgeMod.SWIM_SPEED)) {
			((AttributeSupplierAccessor) value).getInstances().remove(NeoForgeMod.SWIM_SPEED);
			((AttributeSupplierAccessor) value).getInstances().put(NeoForgeMod.SWIM_SPEED, new AttributeInstance(NeoForgeMod.SWIM_SPEED, i -> {}));
		}
		if (value.hasAttribute(NeoForgeMod.NAMETAG_DISTANCE)) {
			((AttributeSupplierAccessor) value).getInstances().remove(NeoForgeMod.NAMETAG_DISTANCE);
			((AttributeSupplierAccessor) value).getInstances().put(NeoForgeMod.NAMETAG_DISTANCE, new AttributeInstance(NeoForgeMod.NAMETAG_DISTANCE, i -> {}));
		}
		if (value.hasAttribute(NeoForgeMod.CREATIVE_FLIGHT)) {
			((AttributeSupplierAccessor) value).getInstances().remove(NeoForgeMod.CREATIVE_FLIGHT);
			((AttributeSupplierAccessor) value).getInstances().put(NeoForgeMod.CREATIVE_FLIGHT, new AttributeInstance(NeoForgeMod.CREATIVE_FLIGHT, i -> {}));
		}
	}
}
