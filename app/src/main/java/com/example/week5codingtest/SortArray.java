package com.example.week5codingtest;

import java.util.*;


public class SortArray {
    public static void main(String[] args) {

        Integer[] array = {2,8,9,3,4,3,2,6,6,2,4,9,8};

        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }


    public static Comparable[] mergeSort(Comparable[] list) {

        if (list.length <= 1) {
            return list;
        }

        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;

    }


    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {

        int aFirst = 0;

        int aSecond = 0;

        int aMerged = 0;

        while (aFirst < first.length && aSecond < second.length) {
            if (first[aFirst].compareTo(second[aSecond]) < 0) {
                result[aMerged] = first[aFirst];
                aFirst++;
            } else {
                result[aMerged] = second[aSecond];
                aSecond++;
            }
            aMerged++;
        }

        System.arraycopy(first, aFirst, result, aMerged, first.length - aFirst);
        System.arraycopy(second, aSecond, result, aMerged, second.length - aSecond);
    }



}