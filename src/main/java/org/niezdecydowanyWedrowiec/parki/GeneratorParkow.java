package org.niezdecydowanyWedrowiec.parki;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneratorParkow {
    public static void main(String[] args) throws IOException {
        String nazwa = "park1";
        int iloscDrog = 10;
        int X = 10;
        int studzianki = 1;
        int smietnik = 1;
        int wyjcie = 1;

        int ileDrogi = 0;

        boolean[][] drogi = new boolean[X][X];

        Random rand = new Random();

        try (FileWriter writer = new FileWriter(nazwa + ".txt")) {

            // Generowanie podstawowych dróg
            for (int i = 1; i < X - 1; i++) {
                int j = i + 1;
                drogi[i][j] = true;
                ileDrogi++;
                writer.write(i + " " + j + " " + (rand.nextInt(X - 1) + 1) + "\n");
            }

            // Generowanie dodatkowych dróg
            for (int i = 1; i < (X - 1) + iloscDrog; i++) {
                int start = rand.nextInt(X - 1) + 1;
                int koniec = rand.nextInt(X - 1) + 1;

                if (start != koniec && !drogi[start][koniec]) {
                    drogi[start][koniec] = true;
                    ileDrogi++;
                    writer.write(start + " " + koniec + " " + (rand.nextInt(X - 1) + 1) + "\n");
                }
            }

            writer.write("\n");

            writer.write(studzianki + " ");
            losujBezPowtorzen(writer, studzianki, X);

            writer.write("\n");

            writer.write(wyjcie + " ");
            losujBezPowtorzen(writer, wyjcie, X);

            writer.write("\n");

            writer.write("1 " + (rand.nextInt(X - 1) + 1) + "\n");


            writer.write(smietnik + " ");
            losujBezPowtorzen(writer, smietnik, X);

            writer.write("\n");

            writer.write(X + " " + ileDrogi);

        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania do pliku.");
            e.printStackTrace();
        }
    }

    public static void losujBezPowtorzen(FileWriter writer, int X, int Y) throws IOException {
        if (X > Y) {
            System.out.println("Nie można wylosować więcej liczb niż dostępne w zakresie.");
            return;
        }

        Random rand = new Random();
        int[] wylosowane = new int[X];

        for (int i = 0; i < X; i++) {
            int losowaLiczba;
            do {
                losowaLiczba = rand.nextInt(Y) + 1;
            } while (czyZawiera(wylosowane, losowaLiczba));

            wylosowane[i] = losowaLiczba;
            writer.write(losowaLiczba + " ");
        }
    }

    public static boolean czyZawiera(int[] tablica, int liczba) {
        for (int i : tablica) {
            if (i == liczba) {
                return true;
            }
        }
        return false;
    }
}

