package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;

public class Main {
    public static void main(String[] args) {



//        System.out.println(SimplifiedProbability.calculatePlacesProbabilities(3,4));
//        System.out.println(MonteCarloSimulation.simulate(4,3,100)); // to jest dobrze ;)

        MacierzRzadka macierzRzadka = new MacierzRzadka(3);

        macierzRzadka.ustawWartosc(1,2,10.5);
    }
}
