package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import org.niezdecydowanyWedrowiec.Main;
import org.niezdecydowanyWedrowiec.WczytaniePliku;
import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa implementująca podstawową wersję symulacji wedrowania po parku.
 */
public class WersjaPodstawowaSymulacja {
    /** Obecna pozycja w parku. */
    public static int obecnie;

    /** Tablica reprezentująca skrzyżowania w parku. */
    public static MacierzRzadka skrzyrzowania;    /*
                                                0 - czy wejście
                                                1 - czy studzienka
                                                2 - miejsce startowe
                                                3 - czy śmietnik
                                                */

    /** Tablica reprezentująca czasy podróży między skrzyżowaniami. */
    public static MacierzRzadka drogi;

    /**
     * Metoda symulująca podróż po parku.
     * @param iloscSymulacji Liczba symulacji do przeprowadzenia.
     * @return Prawdopodobieństwo sukcesu wyjścia z parku.
     */
    public static double symuluj(int iloscSymulacji, int obecnieee)
    {
        WczytaniePliku.czytajDaneZPliku(Main.nazwaPliku);
        drogi = WczytaniePliku.drogi;
        skrzyrzowania = WczytaniePliku.skrzyrzowania;
        obecnie = obecnieee;//WczytaniePliku.obecnie;

        Random random = new Random();



        double sukces = 0;

        for(int i = 0; i < iloscSymulacji; i++) {    //Przeprowadza N symulacji wyjścia z parku
            obecnie = obecnieee;
            if (czyWyjdzie(random)) {
                sukces++;
            }
        }
        return (sukces / iloscSymulacji);
    }

    /**
     * Metoda sprawdzająca, czy osoba wyjdzie z parku.
     * @param random Generator liczb losowych.
     * @return True, jeśli osoba wyjdzie z parku; False, jeśli wpadnie do studzienki.
     */
    public static boolean czyWyjdzie(Random random)
    {
//        for(int i = 0; i < skrzyrzowania[0].length; i++) {  //ustala miejsce startu
//            if(skrzyrzowania[2][i])
//                obecnie = i+1;
//        }

        while(!(skrzyrzowania.pobierzWartosc(0, obecnie-1) == 1.0 || skrzyrzowania.pobierzWartosc(1, obecnie -1) == 1.0)) {
//        while(!(skrzyrzowania[0][obecnie-1] || skrzyrzowania[1][obecnie-1])) {
//            int i = wyburDrogi(random);                                                                 //losuje nową droge
            //if(SymulacjaMonteCarlo.symuluj(drogi[obecnie - 1][i - 1]-1, 1, 1) != 0.0) {        //próbuje przez nią przejść
//                obecnie = i;                                                                             //jeżeli przejdzie ustala nowe miejsce wedrowcy
//            }
            obecnie = symulujDroge(random);
            //return false;
        }

        if(skrzyrzowania.pobierzWartosc(0,obecnie-1) == 1.0)
//        if(skrzyrzowania[0][obecnie-1])                                         //zwraca true jeżeli wędrowiec wyjdzie oraz false gdy wpadnie do studzianki
            return false;
        else
            return true;
    }

    /**
     * Metoda losująca drogę.
     * @param random Generator liczb losowych.
     * @return Numer skrzyżowania, na które należy się udać.
     */
    public static int symulujDroge(Random random) {
        //System.out.println(obecnie + " obecnie ---------");
        ArrayList<Integer> dlugosci = new ArrayList<>();
        ArrayList<Integer> nrSkrzyrzowania = new ArrayList<>();
        for(int i = 0; i < drogi.rozmiarMacierzy; i++)
        {
            if(drogi.pobierzWartosc(obecnie -1, i) != 0.0) {
                dlugosci.add((int) drogi.pobierzWartosc(obecnie -1, i));
                nrSkrzyrzowania.add(i);
            }
        }
        int[] wyniki = new int[dlugosci.size()];
        int wybrana = 0;
        while(wyniki[wybrana] != dlugosci.get(wybrana)+1)
        {
           //System.out.println(wybrana + " " + wyniki[wybrana] + " = " + dlugosci.get(wybrana));
            if(wyniki[wybrana] == 0)
            {
                wybrana = random.nextInt(dlugosci.size());
                wyniki[wybrana]++;
            }
            else
            {
                if(random.nextInt(2) == 0)
                    wyniki[wybrana]++;
                else
                    wyniki[wybrana]--;
            }

        }
        //System.out.println(wybrana + " " + wyniki[wybrana] + " = " + dlugosci.get(wybrana));
        return nrSkrzyrzowania.get(wybrana)+1;
    }


//    public static int wyburDrogi(Random random)
//    {
//        int i = 0;
//        boolean gotowe = false;
//        do{
//            i = random.nextInt(skrzyrzowania[0].length * 2);
//            int j = i / 2;
//
//            // System.out.println("i: " + i + " drogi[" + (obecnie-1) + "][" + j + "] = " + drogi[obecnie-1][i/2]);
//
//            if(drogi[obecnie-1][j] != 0)
//                if((i%2==0 || !skrzyrzowania[3][j]))
//                    gotowe = true;
//        }while(!gotowe);       //sprawdza czy istnieje droga z obecnego miesca do skrzyrzowania i
//        return i/2+1;
//    }
}
