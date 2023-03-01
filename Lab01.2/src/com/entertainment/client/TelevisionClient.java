package com.entertainment.client;

import com.entertainment.Brands;
import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television("LG", 25);
        System.out.println(tv1);
        System.out.println(tv2);

        tv2.changeChannel(9);
        System.out.println(tv2);

        //use == to show if tv1 and tv2 refer to the same physical object

        Television tvA = new Television("Sony",11);
        Television tvB = new Television("Sony",11);
        Television tvC = new Television("Sony",47);
        Television tvD = new Television("Sony",52);
        System.out.println(tvA == tvB);

        //use equals() to show if tv1 and tv2 are "equal"
        System.out.println(tvA.equals(tvB));

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println("The size of the set: " + tvs.size());
        for(Television tv: tvs) {
            System.out.println(tv);
        }
    }
}