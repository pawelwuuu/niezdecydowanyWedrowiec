package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WersjaPodstawowaMacierz {
    public static int obecnie;
    public static boolean[][] skrzyrzowania;    /*
                                                0 - czy studzienka
                                                1 - czy wejscie
                                                2 - miejsce startowe
                                                3 - czy smietnik
                                                */
    public static int[][] drogi;    //czas drogi między m i n skrzyrzowaniem

    public static Double[][]macierz;

    public static Double[][] macierzPodstawowa() {

        WczytaniePliku.czytajDaneZPliku("src\\main\\java\\org\\niezdecydowanyWedrowiec\\park.txt");
        drogi = WczytaniePliku.drogi;
        skrzyrzowania = WczytaniePliku.skrzyrzowania;


        macierz = new Double[skrzyrzowania[0].length][skrzyrzowania.length];

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
                            macierz[i][j] = WersjaUproszczona.obliczPrawdopodobienstwaMiejsc(1, drogi[i][j]).get(drogi[i][j]); //wpisuje szanse przejścia przez alejke
                            niePusty = true;
                        }
                    }
                }
            }
            if(niePusty)
                poprawDane(j);      //Przekształca proporcionalnie dane by ich suma dawała 0
        }

//        for (int j = 0; j < macierz.length; j++) {
//            for (int i = 0; i < macierz[j].length; i++) {       //wypisuje macierz
//                System.out.print(macierz[i][j] + " ");
//            }
//            System.out.println();
//        }



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

    public static Double[] podajWektorWynikowy() {
        Double[] wektorWynikowy = new Double[macierz.length];

        for (int i = 0; i < skrzyrzowania[1].length; i++) {
            if  (skrzyrzowania[1][i] == true) {
                wektorWynikowy[i] = 1.;
            } else {
                wektorWynikowy[i] = 0.;
            }
        }

        return wektorWynikowy;
    }

}
