package uk.co.leafhacker.autoclick;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class FabricEntrypoint implements ModInitializer {

	static final String CATEGORY_ID = "key.autoclick";

	private List<Mode> modes = new ArrayList<>();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Add modes to the list
		modes.add(new DelayedAttack());

		// Register keybinds
		Keybind.registerCategory();
		modes.forEach(mode -> Keybind.registerKeybind(mode.getKeybind()));

		// Listen to the tick event so we can toggle keybinds and call tick on enabled modes
		ClientTickCallback.EVENT.register(this::tick);
	}

	private void tick(MinecraftClient client) {
		// Toggle keybinds
		modes.forEach(mode -> {
			while (mode.getKeybind().wasPressed()) {
				mode.toggle();
			}
		});

		// Tick modes
		modes.stream().filter(Mode::isEnabled).forEach(mode -> mode.tick(client));
	}
}
