package projekt.java.po;

public class Wilcze_Jagody extends Roslina {
    public Wilcze_Jagody(Swiat swiat,Pozycja pozycja) {
        this.inicjatywa=0;
        this.sila=99;
        this.swiat=swiat;
        this.pozycja=pozycja;
    }


    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek k) {
        swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
        swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y] = new PustePole();
        swiat.Usun(nastepny);
        swiat.Usun(org);
        swiat.text.add(org.wypisz()+" zjadl wilsze jagody!");
    }


    public void ruch(Kierunek kierunek, Organizm org) {
        if (kierunek == Kierunek.gora) {
            if (pozycja.x - 1 > -1) {
                Pozycja x=new Pozycja(pozycja.x - 1,pozycja.y);
                if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof PustePole) swiat.Dodaj(new Wilcze_Jagody(swiat, x),x);
            }
        }
        else if (kierunek == Kierunek.dol) {
            if (pozycja.x + 1 < swiat.getX()) {
                Pozycja x=new Pozycja(pozycja.x + 1,pozycja.y);
                if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof  PustePole) swiat.Dodaj(new Wilcze_Jagody(swiat, x), x);
            }
        }
        else if (kierunek == Kierunek.prawo) {
            if (pozycja.y + 1 < swiat.getY()) {
                Pozycja x=new Pozycja(pozycja.x,pozycja.y + 1);
                if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) swiat.Dodaj(new Wilcze_Jagody(swiat, x), x);
            }
        }
        else if (kierunek == Kierunek.lewo) {
            if (pozycja.y - 1 > -1) {
                Pozycja x=new Pozycja(pozycja.x,pozycja.y - 1);
                if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) swiat.Dodaj(new Wilcze_Jagody(swiat, x), x);
            }
        }
    }
    @Override
    public String wypisz() {
        return "WilczeJagody";
    }
}
