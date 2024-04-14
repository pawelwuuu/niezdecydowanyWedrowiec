package org.niezdecydowanyWedrowiec;

public class WyswietlaczTablic {
    public static void wyswietlTablice(Object[][] tablica) {
        System.out.println(konwertujTabliceNaString(tablica));
    }

    public static void wyswietlTablice(Object[] tablica) {
        System.out.println(konwertujTabliceNaString(tablica));
    }

    public static String konwertujTabliceNaString(Object[][] tablica) {
        int dlugoscTablicy = tablica.length;

        String tablicaNapis = "-------------------\n";
        for (int i = 0; i < dlugoscTablicy; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablicaNapis += "\t" + tablica[i][j];
            }
            tablicaNapis += "\n";
        }

        tablicaNapis += "-------------------\n";

        return tablicaNapis;
    }

    public static String konwertujTabliceNaString(Object[] tablica) {
        int dlugoscTablicy = tablica.length;

        String tablicaNapis = "-------------------\n";
        for (int i = 0; i < dlugoscTablicy; i++) {
            tablicaNapis += "\t" + tablica[i];
        }

        tablicaNapis += "\n-------------------";

        return tablicaNapis;
    }
}
