package org.niezdecydowanyWedrowiec;

import org.niezdecydowanyWedrowiec.macierz.MacierzRzadka;
import org.niezdecydowanyWedrowiec.macierz.WyjatekMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaMacierz;
import org.niezdecydowanyWedrowiec.prawodpodobienstwa.WersjaPodstawowaSymulacja;

public class Main {
    public static void main(String[] args) {

        MacierzRzadka macierzRzadka = new MacierzRzadka(transpose(WersjaPodstawowaMacierz.macierzPodstawowa()));

        System.out.println(macierzRzadka);

        try {
            System.out.println(macierzRzadka.pobierzWartosc(0,1));
        } catch (WyjatekMacierz e) {
            System.out.println(e.getMessage());
        }


    }

    public static Double[][] transpose(Double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        Double[][] transposedMatrix = new Double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}
