package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import java.util.Random;

public class SymulacjaMonteCarlo {
    public static double symuluj(int s, int n, int symulacje) {
        int wyjsciaPozytywne = 0;
        Random losowy = new Random();
        for (int i = 0; i < symulacje; i++) {
            int sTmp = s;
            int nTmp = n;
            while (sTmp > 0 && nTmp > 0) {
                if (losowy.nextInt(10) % 2 == 0) {
                    sTmp--;
                    nTmp++;
                } else {
                    nTmp--;
                    sTmp++;
                }
            }

            if (sTmp == 0) {
                wyjsciaPozytywne++;
            }
        }

        return (double) wyjsciaPozytywne / symulacje;
    }
}
