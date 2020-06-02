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


    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public int getIloscProduktu() {
        return iloscProduktu;
    }

    public void setIloscProduktu(int iloscProduktu) {
        this.iloscProduktu = iloscProduktu;
    }
}
