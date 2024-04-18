package org.niezdecydowanyWedrowiec.hipotezy;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.miernikCzasu.MiernikCzasu;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;

public class Hipoteza3 {
    public static void wypiszCzasyAlgo(int iloscTestow, String[] nazwyPlikowArg) {
        String[] nazwyPlikow = new String[] {
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt",
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMM0.txt",
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt"
        };

        if (nazwyPlikowArg != null) {
            nazwyPlikow = nazwyPlikowArg;
        }

        System.out.printf("Srednie czasy wykonanania algorytmów w nanosekundach dla %d prob\n", iloscTestow);

        String aktualnyPlik = Main.nazwaPliku;
        for (int i = 1; i < nazwyPlikow.length + 1; i++) {
            System.out.printf("Test dla %s:\n", aktualnyPlik.split("\\\\")[aktualnyPlik.split("\\\\").length - 1]);
            double sredniaA1 = 0.;
            double sredniaA2 = 0.;
            double sredniaA3 = 0.;
            for (int j = 0; j < iloscTestow; j++) {
                long a1 = MiernikCzasu.zmierzCzasWykonania(() -> {
                    GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
                });

                long a2 = MiernikCzasu.zmierzCzasWykonania(() -> {
                    GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
                });

                long a3 = MiernikCzasu.zmierzCzasWykonania(() -> {
                    GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-6);
                });

                sredniaA1 += a1;
                sredniaA2 += a2;
                sredniaA3 += a3;
//                System.out.printf("Czas wykonania\nA1 %d\nA2 %d\nA3 %d\n", a1, a2, a3);      czasy poszczegolnych testow
            }
            sredniaA1 /= iloscTestow;
            sredniaA2 /= iloscTestow;
            sredniaA3 /= iloscTestow;
            System.out.printf("Sredni czas wykonania:\nA1 %.5f\nA2 %.5f\nA3 %.5f\n", sredniaA1, sredniaA2, sredniaA3);

            aktualnyPlik = nazwyPlikow[i-1];
            Main.nazwaPliku = aktualnyPlik;
        }
    }
}
