package projekt.java.po;

import java.util.Random;

public class Zolw extends Zwierze {
    public Zolw(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=1;
        this.sila=2;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }

    @Override
    public void akcja(Organizm org) {
        Kierunek k=Kierunek.dol;
        Random generator = new Random();
        int prawodpodobienstwo= generator.nextInt(4)+1;
        if (prawodpodobienstwo == 1) {
            int szansa = generator.nextInt(4) + 1;
            if (szansa == 1) {
                k = Kierunek.gora;
            } else if (szansa == 2) {
                k = Kierunek.dol;
            } else if (szansa == 3) {
                k = Kierunek.prawo;
            } else if (szansa == 4) {
                k = Kierunek.lewo;
            }
            ruch(k, 1);
        }
    }

    @Override
    public Organizm urodziny(Pozycja p) {
        return super.urodziny(p);
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek kierunek) {
        if (org.sila >= 5) {
            if (nastepny.sila > org.sila) {
                swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
                swiat.text.add("Nieudany atak na zolwia: "+org.wypisz());
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
                    int a=0;
                }
                swiat.pole[org.pozycja.x][org.pozycja.y] = org;
                swiat.text.add("Zolw zostal pokonany przez: "+org.wypisz());
            }
        }
        else {
            swiat.text.add("Zolw odepchnol: "+org.wypisz());
        }
    }
    @Override
    public String wypisz() {
        return "Zolw";
    }
}
