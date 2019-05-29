package projekt.java.po;

import java.util.Random;

public class Roslina extends Organizm {
    public Roslina() {
    }
    @Override
    public int PobierzInicjatywe() {
        return 0;
    }

    @Override
    public void akcjaCzlowiek(Kierunek k) {

    }

    @Override
    public void akcja(Organizm org) {
        Kierunek k=Kierunek.dol;
        Random generator = new Random();
        int szansa=generator.nextInt(20);
        int kierunek = generator.nextInt(4)+1;
        if (kierunek == 1) {
            k=Kierunek.gora;
        }
        else if (kierunek == 2) {
            k=Kierunek.dol;
        }
        else if (kierunek == 3) {
            k=Kierunek.prawo;
        }
        else if (kierunek == 4) {
            k=Kierunek.lewo;
        }
        if(szansa==1) ruch(k,1);
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
