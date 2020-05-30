package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        List<Zamowienie> Zamowienia;
        List<Klient> klienci = new ArrayList<>();
        Klient klienci1 = new Klient("Kasia", "Gdansk", "wp.pl", "Y", new RodzajK("VIP"));
        klienci.add(klienci1);
        List<Produkt> produkty = new ArrayList<>();
        Produkt produkty1 = new Produkt("Koc", 100.5, "Pepco", new Wymiary(20, 20), 20, "fcvgbhnjkml,");
        Produkt produkty2 = new Produkt("Koc1", 100.5, "Pepco", new Wymiary(20, 20), 20, "fcvgbhnjkml,");
        Produkt produkty3 = new Produkt("Koc2", 100.5, "Pepco", new Wymiary(20, 20), 20, "fcvgbhnjkml,");
        produkty.add(produkty1);
        produkty.add(produkty2);
        produkty.add(produkty3);
        klienci1.zaloguj();

        Zamowienie zamowienie = new Zamowienie();
        System.out.println("Wybierz produkty z listy: ");
        for (int i = 0; i < produkty.size(); i++) {
            System.out.println(String.valueOf(i+1) +" "+produkty.get(i));
        }
        Scanner input = new Scanner(System.in);
int produktZListy=input.nextInt();
PozycjaZamowienia pozycjaZamowienia=new PozycjaZamowienia(1, produkty.get(produktZListy-1));
zamowienie.dodajPozycjeZamowienia(pozycjaZamowienia);
        List<String> platnoscLista = Arrays.asList("Gotowka", "Przelew", "Karta kredytowa");

        System.out.println("Wybierz formę płatności: ");

        for (String platnosc : platnoscLista) {
            System.out.println(platnosc);
        }
        String forma = input.next();
        switch (forma) {
            case "Gotowka":
                System.out.println("Pobrano gotowke");
                break;
            case "Przelew":
                System.out.println("Przelew wykonano");
                break;
            case "Karta kredytowa":
                System.out.println("Karta");
                break;
            default:
                System.out.println("Taka forma platnosci nie instnieje");

        }


    }
}

//Platnosc
class FormaPlatnosci {

}

class Platnosc {
    Object rodzajPlatn;
    Double kwota;


}

class Przelew extends FormaPlatnosci {
    String nazwBanku = "";
    String nrKonta = "";

    void potwierdz() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Podaj nr konta");

            nrKonta = input.next();
            if (nrKonta.length() == 26 || nrKonta.length() == 32) {
            } else System.out.println("Zbyt krótki nr konta");
        }

        while (!(nrKonta.length() == 26) || !(nrKonta.length() == 32));
        System.out.println("Podaj nazwę Banku");
        nazwBanku = input.next();
        System.out.println("Przelew zostanie wykonany na rachunek: " + nrKonta + " w banku: " + nazwBanku);
        System.out.print("Potwierdzenie operacji: (Y/N) ");
        String potw = input.next();
        if (potw.equals("y") || potw.equals("Y")) {
            System.out.println("Przelew został zlecony");
        } else if (potw.equals("n") || potw.equals("N")) {
            System.out.println("Przelew anulowano");
        } else System.out.println("Błędna polecenie. Spróbuj ponownie");
    }
}


class Gotowka extends FormaPlatnosci {

}

class KartaKredytowa extends FormaPlatnosci {
    protected String wlasciciel = "";
    protected Date dataWazn = new Date();

    void pobierz() {
        System.out.println("Pobierz gotówkę");
    }

    void potwierdz() {
        System.out.println("Potwierdzono");

    }
}

//PRODUKT I ZAMÓWIENIE

class Produkt {
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

class PozycjaZamowienia {
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

//ZAMÓWIENIE
class Zamowienie {
    Klient klient;
    Date dataZlozenia;
    private int liczbaPoz;
    Object status;
    Boolean rabat;
    Boolean faktura;
    public List<PozycjaZamowienia> wybraneProdukty=new ArrayList<>();
    public List<FormaPlatnosci> platnoscList=new ArrayList<>();

    public void dodajPozycjeZamowienia(PozycjaZamowienia pozycjaZamowienia) {
        this.wybraneProdukty.add(pozycjaZamowienia);
    }

    public void dodajPlatnosc(FormaPlatnosci formaPlatnosci) {
        this.platnoscList.add(formaPlatnosci);
    }


    void zmienPoz() {

    }

    void usunPoz(PozycjaZamowienia pozycja) {
        // if (this.wybraneProdukty.contains(pozycja)) -->
        this.wybraneProdukty.remove(pozycja);
    }

    void analizuj() {
        System.out.println("Analizowanie...");
    }

    private double obliczLKwote() {
        double cost = 0.0D;

        for (PozycjaZamowienia pozycjaZamowienia : wybraneProdukty) {
            cost += pozycjaZamowienia.obliczKwPoz();
        }

        return cost;
    }

}
//KLIENT

class Klient {
    String nazwa = "Agnieszka";
    String adres;
    String email;
    String zgoda;
    Object rodzajK;

    public Klient(String nazwa, String adres, String email, String zgoda, Object rodzajK) {
        this.nazwa = nazwa;
        this.adres = adres;
        this.email = email;
        this.zgoda = zgoda;
        this.rodzajK = rodzajK;
    }

    void zarejestruj() {
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj nazwę użytkownika: ");
        nazwa = input.next();
        System.out.print("Podaj adres: ");
        adres = input.next();
        System.out.print("Podaj email: ");
        email = input.next();
        System.out.print("Czy wyrażasz zgodę na przetwarzanie danych? (Y/N):  ");
        zgoda = input.next();
    }

    void zaloguj() {
        Scanner input = new Scanner(System.in);
        String user;
        do {
            System.out.print("Aby się zalogować podaj nazwę użytkownika: ");
            user = input.next();
            if (user.equals(nazwa)) {
                System.out.println("Zalogowano");
            } else System.out.println("Błędne dane. Spróbuj ponownie");

        }
        while (!user.equals(nazwa));
        nazwa = user;
    }

    void wyloguj() {
        System.out.println("Wylogowano");
    }

    void usun() {
        Scanner input = new Scanner(System.in);
        System.out.print("Czy na pewno usunąć użytkownika? (Y/N) ");
        String potw = input.next();
        if (potw.equals("y") || potw.equals("Y")) {
            System.out.println("Usunięto użytkownika");
            nazwa = null;
        } else if (potw.equals("n") || potw.equals("N")) {
            System.out.println("Zrezygnowano z usunięcia użytkownika");
        } else System.out.println("Błędna polecenie. Spróbuj ponownie");
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

class RodzajK {
    String rodzaj;

    public RodzajK(String rodzaj) {
    }
}