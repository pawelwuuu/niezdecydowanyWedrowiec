package org.niezdecydowanyWedrowiec.hipotezy;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.WyswietlaczTablic;
import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.SymulacjaMonteCarlo;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

import static java.lang.Math.abs;

public class Hipoteza1 {


    // pintuje bledy a1 potem bledy a2
    public void podajWynik() {
        String[] nazwyPlikow = new String[] {
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt",
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMM0.txt",
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt",
                "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDD0.txt"
        };

        for (int j = 0; j < nazwyPlikow.length ; j++) {
            String aktualnyPlik = nazwyPlikow[j];
            System.out.printf("Test dla %s:\n", aktualnyPlik.split("\\\\")[aktualnyPlik.split("\\\\").length - 1]);

            //double[] rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
            double[] rozwiaz2 = GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
            double[] rozwiaz1 = GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
            MacierzRzadka macierz = WersjaPodstawowaMacierz.macierzPodstawowa();
            double[] wektorWynikowy = WersjaPodstawowaMacierz.podajWektorWynikowy();
            double suma1, suma2;
            double[] mWynikowaPoMnozeniu1 = new double[macierz.rozmiarMacierzy];
            double[] mWynikowaPoMnozeniu2 = new double[macierz.rozmiarMacierzy];
            double[] roznice1 = new double[macierz.rozmiarMacierzy];
            double[] roznice2 = new double[macierz.rozmiarMacierzy];
            double suma = 0;

            for (MacierzRzadka.Para para : macierz.macierzRzadka.keySet()) {

                mWynikowaPoMnozeniu1[para.getWiersz()] += macierz.pobierzWartosc(para.getWiersz(), para.getKolumna()) * rozwiaz1[para.getKolumna()];
                mWynikowaPoMnozeniu2[para.getWiersz()] += macierz.pobierzWartosc(para.getWiersz(), para.getKolumna()) * rozwiaz2[para.getKolumna()];
            }

            for (int i = 0; i < macierz.rozmiarMacierzy; i++) {
                roznice1[i] = abs(mWynikowaPoMnozeniu1[i] - wektorWynikowy[i]);
                roznice2[i] = abs(mWynikowaPoMnozeniu2[i] - wektorWynikowy[i]);
                suma += roznice1[i] - roznice2[i];

            }
            WyswietlaczTablic.wyswietlTablice(roznice1);
            WyswietlaczTablic.wyswietlTablice(roznice2);
            System.out.println(suma);
            System.out.println();
            Main.nazwaPliku = aktualnyPlik;
        }


    }
//        double[] rozwiaz = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        double[] rozwiaz1 = GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
//

//        obliczSume();
//       // System.out.println(suma1 - suma2);
//        System.out.println(WersjaPodstawowaSymulacja.symuluj(1000000,0));
//        //System.out.println(rozwiaz1[0] - WersjaPodstawowaSymulacja.symuluj(1000,0));
//        }
//
//        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt";
//        rozwiaz = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        rozwiaz1 = GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
//
//
//        System.out.println("gauss - gaussZwyborem");
//        for (int i = 0; i < rozwiaz.length; i++) {
//            System.out.println(rozwiaz[i] - rozwiaz1[i]);
//        }
//        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMM0.txt";
//        rozwiaz = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        rozwiaz1 = GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
//
//
//        System.out.println("gauss - gaussZwyborem");
//        for (int i = 0; i < rozwiaz.length; i++) {
//            System.out.println(rozwiaz[i] - rozwiaz1[i]);
//        }
//        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt";
//        rozwiaz = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        rozwiaz1 = GaussEliminacja.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy());
//
//
//        System.out.println("gauss - gaussZwyborem");
//        for (int i = 0; i < rozwiaz.length; i++) {
//            System.out.println(rozwiaz[i] - rozwiaz1[i]);



}
