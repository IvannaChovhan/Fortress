package com.company.string_practice;

import java.util.List;

public class StringPractice {

    public String strBuilderUse(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str).append("*");
        }
        return stringBuilder.toString();
    }

    public String[] strSplitUse(String str, String delimiter) {
            return str.split(delimiter);
    }

    public <T extends Number> String concatDiffTypes(String str, List<T> numbers) {
        for (T num : numbers) {
            str += num;
        }
        return str;
    }
}
