package projekt.java.po;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.*;

public class MyPanel extends JPanel {
    private int wys,szer;
    public Swiat s;
    private BufferedImage imageLis,imageOwca,imageAntylopa,imageCzlowiek,imageWilk,imageZolw,imageGuarana,imageTrawa,imageMlecz,imageWilczeJagody,imageBarszczSosnowskiego;
    public MyPanel(int x,int y,Swiat s1) {
        this.s=s1;
        this.szer=x;
        this.wys=y;
        setPreferredSize(new Dimension(1280, 720));
        setVisible(true);
        File imagelis = new File("Lis.jpg");
        File imageowca = new File("Owca.jpg");
        File imagewilk = new File("Wilk.jpg");
        File imageantylopa = new File("Antylopa.jpg");
        File imagezolw = new File("Zolw.jpg");
        File imageczlowiek = new File("Czlowiek.jpg");
        File imageguarana = new File("Guarana.jpg");
        File imagetrawa = new File("Trawa.jpg");
        File imagemlecz = new File("Mlecz.jpg");
        File imagewilczejagody = new File("WilczeJagody.jpg");
        File imagebarszczsosnowskiego = new File("BarszczSosnowskiego.jpg");
        //exceptions
        try {
            imageLis = ImageIO.read(imagelis);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageOwca = ImageIO.read(imageowca);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageAntylopa = ImageIO.read(imageantylopa);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageZolw = ImageIO.read(imagezolw);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageWilk = ImageIO.read(imagewilk);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageCzlowiek = ImageIO.read(imageczlowiek);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageGuarana = ImageIO.read(imageguarana);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageMlecz = ImageIO.read(imagemlecz);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageTrawa = ImageIO.read(imagetrawa);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageWilczeJagody = ImageIO.read(imagewilczejagody);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
        try {
            imageBarszczSosnowskiego = ImageIO.read(imagebarszczsosnowskiego);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Ramka pola gry
        Rectangle2D rectangle = new Rectangle2D.Double(10, 10, szer*30, wys*30);
        int a=10,b=10;//szerokosc i wysokosc rysowania
        for(int i=0;i<s.x;i++){
            for(int j=0;j<s.y;j++){
                if(s.pole[i][j] instanceof Wilk){
                    g2d.drawImage(imageWilk, a, b, this);
                }
                else if(s.pole[i][j] instanceof Lis){
                    g2d.drawImage(imageLis, a, b, this);
                }
                else if(s.pole[i][j] instanceof Antylopa){
                    g2d.drawImage(imageAntylopa, a, b, this);
                }
                else if(s.pole[i][j] instanceof Zolw){
                    g2d.drawImage(imageZolw, a, b, this);
                }
                else if(s.pole[i][j] instanceof Owca){
                    g2d.drawImage(imageOwca, a, b, this);
                }
                else if(s.pole[i][j] instanceof Guarana){
                    g2d.drawImage(imageGuarana, a, b, this);
                }
                else if(s.pole[i][j] instanceof Wilcze_Jagody){
                    g2d.drawImage(imageWilczeJagody, a, b, this);
                }
                else if(s.pole[i][j] instanceof Trawa){
                    g2d.drawImage(imageTrawa, a, b, this);
                }
                else if(s.pole[i][j] instanceof Mlecz){
                    g2d.drawImage(imageMlecz, a, b, this);
                }
                else if(s.pole[i][j] instanceof Barszcz_Sosnowskiego){
                    g2d.drawImage(imageBarszczSosnowskiego, a, b, this);
                }
                else if(s.pole[i][j] instanceof Czlowiek) {
                    g2d.drawImage(imageCzlowiek, a, b, this);
                }
               a+=30;
            }
           a=10;
            b+=30;
        }
        g2d.draw(rectangle);
        int i=s.x*30+25;
        for (String temp : s.text){
            g.drawString(temp,10,i);
            i+=11;
        }
        g.drawString("Tura: "+s.tura,630,22);
        if(s.cooldown>0){
            g.drawString("Cooldown: "+s.cooldown,630,34);
        }
        s.text.removeAll(s.text);
    }
    public void clear(){

    }
}
