package com.com;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class WarriorTest {

    private Warrior warrior = new Warrior("John", "Weak", TypeOfWarrior.SWORDSMAN);;

    @Test
    public void Should_FailToFight_WhenWarriorIsNotReadyToFight() {
        warrior.fight();
        boolean value = warrior.getReadyToFight();
        Assert.assertEquals(true, value);
    }
}