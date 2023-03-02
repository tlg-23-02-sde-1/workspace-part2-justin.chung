package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    
    private Television tv1;
    private Television tv2;
    
    @Before
    public void setUp() throws Exception {
        tv1 = new Television("Sony",50,DisplayType.OLED);
        tv2 = new Television("Sony",50,DisplayType.OLED);
    }

    //VolumeTests

    @Test (expected = IllegalArgumentException.class)
    public void setVolume_shouldReturnException_forVolumeAboveUpperBound() {
        tv1.setVolume(101);
        assertEquals(50,tv1.getVolume());
    }

    @Test
    public void setVolume_shouldAllow_forVolumeAtUpperBound() {
        tv1.setVolume(100);
        assertEquals(100,tv1.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldReturnException_forVolumeBelowLowerBound() {
        try {
            tv1.setVolume(-1);
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: -1. Allowed range: [0,100].",e.getMessage());
            throw e;
        }
        finally {
            assertEquals(50,tv1.getVolume());
        }
    }

    @Test
    public void setVolume_shouldAllow_forVolumeAtLowerBound() {
        tv1.setVolume(0);
        assertEquals(0,tv1.getVolume());
    }

    //ChannelTests

    @Test (expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowException_forChannelAboveUpperBound () throws InvalidChannelException {
        tv1.changeChannel(1000);
        assertEquals(3,tv1.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldAllow_forChannelAtUpperBound () throws InvalidChannelException {
        tv1.changeChannel(999);
        assertEquals(999,tv1.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowException_forChannelBelowLowerBound()
    throws InvalidChannelException {
        try {
            tv1.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].",e.getMessage());
            throw e;
        }
        finally {
            assertEquals(3, tv1.getCurrentChannel());
        }
    }

    @Test
    public void changeChannel_shouldAllow_forChannelAtLowerBound() throws InvalidChannelException{
        tv1.changeChannel(1);
        assertEquals(1,tv1.getCurrentChannel());
    }

    //CompareTests

    @Test
    public void compareTo_shouldReturnZero_forIdenticalTVs() {
        assertEquals(0,tv1.compareTo(tv2));
    }

    @Test
    public void compareTo_shouldReturnFalse_forDifferentTVs() {
        tv1.setBrand("Samsung");
        assertNotEquals(0,tv1.compareTo(tv2));
    }

    //EqualsTests

    @Test
    public void equals_shouldReturnTrue_forIdenticalTVs() {
        assertEquals(tv1, tv2);
    }

    @Test
    public void equals_shouldReturnFalse_forTVs_withDifferentVolume() {
        tv1.setVolume(49);
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_forTVs_withDifferentBrands() {
        tv1.setBrand("Samsung");
        assertNotEquals(tv1,tv2);
    }

    @Test
    public void equals_shouldReturnFalse_forTVs_withDifferentDisplays() {
        tv1.setDisplay(DisplayType.LED);
        assertNotEquals(tv1,tv2);
    }

    //HashCodeTests

    @Test
    public void hashCode_shouldReturn_sameHashCodes_forSameTVs() {
        assertEquals(tv1.hashCode(),tv2.hashCode());
    }

    //compareToTests

    @Test
    public void compareTo_shouldReturnTrue_withIdenticalTVs() {
        assertTrue(tv1.compareTo(tv2) == 0);
    }

    @Test
    public void compareTo_shouldReturnPositiveInteger_forTV2LongerBrand() {
        tv2.setBrand("Samsung");
        assertTrue(tv1.compareTo(tv2) > 0);
    }

    @Test
    public void compareTo_shouldReturnNegativeInteger_forTV2ShorterBrand() {
        tv1.setBrand("LG");
        assertTrue(tv1.compareTo(tv2) < 0);
    }
}