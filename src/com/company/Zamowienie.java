package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zamowienie {
    Klient klient;
    Date dataZlozenia;
    private int liczbaPoz;
    private double lacznaKwota;
    Object status;
    Boolean rabat;
    Boolean faktura;
    public List<PozycjaZamowienia> wybraneProdukty = new ArrayList<>();
    public List<Platnosc> platnoscList = new ArrayList<>();

    public void dodajPozycjeZamowienia(PozycjaZamowienia pozycjaZamowienia) {
        this.wybraneProdukty.add(pozycjaZamowienia);
    }

    public void dodajPlatnosc(Platnosc rodzajPlatnosci) {
        this.platnoscList.add(rodzajPlatnosci);
    }


    void zmienPoz() {
        System.out.println("Zmiana pozycji");
    }

    void usunPoz(PozycjaZamowienia pozycja) {
        this.wybraneProdukty.remove(pozycja);
    }

    void analizuj() {
        System.out.println("Analizowanie...");
    }

double obliczLKwote(double v) {
        double cost = 0.0D;

      for (PozycjaZamowienia pozycjaZamowienia: wybraneProdukty ) {
            cost += pozycjaZamowienia.obliczKwPoz();

      }

        return cost;
    }

}