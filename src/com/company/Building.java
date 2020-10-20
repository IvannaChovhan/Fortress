package com.company;

/**
 *  Abstract class that contains information about century,
 *  when the building was built and its square in m2
 */

abstract class Building {
    private int century;
    private float square;

    Building(int century, float square) {
        this.century = century;
        this.square = square;
    }

    public Building() {
    }

    public void setCentury(int century) {
        this.century = century;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public int getCentury() {
        return century;
    }

    public float getSquare() {
        return square;
    }

    /* Own function for showing */
    public void show() {
        System.out.println("The building was built in " + century + "th century and has square " + square + " м2");
    }

}
