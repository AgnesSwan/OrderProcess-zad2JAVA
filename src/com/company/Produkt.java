package com.company;

public class Produkt {
    String nazwa;
    double waga;
    String producent;
    Object wymiary;
    double cena;
    String opis;

    public Produkt(String nazwa, double waga, String producent, Object wymiary, double cena, String opis) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.producent = producent;
        this.wymiary = wymiary;
        this.cena = cena;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return this.nazwa + " " + this.waga + " " + this.cena;
    }
}

class Wymiary {
    double szer;
    double dł;

    public Wymiary(double szer, double dł) {
        this.szer = szer;
        this.dł = dł;
    }
}