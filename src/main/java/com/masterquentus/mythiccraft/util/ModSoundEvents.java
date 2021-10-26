package com.masterquentus.mythiccraft.util;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {
	 public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
	            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MythicCraft.MOD_ID);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @SuppressWarnings("unused")
	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
	        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(MythicCraft.MOD_ID, name)));
	    }

	    public static void register(IEventBus eventBus) {
	        SOUND_EVENTS.register(eventBus);
	    }
	}
