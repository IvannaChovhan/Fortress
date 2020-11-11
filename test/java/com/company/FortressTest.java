package com.company;

import org.junit.Assert;
import org.junit.Test;
import com.company.exception.NotEnoughSpaceForFortressException;

import java.util.ArrayList;
import java.util.Arrays;


import static org.mockito.Mockito.*;

public class FortressTest {
    private Fortress fortress = new Fortress();

    @Test(expected = NotEnoughSpaceForFortressException.class)
    public void constructorExceptionTest() {
        fortress = new Fortress(17, 120, "Podilskaya", new ArrayList(Arrays.asList(18.9f)),
                new Person("Inna", "Muliar"),
                new ArrayList(Arrays.asList(new Warrior("Sergiy", "Karmeliuk", TypeOfWarrior.ARCHER))));
    }

    @Test(expected = NotEnoughSpaceForFortressException.class)
    public void notEnoughSpaceInSetExceptionTest() {
        fortress = mock(Fortress.class);
        doThrow(new NotEnoughSpaceForFortressException("Not enough space for fortress")).when(fortress).setSquare(anyFloat());
        fortress.setSquare(1f);
    }

    @Test
    public void CountTowersShouldBeZeroTest() {
        fortress = mock(Fortress.class);
        fortress.setTowers(new ArrayList<>());

        doReturn(0).when(fortress).getCountTowers();
        int value = fortress.getCountTowers();
        Assert.assertEquals(0, value);
    }

    @Test
    public void CountTowersShouldBeIntTest() {
        fortress = mock(Fortress.class);
        fortress.setTowers(new ArrayList<>(Arrays.asList(10f, 21f)));
        doReturn(2).when(fortress).getCountTowers();
        int value = fortress.getCountTowers();
        Assert.assertEquals(2, value);

        fortress.setTowers(new ArrayList<>(Arrays.asList(12.5f, 16.2f, 180.1f, 15f)));
        doReturn(4).when(fortress).getCountTowers();
        value = fortress.getCountTowers();
        Assert.assertEquals(4, value);
    }

    @Test
    public void AddWarriorToGarrisonByWarriorObjectTest() {
        Warrior warrior = new Warrior("John", "Watson", TypeOfWarrior.ARCHER);
        fortress.getGarrison().addWarrior(warrior);
        Assert.assertEquals(warrior, fortress.getGarrison().getWarriors().get(0));
    }

    @Test
    public void AddWarriorToGarrisonByParametersTest() {
        fortress.setGarrison(new ArrayList<Warrior>());
        fortress.getGarrison().addWarrior("John", "Watson", TypeOfWarrior.ARCHER);
        Warrior warrior_added = fortress.getGarrison().getWarriors().get(0);

        Assert.assertEquals("John", warrior_added.getName());
        Assert.assertEquals("Watson", warrior_added.getSurname());
        Assert.assertEquals(TypeOfWarrior.ARCHER, warrior_added.getType_of_warrior());
    }

    @Test
    public void CountWarriorsShouldBeZeroTest() {
        fortress.setGarrison(new ArrayList<Warrior>());
        Assert.assertEquals(0, fortress.getGarrison().getCount());
    }

    @Test
    public void CountWarriorsShouldBeIntTest() {
        fortress = mock(Fortress.class);
        Fortress.Garrison garrison = mock(Fortress.Garrison.class);

        ArrayList<Warrior> warriors = new ArrayList<Warrior>();
        warriors.add(new Warrior("Jean", "Jacques", TypeOfWarrior.ARCHER));
        warriors.add(new Warrior("Bruse", "Feamen", TypeOfWarrior.SPEARMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);

        doReturn(3).when(garrison).getCount();
        int value = garrison.getCount();
        Assert.assertEquals(3, value);

        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);

        doReturn(5).when(garrison).getCount();
        value = garrison.getCount();
        Assert.assertEquals(5, value);

        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);

        doReturn(10).when(garrison).getCount();
        value = garrison.getCount();
        Assert.assertEquals(10, value);
    }
}