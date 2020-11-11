package com.company;

import com.company.exception.NotEnoughHighForTowerException;
import org.junit.Assert;
import org.junit.Test;

public class TowerTest {
    Tower tower1 = new Tower();
    Tower tower2 = new Tower();

    @Test(expected = NotEnoughHighForTowerException.class)
    public void constructorExceptionTest() throws NotEnoughHighForTowerException {
        tower1 = new Tower(1f);
    }

    @Test
    public void overriddenHashcodeTest() {
        boolean actual = (tower1.hashCode() == tower2.hashCode());
        Assert.assertTrue(actual);
    }

    @Test
    public void overriddenEqualsTest() {
        boolean actual = tower1.equals(tower2);
        Assert.assertTrue(actual);
    }
}