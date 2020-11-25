package com.com;

import org.junit.Assert;
import org.junit.Test;
import com.com.exception.NotEnoughSpaceForFortressException;

import java.util.ArrayList;
import java.util.Arrays;

public class FortressTest {
    private Fortress fortress = new Fortress();

    @Test(expected = NotEnoughSpaceForFortressException.class)
    public void Should_TrowException_When_SquareIsToSmallInConstructor() {
        fortress = new Fortress(17, 120, "Podilskaya", new ArrayList(Arrays.asList(18.9f)),
                new Person("Inna", "Muliar"),
                new ArrayList(Arrays.asList(new Warrior("Sergiy", "Karmeliuk", TypeOfWarrior.ARCHER))));
    }

    @Test(expected = NotEnoughSpaceForFortressException.class)
    public void Should_TrowException_When_SquareIsToSmallInSetMethod() {
        fortress.setSquare(1f);
    }

    @Test
    public void Should_Fail_When_CountOfTowersNotZero() {
        fortress.setTowers(new ArrayList<>());

        int value = fortress.getCountTowers();
        Assert.assertEquals(0, value);
    }

    @Test
    public void Should_Fail_When_CountOfTowersIsIncorrect() {
        fortress.setTowers(new ArrayList<>(Arrays.asList(10f, 21f)));
        int value = fortress.getCountTowers();
        Assert.assertEquals(2, value);

        fortress.setTowers(new ArrayList<>(Arrays.asList(12.5f, 16.2f, 180.1f, 15f)));
        value = fortress.getCountTowers();
        Assert.assertEquals(4, value);
    }
}