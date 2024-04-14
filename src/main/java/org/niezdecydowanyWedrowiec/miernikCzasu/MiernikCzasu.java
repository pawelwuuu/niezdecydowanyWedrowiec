package org.niezdecydowanyWedrowiec.miernikCzasu;

/**
 * Klasa umożliwiająca pomiar czasu wykonania funkcji.
 */
public class MiernikCzasu {

    /**
     * Metoda mierząca czas wykonania funkcji.
     * @param funkcja Obiekt implementujący interfejs Funkcja, którego metoda zostanie wykonana.
     * @return Czas wykonania funkcji w milisekundach.
     */
    public static long zmierzCzasWykonania(Funkcja funkcja) {
        long czasStartu = System.currentTimeMillis();
        funkcja.wykonaj();
        long czasKonca = System.currentTimeMillis();

        return czasKonca - czasStartu;
    }
}
