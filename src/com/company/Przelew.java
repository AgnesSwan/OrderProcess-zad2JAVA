package com.company;

import java.util.Scanner;

public class Przelew extends Platnosc {

    String nazwBanku = "";
    String nrKonta = "";

    void potwierdz() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Podaj nr konta");

            nrKonta = input.next();
            if (!(nrKonta.length() == 26) || !(nrKonta.length() == 32)) break;
            else
                {System.out.println("Zbyt krótki nr konta");}
        }

        while (true);
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
