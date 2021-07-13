package com.masterquentus.mythiccraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class MythicCraftConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	
	static {
		BUILDER.push("Config For MythicCraft");
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
