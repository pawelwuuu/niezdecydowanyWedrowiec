package org.example;

import java.util.Random;

public class MonteCarloSimulation {
    public static double simulate(int s, int n, int simulations) {
        int exitPositiveTrials = 0;
        Random random = new Random();
        for (int i = 0; i < simulations; i++) {
            while (s != 0 && n != 0) {
                if (random.nextInt(10) % 2 == 0) {
                    s--;
                    n++;
                } else {
                    n --;
                    s++;
                }
            }

            if (s == 0) {
                exitPositiveTrials++;
            }
        }

        return (double) exitPositiveTrials /simulations;

    }
}
