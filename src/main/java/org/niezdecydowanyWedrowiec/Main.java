package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.SymulacjaMonteCarlo;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaUproszczona;

public class Main {
    public static void main(String[] args) {
        System.out.println(WersjaUproszczona.obliczPrawdopodobienstwaMiejsc(4,3));
        System.out.println(SymulacjaMonteCarlo.symuluj(4,3,100000)); // to jest dobrze ;)

        MacierzRzadka macierzRzadka = new MacierzRzadka(2);
        macierzRzadka.ustawWartosc(1,1,3.5);

        System.out.println(macierzRzadka);

        Double[][] tablica = {
                {1.,2.},
                {1.,2.,3.}
        };

        WyswietlaczTablic.wyswietlTablice(tablica);
    }
}
