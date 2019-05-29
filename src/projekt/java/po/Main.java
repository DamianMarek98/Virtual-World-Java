package projekt.java.po;
import java.util.Scanner;
import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        int wysokosc=20,szerokosc=20;
        Swiat s1=new Swiat(wysokosc,szerokosc);

        Pozycja x=new Pozycja(2,3);
        Zolw a=new Zolw(s1,x);
        s1.Dodaj(a,x);
        Pozycja y=new Pozycja(2,5);
        Lis k=new Lis(s1,y);
        s1.Dodaj(k,y);
        Czlowiek c=new Czlowiek(s1,new Pozycja(0,0));
        s1.Dodaj(c,new Pozycja(0,0));
        s1.Dodaj(new Owca(s1,new Pozycja(3,4)),new Pozycja(3,4));
        s1.Dodaj(new Guarana(s1,new Pozycja(10,10)),new Pozycja(10,10));
        s1.Dodaj(new Wilcze_Jagody(s1,new Pozycja(1,5)),new Pozycja(1,5));
        s1.Dodaj(new Antylopa(s1,new Pozycja(3,7)),new Pozycja(3,7));
        s1.Dodaj(new Wilk(s1,new Pozycja(8,5)),new Pozycja(8,5));
        s1.Dodaj(new Mlecz(s1,new Pozycja(10,5)),new Pozycja(10,5));
        s1.Dodaj(new Trawa(s1,new Pozycja(11,0)),new Pozycja(11,0));
        s1.Dodaj(new Barszcz_Sosnowskiego(s1,new Pozycja(12,14)),new Pozycja(12,14));

        int i=s1.nowe.size();
        System.out.println(i);



        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfejs(wysokosc,szerokosc,s1);
            }
        });
    }
}


