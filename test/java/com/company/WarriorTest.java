package com.company;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WarriorTest {

    @Test
    public void fightInterfaceMethodTest() {
        Warrior warrior = mock(Warrior.class);
        warrior.fight();
        when(warrior.getReadyToFight()).thenReturn(true);
        boolean value = warrior.getReadyToFight();
        Assert.assertEquals(true, value);
    }
}