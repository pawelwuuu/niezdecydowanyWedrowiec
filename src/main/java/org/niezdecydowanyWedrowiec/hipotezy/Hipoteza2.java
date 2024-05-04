package org.niezdecydowanyWedrowiec.hipotezy;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.SymulacjaMonteCarlo;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Hipoteza2 {
    double[] rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
    double[] rozwiaz1 = GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
    //double[] rozwiaz = GaussEliminacja.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());
    double suma1;
    double sumaA2;
    double sumaA3;
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
            suma1 += Math.abs(rozwiaz[i] - rozwiaz1[i]);
            sumaA2 += Math.abs(rozwiaz1[i]);
            sumaA3 += Math.abs(rozwiaz[i]);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(sumaA2 + " " + sumaA3 + " " + suma1);


        suma1 = 0;
        sumaA2 = 0;
        sumaA3 = 0;

        System.out.println();
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt";
        rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
        rozwiaz1 = GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());

        System.out.println("MD");
        for(int i = 0; i < rozwiaz.length; i++) {
            suma1 += Math.abs(rozwiaz[i] - rozwiaz1[i]);
            sumaA2 += Math.abs(rozwiaz1[i]);
            sumaA3 += Math.abs(rozwiaz[i]);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(sumaA2 + " " + sumaA3 + " " + suma1);


        suma1 = 0;
        sumaA2 = 0;
        sumaA3 = 0;

        System.out.println();
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt";
        rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
        rozwiaz1 = GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());

        System.out.println("DM");
        for(int i = 0; i < rozwiaz.length; i++) {
            suma1 += Math.abs(rozwiaz[i] - rozwiaz1[i]);
            sumaA2 += Math.abs(rozwiaz1[i]);
            sumaA3 += Math.abs(rozwiaz[i]);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(sumaA2 + " " + sumaA3 + " " + suma1);


        suma1 = 0;
        sumaA2 = 0;
        sumaA3 = 0;

        System.out.println();
        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDD0.txt";
        rozwiaz = GaussSeidel.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
        rozwiaz1 = GaussZCzesciowymWyborem.rozwiaz(WersjaPodstawowaMacierz.macierzPodstawowa(), WersjaPodstawowaMacierz.podajWektorWynikowy());

        System.out.println("DD");
        for(int i = 0; i < rozwiaz.length; i++) {
            suma1 += Math.abs(rozwiaz[i] - rozwiaz1[i]);
            sumaA2 += Math.abs(rozwiaz1[i]);
            sumaA3 += Math.abs(rozwiaz[i]);
            //System.out.println(rozwiaz[i] + " " + WersjaPodstawowaSymulacja.symuluj(1000,i+1));
        }
        System.out.println(sumaA2 + " " + sumaA3 + " " + suma1);


        System.out.println();

    }

}
