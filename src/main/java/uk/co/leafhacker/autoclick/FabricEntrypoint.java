package uk.co.leafhacker.autoclick;

import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		DelayedAttack clicker = new DelayedAttack();
	}
}
