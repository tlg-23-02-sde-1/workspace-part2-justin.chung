package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {

    private Television tv1;
    private Television tv2;

    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony",50,DisplayType.OLED);
        tv2 = new Television("Sony",50,DisplayType.OLED);
    }

    @Test
    public void brandChannelComparator_returnsZero_forTVs_withSameBrandAndChannel() {
        TelevisionBrandChannelComparator comp = new TelevisionBrandChannelComparator();
        assertTrue(comp.compare(tv1,tv2) == 0);
    }

    @Test
    public void brandChannelComparator_returnsNegativeInteger_forTVs_withDifferentBrand() {
        tv1.setBrand("Samsung");
        TelevisionBrandChannelComparator comp = new TelevisionBrandChannelComparator();
        assertTrue(comp.compare(tv1,tv2)  < 0);
    }

    @Test
    public void brandChannelComparator_returnsPositiveInteger_forTVs_withSameBrandDifferentChannel() throws InvalidChannelException {
        tv1.changeChannel(5);
        TelevisionBrandChannelComparator comp = new TelevisionBrandChannelComparator();
        assertTrue(comp.compare(tv1,tv2) > 0);
    }
}