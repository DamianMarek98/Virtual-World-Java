package projekt.java.po;

import java.util.Random;

public class Lis extends Zwierze {
    public Lis(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=7;
        this.sila=3;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }



    @Override
    public Organizm urodziny(Pozycja p) {
        return new Lis(swiat,p);
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek kierunek){
        if (nastepny.PobierzSile() > org.PobierzSile()) {
            swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
            swiat.text.add("Lis pokonal atakujacego: "+ org.wypisz());
            swiat.Usun(org);
        }
        else
        {
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
            swiat.text.add("Lis zostal pokonany przez: "+ org.wypisz());
        }
    }
    @Override
    public String wypisz() {
        return "Lis";
    }

    @Override
    public void akcja(Organizm org) {
        Kierunek k=Kierunek.gora;
        Random generator = new Random();
        int szansa = generator.nextInt(4)+1;
        if (szansa == 1) {
            k = Kierunek.gora;
        } else if (szansa == 2) {
            k = Kierunek.dol;
        } else if (szansa == 3) {
            k = Kierunek.prawo;
        } else if (szansa == 4) {
            k = Kierunek.lewo;
        }
        if (k == Kierunek.gora) {
            if (pozycja.x - 1 > -1) {
                if (swiat.pole[org.pozycja.x - 1][org.pozycja.y].sila > org.sila) {}
			else ruch(k, 1);
            }
        }
        else if (k==Kierunek.dol) {
            if (pozycja.x + 1 < swiat.getX()) {
                if (swiat.pole[org.pozycja.x + 1][org.pozycja.y].sila > org.sila) {}
			else ruch(k, 1);
            }
        }
        else if (k==Kierunek.prawo) {
            if (pozycja.y + 1 < swiat.getY()) {
                if (swiat.pole[org.pozycja.x][org.pozycja.y + 1].sila > org.sila) {}
			else ruch(k, 1);
            }
        }
        else if (k==Kierunek.lewo) {
            if (pozycja.y - 1 > -1) {
                if (swiat.pole[org.pozycja.x][org.pozycja.y - 1].sila > org.sila) {}
			else ruch(k, 1);
            }
        }
    }
}
