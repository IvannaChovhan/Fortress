package com.com;

import org.apache.log4j.Logger;

import java.util.List;

/**
 *  The Warrior class contains information about person
 *  and what type of warrior he is
 */

public class Warrior extends Person implements Fightable{

    private static final Logger LOGGER = Logger.getLogger(Warrior.class);
    private TypeOfWarrior typeOfWarrior;
    private boolean readyToFight = false;
    private List<Reward> rewards;

    public Warrior(String name, String surname, TypeOfWarrior type) {
        super(name, surname); // passed to parent constructor
        this.typeOfWarrior = type;
    }

    public Warrior(String name, String surname, TypeOfWarrior type, List<Reward> rewards) {
        super(name, surname); // passed to parent constructor
        this.typeOfWarrior = type;
        this.rewards = rewards;
    }

    Warrior(Person p, TypeOfWarrior type) {
        super(p);
        this.typeOfWarrior = type;
    }

    public void setTypeOfWarrior(TypeOfWarrior type) {
        this.typeOfWarrior = type;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public TypeOfWarrior getTypeOfWarrior() {
        return typeOfWarrior;
    }

    public boolean getReadyToFight() {
        return readyToFight;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    /* Own function for showing */
    @Override
    public void show() {
        super.show();
        LOGGER.info("Type of warrior: " + typeOfWarrior);
    }

    @Override
    public void fight() {
        LOGGER.info("I'm ready to fight");
        readyToFight = true;
    }
}
