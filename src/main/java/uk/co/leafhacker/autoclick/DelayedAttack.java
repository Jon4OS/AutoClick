package uk.co.leafhacker.autoclick;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.InputUtil.Type;
import org.lwjgl.glfw.GLFW;
import uk.co.leafhacker.autoclick.mixin.AccessorMinecraftClient;

public class DelayedAttack implements Mode {

    private Keybind keybind;
    private boolean enabled;

    DelayedAttack() {
        keybind = new Keybind("toggle_delayed_attack", Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN);
    }

    @Override
    public void tick(MinecraftClient client) {
        ClientPlayerEntity player = client.player;
        if (player == null) return;
        if (client.world == null) return;
        if (client.currentScreen != null) return;

        // Don't click if using an item
        if (player.isUsingItem()) return;

        // Don't click if player is clicking manually
        if (client.options.keyAttack.isPressed() || client.options.keyUse.isPressed()) return;

        // Don't click if cooldown active
        if (player.getAttackCooldownProgress(0) < 1) return;

        // Left click
        ((AccessorMinecraftClient) client).runDoAttack();
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void toggle() {
        enabled = !enabled;
    }

    @Override
    public Keybind getKeybind() {
        return keybind;
    }
}
