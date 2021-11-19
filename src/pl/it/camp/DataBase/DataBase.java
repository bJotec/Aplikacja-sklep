package pl.it.camp.DataBase;

import org.apache.commons.codec.digest.DigestUtils;
import pl.it.camp.Products.Products;
import pl.it.camp.authenticate.Authenticator;
import pl.it.camp.authenticate.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBase {

    private Products[] products = new Products[5];

    private List<User> users = new ArrayList<>();
    private static final DataBase instace = new DataBase();


    public DataBase() {

        this.products[0] = new Products(1, "Bulka", 1, 0.44);
        this.products[1] = new Products(2, "Chleb", 2, 4.5);
        this.products[2] = new Products(3, "Jogurt", 3, 5.4);
        this.products[3] = new Products(4, "Herbata", 4, 5.4);
        this.products[4] = new Products(5, "Sok", 5, 4.88);
        this.users.add( new User("admin", DigestUtils.md5Hex(Authenticator.MD5_SEED + "admin")));
        this.users.add( new User("user", DigestUtils.md5Hex(Authenticator.MD5_SEED + "user")));

    }

    private Products findByCode(int kod) {
        for (Products products : this.products) {
            if (products.getKod() == kod) {
                return products;
            }
        }
        return null;
    }

/*    private Products findByIlosc(int kod) {
        for (Products products : this.products) {
            if (products.getKod() == kod) {
                if (products.getIlosc() != 0) {
                    return products;
                }
            }
        }
        return null;
    }*/

    public Products findCurrentList(int kod) {
        Products products = this.findByCode(kod);
        if (products == null || products.isEmpty()) {
            return null;
        } else {
            return products;
        }
    }

/*    public Products findCurrentListIlosc(int ilosc) {

        // ten warunek nie wiem czemu wyrzuca mi .NullPointerException

        Products products = this.findByIlosc(ilosc);
        if (products.getIlosc() == 0) {
            return null;
        } else {
            return products;
        }

    }*/

    public Products[] getproducts   () {return products;}

    public User getUserByLogin (String login) {
        for (User user:this.users){
            if ( user.getLogin().equals(login)){
                return user;
            }
        }

        return  null;
    }

    public Products[] getProducts() {
        return products;
    }



    public static DataBase getInstace() {
        return instace;
    }

}