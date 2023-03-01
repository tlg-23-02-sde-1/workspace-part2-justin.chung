package com.entertainment.client;

import com.entertainment.Television;

import java.util.Comparator;

class TelevisionChannelComparator implements Comparator<Television> {
    @Override
    public int compare(Television o1, Television o2) {
        return Integer.compare(o1.getChannel(),o2.getChannel());
    }
}