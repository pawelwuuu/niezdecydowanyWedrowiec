package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.hipotezy.Hipoteza1;
import org.niezdecydowanyWedrowiec.hipotezy.Hipoteza3;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Main {
    public static String nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDD0.txt";
    public static void main(String[] args) {

        Hipoteza1 hipoteza1 = new Hipoteza1();
        hipoteza1.podajWynik();
    }
}
