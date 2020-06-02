package com.company;

import java.util.Date;

public class KartaKredytowa extends Platnosc {

    protected String wlasciciel = "";
    protected Date dataWazn = new Date();

    void pobierz() {
        System.out.println("Pobierz gotówkę");
    }

    void potwierdz() {
        System.out.println("Opłatę pobrano");

    }

}
