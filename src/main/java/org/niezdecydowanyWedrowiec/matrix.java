package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class matrix {
    public static int obecnie;
    public static boolean[][] skrzyrzowania;    /*
                                                0 - czy studzienka
                                                1 - czy wejscie
                                                2 - miejsce startowe
                                                3 - czy smietnik
                                                */
    public static int[][] drogi;    //czas drogi między m i n skrzyrzowaniem

    public static double[][]macierz;

    public static double[][] macierzPodstawowa() {
        czytajDaneZPliku("src\\main\\java\\org\\example\\park.txt");

        macierz = new double[skrzyrzowania[0].length][skrzyrzowania.length];

        for (int j = 0; j < macierz.length; j++) {
            boolean niePusty = false;
            for (int i = 0; i < macierz[j].length; i++) {
                if(i == j)
                    macierz[j][i] = 1;          //Wypełnia skos 1
                else
                {
                    if(skrzyrzowania[0][j] || skrzyrzowania[1][j])
                        macierz[i][j] = 0;          //jeżeli jest studzienka albo wyjście wpisuje 0
                    else
                    {
                        macierz[i][j] = SimplifiedProbability.calculatePlacesProbabilities(1,drogi[i][j]).get(drogi[i][j]); //wpisuje szanse przejścia przez alejke
                        niePusty = true;
                    }
                }
            }
            if(niePusty)
                poprawDane(j);      //Przekształca proporcionalnie dane by ich suma dawała 0
        }

        for (int j = 0; j < macierz.length; j++) {
            for (int i = 0; i < macierz[j].length; i++) {       //wypisuje macierz
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }
        return macierz;
    }
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
