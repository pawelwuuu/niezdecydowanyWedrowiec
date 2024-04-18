package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.WczytaniePliku;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;

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
    //public static double[][] macierz;

    public static MacierzRzadka macierzRzadka;
    /**
     * Metoda tworząca macierz podstawową.
     * @return Macierz podstawowa.
     */
    public static MacierzRzadka macierzPodstawowa() {

        WczytaniePliku.czytajDaneZPliku(Main.nazwaPliku);
        drogi = WczytaniePliku.drogi;
        skrzyrzowania = WczytaniePliku.skrzyrzowania;

        //macierz = new double[drogi[0].length][drogi.length];
        macierzRzadka = new MacierzRzadka(drogi[0].length);

        for (int j = 0; j < drogi[0].length; j++) {
            boolean niePusty = false;
            for (int i = 0; i < drogi[0].length; i++) {
                if(i == j)
                    macierzRzadka.ustawWartosc(j,i,1.0);
                else
                {
                    if(!(skrzyrzowania[0][j] || skrzyrzowania[1][j]))
                    {
                        if(!(drogi[i][j] == 0)) {
                            macierzRzadka.ustawWartosc(i,j, WersjaUproszczona.obliczPrawdopodobienstwaMiejsc(1, drogi[i][j]).get(drogi[i][j])); //wpisuje szanse przejścia przez alejkę
                            niePusty = true;
                        }
                    }
                }
            }
            if(niePusty)
                poprawDane(j);      //Przekształca proporcjonalnie dane, by ich suma dawała 0
        }

        return transponuj(macierzRzadka);
    }

    /**
     * Metoda poprawiająca dane w macierzy.
     * @param j Indeks kolumny macierzy.
     */
    public static void poprawDane(int j)
    {
        double sum = 0;
        for(int i = 0; i < drogi.length; i++)
            if(macierzRzadka.pobierzWartosc(i,j) != 1)
            {
                sum += macierzRzadka.pobierzWartosc(i,j);
                if(!skrzyrzowania[3][i])
                    sum += macierzRzadka.pobierzWartosc(i,j);
            }
        for(int i = 0; i < drogi.length; i++)
            if(macierzRzadka.pobierzWartosc(i,j) != 1)
            {
                if(!skrzyrzowania[3][i])
                    macierzRzadka.ustawWartosc(i,j,macierzRzadka.pobierzWartosc(i,j) * -2/sum);
                else
                    macierzRzadka.ustawWartosc(i,j,macierzRzadka.pobierzWartosc(i,j) * -1/sum);
            }
    }

    /**
     * Metoda zwracająca wektor wynikowy.
     * @return Wektor wynikowy.
     */
    public static double[] podajWektorWynikowy() {
        double[] wektorWynikowy = new double[drogi[0].length];

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
     * Metoda transponująca macierz.
     * @param matrix Macierz do transponowania.
     * @return Transponowana macierz.
     */
    public static MacierzRzadka transponuj(MacierzRzadka matrix) {
        int rows = drogi[0].length;
        int cols = drogi[0].length;

        MacierzRzadka transposedMatrix = new MacierzRzadka(rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix.czyUstawione(i,j))
                    transposedMatrix.ustawWartosc(j,i,matrix.pobierzWartosc(i,j));
            }
        }

        return transposedMatrix;
    }
}
