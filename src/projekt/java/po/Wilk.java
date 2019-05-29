package projekt.java.po;

public class Wilk extends Zwierze {
    public Wilk(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=9;
        this.sila=5;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }

    @Override
    public void akcja(Organizm org) {
        super.akcja(org);
    }

    @Override
    public Organizm urodziny(Pozycja p) {
        return new Wilk(swiat, p);
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek kierunek) {

        if (nastepny.PobierzSile() > org.PobierzSile()) {
            swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
            swiat.text.add("Wilk pokonal atakujacego: "+org.wypisz());
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
            else if (kierunek ==Kierunek.prawo) {
                org.pozycja.y++;
            }
            else if (kierunek == Kierunek.lewo) {
                org.pozycja.y--;
            }
            swiat.pole[org.pozycja.x][org.pozycja.y] = org;
            swiat.text.add("Wilk zostal pokonany przez "+org.wypisz());

        }
    }
    @Override
    public String wypisz() {
        return "Wilk";
    }
}
