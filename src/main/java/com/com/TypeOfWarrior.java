package com.com;

import org.apache.log4j.Logger;

/* Three types of warriors */
public enum TypeOfWarrior {

    ARCHER("bow"),
    SWORDSMAN("sword"),
    SPEARMAN("spear");

    private static final Logger LOGGER = Logger.getLogger(TypeOfWarrior.class);
    private String weapon;

    TypeOfWarrior(String weapon) {
        this.weapon = weapon;
    }

    TypeOfWarrior() {
    }

    //Own method to show using stringbuilder
    public static String showTypeOfWarriors() {
        LOGGER.info("TypeOfWarrior enum: ");
        StringBuilder stringBuilder = new StringBuilder();
        for (TypeOfWarrior typeOfWarrior : TypeOfWarrior.values()) {
            if (typeOfWarrior.weapon != null) {
                stringBuilder.append(typeOfWarrior)
                        .append(" weapon: ")
                        .append(typeOfWarrior.weapon)
                        .append("; ");
            } else {
                stringBuilder.append(typeOfWarrior);
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
