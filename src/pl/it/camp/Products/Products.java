package pl.it.camp.Products;

public class Products {

    private String nazwa;
    public int ilosc;
    public int kod;
    private double price;
    private boolean empty;

    public Products(int kod, String nazwa, int ilosc, double price) {
        this.kod = kod;
        this.nazwa = nazwa;
        this.ilosc = ilosc;
        this.price = (double) price;
        this.empty = false;
    }

    public Products(int ilosc) {

        this.ilosc = ilosc;

    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIlosc() {
        return ilosc;
    }

    public double getPrice() {
        return price;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }


    public int getKod() {
        return kod;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public boolean setEmpty() {
        return empty;
    }
}
