package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    public double getAverage() {
        return arrayList.stream().reduce(Integer::sum)
                .map(Integer::doubleValue)
                .map(number -> number / arrayList.size()).get();
    }

    public double getOrderedMedian() {
        return 't';
    }

    public int getFirstEven() {
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
