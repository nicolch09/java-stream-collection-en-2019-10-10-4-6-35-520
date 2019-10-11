package com.thoughtworks.collection;

import com.sun.corba.se.spi.ior.ObjectId;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
       return array.stream().map(element -> element * 3)
               .collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        return array.stream().map(x -> letterList.get(x - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream()
                .map(this::validateAndConcatLetters)
                .collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream()
                .sorted(Comparator
                .reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted()
                .collect(Collectors.toList());
    }

    public String validateAndConcatLetters(int index){
        int position = index - 1;
        if(index > 26){
            return letterList.get((position  / 26) - 1) + letterList.get(position % 26);
        }
        return letterList.get(position);
    }
}
