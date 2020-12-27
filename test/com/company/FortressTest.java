package com.company;

import com.company.exception.NotEnoughHighForTowerException;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FortressTest {
    private Fortress fortress = new Fortress();

    @Test
    public void Should_Fail_When_TowerHasNotMaxHeight() {
        fortress.setTowers(new ArrayList<>(Arrays.asList(10f, 21f)));
        double value = fortress.getMaxHeightTower().getHeight();
        Assert.assertEquals(21f, value, 0);
    }

    @Test
    public void Should_Fail_When_TowersAvgHeightIsIncorrect() {
        ArrayList<Float> towersHeights = new ArrayList<>(Arrays.asList(10f, 10f, 40f));
        fortress.setTowers(towersHeights);

        double expected_val = towersHeights.stream().mapToDouble(val -> val).average().orElse(0.0);
        double value = fortress.getAvgHeightTowers();

        Assert.assertEquals(expected_val, value, 0);
    }

    @Test
    public void Should_Fail_When_SomeTowersAvgHeightIsIncorrect() {
        ArrayList<Float> towersHeights = new ArrayList<>(Arrays.asList(10f, 10f, 40f));
        fortress.setTowers(towersHeights);
        fortress.setCentury(15);

        double expected_val = towersHeights.stream().mapToDouble(val -> val).average().orElse(0.0);
        double value = fortress.getAvgHeightSomeTowers(15);

        Assert.assertEquals(expected_val, value, 0);
    }

    @Test
    public void Should_Fail_When_TowersAreNotNew() throws NotEnoughHighForTowerException {
        fortress = new Fortress();

        Tower tower1 = new Tower(15, 10, 15f);
        Tower tower2 = new Tower(15, 10, 15f);
        Tower tower3 = new Tower(17, 10, 15f);

        fortress.addTower(tower1);
        fortress.addTower(tower2);
        fortress.addTower(tower3);

        Map<String, List<Tower>> expected = new HashMap<>();

        List<Tower> listFalse = List.of(tower1, tower2);
        List<Tower> listTrue = List.of(tower3);
        expected.put("Підходить: ", listTrue);
        expected.put("Не підходить: ", listFalse);

        Assert.assertEquals(expected, fortress.getNewTowers(16));
    }

    @Test
    public void Should_Fail_When_RewardIsNotTheMostPopular(){
        Reward reward1 = new Reward("gold medal");
        Reward reward2 = new Reward("silver medal");

        Warrior warrior1 = new Warrior("John", "Lenon", TypeOfWarrior.SWORDSMAN, List.of(reward1, reward1, reward2));
        Warrior warrior2 = new Warrior("Mark", "Lenon", TypeOfWarrior.SWORDSMAN, List.of(reward1, reward1, reward2));

        fortress.setGarrison(new ArrayList<>(List.of(warrior1, warrior2)));

        Assert.assertEquals("gold medal", fortress.getGarrison().getTheMostPopularWarriorsReward());
    }
}