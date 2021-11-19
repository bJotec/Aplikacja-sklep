package pl.it.camp.authenticate;

import org.apache.commons.codec.digest.DigestUtils;
import pl.it.camp.DataBase.DataBase;

public class Authenticator {

    public static final String MD5_SEED = "Gd5xAm9OepHO5A1WnYN1IScrSbHgDiRK" ;

    private static final Authenticator instance = new Authenticator();

    private Authenticator(){
    }

    public static boolean authenticate (String login, String password) {

        DataBase dataBase = DataBase.getInstace();
        User user = dataBase.getUserByLogin(login);
        return user != null && user.getPassword().equals(DigestUtils.md5Hex(MD5_SEED + password));


    }

    public static Authenticator getInstance(){
        return instance;
    }
}