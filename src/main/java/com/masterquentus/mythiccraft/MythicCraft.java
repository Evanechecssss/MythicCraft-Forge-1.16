package com.masterquentus.mythiccraft;

import com.masterquentus.mythiccraft.entities.*;
import com.masterquentus.mythiccraft.init.*;
import com.masterquentus.mythiccraft.objects.blocks.*;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.masterquentus.mythiccraft.objects.WaterartichokeCrop;
import com.masterquentus.mythiccraft.objects.items.ModSpawnEggItem;
import com.masterquentus.mythiccraft.world.gen.MythicCraftOreGen;
import com.masterquentus.mythiccraft.world.gen.StructureGen;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import software.bernie.geckolib3.GeckoLib;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

@Mod("mythiccraft")
public class MythicCraft {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mythiccraft";
	public static MythicCraft instance;

	public static final ResourceLocation Unerworld_Dim_Type = new ResourceLocation(MOD_ID, "underworld");

	public MythicCraft() {
		GeckoLib.initialize();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		
		ItemInit.ITEMS.register(modEventBus);
		FluidInit.FLUIDS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		BlockInit.NO_ITEM_BLOCK.register(modEventBus);
		ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);

		BiomeInit.Biomes.register(modEventBus);
		DimensionInit.MOD_DIMENSIONS.register(modEventBus);
		FeatureInit.FEATURES.register(modEventBus);

		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream()
				.filter(block -> !(block.get() instanceof HellFireBlock))
				.filter(block -> !(block.get() instanceof ModCropBlock))
				.filter(block -> !(block.get() instanceof WaterartichokeCrop))
				.map(RegistryObject::get)
				.filter(block -> !(block instanceof FlowingFluidBlock))
				.forEach(block -> {
					final Item.Properties properties = new Item.Properties().tab(MythicCraftItems.instance);
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});

		LOGGER.debug("Registered BlockItems!");
	}

	@SubscribeEvent
	public static void mobAttributes(EntityAttributeCreationEvent event){
		event.put(ModEntityTypes.BASILISK_ENTITY.get(), BasiliskEntity.createAttributes().build());
		event.put(ModEntityTypes.FAIRY_ENTITY.get(), FairyEntity.createAttributes().build());
		event.put(ModEntityTypes.GOBLIN_ENTITY.get(), GoblinEntity.createAttributes().build());
		event.put(ModEntityTypes.LILITH_ENTITY.get(), LilithEntity.createAttributes().build());
		event.put(ModEntityTypes.SIREN_ENTITY.get(), SirenEntity.createAttributes().build());
		event.put(ModEntityTypes.UNICORN_ENTITY.get(), UnicornEntity.createAttributes().build());
	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeInit.registerBiomes();
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		MythicCraftOreGen.generateOre();
		DeferredWorkQueue.runLater(StructureGen::generateStructures);
	}

	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();

	}

	public static class MythicCraftItems extends ItemGroup {
		public static final MythicCraftItems instance = new MythicCraftItems(ItemGroup.GROUPS.length,
				"mythiccraftitems");

		private MythicCraftItems(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.MYTHIC_DIAMOND.get());
		}

		public static class MythicCraftBlocks extends ItemGroup {
			public static final MythicCraftBlocks instance = new MythicCraftBlocks(ItemGroup.GROUPS.length,
					"mythiccraftblocks");

			private MythicCraftBlocks(int index, String label) {
				super(index, label);
			}

			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlockInit.MYTHICDIAMOND_BLOCK.get());

			}
		}
	}
}
