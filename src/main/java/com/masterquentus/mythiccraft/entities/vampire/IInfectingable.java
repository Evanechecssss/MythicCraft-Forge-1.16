package com.masterquentus.mythiccraft.entities.vampire;

import net.minecraft.entity.LivingEntity;

/**
 * the interface is implemented by types that can infect.
 * These can be vampires, snakes and other creatures.
 * ***
 */
public interface IInfectingable {
    /**
     * @return success of the infection operation
     * if you need to pass additional parameters, you should use polymorphism without changing the interface.
     */
    boolean infect(LivingEntity entity);

    /**
     * @return true if entity is infected
     */
    boolean isInfected();
    boolean canBeInfected();
    boolean isInfectSource();

    /**
     * Temp method can keep some Object with information about infection;
     * @param param with class
     */
    void getInfection(Object param);
}
