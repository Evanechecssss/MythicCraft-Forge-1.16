package com.masterquentus.mythiccraft.objects.items.crafting;

import com.masterquentus.mythiccraft.MythicCraft;

import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializers {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MythicCraft.MOD_ID);

    public static final RegistryObject<CookingRecipeSerializer<?>> WITCHES_SMELTING
            = RECIPE_SERIALIZER.register("witchesoven", () ->
            new CookingRecipeSerializer<>(WitchesOvenRecipe::new, 200));

    public static IRecipeType<WitchesOvenRecipe> WITCHES_RECIPE = Registry.register(Registry.RECIPE_TYPE,
            new ResourceLocation(MythicCraft.MOD_ID, "witchesoven"), new IRecipeType<WitchesOvenRecipe>() {
                        public String toString() {
                            return MythicCraft.MOD_ID + ":witchesoven";
                        }});

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);
    }
}
