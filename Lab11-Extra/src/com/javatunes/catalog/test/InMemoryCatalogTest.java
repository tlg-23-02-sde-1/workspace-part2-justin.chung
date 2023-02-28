/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.Catalog;
import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        // testFindByKeyword();
        // testFindByCategory();
        test();
        // testGetAll();
    }

    private static void testFindById() {
        Catalog catalog = new InMemoryCatalog();
        System.out.println(catalog.findById(100L));
    }

    private static void testFindByKeyword() {
        Catalog catalog = new InMemoryCatalog();
        System.out.println(catalog.findByKeyword("Seal"));
    }

    private static void testFindByCategory() {
        Catalog catalog = new InMemoryCatalog();
        System.out.println(catalog.findByCategory(MusicCategory.ROCK));
    }

    private static void test() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for(MusicItem item:catalog.titleSameAsArtist()) {
            System.out.println(item);
        }
    }

    private static void testGetAll() {
    }
}