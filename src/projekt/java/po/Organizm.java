package projekt.java.po;

public abstract class Organizm  {
    public Pozycja pozycja;
    public Swiat swiat;
    public int inicjatywa, sila;
    abstract public void akcja(Organizm org);
    abstract public void kolizja(Organizm nastepny,Organizm org,Kierunek k);
    abstract public void rysowanie();
    abstract public void ruch(Kierunek k,int dystans);
    abstract public Organizm urodziny(Pozycja p);
    abstract public void akcjaCzlowiek(Kierunek k);
    abstract public char znak();
    abstract public String wypisz();
    abstract public Pozycja PobierzPozycje();
    abstract public int PobierzWIek();
    abstract public int PobierzSile();
    abstract public int PobierzInicjatywe();
}
