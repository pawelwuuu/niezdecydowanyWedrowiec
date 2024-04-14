package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import java.util.ArrayList;

/**
 * Klasa implementująca uproszczoną wersję obliczania prawdopodobieństw miejsc.
 */
public class WersjaUproszczona {

    /**
     * Metoda obliczająca prawdopodobieństwa miejsc.
     * @param n Liczba początkowa.
     * @param s Liczba docelowa.
     * @return Lista zawierająca obliczone prawdopodobieństwa.
     */
    public static ArrayList<Double> obliczPrawdopodobienstwaMiejsc(int n, int s) {
        int szerokoscMacierzy = 1 + n + s;
        double[][] macierz = new double[szerokoscMacierzy][szerokoscMacierzy];
        double[] wynikMacierzy = new double[szerokoscMacierzy];
        wynikMacierzy[0] = 1;

        for (int i = 0; i < szerokoscMacierzy; i++) {
            macierz[i][i] = 1;
            if (i - 1 >= 0 && i + 1 <= szerokoscMacierzy - 1) {
                macierz[i][i-1] = -0.5;
                macierz[i][i+1] = -0.5;
            }
        }

        ArrayList<Double> wynik = new ArrayList<>();
        for (double element : rozwiaz(macierz, wynikMacierzy)) {
            wynik.add(element);
        }

        return wynik;
    }

    /**
     * Metoda rozwiązująca układ równań.
     * @param A Macierz współczynników.
     * @param b Wektor wyrazów wolnych.
     * @return Tablica zawierająca rozwiązanie układu równań.
     */
    public static double[] rozwiaz(double[][] A, double[] b) {
        int N = A.length;

        // Eliminacja Gaussa
        for (int i = 0; i < N; i++) {
            // Szukamy największego elementu w kolumnie i-tej
            int indeksMaxWiersza = i;
            for (int k = i + 1; k < N; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[indeksMaxWiersza][i])) {
                    indeksMaxWiersza = k;
                }
            }

            // Zamiana wierszy
            double[] temp = A[i];
            A[i] = A[indeksMaxWiersza];
            A[indeksMaxWiersza] = temp;
            double tempB = b[i];
            b[i] = b[indeksMaxWiersza];
            b[indeksMaxWiersza] = tempB;

            // Eliminacja
            for (int k = i + 1; k < N; k++) {
                double wspolczynnik = A[k][i] / A[i][i];
                b[k] -= wspolczynnik * b[i];
                for (int j = i; j < N; j++) {
                    A[k][j] -= wspolczynnik * A[i][j];
                }
            }
        }

        // Wyliczanie rozwiązania
        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            x[i] = b[i];
            for (int j = i + 1; j < N; j++) {
                x[i] -= A[i][j] * x[j];
            }
            x[i] /= A[i][i];
        }

        return x;
    }
}
