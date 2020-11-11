package com.company;

import org.junit.Assert;
import org.junit.Test;

public class TypeOfWarriorTest {

    @Test
    public void showTypeOfWarriorTest() {
        String actual = TypeOfWarrior.showTypeOfWarriors();
        Assert.assertEquals("archer weapon: bow; swordsman weapon: sword; spearman weapon: spear", actual);
    }

    @Test
    public void toStringTypeOfWarriorTest() {
        String actual = TypeOfWarrior.SWORDSMAN.toString();
        Assert.assertEquals("swordsman", actual);
    }
}