package projekt.java.po;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Swiat {
    protected int x, y;
    protected Organizm[][] pole;
    protected List<Organizm> lista=new LinkedList();
    protected List<Organizm> usun=new LinkedList();
    protected List<Organizm> nowe=new LinkedList();
    public List<String> text=new LinkedList();
    public int wykonanie;
    public int cooldown;
    public int tura=0;
    public boolean t;
    public Kierunek k;
    public Swiat(int x,int y){
        this.wykonanie = 0;
        this.cooldown=0;
        this.t = false;
        this.tura=0;
        this.x=x;
        this.y=y;
        pole=new Organizm[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
                pole[i][j]=new PustePole();
            }
        }
    }
    public void Dodaj(Organizm org,Pozycja pozycja){
        pole[org.pozycja.x][org.pozycja.y]=org;
        nowe.add(org);
    }
    public void Usun(Organizm org){
        usun.add(org);
    }
    public Organizm[][] getPole() {
        return pole;
    }
    public void WykonajTure(Kierunek k){
        tura++;
        //nowe organizmy
       boolean dodanie=true;
       for(Organizm temp : nowe){
           if(lista.isEmpty()){
               lista.add(temp);
           }
           else {
               dodanie=false;
               for (Organizm x : lista) {
                   if (temp.PobierzInicjatywe() > x.PobierzInicjatywe()) {
                       lista.add(lista.indexOf(x), temp);
                       dodanie=true;
                       break;
                   }
               }
               if(!dodanie){
                   lista.add(temp);
               }
           }
       }
       nowe.removeAll(nowe);

        for (Organizm temp : lista) {
            if (temp.wypisz() == pole[temp.pozycja.x][temp.pozycja.y].wypisz()) {
                if (temp instanceof Czlowiek) {
                    temp.akcjaCzlowiek(k);
                } else temp.akcja(temp);
            }
        }
       for (Organizm temp : usun) {
            lista.remove(temp);
       }
       usun.removeAll(usun);
       for (Organizm x : lista) {
           System.out.println("Organizm "+x.wypisz()+" na pozycji: "+x.pozycja.y+","+x.pozycja.x);
       }
       }

       public void zapisz() throws FileNotFoundException{
               try {
                   PrintWriter zapis = new PrintWriter("zapis.txt");
                   zapis.println(t);
                   zapis.println(wykonanie);
                   zapis.println(cooldown);
                   zapis.println(tura);
                   zapis.println(x);
                   zapis.println(y);
                   for (Organizm temp : lista) {
                   zapis.println(temp.wypisz());
                       zapis.println(temp.pozycja.x);
                       zapis.println(temp.pozycja.y);
                       zapis.println(temp.inicjatywa);
                       zapis.println(temp.sila);
                   }
                   zapis.println("End");
                   zapis.close();
               } finally {
               }
       }

       public void wczytaj() throws FileNotFoundException{
        lista.removeAll(lista);
        int b,c,d,i,s;
           Scanner odczyt = new Scanner(new File("zapis.txt"));
           t=odczyt.nextBoolean();
           wykonanie=odczyt.nextInt();
           cooldown=odczyt.nextInt();
           tura=odczyt.nextInt();
           x=odczyt.nextInt();
           y=odczyt.nextInt();
           pole=new Organizm[x][y];
           for(int z=0;z<x;z++){
               for(int j=0;j<x;j++){
                   pole[z][j]=new PustePole();
               }
           }
           String k;
            while(odczyt.hasNextLine()) {
               k = odczyt.next();
                System.out.println("k="+k);
                if (k.contains("Czlowiek")) {
                    System.out.println("DODAJE CZLOWIEKOA");
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Czlowiek q = new Czlowiek(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Wilk")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Wilk q = new Wilk(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Lis")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Lis q = new Lis(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Zolw")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Zolw q = new Zolw(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Owca")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Owca q = new Owca(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Antylopa")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Antylopa q = new Antylopa(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Guarana")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Guarana q = new Guarana(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Trawa")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Trawa q = new Trawa(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("Mlecz")) {
                    System.out.println("MLECZ");
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Mlecz q = new Mlecz(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("BarszczSosnowskiego")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Barszcz_Sosnowskiego q = new Barszcz_Sosnowskiego(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                } else if (k.contains("WilczeJagody")) {
                    c = odczyt.nextInt();
                    d = odczyt.nextInt();
                    Wilcze_Jagody q = new Wilcze_Jagody(this, new Pozycja(c, d));
                    q.inicjatywa = odczyt.nextInt();
                    q.sila = odczyt.nextInt();
                    Dodaj(q, new Pozycja(c, d));
                }
                else if(k.contains("End")){
                    break;
                }
                else break;
            }

           int g=nowe.size();
           System.out.println("NOWA LISTA: "+g);
       }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
