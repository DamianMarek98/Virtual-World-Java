package projekt.java.po;

import java.util.Random;

public class Mlecz extends Roslina {
    public Mlecz(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=0;
        this.sila=0;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }

    @Override
    public void akcja(Organizm org) {
        for (int i = 0; i < 3; i++) {
            Kierunek k=Kierunek.dol;
            Random generator = new Random();
            int szansa=generator.nextInt(20)+1;
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
           if(szansa==2) ruch(k,1);
        }
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek kierunek) {
        swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
        swiat.Usun(nastepny);
        if (kierunek == Kierunek.gora) {
            org.pozycja.x--;
        }
        else if (kierunek == Kierunek.dol) {
            org.pozycja.x++;
        }
        else if (kierunek == Kierunek.prawo) {
            org.pozycja.y++;
        }
        else if (kierunek == Kierunek.lewo) {
            org.pozycja.y--;
        }
        swiat.pole[org.pozycja.x][org.pozycja.y] = org;
        swiat.text.add("Mlecz zostal zjedzony przez: "+org.wypisz());
    }

    @Override
    public void ruch(Kierunek kierunek, int dystans){
        if (kierunek == Kierunek.gora) {
            if (pozycja.x - 1 > -1) {
                Pozycja x=new Pozycja(pozycja.x - 1,pozycja.y);
                if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof PustePole) swiat.Dodaj(new Mlecz(swiat, x),x);
            }
        }
        else if (kierunek == Kierunek.dol) {
            if (pozycja.x + 1 < swiat.getX()) {
                Pozycja x=new Pozycja(pozycja.x + 1,pozycja.y);
                if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof  PustePole) swiat.Dodaj(new Mlecz(swiat, x), x);
            }
        }
        else if (kierunek == Kierunek.prawo) {
            if (pozycja.y + 1 < swiat.getY()) {
                Pozycja x=new Pozycja(pozycja.x,pozycja.y + 1);
                if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) swiat.Dodaj(new Mlecz(swiat, x), x);
            }
        }
        else if (kierunek == Kierunek.lewo) {
            if (pozycja.y - 1 > -1) {
                Pozycja x=new Pozycja(pozycja.x,pozycja.y - 1);
                if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) swiat.Dodaj(new Mlecz(swiat, x), x);
            }
        }
    }
    @Override
    public String wypisz() {
        return "Mlecz";
    }
}
