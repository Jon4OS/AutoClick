package uk.co.leafhacker.autoclick;

import net.minecraft.client.MinecraftClient;

public interface Mode {
    Keybind getKeybind();
    void toggle();
    boolean isEnabled();
    void tick(MinecraftClient client);
}
