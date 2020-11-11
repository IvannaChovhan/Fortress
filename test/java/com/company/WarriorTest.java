package com.company;

import org.junit.Assert;
import org.junit.Test;

public class WarriorTest {
    Warrior warrior = new Warrior("John", "Watson", TypeOfWarrior.SWORDSMAN);

    @Test
    public void fightInterfaceMethodTest() {
        warrior.fight();
        Assert.assertEquals(true, warrior.getReadyToFight());
    }
}