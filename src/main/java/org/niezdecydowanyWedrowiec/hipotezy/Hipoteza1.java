package org.niezdecydowanyWedrowiec.hipotezy;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.SymulacjaMonteCarlo;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Hipoteza1 {
    //double[] rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
    double[] rozwiaz1 = GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
    double[] rozwiaz = GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
    double suma1, suma2;
//
//    public void obliczSume() {
//        suma1 = obliczSumeTablicy(rozwiaz);
//        suma2 = obliczSumeTablicy(rozwiaz1);
//    }
//    private double obliczSumeTablicy(double[] tablica) {
//        double suma = 0;
//        for (double element : tablica) {
//            suma += element;
//        }
//        return suma;
//    }
//
//
    public void podajWynik() {

        System.out.println("MM");
        for(int i = 0; i < rozwiaz.length; i++) {
            double monte = WersjaPodstawowaSymulacja.symuluj(100000,i+1);
            suma1 += Math.abs(rozwiaz[i] - monte );
            suma2 += Math.abs(rozwiaz1[i] - monte);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(suma1);
        System.out.println(suma2);
        System.out.println(suma1 - suma2);
        suma1 = 0;
        suma2 = 0;

        System.out.println();
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt";
        rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
        rozwiaz1 = GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());

        System.out.println("MD");
        for(int i = 0; i < rozwiaz.length; i++) {
            double monte = WersjaPodstawowaSymulacja.symuluj(100000,i+1);
            suma1 += Math.abs(rozwiaz[i] - monte);
            suma2 += Math.abs(rozwiaz1[i] - monte);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(suma1);

        System.out.println(suma2);
        System.out.println(suma1 - suma2);

        suma1 = 0;
        suma2 = 0;

        System.out.println();
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt";
        rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
        rozwiaz1 = GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());

        System.out.println("DM");
        for(int i = 0; i < rozwiaz.length; i++) {
            double monte = WersjaPodstawowaSymulacja.symuluj(10000,i+1);
            suma1 += Math.abs(rozwiaz[i] - monte);
            suma2 += Math.abs(rozwiaz1[i] - monte);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(suma1);

        System.out.println(suma2);
        System.out.println(suma1 - suma2);

        suma1 = 0;
        suma2 = 0;

        System.out.println();
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDD0.txt";
        rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
        rozwiaz1 = GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());

        System.out.println("DD");
        for(int i = 0; i < rozwiaz.length; i++) {
            double monte = WersjaPodstawowaSymulacja.symuluj(10000,i+1);
            suma1 += Math.abs(rozwiaz[i] - monte);
            suma2 += Math.abs(rozwiaz1[i] - monte);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(suma1);
        System.out.println(suma2);
        System.out.println(suma1 - suma2);

        suma1 = 0;
        suma2 = 0;

        System.out.println();

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
