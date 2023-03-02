/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * The "T" is really going to be something like MusicItem
 * ShoppingCart<MusicItem> cart = ... // what's the T? MusicItem
 * ShoppingCart<MediaPlayer> cart = ... // what's the T? MediaPlayer
 */

public class ShoppingCart<T extends Product> {
  // storage for the cart's contents
  private final Collection<T> items = new ArrayList<T>();  // diamond not used here just to emphasize the T
  
  public void addItem(T item) {
    items.add(item);
  }
  
  public void removeItem(T item) {
    items.remove(item);
  }

  //returns readOnly of items
  public Collection<T> allItems() {
    return Collections.unmodifiableCollection(items);
  }

  public int size() {
    return items.size();
  }

  public double total() {
    double total = 0.0;
    for(T item:items) {
      total += item.getPrice();
    }
    return total;
  }
}