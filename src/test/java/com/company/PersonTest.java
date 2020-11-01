package com.company;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    Person firstPerson = new Person("John", "Watson");
    Person secondPerson = new Person("Mary", "Johnson");

    @Test
    public void copyConstructorTest() {
        firstPerson = new Person(secondPerson);
        Assert.assertEquals(firstPerson.getName(), secondPerson.getName());
        Assert.assertEquals(firstPerson.getSurname(), secondPerson.getSurname());
    }

    @Test
    public void nonOverriddenHashcodeTest() {
        boolean actual = (firstPerson.hashCode() == secondPerson.hashCode());
        Assert.assertFalse(actual);
    }

    @Test
    public void nonOverriddenEqualsTest() {
        boolean actual = firstPerson.equals(secondPerson);
        Assert.assertFalse(actual);
    }
}