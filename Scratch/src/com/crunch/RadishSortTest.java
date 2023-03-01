package com.crunch;

import java.util.ArrayList;
import java.util.List;

class RadishSortTest {
    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        radishes.add(new Radish("red",1.1,2.1,0));
        radishes.add(new Radish ("pink",3.5,0.0,3));
        radishes.add(new Radish("black", 2.2, 4.2, 0));
        radishes.add(new Radish("white",1.8,1.5,7));

        dump(radishes);
        System.out.println();

        // passing null means sort by natural order
        radishes.sort(null);
        dump(radishes);
        System.out.println();

        // sort by color, via an instance of Radish color comparator
        radishes.sort(new RadishColorComparator());
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radish) {
        for(Radish r:radish) {
            System.out.println(r);
        }
    }
}