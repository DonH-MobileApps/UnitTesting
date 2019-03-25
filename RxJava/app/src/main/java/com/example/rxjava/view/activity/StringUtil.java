package com.example.rxjava.view.activity;

import java.util.ArrayList;

public class StringUtil {

    public static boolean isActuallyEmpty(String stringToCheck) {
        return stringToCheck == null || stringToCheck.isEmpty();

    }

    public static String createStringFromArrayList(ArrayList<String> arrayList){
        StringBuilder sb = new StringBuilder();
        for (String currentString : arrayList) {
            sb.append(currentString);
            sb.append(BLANK);
        }
return sb.toString();
    }


}


