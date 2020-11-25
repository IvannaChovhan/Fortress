package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WarriorTest {

    private Warrior warrior = new Warrior("John", "Weak", TypeOfWarrior.SWORDSMAN);;

    @Test
    public void Should_FailToFight_WhenWarriorIsNotReadyToFight() {
        warrior.fight();
        boolean value = warrior.getReadyToFight();
        Assert.assertEquals(true, value);
    }
}