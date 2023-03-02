package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog cat;

    @Before
    public void setUp() {
        cat = new InMemoryCatalog();
    }

    // findById Tests

    @Test
    public void findID_shouldReturnMusicItem_withValidID() {
        for(int i = 1; i < cat.size() + 1;i++ ) {
            long l;
            l = i;
            assertNotNull(cat.findById(l));
        }
    }

    @Test
    public void findID_shouldCorrect_MusicItem() {
        MusicItem item = cat.findById(1L);
        assertEquals(1L,item.getId().longValue());
    }

    @Test
    public void findId_shouldReturnNull_belowLowerBoundID() {
        assertNull(cat.findById(0L));
    }

    @Test
    public void findId_shouldReturnNull_aboveUpperBoundID() {
        long l;
        l = cat.size() + 1;
        assertNull(cat.findById(l));
    }

    // findByCategory Tests

    @Test
    public void findByCategory_shouldReturnCollection_withValidCategory() {
        Collection<MusicItem> items = cat.findByCategory(MusicCategory.ROCK);
        assertEquals(6,items.size());
        for(MusicItem item:items) {
            assertEquals(MusicCategory.ROCK,item.getMusicCategory());
        }
    }

    // titleSameAsArtist Tests

    @Test
    public void titleSameAsArtist_shouldReturn_Id6And7() {
        Collection<MusicItem> items = cat.titleSameAsArtist();
        int i = 6;
        for(MusicItem item:items) {
            assertEquals(i,item.getId().longValue());
            i++;
        }
    }

    // rockItemPrice Tests

    @Test
    public void rockItemPrice_shouldReturnCollection_ofRockItems_lessThanOrEqualTo_specifiedPrice() {
        Collection<MusicItem> items = cat.rockItemPrice(10.00);
        for(MusicItem item:items) {
            assertEquals(MusicCategory.ROCK,item.getMusicCategory());
            assertTrue(item.getPrice() <= 10.00);
        }
    }

    @Test
    public void rockItemPrice_shouldReturnEmptyCollection_ifPriceIsTooLow() {
        Collection<MusicItem> items = cat.rockItemPrice(1);
        assertTrue(items.isEmpty());
    }

    // findByKeyword Tests

    @Test
    public void findByKeyword_shouldReturnACollection_ofMusicItems_thatContainTheKeyword() {
        Collection<MusicItem> items = cat.findByKeyword("li");
        assertEquals(3,items.size());
    }

    @Test
    public void findByKeyWord_shouldReturnACollection_withOneItem_withKeywordSEAL() {
        Collection<MusicItem> items = cat.findByKeyword("Seal");
        assertEquals(1,items.size());
    }

    // genreCount Tests

    @Test
    public void genreCount_shouldReturnCorrectNumberOfRockItems() {
        int items = cat.genreCount(MusicCategory.ROCK);
        assertEquals(6,items);
    }

    //averagePrice Tests

    @Test
    public void averagePrice_shouldReturnAveragePrice_ofEntireCatalog() {
        assertEquals(15.309,cat.averagePrice(),0.001);
    }

    // cheapestItemInGenre Tests

    @Test
    public void cheapestItemInGenre_shouldReturnMusicItem_withLowestPrice() {
        MusicItem item = cat.cheapestItemInGenre(MusicCategory.POP);
        assertEquals(MusicCategory.POP,item.getMusicCategory());
        assertEquals(13.99,item.getPrice(),0.001);
    }

    // averagePriceOfGenre Tests

    @Test
    public void averagePriceOfGenre_shouldReturnCorrectAverage_ofChosenGenre() {
        assertEquals(15.64,cat.averagePriceOfGenre(MusicCategory.ROCK),0.001);
    }

    // atLeast10 Tests

    @Test
    public void atLeast10_shouldReturnFalse() {
        assertFalse(cat.atLeast10());
    }

    // isGenrePresent Tests

    @Test
    public void isGenrePresent_shouldReturnTrue_forValidMusicalCategory() {
        assertTrue(cat.isGenrePresent(MusicCategory.ALTERNATIVE));
    }

    // sortedPopTitles

    @Test
    public void sortedPopTitles_shouldReturnASet_ofTitlesOfPopSongs_inNaturalOrder() {
        Collection<String> items = cat.sortedPopTitles();
        assertEquals(4,items.size());
        Object[] itemsList = items.toArray();
        assertEquals("Diva",itemsList[0]);
        assertEquals("Dream of the Blue Turtles",itemsList[1]);
        assertEquals("Seal",itemsList[2]);
        assertEquals("So",itemsList[3]);
    }

    //releasedIn80s


    @Test
    public void releasedIn80s_shouldReturnCollection_ofAllMusicItems_releasedInThe80s_andBelowSpecifiedPrice() {
        Collection<MusicItem> items = cat.releasedIn80s(10.00);
        assertTrue(items.isEmpty());
        items = cat.releasedIn80s(13.00);
        assertFalse(items.isEmpty());
        assertEquals(4, items.size());
        for(MusicItem item:items) {
            assertTrue(item.getPrice() <= 13.00);
            assertTrue(item.getReleaseDate().compareTo(new Date(90,1,1)) < 0);
        }
    }
}