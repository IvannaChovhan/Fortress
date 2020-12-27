package unitTests;

import com.com.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    private final Person secondPerson = new Person("Mary", "Johnson");

    @Test
    public void Should_FailToCompare_WhenPersonFieldsAreDifferent() {
        Person firstPerson = new Person(secondPerson);
        Assert.assertEquals(firstPerson.getName(), secondPerson.getName());
        Assert.assertEquals(firstPerson.getSurname(), secondPerson.getSurname());
    }
}
