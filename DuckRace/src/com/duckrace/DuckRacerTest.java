package com.duckrace;

import java.util.List;

import static com.duckrace.Reward.*;

class DuckRacerTest {
    public static void main(String[] args) {
        DuckRacer racer = new DuckRacer(1, "Daffy Duck");
        System.out.println(racer);
        List<String> rewards = racer.getRewards();
        racer.wins(DEBIT_CARD);
        racer.wins(DEBIT_CARD);
        racer.wins(DEBIT_CARD);
        System.out.println(racer);
        System.out.println("Wins: " + racer.getWins());
        System.out.println("Rewards: " + racer.getRewards());
        racer.wins(DEBIT_CARD);

        System.out.println("rewards: " + rewards);
    }
}