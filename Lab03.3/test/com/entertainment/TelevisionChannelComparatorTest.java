package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {

    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony",50,DisplayType.OLED);
        tv2 = new Television("Sony",50,DisplayType.OLED);
    }
    @Test
    public void channelComparator_shouldReturnTrue_forTVs_withSameBrandSameChannel() {
        TelevisionChannelComparator comp = new TelevisionChannelComparator();
        assertTrue(comp.compare(tv1,tv2) == 0);
    }

    @Test
    public void channelComparator_shouldReturnFalse_forTVs_withSameBrandDifferentChannel() throws InvalidChannelException {
        tv1.changeChannel(5);
        TelevisionChannelComparator comp = new TelevisionChannelComparator();
        assertTrue(comp.compare(tv1,tv2) > 0);
    }

    @Test
    public void channelComparator_shouldReturnFalse_forTVs_withDifferentBrandDifferentChannel() throws InvalidChannelException {
        TelevisionChannelComparator comp = new TelevisionChannelComparator();
        tv1.changeChannel(2);
        tv1.setBrand("Samsung");
        assertTrue(comp.compare(tv1,tv2) < 0);
    }

}