package org.niezdecydowanyWedrowiec.hipotezy;

import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;

public class Hipoteza1 {
    double[] rozwiaz = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
    double[] rozwiaz1 = GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());



    double suma1, suma2;

    public void podajWynik() {
        System.out.println("gauss - gaussZwyborem");
        for (int i = 0; i < rozwiaz.length; i++) {
            System.out.println(rozwiaz[i] - rozwiaz1[i]);
        }
    }

}
