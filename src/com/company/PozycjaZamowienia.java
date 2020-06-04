package com.company;

public class PozycjaZamowienia {
    private Produkt produkt;
    int iloscProduktu;

    public PozycjaZamowienia(int iloscProduktu, Produkt produkt) {
        this.produkt = produkt;
        this.iloscProduktu = iloscProduktu;
    }


    double obliczKwPoz() {
        return iloscProduktu * produkt.cena;
    }



}
