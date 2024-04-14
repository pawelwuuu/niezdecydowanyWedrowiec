package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import org.niezdecydowanyWedrowiec.WczytaniePliku;

/**
 * Klasa implementująca podstawową wersję algorytmu wyznaczania macierzy podstawowej.
 */
public class WersjaPodstawowaMacierz {

    /** Obecna pozycja w parku. */
    public static int obecnie;

    /** Tablica reprezentująca skrzyżowania w parku. */
    public static boolean[][] skrzyrzowania;    /*
                                                0 - czy studzienka
                                                1 - czy wejście
                                                2 - miejsce startowe
                                                3 - czy śmietnik
                                                */

    /** Tablica reprezentująca czasy podróży między skrzyżowaniami. */
    public static int[][] drogi;

    /** Macierz podstawowa. */
    public static double[][] macierz;

    /**
     * Metoda tworząca macierz podstawową.
     * @return Macierz podstawowa.
     */
    public static double[][] macierzPodstawowa() {

        WczytaniePliku.czytajDaneZPliku("src\\main\\java\\org\\niezdecydowanyWedrowiec\\park.txt");
        drogi = WczytaniePliku.drogi;
        skrzyrzowania = WczytaniePliku.skrzyrzowania;

        macierz = new double[skrzyrzowania[0].length][skrzyrzowania.length];

        for (int j = 0; j < macierz.length; j++) {
            boolean niePusty = false;
            for (int i = 0; i < macierz[j].length; i++) {
                if(i == j)
                    macierz[j][i] = 1.0;          //Wypełnia skos 1
                else
                {
                    if(skrzyrzowania[0][j] || skrzyrzowania[1][j])
                        macierz[i][j] = (double) 0;          //jeżeli jest studzienka albo wyjście wpisuje 0
                    else
                    {
                        if(drogi[i][j] == 0) {
                            macierz[i][j] = (double) 0;
                        }
                        else {
                            macierz[i][j] = WersjaUproszczona.obliczPrawdopodobienstwaMiejsc(1, drogi[i][j]).get(drogi[i][j]); //wpisuje szanse przejścia przez alejkę
                            niePusty = true;
                        }
                    }
                }
            }
            if(niePusty)
                poprawDane(j);      //Przekształca proporcjonalnie dane, by ich suma dawała 0
        }

        return transponuj(macierz);
    }

    /**
     * Metoda poprawiająca dane w macierzy.
     * @param j Indeks kolumny macierzy.
     */
    public static void poprawDane(int j)
    {
        double sum = 0;
        for(int i = 0; i < drogi.length; i++)
            if(macierz[i][j] != 1)
            {
                sum += macierz[i][j];
                if(!skrzyrzowania[3][i])
                    sum += macierz[i][j];
            }
        for(int i = 0; i < drogi.length; i++)
            if(macierz[i][j] != 1)
            {
                if(!skrzyrzowania[3][i])
                    macierz[i][j] *= -2/sum;
                else
                    macierz[i][j] *= -1/sum;
            }
        System.out.println();
    }

    /**
     * Metoda zwracająca wektor wynikowy.
     * @return Wektor wynikowy.
     */
    public static double[] podajWektorWynikowy() {
        double[] wektorWynikowy = new double[macierz.length];

        for (int i = 0; i < skrzyrzowania[1].length; i++) {
            if  (skrzyrzowania[1][i]) {
                wektorWynikowy[i] = 1.;
            } else {
                wektorWynikowy[i] = 0.;
            }
        }

        return wektorWynikowy;
    }

    /**
     * Metoda rozwiązująca równanie.
     * @return Rozwiązanie równania.
     */
    public static double[] rozwiazRownanie() {
        double[][] macierzPodstawowa = macierzPodstawowa();
        double[] wektorWynikowy = podajWektorWynikowy();
        return WersjaUproszczona.rozwiaz(macierzPodstawowa, wektorWynikowy);
    }

    /**
     * Metoda transponująca macierz.
     * @param matrix Macierz do transponowania.
     * @return Transponowana macierz.
     */
    public static double[][] transponuj(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        double[][] transposedMatrix = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}
