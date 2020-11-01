package com.company;

/**
 * The Person class contains the most important
 * information about human like name and surname
 */
public class Person {
    private String name;
    private String surname;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Person(Person gov) {
        this.name = gov.name;
        this.surname = gov.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    /* Own function for showing */
    public void show(){
        System.out.println("Name: " + name + "\nSurname: " + surname);
    }
}
