package unitTests;

import com.com.Tower;
import com.com.exception.NotEnoughHighForTowerException;
import org.junit.Assert;
import org.junit.Test;

public class TowerTest {

    private Tower tower1 = new Tower();
    private final Tower tower2 = new Tower();

    @Test(expected = NotEnoughHighForTowerException.class)
    public void Should_TrowException_When_HeightIsToSmallInConstructor() throws NotEnoughHighForTowerException {
        tower1 = new Tower(1f);
    }

    @Test
    public void Should_Fail_WhenHashCodesAreNotEqual() {
        boolean actual = (tower1.hashCode() == tower2.hashCode());
        Assert.assertTrue(actual);
    }

    @Test
    public void Should_Fail_WhenTowersAreNotEqual() {
        boolean actual = tower1.equals(tower2);
        Assert.assertTrue(actual);
    }
}