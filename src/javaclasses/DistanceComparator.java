package javaclasses;

import java.util.ArrayList;
import java.util.Comparator;

public class DistanceComparator implements Comparator<Integer> {

    public int compare(Integer a,Integer b){
        return a.compareTo(b);
    }
}
