package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.SymulacjaMonteCarlo;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaUproszczona;

public class Main {
    public static void main(String[] args) {



        System.out.println(WersjaUproszczona.obliczPrawdopodobienstwaMiejsc(4,3));
        System.out.println(SymulacjaMonteCarlo.symuluj(4,3,100000)); // to jest dobrze ;)

    }
}
