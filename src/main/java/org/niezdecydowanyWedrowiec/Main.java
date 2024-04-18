package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Main {
    public static String nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMM0.txt";
    public static void main(String[] args) {

//        double[] rozwiaz = GaussZCzesciowymWyborem.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
//        double[] rozwiaz1 = GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
//        double[] rozwiaz2 = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        WyswietlaczTablic.wyswietlTablice(rozwiaz);
//        WyswietlaczTablic.wyswietlTablice(rozwiaz1);
//        WyswietlaczTablic.wyswietlTablice(rozwiaz2);


//        new Hipoteza2().podajWynik();
//

        System.out.println(WersjaPodstawowaMacierz.macierzPodstawowa());
        System.out.println(WersjaPodstawowaSymulacja.symuluj(100000,3));
//        MacierzRzadka macierzRzadka = WersjaPodstawowaMacierz.macierzPodstawowa();
//        macierzRzadka.macierzRzadka.values().forEach(System.out::println);
    }
}
