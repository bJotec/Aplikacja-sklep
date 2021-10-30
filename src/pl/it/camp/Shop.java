package pl.it.camp;

import pl.it.camp.DataBase.DataBase;
import pl.it.camp.GUI.GUI;
import pl.it.camp.Products.Products;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop {
    public static void main(String[] args) throws IOException {
        DataBase database = new DataBase();
        GUI gui = new GUI();

        while(true) {
            gui.menu();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String choose = reader.readLine();


            switch (choose) {
                case "1":
                    for (Products products: database.getProducts()) {
                        gui.printProducts(products);

                    }
                    break;
                case "2":
                    System.out.println("Wprowadz kod produktu : " );
                    Products products = database.findCurrentList(Integer.parseInt(reader.readLine()));

                    System.out.println("Wprowadz ilosc : " );
                    int ilosc = Integer.parseInt(reader.readLine());

                    if (products == null || products.getIlosc() < ilosc ||  0 == ilosc )  {
                        System.out.println("Nie ma takiego produktu lub ilosv jest nieprawdziwa");
                    }

                    else {
                       products.setIlosc(products.getIlosc()- ilosc) ;
                        System.out.println(" Kupiono produkt w ilosci  " + ilosc  );
                    }
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór");
            }
        }
    }
}
