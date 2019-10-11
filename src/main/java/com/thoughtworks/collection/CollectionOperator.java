package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int start = Math.min(left, right);
        int end = Math.max(left, right);
        for(int i = start; i <= end; i++){
            result.add(i);
        }
        if(left > right){
            result.sort(Comparator.reverseOrder());
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<>();
        int start = Math.min(left, right);
        int end = Math.max(left, right);
        for(int i = start; i <= end; i++){
            if(i % 2 == 0)
                result.add(i);
        }
        if(left > right){
            result.sort(Comparator.reverseOrder());
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(element -> element % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray)
                .boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray)
                .boxed().collect(Collectors.toList());
        return firstList.stream().filter(element -> secondList.contains(element)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray).mapToInt(Integer::intValue)
                .boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(secondArray).mapToInt(Integer::intValue)
                .boxed().collect(Collectors.toList());
        firstList.addAll(secondList.stream().
                filter(element -> !firstList.contains(element)).collect(Collectors.toList()));
        return firstList;
    }
}
