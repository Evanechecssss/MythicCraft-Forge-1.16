package com.masterquentus.mythiccraft;
import com.masterquentus.mythiccraft.objects.blocks.WaterartichokeCrop;
import com.masterquentus.mythiccraft.objects.blocks.WoodTypesInit;
import com.masterquentus.mythiccraft.objects.items.ModSpawnEggItem;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

@Mod.EventBusSubscriber(modid = MythicCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

@Mod("mythiccraft")
public class MythicCraft {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "mythiccraft";

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
		ModRecipeSerializers.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		StructuresInit.STRUCTURES.register(modEventBus);
		BiomeInit.BIOMES.register(modEventBus);
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGen::addFeaturesToBiomes);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().filter(block -> !(block.get() instanceof HellFireBlock))
				.filter(block -> !(block.get() instanceof ModCropBlock))
				.filter(block -> !(block.get() instanceof WallSignBlock))
				.filter(block -> !(block.get() instanceof WaterartichokeCrop))
				.filter(block -> !(block.get() instanceof FlowerPotBlock))
				.filter(block -> !(block.get() instanceof ModStandingSignBlock))
				.filter(block -> !(block.get() instanceof ModWallSignBlock))
				.filter(block -> !(block.get() instanceof CoralFanBlock))
				.filter(block -> !(block.get() instanceof ModKelpTopBlock))
				.filter(block -> !(block.get() instanceof DemonHeartBlock))
				.filter(block -> !(block.get() instanceof ModKelpBlock)).map(RegistryObject::get)
				.filter(block -> !(block instanceof FlowingFluidBlock)).forEach(block -> {
					final Item.Properties properties = new Item.Properties().tab(MythicCraftBlocks.instance);
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});

		LOGGER.debug("Registered BlockItems!");
	}

	@SubscribeEvent
	public static void mobAttributes(EntityAttributeCreationEvent event) {
		event.put(ModEntityTypes.BASILISK_ENTITY.get(), BasiliskEntity.createAttributes().build());
		event.put(ModEntityTypes.FAIRY_ENTITY.get(), FairyEntity.createAttributes().build());
		event.put(ModEntityTypes.GOBLIN_ENTITY.get(), GoblinEntity.createAttributes().build());
		event.put(ModEntityTypes.LILITH_ENTITY.get(), LilithEntity.createAttributes().build());
		event.put(ModEntityTypes.SIREN_ENTITY.get(), SirenEntity.createAttributes().build());
		event.put(ModEntityTypes.UNICORN_ENTITY.get(), UnicornEntity.createAttributes().build());
		event.put(ModEntityTypes.EVOKER.get(), VampireEvokerEntity.createAttributes().build());
		event.put(ModEntityTypes.VINDICATOR.get(), VampireVindicatorEntity.createAttributes().build());
		event.put(ModEntityTypes.PILLAGER.get(), VampirePillagerEntity.createAttributes().build());
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			StructuresInit.setupStructures();
			WoodType.register(WoodTypesInit.BLOOD_OAK);
			WoodType.register(WoodTypesInit.WHITE_OAK);
			WoodType.register(WoodTypesInit.SILVER_WOOD);
			WoodType.register(WoodTypesInit.WITCH_WOOD);
			WoodType.register(WoodTypesInit.ALDER);
			WoodType.register(WoodTypesInit.HAWTHORN);
			WoodType.register(WoodTypesInit.ROWAN);
			WoodType.register(WoodTypesInit.WILLOW);
			WoodType.register(WoodTypesInit.BEECH);
			WoodType.register(WoodTypesInit.ASH);
			WoodType.register(WoodTypesInit.BLACKTHORN);
			WoodType.register(WoodTypesInit.CEDAR);
			WoodType.register(WoodTypesInit.ELDER);
			WoodType.register(WoodTypesInit.JUNIPER);
			WoodType.register(WoodTypesInit.WITCHHAZEL);
			WoodType.register(WoodTypesInit.YEW);
			WoodType.register(WoodTypesInit.INFESTED);
			WoodType.register(WoodTypesInit.CHARRED);
			WoodType.register(WoodTypesInit.ICY);
			WoodType.register(WoodTypesInit.TWISTED);
			WoodType.register(WoodTypesInit.DISTORTED);
			WoodType.register(WoodTypesInit.HELLBARK);
			InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
					() -> SlotTypePreset.CHARM.getMessageBuilder().build());
			InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE,
					() -> SlotTypePreset.NECKLACE.getMessageBuilder().build());
		});
	}

	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();

	}

	public static class MythicCraftItems extends ItemGroup {
		public static final MythicCraftItems instance = new MythicCraftItems(ItemGroup.TABS.length, "mythiccraftitems");

		private MythicCraftItems(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.MYTHIC_DIAMOND.get());
		}
	}

	public static class MythicCraftBlocks extends ItemGroup {
		public static final MythicCraftBlocks instance = new MythicCraftBlocks(ItemGroup.TABS.length,
				"mythiccraftblocks");

		private MythicCraftBlocks(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack makeIcon() {
			return new ItemStack(OreType.MYTHICDIAMOND.block.get());
		}
	}
}
