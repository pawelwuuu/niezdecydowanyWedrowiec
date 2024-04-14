package org.niezdecydowanyWedrowiec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasa odpowiedzialna za wczytywanie danych z pliku.
 */
public class WczytaniePliku {

    /** Tablica przechowująca czasy przejazdów między skrzyżowaniami. */
    public static int[][] drogi;

    /** Tablica przechowująca właściwości skrzyżowań. */
    public static boolean[][] skrzyrzowania;

    /** Numer obecnego skrzyżowania. */
    public static int obecnie;

    /**
     * Metoda wczytująca dane z pliku.
     * @param nazwaPliku Nazwa pliku z danymi.
     */
    public static void czytajDaneZPliku(String nazwaPliku) {
        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            // M - ilość skrzyżowań N- ilość ścieżek
            linia = br.readLine();
            String[] wymiary = linia.split(" ");
            int m = Integer.parseInt(wymiary[0]);
            int n = Integer.parseInt(wymiary[1]);

            // Tworzenie tablic dróg i skrzyżowań
            drogi = new int[m][m];
            skrzyrzowania = new boolean[4][m];

            // Wczytywanie ścieżek między skrzyżowaniami
            for (int i = 0; i < n; i++) {
                linia = br.readLine();
                String[] daneSkrzyzowania = linia.split(" ");
                int a = Integer.parseInt(daneSkrzyzowania[0]);
                int b = Integer.parseInt(daneSkrzyzowania[1]);
                int c = Integer.parseInt(daneSkrzyzowania[2]);
                dodajDroge(a, b, c);
            }

            br.readLine();

            // Wczytywanie własności skrzyżowań
            for (int i = 0; i < 4; i++) {
                linia = br.readLine();
                String[] daneSkrzyzowania = linia.split(" ");
                for (int j = 1; j < daneSkrzyzowania.length; j++) {
                    String a = daneSkrzyzowania[j];
                    dodajSkrzyrzowanie(i, Integer.parseInt(a));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dodaje właściwość skrzyżowania.
     * @param i Indeks właściwości.
     * @param j Numer skrzyżowania.
     */
    public static void dodajSkrzyrzowanie(int i, int j) {
        skrzyrzowania[i][j - 1] = true;
    }

    /**
     * Dodaje drogę między skrzyżowaniami.
     * @param a Numer pierwszego skrzyżowania.
     * @param b Numer drugiego skrzyżowania.
     * @param c Czas przejazdu między skrzyżowaniami.
     */
    public static void dodajDroge(int a, int b, int c) {
        drogi[a - 1][b - 1] = c;
        drogi[b - 1][a - 1] = c;
    }
}
