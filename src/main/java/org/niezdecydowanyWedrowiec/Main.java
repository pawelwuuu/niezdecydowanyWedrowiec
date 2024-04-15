package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.miernikCzasu.MiernikCzasu;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;

public class Main {
    public static void main(String[] args) {

//        WyswietlaczTablic.wyswietlTablice(transpose(WersjaPodstawowaMacierz.macierzPodstawowa()));
//        WyswietlaczTablic.wyswietlTablice(WersjaPodstawowaMacierz.podajWektorWynikowy());


        WyswietlaczTablic.wyswietlTablice(WersjaPodstawowaMacierz.rozwiazRownanie());

        double[] rozwiaz = GaussZCzesciowymWyborem.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        WyswietlaczTablic.wyswietlTablice(rozwiaz);


    }


}
