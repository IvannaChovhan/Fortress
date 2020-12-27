package intergationTests;

import com.com.Fortress;
import com.com.Person;
import com.com.TypeOfWarrior;
import com.com.Warrior;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.mockito.Mockito.times;

public class FortressIT {

    @Spy
    private Fortress fortress = new Fortress();
    
    @Spy
    private Person governor = new Person();

    @Test
    public void Should_FailToGetGovernor_When_GovernorNotAdded() {
        governor.setSurname("Patcher");
        governor.setName("John");

        fortress.setGovernor(governor);

        Assert.assertEquals("John", fortress.getGovernor().getName());
        Assert.assertEquals("Patcher", fortress.getGovernor().getSurname());
    }

    @Test
    public void Should_FailToGetWarrior_When_WarriorNotAdded() {
        Warrior warrior = Mockito.mock(Warrior.class);

        Mockito.when(warrior.getName()).thenReturn("John");
        Mockito.when(warrior.getSurname()).thenReturn("Weak");
        Mockito.when(warrior.getTypeOfWarrior()).thenReturn(TypeOfWarrior.SWORDSMAN);

        fortress.getGarrison().addWarrior(warrior);

        Assert.assertEquals("John", fortress.getGarrison().getWarriors().get(0).getName());
        Assert.assertEquals("Weak", fortress.getGarrison().getWarriors().get(0).getSurname());
        Assert.assertEquals(TypeOfWarrior.SWORDSMAN, fortress.getGarrison().getWarriors().get(0).getTypeOfWarrior());

        Mockito.verify(warrior, times(1)).getName();
        Mockito.verify(warrior, times(1)).getSurname();
        Mockito.verify(warrior, times(1)).getTypeOfWarrior();
    }

    @Test
    public void Should_Fail_When_CountOfWarriorsIsIncorrect() {
        Fortress.Garrison garrison = Mockito.mock(Fortress.Garrison.class);

        ArrayList<Warrior> warriors = new ArrayList<>();
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

        Mockito.verify(garrison, times(3)).getCount();
    }
}
