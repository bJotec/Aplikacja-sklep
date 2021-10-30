package pl.it.camp;

        public class PotegowanieRekurencyjne {


    int potega(int l, int p) {

        if (p == 0) {
            return 1;

        }
        return l * potega(l, --p);
    }

    public static void main(String[] args) {

        PotegowanieRekurencyjne potega = new PotegowanieRekurencyjne();
        System.out.println(potega.potega(2, 3));


    }
}
