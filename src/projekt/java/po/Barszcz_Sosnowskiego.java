package projekt.java.po;

import java.util.Random;

public class Barszcz_Sosnowskiego extends Roslina {
    public Barszcz_Sosnowskiego(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=0;
        this.sila=10;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }

    @Override
    public void akcja(Organizm org) {
        //Barszcz_Sosnowskiego zabija zwierzeta w swoim sasiedztwie
        if (pozycja.x + 1 < swiat.getX() && swiat.pole[org.pozycja.x + 1][org.pozycja.y] instanceof Zwierze ) {
            swiat.Usun(swiat.pole[org.pozycja.x + 1][org.pozycja.y]);
            swiat.pole[org.pozycja.x + 1][org.pozycja.y] = new PustePole();
        }
        if (pozycja.x - 1 > -1 && swiat.pole[org.pozycja.x - 1][org.pozycja.y] instanceof Zwierze) {
            swiat.Usun(swiat.pole[org.pozycja.x - 1][org.pozycja.y]);
            swiat.pole[org.pozycja.x - 1][org.pozycja.y] = new PustePole();
        }
        if (pozycja.y + 1 < swiat.getY() && swiat.pole[org.pozycja.x][org.pozycja.y+1] instanceof Zwierze) {
            swiat.Usun(swiat.pole[org.pozycja.x][org.pozycja.y + 1]);
            swiat.pole[org.pozycja.x ][org.pozycja.y + 1] = new PustePole();
        }
        if (pozycja.y - 1 > -1 && swiat.pole[org.pozycja.x][org.pozycja.y-1] instanceof Zwierze) {
            swiat.Usun(swiat.pole[org.pozycja.x][org.pozycja.y-1]);
            swiat.pole[org.pozycja.x][org.pozycja.y-1] = new PustePole();
        }
        Kierunek k=Kierunek.dol;
        Random generator = new Random();
        int szansa=generator.nextInt(1)+20;
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
        ruch(k,1);
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek k) {
        swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
        swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y] = new PustePole();
        swiat.Usun(nastepny);
        swiat.Usun(org);
    }


    public void ruch(Kierunek kierunek, Organizm org) {
        if (kierunek == Kierunek.gora) {
            if (pozycja.x - 1 > -1) {
                if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof PustePole) swiat.Dodaj(new Barszcz_Sosnowskiego(swiat, new Pozycja(pozycja.x - 1,pozycja.y)), new Pozycja(pozycja.x - 1,pozycja.y));
            }
        }
        else if (kierunek == Kierunek.dol) {
            if (pozycja.x + 1 < swiat.getX()) {
                if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof PustePole) swiat.Dodaj(new Barszcz_Sosnowskiego(swiat,new Pozycja(pozycja.x + 1,pozycja.y )), new Pozycja(pozycja.x + 1,pozycja.y));
            }
        }
        else if (kierunek == Kierunek.prawo) {
            if (pozycja.y + 1 < swiat.getY()) {
                if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) swiat.Dodaj(new Barszcz_Sosnowskiego(swiat, new Pozycja(pozycja.x,pozycja.y + 1 )), new Pozycja(pozycja.x ,pozycja.y + 1));
            }
        }
        else if (kierunek == Kierunek.lewo) {
            if (pozycja.y - 1 > -1) {
                if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) swiat.Dodaj(new Barszcz_Sosnowskiego(swiat, new Pozycja(pozycja.x,pozycja.y - 1 )), new Pozycja(pozycja.x,pozycja.y - 1));
            }
        }
    }
    @Override
    public String wypisz() {
        return "BarszczSosnowskiego";
    }
}
