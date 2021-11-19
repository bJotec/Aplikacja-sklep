package pl.it.camp;

import pl.it.camp.DataBase.DataBase;
import pl.it.camp.GUI.GUI;
import pl.it.camp.Products.Products;
import pl.it.camp.authenticate.Authenticator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop {
    public static void main(String[] args) throws IOException {
        DataBase database = DataBase.getInstace();
        GUI gui = GUI.getInstance();
        Authenticator authenticator = Authenticator.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            gui.menu();

            String choose = reader.readLine();

            switch (choose) {
                case "1":
                    for (Products products : database.getProducts()) {
                        gui.printProducts(products);
                    }
                    break;

                case "2":
                    System.out.println("Zaloguj się aby zakupić jakiś produkt");
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Login");
                        String login = reader.readLine();
                        System.out.println("Hasło");
                        String password = reader.readLine();

                        if (!authenticator.authenticate(login, password)) {
                            System.out.println("Nieprawidłowe dane");
                        } else {
                            break;
                        }

                        if (i == 2) {
                            return;
                        }
                    }
                    System.out.println("Wprowadz kod produktu : ");
                    Products products = database.findCurrentList(Integer.parseInt(reader.readLine()));

                    System.out.println("Wprowadz ilosc : ");
                    int ilosc = Integer.parseInt(reader.readLine());

                    if (products == null || products.getIlosc() < ilosc || 0 == ilosc) {
                        System.out.println("Nie ma takiego produktu lub ilosv jest nieprawdziwa");
                    } else {
                        products.setIlosc(products.getIlosc() - ilosc);
                        System.out.println(" Kupiono produkt w ilosci  " + ilosc);
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
