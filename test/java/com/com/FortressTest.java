package com.com;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import org.mockito.Mockito;

public class FortressTest {
    private Fortress fortress = new Fortress();

    @Test
    public void Should_FailToGetGovernor_When_GovernorNotAdded() {
        Person governor = Mockito.mock(Person.class);
        governor.setName("John");
        governor.setSurname("Patcher");

        Mockito.when(governor.getName()).thenReturn("John");
        Mockito.when(governor.getSurname()).thenReturn("Patcher");

        fortress.setGovernor(governor);

        Assert.assertEquals("John", fortress.getGovernor().getName());
        Assert.assertEquals("Patcher", fortress.getGovernor().getSurname());
    }

    @Test
    public void Should_FailToGetWarrior_When_WarriorNotAdded() {
        Warrior warrior = Mockito.mock(Warrior.class);
        warrior.setName("John");
        warrior.setSurname("Weak");
        warrior.setType_of_warrior(TypeOfWarrior.SWORDSMAN);

        Mockito.when(warrior.getName()).thenReturn("John");
        Mockito.when(warrior.getSurname()).thenReturn("Weak");
        Mockito.when(warrior.getType_of_warrior()).thenReturn(TypeOfWarrior.SWORDSMAN);

        fortress.getGarrison().addWarrior(warrior);

        Assert.assertEquals("John", fortress.getGarrison().getWarriors().get(0).getName());
        Assert.assertEquals("Weak", fortress.getGarrison().getWarriors().get(0).getSurname());
        Assert.assertEquals(TypeOfWarrior.SWORDSMAN, fortress.getGarrison().getWarriors().get(0).getType_of_warrior());
    }

    @Test
    public void Should_Fail_When_CountOfWarriorsIsIncorrect() {
        Fortress.Garrison garrison = Mockito.mock(Fortress.Garrison.class);

        ArrayList<Warrior> warriors = new ArrayList<Warrior>();
        warriors.add(new Warrior("Jean", "Jacques", TypeOfWarrior.ARCHER));
        warriors.add(new Warrior("Bruse", "Feamen", TypeOfWarrior.SPEARMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);

        Mockito.when(garrison.getCount()).thenReturn(3);
        int value = garrison.getCount();
        Assert.assertEquals(3, value);

        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);

        Mockito.when(garrison.getCount()).thenReturn(5);
        value = garrison.getCount();
        Assert.assertEquals(5, value);

        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        warriors.add(new Warrior("Kevin", "Rockless", TypeOfWarrior.SWORDSMAN));
        fortress.setGarrison(warriors);

        Mockito.when(garrison.getCount()).thenReturn(10);
        value = garrison.getCount();
        Assert.assertEquals(10, value);
    }
}