package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.hipotezy.Hipoteza1;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Main {
    public static String nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkXD0.txt";
    public static void main(String[] args) {


        System.out.println(WersjaPodstawowaSymulacja.symuluj(10000000, 2));

        WyswietlaczTablic.wyswietlTablice(GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy()));

    }
}
