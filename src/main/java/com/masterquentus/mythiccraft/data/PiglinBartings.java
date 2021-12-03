package com.masterquentus.mythiccraft.data;

import it.unimi.dsi.fastutil.ints.IntLists;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.*;
import java.util.function.Predicate;

/**
 * \* User: Evanechecssss
 * \* https://evanechecssss.github.io
 * \
 */
public class PiglinBartings {

    private static final Map<ItemStack,Integer> bartings;

    static {
        bartings= new HashMap<ItemStack,Integer>();
        bartings.put(new ItemStack(Items.GOLD_INGOT,10),50);
        bartings.put(new ItemStack(Items.GOLD_NUGGET,10),100);
    }




    public static List<ItemStack> getBartings(){
        List<ItemStack> list = new ArrayList<>();
        bartings.forEach((itemStack, integer) -> {
            list.add(itemStack);
        });
        return list;
    }
    public static List<ItemStack> getBartingsWithRandom(){
        Random random = new Random();
        List<ItemStack> list = new ArrayList<ItemStack>();
        bartings.forEach((itemStack, integer) -> {
          if(random.nextInt(100)<=integer){
            list.add(itemStack);
          }
        });
        list.add(new ItemStack(Items.AIR));
        return list;
    }

}