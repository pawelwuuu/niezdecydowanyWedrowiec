package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;

public class Main {
    public static String nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt";
    public static void main(String[] args) {


//        Hipoteza3.wypiszCzasyAlgo(15, null);

        double[][] macierzX = new double[][]{
                {
                        1, 2, 3
                },
                {
                        4, 2, 1
                },
                {
                        5, 1, 1
                }
        };

        MacierzRzadka macierzRzadka = new MacierzRzadka(macierzX);

        double[] macierzWynikowa = new double[] {
                14,11,10
        };


        WyswietlaczTablic.wyswietlTablice(GaussZCzesciowymWyborem.rozwiaz(macierzRzadka, macierzWynikowa));
    }
}
