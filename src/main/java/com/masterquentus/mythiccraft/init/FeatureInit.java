package com.masterquentus.mythiccraft.init;

import java.util.Locale;

import com.masterquentus.mythiccraft.MythicCraft;
import com.masterquentus.mythiccraft.world.feature.structures.GoblinHousePieces;
import com.masterquentus.mythiccraft.world.feature.structures.GoblinHouseStructure;
import com.masterquentus.mythiccraft.world.feature.structures.WolfDenPieces;
import com.masterquentus.mythiccraft.world.feature.structures.WolfDenStructure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = MythicCraft.MOD_ID)
public class FeatureInit {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(
			ForgeRegistries.FEATURES, MythicCraft.MOD_ID);


	public static IStructurePieceType GOBLINHOUSE_PIECE = GoblinHousePieces.Piece::new;
	public static IStructurePieceType WOLF_DEN_PIECE = WolfDenPieces.Piece::new;

	public static final RegistryObject<GoblinHouseStructure> GOBLINHOUSE = FEATURES.register("goblin_house",
			() -> new GoblinHouseStructure(NoFeatureConfig::deserialize));
	public static final RegistryObject<WolfDenStructure> WOLFDEN = FEATURES.register("wolf_den",
			() -> new WolfDenStructure(NoFeatureConfig::deserialize));

	@SubscribeEvent
	public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event) {
		Registry.register(Registry.STRUCTURE_PIECE, "GOBLINHOUSE".toLowerCase(Locale.ROOT), GOBLINHOUSE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "WOLFDEN".toLowerCase(Locale.ROOT), WOLF_DEN_PIECE);
	}

}
