package pl.it.camp.GUI;

import pl.it.camp.Products.Products;

public class GUI {


    private static final GUI instance = new GUI();

    private GUI() {

    }
    public static void menu() {
        System.out.println("1. Listwa produktów");
        System.out.println("2. Kup produkt ");
        System.out.println("3. Wyjdz");
    }

    public int printProducts(Products products) {
        if (products.getIlosc() > 0) {
            System.out.println(products.getKod() + ". " + products.getNazwa() + "  -  ilosc dostepna: " + products.getIlosc() + "  -  cena: " + products.getPrice());
        } else {
            System.out.println();
        }

        System.out.println();
        return 0;

    }

    public static GUI getInstance(){
        return instance;
    }
}


