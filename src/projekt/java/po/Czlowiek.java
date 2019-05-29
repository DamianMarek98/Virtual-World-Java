package projekt.java.po;

import java.util.Random;

public class Czlowiek extends Zwierze {
    public Kierunek k;

    public Czlowiek(Swiat swiat, Pozycja pozycja) {
        this.inicjatywa = 4;
        this.sila = 5;
        this.swiat = swiat;
        this.pozycja = pozycja;
        this.k = Kierunek.prawo;
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek kierunek) {
        if (nastepny.PobierzSile() > org.PobierzSile()) {
            swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
            swiat.text.add("Nieudany atak na czlowieka: "+org.wypisz());
            swiat.Usun(org);
        }
        else {
            swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
            swiat.Usun(nastepny);
            if (kierunek == Kierunek.gora) {
                org.pozycja.x--;
            } else if (kierunek == Kierunek.dol) {
                org.pozycja.x++;
            } else if (kierunek == Kierunek.prawo) {
                org.pozycja.y++;
            } else if (kierunek == Kierunek.lewo) {
                org.pozycja.y--;
            }
            swiat.pole[org.pozycja.x][org.pozycja.y] = org;
            swiat.text.add("Czlowiek zostal pokonany przez: "+org.wypisz());
        }
    }

    @Override
    public void akcjaCzlowiek(Kierunek k) {
        if (swiat.t) {
            if (swiat.wykonanie == 1 || swiat.wykonanie == 2) {
                Random generator = new Random();
                int szansa = generator.nextInt(2) + 1;
                if (szansa == 1) {
                    ruch(k, 1);
                    ruch(k, 1);
                } else {
                    ruch(k, 1);
                }
            } else {
                ruch(k, 1);
                ruch(k, 1);
            }
        } else {
            ruch(k, 1);
        }
        if(swiat.cooldown>0){
            swiat.cooldown--;
            if(swiat.wykonanie>0) {
                swiat.wykonanie--;
                if(swiat.wykonanie==0) swiat.t=false;
            }
        }
    }
    @Override
    public String wypisz() {
        return "Czlowiek";
    }
}
