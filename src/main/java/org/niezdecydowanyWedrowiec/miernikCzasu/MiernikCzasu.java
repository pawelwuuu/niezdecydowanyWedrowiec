package org.niezdecydowanyWedrowiec.miernikCzasu;

public class MiernikCzasu {
    public static long zmierzCzasWykonania(Funkcja funkcja) {
        long czasStartu = System.currentTimeMillis();
        funkcja.wykonaj();
        long czasKonca = System.currentTimeMillis();

        return czasKonca - czasStartu;
    }
}
