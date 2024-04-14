package org.niezdecydowanyWedrowiec.prawodpodobienstwa;

import org.niezdecydowanyWedrowiec.WczytaniePliku;

import java.util.Random;

/**
 * Klasa implementująca podstawową wersję symulacji wedrowania po parku.
 */
public class WersjaPodstawowaSymulacja {
    /** Obecna pozycja w parku. */
    public static int obecnie;

    /** Tablica reprezentująca skrzyżowania w parku. */
    public static boolean[][] skrzyrzowania;    /*
                                                0 - czy wejście
                                                1 - czy studzienka
                                                2 - miejsce startowe
                                                3 - czy śmietnik
                                                */

    /** Tablica reprezentująca czasy podróży między skrzyżowaniami. */
    public static int[][] drogi;

    /**
     * Metoda symulująca podróż po parku.
     * @param n Liczba symulacji do przeprowadzenia.
     * @return Prawdopodobieństwo sukcesu wyjścia z parku.
     */
    public static double podruz(int n)
    {
        WczytaniePliku.czytajDaneZPliku("src\\main\\java\\org\\niezdecydowanyWedrowiec\\park.txt");
        drogi = WczytaniePliku.drogi;
        skrzyrzowania = WczytaniePliku.skrzyrzowania;
        obecnie = WczytaniePliku.obecnie;

        Random random = new Random();

        double sukces = 0;

        for(int i = 0; i < n; i++)      //Przeprowadza N symulacji wyjścia z parku
            if(czyWyjdzie(random))
                sukces++;

        return (sukces / n);
    }

    /**
     * Metoda sprawdzająca, czy osoba wyjdzie z parku.
     * @param random Generator liczb losowych.
     * @return True, jeśli osoba wyjdzie z parku; False, jeśli wpadnie do studzienki.
     */
    public static boolean czyWyjdzie(Random random)
    {
        for(int i = 0; i < skrzyrzowania[0].length; i++) {  //ustala miejsce startu
            if(skrzyrzowania[2][i])
                obecnie = i+1;
        }

        do {
            int i = wyburDrogi(random);                                                                 //losuje nową droge
            if(SymulacjaMonteCarlo.symuluj(drogi[obecnie - 1][i - 1], 1, 1) != 0.0) {        //próbuje przez nią przejść
                obecnie = i;                                                                            //jeżeli przejdzie ustala nowe miejsce wedrowcy
            }
        }while(!(skrzyrzowania[0][obecnie-1] || skrzyrzowania[1][obecnie-1]));

        if(skrzyrzowania[0][obecnie-1])                                         //zwraca true jeżeli wędrowiec wyjdzie oraz false gdy wpadnie do studzianki
            return false;
        else
            return true;
    }

    /**
     * Metoda losująca drogę.
     * @param random Generator liczb losowych.
     * @return Numer skrzyżowania, na które należy się udać.
     */
    public static int wyburDrogi(Random random)
    {
        int i = 0;
        boolean gotowe = false;
        do{
            i = random.nextInt(skrzyrzowania[0].length * 2);
            int j = i / 2;

            // System.out.println("i: " + i + " drogi[" + (obecnie-1) + "][" + j + "] = " + drogi[obecnie-1][i/2]);

            if(drogi[obecnie-1][j] != 0)
                if((i%2==0 || !skrzyrzowania[3][j]))
                    gotowe = true;
        }while(!gotowe);       //sprawdza czy istnieje droga z obecnego miesca do skrzyrzowania i
        return i/2+1;
    }
}
