package com.duckrace;

import java.util.HashMap;
import java.util.Map;

class DuckRaceResults {
    private final Map<String,DuckRacer> raceResults = new HashMap<>();

    public void setRacer(DuckRacer racer) {
        raceResults.put(racer.getName(), racer);
    }
    public void addReward(String racerName, Reward reward) {
        raceResults.get(racerName).wins(reward);
    }
    public DuckRacer getRacer(String racerName) {
        return raceResults.get(racerName);
    }
    public int getWins(String racerName) {
        return raceResults.get(racerName).getWins();
    }
}