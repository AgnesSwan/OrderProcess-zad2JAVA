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
 //LOGOWANIE
        klienci1.zaloguj();
//WYBRANIE PRODUKTÓW Z LISTY
        Zamowienie zamowienie = new Zamowienie();
        System.out.println("Wybierz produkty z listy: ");
        for (int i = 0; i < produkty.size(); i++) {
            System.out.println((i + 1) + " " + produkty.get(i));
        }
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Podaj produkt z listy: ");
            int produktZListy = input.nextInt();
            System.out.print("Podaj ilosc produktu: ");
          int ilosc=input.nextInt();
          Produkt wybranyProdukt=produkty.get(produktZListy - 1);
            PozycjaZamowienia pozycjaZamowienia = new PozycjaZamowienia(ilosc, wybranyProdukt);
            zamowienie.dodajPozycjeZamowienia(pozycjaZamowienia);
            System.out.println(pozycjaZamowienia.obliczKwPoz());
            System.out.println("Wybrać kolejny produkt? (Y/N) ");
String decyzja2=input.next();
            System.out.println("Laczna wartosc zamowienia: " + zamowienie.obliczLKwote(pozycjaZamowienia.obliczKwPoz()));

                if (decyzja2.equals("N")||decyzja2.equals("n")) break;


        }
        while (true);
        //Laczna wartosc produktu

        //WYBRANIE FORMY PLATNOSCI
        List<String> platnoscLista = Arrays.asList("Gotowka", "Przelew", "Karta kredytowa");
        System.out.println("Wybierz formę płatności: ");

        for (String platnosc : platnoscLista) {
            System.out.println(platnosc);
        }

            String rodzajPlatn = input.next();

            switch (rodzajPlatn) {
                case "Gotowka":
                    System.out.println("Pobrano gotowke");
                    break;
                case "Przelew":
                    Przelew przelew = new Przelew();
                    przelew.potwierdz();
                    break;
                case "Karta kredytowa":
                    KartaKredytowa karta = new KartaKredytowa();
                    karta.pobierz();
                    karta.potwierdz();
                    break;
                default:
                    System.out.println("Taka forma platnosci nie instnieje");
            }
klienci1.wyloguj();
        }
}






