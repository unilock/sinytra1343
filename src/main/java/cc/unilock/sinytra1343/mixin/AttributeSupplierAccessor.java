package cc.unilock.sinytra1343.mixin;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(AttributeSupplier.class)
public interface AttributeSupplierAccessor {
	@Accessor
	Map<Holder<Attribute>, AttributeInstance> getInstances();
	
	@Accessor
	void setInstances(Map<Holder<Attribute>, AttributeInstance> value);
}
