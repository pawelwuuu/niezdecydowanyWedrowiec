package org.niezdecydowanyWedrowiec.algorytmy;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.macierz.WyjatekMacierz;

public class GaussEliminacja {

    /**
     * Rozwiązuje układ równań liniowych Ax = b, gdzie A jest rzadką macierzą, a b jest wektorem.
     * @param A Rzadka macierz współczynników.
     * @param b Wektor wyrazów wolnych.
     * @return Wektor rozwiązania.
     * @throws WyjatekMacierz Jeśli macierz A i wektor b mają różne rozmiary lub nie można rozwiązać układu.
     */
    public static double[] rozwiaz(MacierzRzadka A, double[] b) throws WyjatekMacierz {
        int rozmiar = A.rozmiarMacierzy;
        if (rozmiar != b.length) {
            throw new WyjatekMacierz("Rozmiary macierzy A i wektora b są niezgodne.");
        }

        // Kopia macierzy A
        MacierzRzadka kopiaA = new MacierzRzadka(A.rozmiarMacierzy);
        for (int i = 0; i < A.rozmiarMacierzy; i++) {
            for (int j = 0; j < A.rozmiarMacierzy; j++) {
                if (A.czyUstawione(i, j)) {
                    kopiaA.ustawWartosc(i, j, A.pobierzWartosc(i, j));
                } else {
                    kopiaA.ustawWartosc(i, j, 0); // Ustawienie domyślnej wartości na zero dla nieustawionych elementów
                }
            }
        }

        // Eliminacja Gaussa
        for (int i = 0; i < rozmiar - 1; i++) {
            for (int j = i + 1; j < rozmiar; j++) {
                double factor = kopiaA.pobierzWartosc(j, i) / kopiaA.pobierzWartosc(i, i);
                for (int k = i; k < rozmiar; k++) {
                    double newValue = kopiaA.pobierzWartosc(j, k) - factor * kopiaA.pobierzWartosc(i, k);
                    kopiaA.ustawWartosc(j, k, newValue);
                }
                b[j] -= factor * b[i];
            }
        }

        // Rozwiązanie równań za pomocą wstecznej substytucji
        double[] x = new double[rozmiar];
        for (int i = rozmiar - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < rozmiar; j++) {
                sum += kopiaA.pobierzWartosc(i, j) * x[j];
            }
            if (kopiaA.pobierzWartosc(i, i) == 0) {
                throw new WyjatekMacierz("Macierz A jest osobliwa, nie można rozwiązać układu równań.");
            }
            x[i] = (b[i] - sum) / kopiaA.pobierzWartosc(i, i);
        }

        return x;
    }
}