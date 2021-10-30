package pl.it.camp;

public class AppNawiasyDomkniete {
    public static void main(String[] args) {

        String a = "[ff[ff]f]df][ffa[]ddfg";

        char[] c = a.toCharArray();
        int ile = 0;
        boolean flag = false;

        // liczenie nawiasów - nie jest potrzebne
        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case '[':
                    ile++;
                    break;
                case ']':
                    ile--;
                    break;
                default:
                    break;
            }
        }

        // petla sprawdzająca po kolei nawiasy czy są domkniete

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '[' && ile == 0) {

                for (int j = i + 1; j < c.length; j++) {
                    if (c[j] == ']') {
                        flag = true;
                        ;
                        break;
                    } else {
                        flag = false;
                    }
                }
            } else {
                flag = false;
            }
            break;
        }
        System.out.println("liczenie nawiaów = " + ile);
        System.out.println("Wszystkie nawiasy są domknięte : " + flag);
    }
}
   /*
     int licznik = 0 ;
    for ( char cz : c) {
        if ( cz == '(') {
            licznik ++;
        }
        else if (c==')') {
            licznik--;
        }
        if (licznik <0)
        {
            System.out.println("nawiasy nieprrawidłowe");
                    return;
        }
    }
    if (licznik == 0) {
        System.out.println("Nawiasy ok");
    }*/

