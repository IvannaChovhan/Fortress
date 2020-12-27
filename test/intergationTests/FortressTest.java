package intergationTests;

import com.com.Fortress;
import com.com.Person;
import com.com.TypeOfWarrior;
import com.com.Warrior;
import org.junit.Assert;
import org.junit.Test;
import com.com.exception.NotEnoughSpaceForFortressException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FortressTest {
    private Fortress fortress = new Fortress();

    @Test(expected = NotEnoughSpaceForFortressException.class)
    public void Should_TrowException_When_SquareIsToSmallInConstructor() {
        fortress = new Fortress(17, 120, "Podilskaya", new ArrayList(Collections.singletonList(18.9f)),
                new Person("Inna", "Muliar"),
                new ArrayList(Collections.singletonList(new Warrior("Sergiy", "Karmeliuk", TypeOfWarrior.ARCHER))));
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

    @Test
    public void Should_Fail_When_CountOfWarriorsNotZero() {
        fortress.setGarrison(new ArrayList<>());
        Assert.assertEquals(0, fortress.getGarrison().getCount());
    }
}