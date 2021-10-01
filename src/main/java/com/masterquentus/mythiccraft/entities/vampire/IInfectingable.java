package com.masterquentus.mythiccraft.entities.vampire;

/**
 * the interface is implemented by types that can infect.
 * These can be vampires, snakes and other creatures.
 */
public interface IInfectingable {
    /**
     * @return success of the infection operation
     * if you need to pass additional parameters, you should use polymorphism without changing the interface.
     */
    boolean infect();

    /**
     * @return true if entity is infected
     */
    boolean isInfected();
}
