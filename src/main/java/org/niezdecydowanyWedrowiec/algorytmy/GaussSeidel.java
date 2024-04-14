package org.niezdecydowanyWedrowiec.algorytmy;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;

public class GaussSeidel {

    public static double[] rozwiaz(MacierzRzadka A, double[] b, int maksIteracji, double tolerancja) {
        int n = A.rozmiarMacierzy;
        double[] x = new double[n];
        double[] xNowe = new double[n];
        int iteracja = 0;
        double roznicaNorm = Double.MAX_VALUE;

        while (iteracja < maksIteracji && roznicaNorm > tolerancja) {
            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                double diagonalnyElement = 0.0;
                for (int j = 0; j < n; j++) {
                    if (i != j && A.czyUstawione(i, j)) {
                        suma += A.pobierzWartosc(i, j) * x[j];
                    } else if (i == j) {
                        diagonalnyElement = A.pobierzWartosc(i, j);
                    }
                }
                xNowe[i] = (b[i] - suma) / diagonalnyElement;
            }

            roznicaNorm = obliczNormeRoznic(x, xNowe);

            System.arraycopy(xNowe, 0, x, 0, n); // Kopiujemy nowe rozwiązanie do wektora x

            iteracja++;
        }

        if (iteracja >= maksIteracji) {
            System.out.println("Osiągnięto maksymalną liczbę iteracji.");
        } else {
            System.out.println("Osiągnięto wymaganą tolerancję.");
        }

        return x;
    }

    private static double obliczNormeRoznic(double[] x, double[] xNowe) {
        double sumaKwadratow = 0.0;
        for (int i = 0; i < x.length; i++) {
            sumaKwadratow += Math.pow(xNowe[i] - x[i], 2);
        }
        return Math.sqrt(sumaKwadratow);
    }
}

