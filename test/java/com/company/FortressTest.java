package com.company;

import org.junit.Assert;
import org.junit.Test;
import com.company.exception.NotEnoughSpaceForFortressException;

import java.util.ArrayList;
import java.util.Arrays;

public class FortressTest {
    private Fortress fortress = new Fortress();

    @Test(expected = NotEnoughSpaceForFortressException.class)
    public void constructorExceptionTest() {
        fortress = new Fortress(17, 120, "Podilskaya", new ArrayList(Arrays.asList(18.9f)),
                new Person("Inna", "Muliar"),
                new ArrayList(Arrays.asList(new Warrior("Sergiy", "Karmeliuk", TypeOfWarrior.ARCHER))));
    }

    @Test
    public void CountTowersShouldBeZeroTest() {
        fortress = new Fortress();
        fortress.setTowers(new ArrayList<>());
        Assert.assertEquals(0, fortress.getCountTowers());
    }

    @Test
    public void CountTowersShouldBeIntTest() {
        fortress.setTowers(new ArrayList<>(Arrays.asList(10f, 21f)));
        Assert.assertEquals(2, fortress.getCountTowers());

        fortress.setTowers(new ArrayList<>(Arrays.asList(12.5f, 16.2f, 180.1f, 15f)));
        Assert.assertEquals(4, fortress.getCountTowers());
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
        Assert.assertEquals(0, fortress.getGarrison().getCount());
    }

    @Test
    public void CountWarriorsShouldBeIntTest() {
        ArrayList<Warrior> warriors = new ArrayList<Warrior>();
        warriors.add(new Warrior("Jean", "Jacques", TypeOfWarrior.ARCHER));
        warriors.add(new Warrior("Bruse", "Feamen", TypeOfWarrior.SPEARMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));

        fortress.setGarrison(warriors);
        Assert.assertEquals(3, fortress.getGarrison().getCount());

        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);
        Assert.assertEquals(5, fortress.getGarrison().getCount());

        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);
        Assert.assertEquals(10, fortress.getGarrison().getCount());
    }
}