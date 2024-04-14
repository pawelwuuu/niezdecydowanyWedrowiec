package org.niezdecydowanyWedrowiec.prawodpodobienstwa;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WersjaPodstawowaSymulacja {
    public static int obecnie;
    public static boolean[][] skrzyrzowania;    /*
                                                0 - czy wejscie
                                                1 - czy studzienka
                                                2 - miejsce startowe
                                                3 - czy smietnik
                                                */
    public static int[][] drogi;    //czas drogi między m i n skrzyrzowaniem

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
