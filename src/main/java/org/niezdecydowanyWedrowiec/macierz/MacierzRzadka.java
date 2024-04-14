package org.niezdecydowanyWedrowiec.macierz;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class MacierzRzadka {
    public int rozmiarMacierzy;
    private final LinkedHashMap<Para, Double> macierzRzadka = new LinkedHashMap<>();

    public MacierzRzadka(int rozmiarMacierzy) {
        this.rozmiarMacierzy = rozmiarMacierzy;
    }

    public MacierzRzadka(Double[][] macierzZwykla) {
        rozmiarMacierzy = macierzZwykla.length;
        for (int i = 0; i < rozmiarMacierzy; i++) {
            for (int j = 0; j < rozmiarMacierzy; j++) {
                if (macierzZwykla[i][j] != 0) {
                    ustawWartosc(i,j, macierzZwykla[i][j]);
                }
            }
        }
    }

    public MacierzRzadka(double[][] macierzZwykla) {
        rozmiarMacierzy = macierzZwykla.length;
        for (int i = 0; i < rozmiarMacierzy; i++) {
            for (int j = 0; j < rozmiarMacierzy; j++) {
                if (macierzZwykla[i][j] != 0) {
                    ustawWartosc(i,j, macierzZwykla[i][j]);
                }
            }
        }
    }

    private class Para {
        int wiersz;
        int kolumna;
        public Para(int wiersz, int kolumna) {
            this.wiersz = wiersz;
            this.kolumna = kolumna;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Para para = (Para) o;
            return wiersz == para.wiersz &&
                    kolumna == para.kolumna;
        }

        @Override
        public int hashCode() {
            return Objects.hash(wiersz, kolumna);
        }
    }

    public boolean czyUstawione(int wiersz, int kolumna) {
        Para para = new Para(wiersz, kolumna);
        return macierzRzadka.containsKey(para);
    }

    public void ustawWartosc(int wiersz, int kolumna, double wartosc) {
        if (wiersz >= rozmiarMacierzy || kolumna >= rozmiarMacierzy) {
            String errStr = String.format("Element w wierszu: %d kolumnie: %d jest poza zakresem macierzy", wiersz, kolumna);
            throw new WyjatekMacierz(errStr);
        }
        Para para = new Para(wiersz, kolumna);
        macierzRzadka.put(para, wartosc);
    }

    public double pobierzWartosc(int wiersz, int kolumna) {
        if (wiersz >= rozmiarMacierzy || kolumna >= rozmiarMacierzy) {
            String errStr = String.format("Element w wierszu: %d kolumnie: %d jest poza zakresem macierzy", wiersz, kolumna);
            throw new WyjatekMacierz(errStr);
        }
        if (!czyUstawione(wiersz, kolumna)) {
            String errStr = String.format("Element w wierszu: %d kolumnie: %d nie jest ustawiony", wiersz, kolumna);
            throw new WyjatekMacierz(errStr);
        }
        return macierzRzadka.get(new Para(wiersz, kolumna));
    }

    public ArrayList<Double> pobierzWiersz(int wiersz) {
        ArrayList<Para> wartosciWiersza = new ArrayList<>();

        for (Para para : macierzRzadka.keySet()) {
            if (para.wiersz == wiersz) {
                wartosciWiersza.add(para);
            }
        }

        ArrayList<Double> wartosciWierszaZeZerami = new ArrayList<>();
        for (int i = 0; i < rozmiarMacierzy; i++) {
            double aktualnaWartoscKolumny = 0.0;
            for(Para para: wartosciWiersza) {
                if (para.kolumna == i) {
                    aktualnaWartoscKolumny = macierzRzadka.get(para);
                }
            }
            wartosciWierszaZeZerami.add(aktualnaWartoscKolumny);
        }

        return wartosciWierszaZeZerami;
    }

    public ArrayList<Double> pobierzKolumne(int kolumna) {
        ArrayList<Para> wartosciKolumny = new ArrayList<>();

        for (Para para : macierzRzadka.keySet()) {
            if (para.kolumna == kolumna) {
                wartosciKolumny.add(para);
            }
        }

        ArrayList<Double> wartosciKolumnyZeZerami = new ArrayList<>();
        for (int i = 0; i < rozmiarMacierzy; i++) {
            double aktualnaWartoscWiersza = 0.0;
            for (Para para : wartosciKolumny) {
                if (para.wiersz == i) {
                    aktualnaWartoscWiersza = macierzRzadka.get(para);
                }
            }
            wartosciKolumnyZeZerami.add(aktualnaWartoscWiersza);
        }

        return wartosciKolumnyZeZerami;
    }

    @Override
    public String toString() {
        String macierzStr = "";
        for (int i = 0; i < rozmiarMacierzy; i++) {
            macierzStr += pobierzWiersz(i) + "\n";
        }

        return macierzStr;
    }
}
