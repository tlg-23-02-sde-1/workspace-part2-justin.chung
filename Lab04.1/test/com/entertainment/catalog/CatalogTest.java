/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrand_shouldReturnEmptyCollection_whenBrandNotFound() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void findByBrand_shouldReturnCollection_withThatBrand_whenBrandFound() {
    Collection<Television> tvs = Catalog.findByBrand("RCA");
    assertNotNull(tvs);
    assertEquals(9,tvs.size());
    for(Television tv:tvs) {
      assertEquals("RCA",tv.getBrand());
    }
  }

  @Test
  public void findByBrands_shouldReturnEmptyMap_whenNoArgsPassed() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("");
    assertNotNull(tvMap);
    assertTrue(tvMap.get("").isEmpty());
  }

  @Test
  public void findByBrands_shouldReturnEmptyMap_whenBrandNotFound() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("NO-MATCHES");
    assertNotNull(tvMap);
    assertTrue(tvMap.get("NO-MATCHES").isEmpty());
  }

  @Test
  public void findByBrands_shouldReturnMap_withOneRow_whenOneBrandPassed() {
    Map<String,Collection<Television>> tvMap = Catalog.findByBrands("RCA");
    assertNotNull(tvMap);
    assertEquals(1,tvMap.keySet().size());
    assertEquals(9,tvMap.get("RCA").size());
  }

  @Test
  public void findByBrands_shouldReturnMapWithEntries_whenBrandsPassed() {
    Map<String, Collection<Television>> tvMap = Catalog.findByBrands("RCA", "Zenith", "LG");

    assertEquals(3, tvMap.size());
    assertEquals(9,tvMap.get("RCA").size());
    for(Television tv: tvMap.get("RCA")) {
      assertEquals("RCA",tv.getBrand());
    }

    assertEquals(9,tvMap.get("Zenith").size());
    for(Television tv: tvMap.get("Zenith")) {
      assertEquals("Zenith",tv.getBrand());
    }

    assertEquals(0,tvMap.get("LG").size());
  }

  @Test(expected=UnsupportedOperationException.class)
  public void readOnlyCatalogTest_shouldThrowException() {
    Collection<Television> cat = Catalog.getInventory();
    Television tv = new Television("LG",50);
    assertTrue(cat.add(tv));
  }
}