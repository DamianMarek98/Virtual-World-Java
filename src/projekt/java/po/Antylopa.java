package projekt.java.po;

import java.util.Random;

public class Antylopa extends Zwierze {
    public Antylopa(Swiat swiat, Pozycja pozycja) {
        this.inicjatywa = 4;
        this.sila = 4;
        this.swiat = swiat;
        this.pozycja = pozycja;
    }

    @Override
    public void akcja(Organizm org) {
        Kierunek k = Kierunek.dol;
        Random generator = new Random();
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
        ruch(k, 1);
    }

    @Override
    public Organizm urodziny(Pozycja p) {
        return new Antylopa(swiat, p);
    }

    @Override
    public void kolizja(Organizm nastepny, Organizm org, Kierunek kierunek) {
        Random generator = new Random();
        int ucieczka = generator.nextInt(1) + 1;
        if (ucieczka == 1) {
            if (pozycja.x - 1 > -1) {
                if (swiat.pole[nastepny.pozycja.x - 1][nastepny.pozycja.y] instanceof PustePole) {
                    swiat.pole[nastepny.pozycja.x - 1][nastepny.pozycja.y] = nastepny;
                    swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y] = org;
                }
            }
            else if (pozycja.x + 1 < swiat.getX()) {
                if (swiat.pole[nastepny.pozycja.x + 1][nastepny.pozycja.y] instanceof PustePole) {
                    swiat.pole[nastepny.pozycja.x + 1][nastepny.pozycja.y] = nastepny;
                    swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y] = org;
                }
            }
            else if (pozycja.y + 1 < swiat.getY()) {
                if (swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y + 1] instanceof PustePole) {
                    swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y + 1] = nastepny;
                    swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y] = org;
                }
            }
            else if (pozycja.y - 1 > -1) {
                if (swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y - 1] instanceof PustePole) {
                    swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y - 1] = nastepny;
                    swiat.pole[nastepny.pozycja.x][nastepny.pozycja.y] = org;
                }
            }
            //brak miejsca do ucieczki, podjęcie walki
            else {
                if (nastepny.PobierzSile() > org.PobierzSile()) {
                    swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
                    swiat.text.add("Antylopa zostala pokonana przez "+org.wypisz());
                    swiat.Usun(org);
                    swiat.text.add("Nieudany atak na antylope "+org.wypisz());
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
                    swiat.text.add("Antylopa zostala pokonana przez: "+org.wypisz());
                }
            }
        } else {
            if (nastepny.PobierzSile() > org.PobierzSile()) {
                swiat.pole[org.pozycja.x][org.pozycja.y] = new PustePole();
                swiat.text.add("Nieudany atak na antylope "+org.wypisz());
                swiat.Usun(org);
            } else {
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
                swiat.text.add("Antylopa zostala pokonana przez "+org.wypisz());
            }
        }
    }

    @Override
    public String wypisz() {
        return "Antylopa";
    }
}
