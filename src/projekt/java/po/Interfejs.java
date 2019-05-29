package projekt.java.po;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;
import java.awt.*;
import javax.swing.*;

public class Interfejs extends JFrame implements ActionListener, KeyListener, MouseListener {
    protected JButton gora,dol,prawo,lewo,specjalna,wczytaj,zapisz,dodaj,exit;
    private JPanel panel,okienko;
    private int a,b;
    private JComboBox<String> Lista;
    private JFrame frame;
    protected int x,y;
    protected Swiat s;
    public Interfejs(int x,int y,Swiat swiat) {
        super("Damian Marek s171952");
        this.s=swiat;
        this.x=x;
        this.y=y;
        panel = new MyPanel(x,y,s);
                setLocation(320,180);
        setFocusable(false);
        //PRZYCISKI KIERUNKÓW SĄ NIEUŻYWANE!!
        dodaj=new JButton("+");
                gora = new JButton("Gora!");
        gora.setBounds(900, 85, 100, 60);
        gora.addActionListener(this);
        gora.setVisible(true);
        dol = new JButton("Dol!");
        dol.setBounds(900, 145, 100, 60);
        dol.addActionListener(this);
        prawo = new JButton("Prawo!");
        prawo.setBounds(1000, 145, 100, 60);
        prawo.addActionListener(this);
        lewo = new JButton("Lewo!");
        lewo.setBounds(800, 145, 100, 60);
        lewo.addActionListener(this);


        specjalna = new JButton("Ult");
        specjalna.setBounds(x*30+25, 85, 100, 60);
        specjalna.addActionListener(this);
        add(specjalna);
        zapisz = new JButton("Zapisz!");
        zapisz.setBounds(x*30+25, 155, 100, 60);
        zapisz.addActionListener(this);
        add(zapisz);
        wczytaj = new JButton("Wczytaj!");
        wczytaj.setBounds(x*30+25, 225, 100, 60);
        wczytaj.addActionListener(this);
        add(wczytaj);
        gora.setFocusable(false);
        wczytaj.setFocusable(false);
        zapisz.setFocusable(false);
        specjalna.setFocusable(false);

        addMouseListener(this);
        gora.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
                add(panel);
                pack();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
            }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            s.WykonajTure(Kierunek.gora);
            panel.repaint();
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            s.WykonajTure(Kierunek.dol);
            panel.repaint();
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            s.WykonajTure(Kierunek.prawo);
            panel.repaint();
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            s.WykonajTure(Kierunek.lewo);
            panel.repaint();
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==specjalna){
            panel.repaint();
            if(s.cooldown==0) {
                s.t = true;
                s.cooldown = 10;
                s.wykonanie = 5;
            }
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);
        }
        if(source==wczytaj){
            try {
                s.wczytaj();
                panel.repaint();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);
        }
        if(source==zapisz){
            try {
                s.zapisz();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);
        }
        if(source==exit){
            String wybrany = (String) Lista.getSelectedItem();
            frame.dispose();
            if(s.pole[b][a] instanceof PustePole) {
                if (wybrany == "Guarana") {
                    s.Dodaj(new Guarana(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Lis") {
                    s.Dodaj(new Lis(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Antylopa") {
                    s.Dodaj(new Antylopa(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Owca") {
                    s.Dodaj(new Owca(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Wilk") {
                    s.Dodaj(new Wilk(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Zolw") {
                    s.Dodaj(new Zolw(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Wilcze Jagody") {
                    s.Dodaj(new Wilcze_Jagody(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Trawa") {
                    s.Dodaj(new Trawa(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Mlecz") {
                    s.Dodaj(new Mlecz(s, new Pozycja(b, a)), new Pozycja(b, a));
                } else if (wybrany == "Barszcz Sosnowskiego") {
                    s.Dodaj(new Barszcz_Sosnowskiego(s, new Pozycja(b, a)), new Pozycja(b, a));
                }
            }
            panel.repaint();
            panel.add(specjalna);
            panel.add(wczytaj);
            panel.add(zapisz);
        }

        }




    @Override
    public void mouseClicked(MouseEvent e) {
        a = e.getX()-10;
        b = e.getY()-48;

        a=a/30;
        b=b/30;

        if(a<s.x && b<s.y) {
            String[] lista = new String[]{"Brak","Lis", "Zolw", "Wilk", "Antylopa", "Owca", "Guarana", "Trawa", "Mlecz", "Wilcze Jagody", "Barszcz Sosnowskiego"};

            Lista = new JComboBox<>(lista);
            frame = new JFrame("FrameDemo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
            frame.setPreferredSize(new Dimension(225, 115));
            frame.setLocation(950, 600);
            frame.setVisible(true);
            frame.pack();
            frame.setFocusable(false);

            frame.setVisible(true);
            frame.add(Lista);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(BorderLayout.NORTH, Lista);
            exit = new JButton("Dalej!");
            exit.setBounds(20, 30, 5, 5);
            exit.addActionListener(this);
            exit.setVisible(true);
            frame.add(exit);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

