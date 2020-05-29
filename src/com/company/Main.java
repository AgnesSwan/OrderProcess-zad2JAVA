package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Klient klient=new Klient();

	klient.zaloguj();
    }
}
//Platnosc

class Platnosc  {
    Object rodzajPlatn;
    Double kwota;

    public ArrayList<Zamowienie> zamowienie;

}
class Przelew extends Platnosc{
    String nazwBanku="";
    String nrKonta="";
    void potwierdz() {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Podaj nr konta");

        nrKonta = input.next();
        if (nrKonta.length() == 26 || nrKonta.length() ==32) {
        }
        else System.out.println("Zbyt krótki nr konta");
        }

    while (!(nrKonta.length() ==26) || !(nrKonta.length()==32));
System.out.println("Podaj nazwę Banku");
nazwBanku = input.next();
        System.out.println("Przelew zostanie wykonany na rachunek: " + nrKonta + " w banku: "+ nazwBanku);
        System.out.print("Potwierdzenie operacji: (Y/N) ");
        String potw=input.next();
        if (potw.equals("y")||potw.equals("Y")){
            System.out.println("Przelew został zlecony");
            }
        else if(potw.equals("n")||potw.equals("N")){
            System.out.println("Przelew anulowano");
        }
        else System.out.println("Błędna polecenie. Spróbuj ponownie");
    }
}


class Gotowka extends Platnosc{

}
class KartaKredytowa extends Platnosc {
   protected String wlasciciel="";
  protected   Date dataWazn=new Date();
  void pobierz(){
      System.out.println("Pobierz gotówkę");
  }
    void potwierdz(){
        System.out.println("Potwierdzono");

    }
}

//PRODUKT I ZAMÓWIENIE

class Produkt{
    String nazwa ;
    double waga;
    String producent;
    Object wymiary;
    double cena;
    String opis;



    private List<PozycjaZamowienia> wybraneProdukty;

}
class PozycjaZamowienia extends Produkt{
    int iloscProduktu;
    double obliczKwPoz(){
        return iloscProduktu*cena;
    }
}

//ZAMÓWIENIE
class Zamowienie {
Date dataZlozenia;
//enum status;
private int liczbaPoz;
Object status;
Boolean rabat;
Boolean faktura;
//metody
    void dodajPoz(){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nazwę produktu: ");
    }


    private double obliczKwote() {
        double cost = 0.0D;

       //for (Product product : purchasedProducts) {
       //     cost += product.getPrice();
       // }

        return cost;
    }
}
//KLIENT

class Klient {
    String nazwa="Agnieszka";
    String adres;
    String email;
    String zgoda;
    Object rodzajK;

void zarejestruj(){
    Scanner input= new Scanner(System.in);
    System.out.print("Podaj nazwę użytkownika: ");
nazwa=input.next();
    System.out.print("Podaj adres: ");
adres=input.next();
    System.out.print("Podaj email: ");
    email=input.next();
    System.out.print("Czy wyrażasz zgodę na przetwarzanie danych? (Y/N):  ");
    zgoda=input.next();
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
    nazwa=user;
}
void wyloguj(){
    System.out.println("Wylogowano");
}
void usun(){
    Scanner input= new Scanner(System.in);
    System.out.print("Czy na pewno usunąć użytkownika? (Y/N) ");
    String potw=input.next();
    if (potw.equals("y")||potw.equals("Y")){
        System.out.println("Usunięto użytkownika");
        nazwa=null;
    }
    else if(potw.equals("n")||potw.equals("N")){
        System.out.println("Zrezygnowano z usunięcia użytkownika");
    }
    else System.out.println("Błędna polecenie. Spróbuj ponownie");
}
}
