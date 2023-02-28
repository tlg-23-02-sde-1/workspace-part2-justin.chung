package com.duckrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    private final int id;
    private String name;
    private final List<String> rewards = new ArrayList<>();

    /*
     * CTORS
     */

    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    /*
     * GETTERS
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Note: we are returning a direct reference to our List.
    // the client can then modify the list directly.
    // This is a bad idea. We should return an unmodifiable list.`

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    /*
     * SETTERS
     */

    // a derived property. We can calculate the number of wins from the rewards colelction
    public int getWins() {
        return rewards.size();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void wins(Reward reward) {
        rewards.add(String.valueOf(reward));
    }

    @Override
    public String toString() {
        return String.format("%s [id=%s, name=%s, rewards=%s]", getClass().getSimpleName(), getId(), getName(), getRewards());
    }

}