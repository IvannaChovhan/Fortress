package com.com;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    Person firstPerson = new Person("John", "Watson");
    Person secondPerson = new Person("Mary", "Johnson");

    @Test
    public void Should_FailToCompare_WhenPersonFieldsAreDifferent() {
        firstPerson = new Person(secondPerson);
        Assert.assertEquals(firstPerson.getName(), secondPerson.getName());
        Assert.assertEquals(firstPerson.getSurname(), secondPerson.getSurname());
    }
}
