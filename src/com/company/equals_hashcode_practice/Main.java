package com.company.equals_hashcode_practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EqualsHashcodePractice practice = new EqualsHashcodePractice();
        while (true) {
            System.out.println("\nEnter the number of the function you'd like to test: ");
            display();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 : {
                    System.out.println("NonOverriddenHashcode\nAre hashcodes equal? "
                            + practice.nonOverriddenHashcode());
                    break;
                }
                case 2 : {
                    System.out.println("OverriddenHashcode\nAre hashcodes equal? "
                            + practice.overriddenHashcode());
                    break;
                }
                case 3 : {
                    System.out.println("OverriddenEquals\n Are object equal? "
                            + practice.overriddenEquals());
                    break;
                }
                case 4 : {
                    System.out.println("NonOverriddenEquals\n Are object equal? "
                            + practice.nonOverriddenEquals());
                    break;
                }
                case 5 : {
                    System.exit(0);
                }
            }
        }
    }
    static void display() {
        System.out.println("1. NonOverriddenHashcode");
        System.out.println("2. OverriddenHashcode");
        System.out.println("3. OverriddenEquals");
        System.out.println("4. NonOverriddenEquals");
        System.out.println("5. Exit");
    }
}
