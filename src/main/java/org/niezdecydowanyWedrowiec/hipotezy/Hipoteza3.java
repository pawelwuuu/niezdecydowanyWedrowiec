package org.niezdecydowanyWedrowiec.hipotezy;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.miernikCzasu.MiernikCzasu;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;

public class Hipoteza3 {
    public static void wypiszCzasyAlgo() {
        long dda1 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long dda2 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussZCzesciowymWyborem.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long dda3 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-6);
        });

        System.out.println(dda1);
        System.out.println(dda2);
        System.out.println(dda3);

        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt";
        long dma1 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long dma2 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussZCzesciowymWyborem.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long dma3 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-6);
        });

        System.out.println(dma1);
        System.out.println(dma2);
        System.out.println(dma3);
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMM0.txt";

        long mma1 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long mma2 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussZCzesciowymWyborem.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long mma3 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-6);
        });

        System.out.println(mma1);
        System.out.println(mma2);
        System.out.println(mma3);


        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt";

        long mda1 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long mda2 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussZCzesciowymWyborem.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
        });

        long mda3 = MiernikCzasu.zmierzCzasWykonania(() -> {
            GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-6);
        });

        System.out.println(mda1);
        System.out.println(mda2);
        System.out.println(mda3);
    }
}
