package com.com;

import org.apache.log4j.Logger;

/**
 *  Abstract class that contains information about century,
 *  when the building was built and its square in m2
 */

abstract class Building {

    private static final Logger LOGGER = Logger.getLogger(Building.class);
    int century;
    float square;

    Building(int century, float square) {
        this.century = century;
        this.square = square;
    }

    Building() {
    }

    void setCentury(int century) {
        this.century = century;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    int getCentury() {
        return century;
    }

    float getSquare() {
        return square;
    }

    /* Own function for showing */
    void show() {
        LOGGER.info("The building was built in " + century + "th century and has square " + square + " м2");
    }

}
