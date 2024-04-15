package org.niezdecydowanyWedrowiec.algorytmy;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;

import java.util.Arrays;

public class GaussZCzesciowymWyborem {

    public static double[] rozwiaz(MacierzRzadka A, double[] b) {
        int n = A.rozmiarMacierzy;
        double[] x = new double[n];

        for (int i = 0; i < n; i++) {
            // Szukanie maksimum w aktualnej kolumnie
            double maxEl = Math.abs(A.czyUstawione(i, i) ? A.pobierzWartosc(i, i) : 0);
            int maxRow = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A.czyUstawione(k, i) ? A.pobierzWartosc(k, i) : 0) > maxEl) {
                    maxEl = Math.abs(A.czyUstawione(k, i) ? A.pobierzWartosc(k, i) : 0);
                    maxRow = k;
                }
            }

            // Zamiana maksymalnego wiersza z aktualnym wierszem
            for (int k = i; k < n; k++) {
                double tmp = A.czyUstawione(maxRow, k) ? A.pobierzWartosc(maxRow, k) : 0;
                if (A.czyUstawione(i, k)) {
                    A.ustawWartosc(maxRow, k, A.pobierzWartosc(i, k));
                }
                A.ustawWartosc(i, k, tmp);
            }
            double tmp = b[maxRow];
            b[maxRow] = b[i];
            b[i] = tmp;

            // Wyzerowanie i-tej kolumny poniżej i-tego wiersza
            for (int k = i + 1; k < n; k++) {
                double c = -(A.czyUstawione(k, i) ? A.pobierzWartosc(k, i) : 0) / (A.czyUstawione(i, i) ? A.pobierzWartosc(i, i) : 0);
                for (int j = i; j < n; j++) {
                    if (i == j) {
                        A.ustawWartosc(k, j, 0.0);
                    } else {
                        double val = A.czyUstawione(k, j) ? A.pobierzWartosc(k, j) : 0;
                        A.ustawWartosc(k, j, val + c * (A.czyUstawione(i, j) ? A.pobierzWartosc(i, j) : 0));
                    }
                }
                b[k] += c * b[i];
            }
        }

        // Rozwiązanie układu równań dla macierzy górnotrójkątnej
        for (int i = n - 1; i >= 0; i--) {
            x[i] = b[i] / (A.czyUstawione(i, i) ? A.pobierzWartosc(i, i) : 0);
            for (int k = i - 1; k >= 0; k--) {
                b[k] -= (A.czyUstawione(k, i) ? A.pobierzWartosc(k, i) : 0) * x[i];
            }
        }
        return x;
    }
}
