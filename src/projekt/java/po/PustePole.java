package projekt.java.po;

public class PustePole extends Organizm {
    public PustePole() {
    }

    @Override
    public void akcjaCzlowiek(Kierunek k) {

    }

    @Override
   public int PobierzInicjatywe() {
        return 0;
    }

    @Override
    public void akcja(Organizm org) {
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek k) {

    }

    @Override
    public void rysowanie() {

    }

    @Override
    public void ruch(Kierunek k, int dystans) {

    }

    @Override
    public Organizm urodziny(Pozycja p) {
        return null;
    }

    @Override
    public char znak() {
        return 0;
    }

    @Override
    public String wypisz() {
        return null;
    }

    @Override
    public Pozycja PobierzPozycje() {
        return null;
    }

    @Override
    public int PobierzWIek() {
        return 0;
    }

    @Override
    public int PobierzSile() {
        return 0;
    }
}
