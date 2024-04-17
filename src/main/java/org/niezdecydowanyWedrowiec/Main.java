package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
import org.niezdecydowanyWedrowiec.hipotezy.Hipoteza1;
import org.niezdecydowanyWedrowiec.hipotezy.Hipoteza2;
import org.niezdecydowanyWedrowiec.hipotezy.Hipoteza3;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.miernikCzasu.Funkcja;
import org.niezdecydowanyWedrowiec.miernikCzasu.MiernikCzasu;
import org.niezdecydowanyWedrowiec.parki.GeneratorParkow;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.SymulacjaMonteCarlo;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Main {
    public static String nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDD0.txt";
    public static void main(String[] args) {

        new Hipoteza1().podajWynik();
        System.out.println("-------------------------------------------------------------------------");
        new Hipoteza2().podajWynik();
        System.out.println("-------------------------------------------------------------------------");
        Hipoteza3.wypiszCzasyAlgo();
        System.out.println("-------------------------------------------------------------------------");
//


    }
}
