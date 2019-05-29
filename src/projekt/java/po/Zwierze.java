package projekt.java.po;
import java.util.Random;

public class Zwierze extends Organizm {
    public Zwierze() {
    }

    @Override
    public int PobierzInicjatywe() {
        return inicjatywa;
    }

    @Override
    public void akcjaCzlowiek(Kierunek k) {

    }

    @Override
    public void akcja(Organizm org) {
        Kierunek k=Kierunek.dol;
        Random generator = new Random();
        int szansa=generator.nextInt(4)+1;
        if (szansa == 1) {
            k=Kierunek.gora;
        }
        else if (szansa == 2) {
            k=Kierunek.dol;
        }
        else if (szansa == 3) {
            k=Kierunek.prawo;
        }
        else if (szansa == 4) {
            k=Kierunek.lewo;
        }
        ruch(k,1);
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek k) {

    }

    @Override
    public void rysowanie() {

    }

    @Override
    public void ruch(Kierunek kierunek, int dystans) {
        if (kierunek == kierunek.gora) {
            if(pozycja.x-1>-1){
                //wejscie na puste pole

                if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof PustePole) {
                    swiat.pole[pozycja.x - 1][pozycja.y] = swiat.pole[pozycja.x][pozycja.y];
                    swiat.pole[pozycja.x][pozycja.y] = new PustePole();
                    pozycja.x--;
                }
                else if (swiat.pole[pozycja.x - 1][pozycja.y].wypisz() == swiat.pole[pozycja.x][pozycja.y].wypisz()){
                    if (pozycja.x - 2 > -1) {
                        if (swiat.pole[pozycja.x - 2][pozycja.y] instanceof PustePole) {
                            Pozycja p=new Pozycja(pozycja.x - 2, pozycja.y);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x +1 < swiat.getX()) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y + 1 < swiat.getY()) {
                        if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x,pozycja.y + 1);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y -1 > -1) {
                        if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof  PustePole) {
                            Pozycja p =new Pozycja(pozycja.x ,pozycja.y - 1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y + 1 <swiat.getY()) {
                        if (swiat.pole[pozycja.x - 1][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x - 1,pozycja.y+1);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y - 1 > -1) {
                        if (swiat.pole[pozycja.x - 1][pozycja.y - 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x -1,pozycja.y-1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                }
                //kolizja z innym organizmem
			else {
                    swiat.pole[pozycja.x - 1][pozycja.y].kolizja(swiat.pole[pozycja.x - 1][pozycja.y], swiat.pole[pozycja.x][pozycja.y],kierunek);
                }
            }
        }
        else if (kierunek == Kierunek.dol) {
            if (pozycja.x + dystans < swiat.getX()) {
                if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof PustePole) {
                    swiat.pole[pozycja.x + 1][pozycja.y] = swiat.pole[pozycja.x][pozycja.y];
                    swiat.pole[pozycja.x][pozycja.y] = new PustePole();
                    pozycja.x++;
                }
			    else if (swiat.pole[pozycja.x + 1][pozycja.y].wypisz() == swiat.pole[pozycja.x][pozycja.y].wypisz()) {
                    if (pozycja.x + 2 < swiat.getX() ) {
                        if (swiat.pole[pozycja.x + 2][pozycja.y] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x - 1 <-1) {
                        if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof  PustePole) {
                            Pozycja p =new Pozycja(pozycja.x - 1,pozycja.y );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y + 1 <swiat.getY()) {
                        if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x,pozycja.y+1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y - 1 > -1) {
                        if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x ,pozycja.y-1);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y + 1 < swiat.getX()) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y + 1] instanceof  PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y+1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y - 1 > -1) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y - 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y-1);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                }
			else {
                    swiat.pole[pozycja.x + 1][pozycja.y].kolizja(swiat.pole[pozycja.x + 1][pozycja.y], swiat.pole[pozycja.x][pozycja.y],kierunek);
                }
            }
        }
        else if (kierunek == Kierunek.prawo) {
            if (pozycja.y + dystans < swiat.getY()) {
                if (swiat.pole[pozycja.x][pozycja.y+1] instanceof  PustePole) {
                    swiat.pole[pozycja.x][pozycja.y+1] = swiat.pole[pozycja.x][pozycja.y];
                    swiat.pole[pozycja.x][pozycja.y] = new PustePole();
                    pozycja.y++;
                }
			else if (swiat.pole[pozycja.x][pozycja.y+1].wypisz() == swiat.pole[pozycja.x][pozycja.y].wypisz()) {
                    if (pozycja.y + 2 < swiat.getY()) {
                        if (swiat.pole[pozycja.x][pozycja.y+2] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x ,pozycja.y +2);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x + 1 < swiat.getX()) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y - 1 >-1) {
                        if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x,pozycja.y-1);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x +1<swiat.getX() ) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y+1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x -1 >-1) {
                        if (swiat.pole[pozycja.x - 1][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja( pozycja.x -1,pozycja.y +1);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x- 1 > -1) {
                        if (swiat.pole[pozycja.x - 1][pozycja.y] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x - 1,pozycja.y );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                }
			else {
                    swiat.pole[pozycja.x][pozycja.y+1].kolizja(swiat.pole[pozycja.x][pozycja.y+1], swiat.pole[pozycja.x][pozycja.y],kierunek);
                }
            }
        }
        else if (kierunek == Kierunek.lewo) {
            if (pozycja.y - dystans > -1) {
                if (swiat.pole[pozycja.x][pozycja.y - 1] instanceof PustePole) {
                    swiat.pole[pozycja.x][pozycja.y - 1] = swiat.pole[pozycja.x][pozycja.y];
                    swiat.pole[pozycja.x][pozycja.y] = new PustePole();
                    pozycja.y--;
                }
			else if (swiat.pole[pozycja.x][pozycja.y-1].wypisz() == swiat.pole[pozycja.x][pozycja.y].wypisz()) {
                    if (pozycja.y - 2 >-1) {
                        if (swiat.pole[pozycja.x][pozycja.y - 2] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x ,pozycja.y-2);
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x + 1 < swiat.getX()) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y] instanceof PustePole) {
                            Pozycja p =new Pozycja( pozycja.x + 1,pozycja.y );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.y +1<swiat.getY()) {
                        if (swiat.pole[pozycja.x][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x ,pozycja.y+1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }

                    else if (pozycja.x + 1<swiat.getX()) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y + 1] instanceof PustePole) {
                            Pozycja p =new Pozycja( pozycja.x + 1,pozycja.y+1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                    else if (pozycja.x - 1 >-1) {
                        if (swiat.pole[pozycja.x - 1][pozycja.y - 1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x - 1,pozycja.y-1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }

                    else if (pozycja.x + 1 <swiat.getX()) {
                        if (swiat.pole[pozycja.x + 1][pozycja.y-1] instanceof PustePole) {
                            Pozycja p =new Pozycja(pozycja.x + 1,pozycja.y-1 );
                            swiat.Dodaj(swiat.pole[pozycja.x][pozycja.y].urodziny(p), p);
                        }
                    }
                }
			else {
                    swiat.pole[pozycja.x][pozycja.y-1].kolizja(swiat.pole[pozycja.x][pozycja.y-1], swiat.pole[pozycja.x][pozycja.y],kierunek);
                }
            }
        }
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
        return this.sila;
    }
}
