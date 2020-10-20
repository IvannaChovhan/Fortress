package com.company.equals_hashcode_practice;

import com.company.Person;
import com.company.Tower;

import java.util.List;

public class EqualsHashcodePractice {


    public boolean nonOverriddenHashcode() {
        Person firstPerson = new Person("Ivanna", "Chovhan");
        Person secondPerson = new Person("Ivanna", "Chovhan");
        int firstHashcode = firstPerson.hashCode();
        int secondHashcode = secondPerson.hashCode();
        firstPerson.show();
        secondPerson.show();
        return firstHashcode == secondHashcode;
    }


    public boolean overriddenHashcode() {
        Tower firstTower = new Tower(12.6f);
        Tower secondTower = new Tower(12.6f);
        int firstHashcode = firstTower.hashCode();
        int secondHashcode = secondTower.hashCode();
        firstTower.show();
        secondTower.show();
        return firstHashcode == secondHashcode;
    }


    public boolean overriddenEquals() {
        Tower firstTower = new Tower(12.6f);
        Tower secondTower = new Tower(12.6f);
        firstTower.show();
        secondTower.show();
        return firstTower.equals(secondTower);
    }


    public boolean nonOverriddenEquals() {
        Person firstPerson = new Person("Oleh", "Chernousov");
        Person secondPerson = new Person("Oleh", "Chernousov");
        firstPerson.show();
        secondPerson.show();
        return firstPerson.equals(secondPerson);
    }
}
