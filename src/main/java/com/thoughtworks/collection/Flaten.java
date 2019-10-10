package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        return Arrays.stream(this.array)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
//        List<Integer> getCommon = new ArrayList<Integer>();

        return Arrays.stream(this.array)
                .flatMap(Arrays::stream)
                .mapToInt(Integer::intValue)
                .boxed()
                .distinct()
                .collect(Collectors.toList());
    }
}
