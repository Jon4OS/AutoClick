package uk.co.leafhacker.autoclick;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import uk.co.leafhacker.autoclick.mixin.AccessorMinecraftClient;

public class SpamClick implements Mode {

    private final Keybind keybind;

    private boolean enabled;

    public SpamClick(Button button) {
        keybind = new Keybind("toggle_spam_"+button.getKeybindId(), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN);
    }

    @Override
    public void tick(MinecraftClient client) {
        ((AccessorMinecraftClient) client).runDoItemUse();
    }

    @Override
    public Keybind getKeybind() {
        return keybind;
    }

    @Override
    public void toggle() {
        enabled = !enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public enum Button {
        LEFT, RIGHT;

        private String getKeybindId() {
            switch (this) {
                case LEFT: return "attack";
                case RIGHT: return "use";
                default: return "";
            }
        }
    }
}
