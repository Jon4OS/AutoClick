package uk.co.leafhacker.autoclick;

import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class Keybind extends FabricKeyBinding {

    protected static final String CATEGORY_ID = "key.autoclick";

    public Keybind(String id, InputUtil.Type type, int code) {
        super(new Identifier("autoclick:"+id), type, code, CATEGORY_ID);
    }

    public static void registerCategory() {
        KeyBindingRegistry.INSTANCE.addCategory(CATEGORY_ID);
    }

    public static void registerKeybind(Keybind keybind) {
        KeyBindingRegistry.INSTANCE.register(keybind);
    }
}
