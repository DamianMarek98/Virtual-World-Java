package projekt.java.po;

public class Trawa extends Roslina {
    public Trawa(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=0;
        this.sila=0;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }


    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek k) {
        swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
        swiat.Usun(nastepny);
        if (k == Kierunek.gora) {
            org.pozycja.x--;
        }
        else if (k == Kierunek.dol) {
            org.pozycja.x++;
        }
        else if (k == Kierunek.prawo) {
            org.pozycja.y++;
        }
        else if (k == Kierunek.lewo) {
            org.pozycja.y--;
        }
        swiat.pole[org.pozycja.x][org.pozycja.y] = org;
        swiat.text.add("Trawa zostala zjedzona przez: "+org.wypisz());
    }

    @Override
    public void ruch(Kierunek kierunek, int dystans) {
        if (kierunek == Kierunek.gora) {
            if (pozycja.x - 1 > -1) {
                Pozycja x=new Pozycja(pozycja.x - 1,pozycja.y);
                if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof PustePole) swiat.Dodaj(new Trawa(swiat, x),x);
            }
        }
        else if (kierunek == Kierunek.dol) {
            if (pozycja.x + 1 < swiat.getX()) {
                Pozycja x=new Pozycja(pozycja.x + 1,pozycja.y);
                if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof  PustePole) swiat.Dodaj(new Trawa(swiat, x), x);
            }
        }
        else if (kierunek == Kierunek.prawo) {
            if (pozycja.y + 1 < swiat.getY()) {
                Pozycja x=new Pozycja(pozycja.x,pozycja.y + 1);
                if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) swiat.Dodaj(new Trawa(swiat, x), x);
            }
        }
        else if (kierunek == Kierunek.lewo) {
            if (pozycja.y - 1 > -1) {
                Pozycja x=new Pozycja(pozycja.x,pozycja.y - 1);
                if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) swiat.Dodaj(new Trawa(swiat, x), x);
            }
        }
    }
    @Override
    public String wypisz() {
        return "Trawa";
    }
}
