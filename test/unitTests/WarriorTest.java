package unitTests;

import com.com.TypeOfWarrior;
import com.com.Warrior;
import org.junit.Assert;
import org.junit.Test;

public class WarriorTest {

    private final Warrior warrior = new Warrior("John", "Weak", TypeOfWarrior.SWORDSMAN);

    @Test
    public void Should_FailToFight_WhenWarriorIsNotReadyToFight() {
        warrior.fight();
        boolean value = warrior.getReadyToFight();
        Assert.assertTrue(value);
    }
}