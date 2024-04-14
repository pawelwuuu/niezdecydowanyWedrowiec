package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class WczytaniePliku {
    public static int[][] drogi;
    public static boolean[][] skrzyrzowania;
    public static int obecnie;

    public static void czytajDaneZPliku(String nazwaPliku) {
        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            // M - ilość skrzyrzowań N- ilość ścierzek
            linia = br.readLine();
            String[] wymiary = linia.split(" ");
            int m = Integer.parseInt(wymiary[0]);
            int n = Integer.parseInt(wymiary[1]);

            // Tworzenie tablic dróg i skrzyrzowań
            drogi = new int[m][m];
            skrzyrzowania = new boolean[4][m];

            // Wczytywanie ścierzek między skrzyżowaniami
            for (int i = 0; i < n; i++) {
                linia = br.readLine();
                String[] daneSkrzyzowania = linia.split(" ");
                int a = Integer.parseInt(daneSkrzyzowania[0]);
                int b = Integer.parseInt(daneSkrzyzowania[1]);
                int c = Integer.parseInt(daneSkrzyzowania[2]);
                dodajDroge(a, b, c);
            }

            br.readLine();

            // Wczytywanie właności skrzyrzowań
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
    public static void dodajSkrzyrzowanie(int i, int j)
    {
        skrzyrzowania[i][j-1] = true;
    }

    public static void dodajDroge(int a, int b,int c)
    {
        drogi[a-1][b-1] = c;
        drogi[b-1][a-1] = c;
    }
}
