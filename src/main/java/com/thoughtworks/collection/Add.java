package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sumOfEvens = 0;
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        for(int i = start; i <= end; i++){
            if(i % 2 == 0)  sumOfEvens += i;
        }
        return sumOfEvens;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sumOfEvens = 0;
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        for(int i = start; i <= end; i++){
            if(i % 2 != 0)  sumOfEvens += i;
        }
        return sumOfEvens;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .reduce(0, (subtotal, element) -> subtotal + (element * 3) + 2);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(num -> num%2!=0 ? 2+(num*3) : num)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(f -> f%2 != 0)
                .reduce(0,(subtotal, element)-> subtotal + (element * 3) + 5);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 == 0)
                .reduce((a, b) -> a + b).get() / 2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 == 0)
                .reduce((a, b) -> a + b).get() / 2;
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.indexOf(specialElment) > -1 ?
                (specialElment % 2 == 0 ? true : false) : false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(element -> element % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenNumbers = arrayList.stream()
                .filter(element -> element % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> oddNumbers = arrayList.stream()
                .filter(element -> element % 2 != 0)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        List<Integer> sortedNumbers = new ArrayList<>();
        sortedNumbers.addAll(evenNumbers);
        sortedNumbers.addAll(oddNumbers);
        return sortedNumbers;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> processedLists = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if(i + 1 < arrayList.size() && i != arrayList.size() - 1){
                processedLists.add((arrayList.get(i) + arrayList.get(i + 1))  * 3);
            }
        }
        return processedLists;
    }

    public static String ricCrea(ListIterator<Character> it) {
        if (it.hasNext()) {
            Character c = it.next();
            if (it.hasNext()) {
                return c + ricCrea(it);
            }
        }
        return "";
    }
}