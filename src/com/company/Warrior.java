package com.company;

/**
 *  The Warrior class contains information about person
 *  and what type of warrior he is
 */

public class Warrior extends Person implements Fightable{

    private TypeOfWarrior type_of_warrior;

    public Warrior(String name, String surname, TypeOfWarrior type) {
        super(name, surname); // passed to parent constructor
        this.type_of_warrior = type;
    }

    public void setType_of_warrior(TypeOfWarrior type) {
        this.type_of_warrior = type;
    }

    public TypeOfWarrior getType_of_warrior() {
        return type_of_warrior;
    }

    /* Own function for showing */
    @Override
    public void show() {
        super.show();
        System.out.println("Type of warrior: " + type_of_warrior);
    }

    @Override
    public void fight() {
        System.out.println("I'm ready to fight");
    }
}
