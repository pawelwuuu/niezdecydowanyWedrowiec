package org.niezdecydowanyWedrowiec.algorytmy;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.macierz.WyjatekMacierz;

public class GaussEliminacja {


    public static double[] rozwiaz(MacierzRzadka macierzRzadka, double[] b) {
        int dlugosc = b.length;
        double[] wynik = new double[dlugosc];

        // Eliminacja Gaussa
        for (int k = 0; k < dlugosc - 1; k++) {
            for (int i = k + 1; i < dlugosc; i++) {
                double m = macierzRzadka.pobierzWartosc(i,k) / macierzRzadka.pobierzWartosc(k,k);
                for (int j = k; j < dlugosc; j++) {
                    double wartoscIJ = macierzRzadka.pobierzWartosc(i,j);
                    macierzRzadka.ustawWartosc(i,j, wartoscIJ - m * macierzRzadka.pobierzWartosc(k,j));
                }
                b[i] -= m * b[k];
            }
        }

        // Rozwiązanie układu równań z postaci trójkątnej górnej
        for (int i = dlugosc - 1; i >= 0; i--) {
            wynik[i] = b[i];
            for (int j = i + 1; j < dlugosc; j++) {
                wynik[i] -= macierzRzadka.pobierzWartosc(i,j) * wynik[j];
            }
            wynik[i] /= macierzRzadka.pobierzWartosc(i,i);
        }

        return wynik;
    }
}