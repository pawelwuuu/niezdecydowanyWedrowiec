//package org.niezdecydowanyWedrowiec.hipotezy;
//
//import org.niezdecydowanyWedrowiec.Main;
//import org.niezdecydowanyWedrowiec.WyswietlaczTablic;
//import org.niezdecydowanyWedrowiec.algorytmy.GaussEliminacja;
//import org.niezdecydowanyWedrowiec.algorytmy.GaussSeidel;
//import org.niezdecydowanyWedrowiec.algorytmy.GaussZCzesciowymWyborem;
//import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
//import org.niezdecydowanyWedrowiec.miernikCzasu.Funkcja;
//import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
//import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;
//
//public class Hipoteza2 {
//    public void podajWynik() {
//        System.out.println(WersjaPodstawowaSymulacja.symuluj(10000));
//        double[] rozwiazParkDD0 = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkDM0.txt";
//        System.out.println(WersjaPodstawowaSymulacja.symuluj(10000));
//        double[] rozwiazParkDM0 = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMM0.txt";
//        System.out.println(WersjaPodstawowaSymulacja.symuluj(10000));
//        double[] rozwiazParkMM0 = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//        Main.nazwaPliku = "src\\main\\java\\org\\niezdecydowanyWedrowiec\\parki\\parkMD0.txt";
//        System.out.println(WersjaPodstawowaSymulacja.symuluj(10000));
//        double[] rozwiazParkMD0 = GaussSeidel.rozwiaz(new MacierzRzadka(WersjaPodstawowaMacierz.macierzPodstawowa()), WersjaPodstawowaMacierz.podajWektorWynikowy(), 10000, 1e-20);
//
//
//        System.out.println(rozwiazParkDD0[0]);
//        System.out.println(rozwiazParkDM0[0]);
//        System.out.println(rozwiazParkMM0[0]);
//        System.out.println(rozwiazParkMD0[0]);
//
//    }
//
//}
