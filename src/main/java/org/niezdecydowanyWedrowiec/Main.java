package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;

public class Main {
    public static void main(String[] args) {

//        WyswietlaczTablic.wyswietlTablice(transpose(WersjaPodstawowaMacierz.macierzPodstawowa()));
//        WyswietlaczTablic.wyswietlTablice(WersjaPodstawowaMacierz.podajWektorWynikowy());


        WyswietlaczTablic.wyswietlTablice(WersjaPodstawowaMacierz.rozwiazRownanie());

        double[] rozwiaz = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 3, 0.1);
        WyswietlaczTablic.wyswietlTablice(rozwiaz);

    }


}
