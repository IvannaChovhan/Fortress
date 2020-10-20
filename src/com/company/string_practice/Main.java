package com.company.string_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringPractice practice = new StringPractice();
        System.out.println("Enter some words: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = practice.strSplitUse(string, " ");
        System.out.println("After using strSplitUse(): " + Arrays.toString(strings));
        System.out.println("After using strBuilderUse(): " + practice.strBuilderUse(strings));
        System.out.println("After using concatDiffTypes(): "
                + practice.concatDiffTypes(string, List.of(2, 3, 4)));
        System.out.println("After using concatDiffTypes(): "
                + practice.concatDiffTypes(string, List.of(2.1f, 2.2f)));
        System.out.println("After using concatDiffTypes(): "
                + practice.concatDiffTypes(string, List.of(0.9, 0.8, 0.1)));
    }
}
