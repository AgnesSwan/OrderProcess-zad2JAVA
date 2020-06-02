package com.company;

import java.util.Scanner;

public class Klient {
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

class RodzajK {
    String rodzaj;

    public RodzajK(String rodzaj) {
    }
}
