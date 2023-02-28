package com.entertainment.client;

import com.entertainment.Brands;
import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television(Brands.LG, 25);
        System.out.println(tv1);
        System.out.println(tv2);

        tv2.setChannel(9);
        System.out.println(tv2);

        //use == to show if tv1 and tv2 refer to the same physical object

        Television tvA = new Television(Brands.SAMSUNG,11);
        Television tvB = new Television(Brands.SAMSUNG,11);
        System.out.println(tvA == tvB);

        //use equals() to show if tv1 and tv2 are "equal"
        System.out.println(tvA.equals(tvB));

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        tvs.add(tvB);

        System.out.println("The size of the set: " + tvs.size());

        //get hashcode
        System.out.println("Hashcode for tvA: " + tvA.hashCode());
        System.out.println("Hashcode for tvB: " + tvB.hashCode());
    }
}