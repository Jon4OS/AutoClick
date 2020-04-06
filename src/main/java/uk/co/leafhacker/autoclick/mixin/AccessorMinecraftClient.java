package uk.co.leafhacker.autoclick.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MinecraftClient.class)
public interface AccessorMinecraftClient {

    @Invoker("doAttack")
    void runDoAttack();

    @Accessor("attackCooldown")
    void setAttackCooldown(int cooldown);
}
