package com.entertainment.client;

import com.entertainment.Television;

import java.util.Comparator;

class TelevisionBrandChannelComparator implements Comparator<Television> {
    @Override
    public int compare(Television o1, Television o2) {
        if (o1.getBrand().equals(o2.getBrand())) {
            return Integer.compare(o1.getChannel(),o2.getChannel());
        }
        return o1.getBrand().compareTo(o2.getBrand());
    }
}