package com.com;

import org.junit.Assert;
import org.junit.Test;

public class TypeOfWarriorTest {

    @Test
    public void Should_FailToDisplay_When_OutputIsIncorrect() {
        String actual = TypeOfWarrior.showTypeOfWarriors();
        Assert.assertEquals("archer weapon: bow; swordsman weapon: sword; spearman weapon: spear", actual);
    }

    @Test
    public void Should_Fail_When_ToStringIsNotLowerCase() {
        String actual = TypeOfWarrior.SWORDSMAN.toString();
        Assert.assertEquals("swordsman", actual);
    }
}