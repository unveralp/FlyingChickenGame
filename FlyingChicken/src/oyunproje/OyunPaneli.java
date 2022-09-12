/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oyunproje;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
class Yumurtalar{
    private int x,y;

    public Yumurtalar(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

}
class Worms{
    private int x,y;
    public boolean visible;
    public Worms(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }
}
class Cat{
    private int x,y;
    public int catspeed=2;
    public boolean visible;
    public Cat(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }
}
class OtherCat{
    private int x,y;
    public boolean visible;
    public OtherCat(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }
}
class OtherWorms{
    private int x,y;
    public boolean visible;
    public OtherWorms(int x,int y) {
        this.x = x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisible() {
        return visible;
    }
}
class Tile{
    public int x=200,y=0,x2=900,y2=-700,sd=5;
    public BufferedImage img5;
    public boolean visible;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
public class OyunPaneli extends JPanel implements KeyListener, ActionListener{

    public int ctrl,up,down,left,right,space;
    Timer timer=new Timer(5,this);
   // private int time=0;
   // private int egg=0;
    private  Tile background;
    private BufferedImage img,img2,img3,img4,img5,img6;
    private ArrayList <Yumurtalar> yumurta=new ArrayList<Yumurtalar>();
    private int yumurtadirx=2;
    private int chickenspeed=10;
    public int kod;
    private final int[][] wormsTargets = {{60, 350}, {700, 400}};
    private final int[][] otherTargets={{70,40},{650,150},{350,280}};
    private final int[][] cat2 = {{200, 150}, {400, 400}, {350, 10},{600,500},{40,400},{450,350},{800,670},{400,250}};
    private ArrayList<Worms> worms=new ArrayList<Worms>();
    private ArrayList <OtherWorms> worms2=new ArrayList<OtherWorms>();
    //private ArrayList <Cat> cats=new ArrayList<Cat>();
    private ArrayList <Cat> cats;
    private ArrayList <OtherCat> cats2=new ArrayList<OtherCat>();
  //  private final int B_WIDTH = 1200;
   // private final int B_HEIGHT = 1200;
    public int Num_cats=7;
    private int point=0;
    private int level=1;
   // private int catspeed=2;
   // public final int maxscreencol=18,maxscreenrow=14,tilesize=50,screenwidth=maxscreencol*tilesize,screenheight=maxscreenrow*tilesize;
    //Tile [] tile;
   // int maptilenum[][];
    //world settings
   // public final int maxworldcol=90,maxworldrow=90,worldwidth=tilesize*maxworldcol,worldheight=tilesize*maxworldrow;
   // public final int screenX=screenwidth/2 - (tilesize/2),screenY=screenheight/2 - (tilesize/2);
    private int chickenx=100;
    private int chickeny=100;
    public Tile bg;
    public Tile bg2;
    Font label;






    public OyunPaneli() {
       // tile=new Tile[5];
        //maptilenum=new int[maxworldcol][maxworldrow];
        bg=new Tile();
        bg2=new Tile();
        label = new Font("Arial" , Font.BOLD , 20) ;
        try {
            
            img =ImageIO.read(this.getClass().getResource("/objects/chicken-g6b3113258_640.png"));
            img2=ImageIO.read(this.getClass().getResource("/objects/eggright.png"));
            img3=ImageIO.read(this.getClass().getResource("/objects/basket-gff2206efb_640.png"));
            img4=ImageIO.read(this.getClass().getResource("/objects/halloween-g13cce0e6d_640.png"));
            //img5=ImageIO.read(this.getClass().getResource("/objects/Cartoon_forest_seamless_background__Vector_illustration__Elements_for_mobile_games_video_games.jpg"));
            //img6=ImageIO.read(this.getClass().getResource("/objects/Cartoon_forest_seamless_background__Vector_illustration__Elements_for_mobile_games_video_games.jpg"));
            img5=ImageIO.read(this.getClass().getResource("/objects/bg.jpg"));
            img6=ImageIO.read(this.getClass().getResource("/objects/bg.jpg"));

            //img5=ImageIO.read(this.getClass().getResource("koy2.jpg"));
          /*  tile[0]=new Tile();
            tile[0].img5=ImageIO.read(this.getClass().getResource("grass.jpg"));
            tile[1]=new Tile();
            tile[1].img5=ImageIO.read(this.getClass().getResource("cloud.png"));
            tile[2]=new Tile();
            tile[2].img5=ImageIO.read(this.getClass().getResource("tree.png"));*/
             
        }catch (IOException ex){
             Logger.getLogger(OyunPaneli.class.getName()).log(Level.SEVERE,null,ex); 
        }
        
       // loadmap();
        //setBackground(Color.black);
        setBackground(Color.black);
        initworms();
        initworms2();
        cats=populatecats();
        timer.start();
        initBackground();
    
    }
    // private boolean ingame;
    public boolean catcollision(){
        
        for(Cat cat:cats) {
            if(new Rectangle(chickenx,chickeny,img.getWidth()/12,img.getHeight()/12).intersects(new Rectangle(cat.getX(),cat.getY(),img4.getWidth()/10,img4.getHeight()/10))){
                point=-1000;
                return true;
            }
        }
        for(OtherCat cat:cats2){
            if(new Rectangle(chickenx,chickeny,img.getWidth()/12,img.getHeight()/12).intersects(new Rectangle(cat.getX(),cat.getY(),img4.getWidth()/6,img4.getHeight()/6))){
                point=-1000;
                return true;
            }
        }
        return false;
    }
    
    public boolean checkcollision(){
        for(Yumurtalar yum:yumurta){
            for(Worms worm:worms) {
                // Rectangle r1=yum.getBounds(yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20);
                if(new Rectangle(yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20).intersects(new Rectangle(worm.getX(),worm.getY(),img3.getWidth()/20,img3.getHeight()/20))){
                    point+=50;
                    return true;
                }
            }
        }
        if((point>500 && point<=1500) || level==2){
            level=2;
            for(Yumurtalar yum:yumurta){
                for(Cat cat:cats){
                    if(new Rectangle(yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20).intersects(new Rectangle(cat.getX(),cat.getY(),img4.getWidth()/10,img4.getHeight()/10))){
                        point-=150;
                        try{
                            cats.remove(cat);
                        }catch(java.util.ConcurrentModificationException e){

                        }
                    }
                }
            }
        }
        if(point>1500 || level==3){
            level=3;
            chickenspeed=12;
            initcat2();
            for(Worms worm:worms){
                worms.remove(worm);
            }
            if(point==2500){
                timer.stop();
                String message="You Win\n"+
                        "Your Score:"+ point;
                JOptionPane.showMessageDialog(this,message);
                System.exit(0);
            }
        }
        return false;
    }
    public boolean checkcollision2(){
        for(Yumurtalar yum:yumurta){
            for(OtherWorms worm:worms2){
                if(new Rectangle(yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20).intersects(new Rectangle(worm.getX(),worm.getY(),img3.getWidth()/30,img3.getHeight()/30))){
                    point+=100;
                    return true;
                }
            }
        }
        if((point>500 && point<=1500) || level==2){
            level=2;
            //categgcollision();
            for(Yumurtalar yum:yumurta){
                for(Cat cat:cats){
                    if(new Rectangle(yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20).intersects(new Rectangle(cat.getX(),cat.getY(),img4.getWidth()/10,img4.getHeight()/10))){
                        point-=150;
                        try{
                            cats.remove(cat);
                        }catch(java.util.ConcurrentModificationException e){

                        }
                    }
                }
            }
        }
        if(point>1500 || level==3){
            level=3;
            chickenspeed=12;
            initcat2();
            for(Worms worm:worms){
                worms.remove(worm);
            }
            if(point==2500){
                timer.stop();
                String message="You Win\n"+
                        "Your Score:"+ point;
                JOptionPane.showMessageDialog(this,message);
                System.exit(0);
            }

        }
        return false;
    }
    private ArrayList<Cat> populatecats() {
        ArrayList<Cat> catslist=new ArrayList<>();
        Random rand=new Random();

        for(int i=0;i<Num_cats;i++){
            int catx=rand.nextInt(600)+150;
            int caty=rand.nextInt(450)+150;
            catslist.add(new Cat(catx,caty));
        }
        return catslist;
    }

    public void initBackground() {

        background = new Tile();
    }

    private void initcat2(){
        for (int[] p : cat2) {
            cats2.add(new OtherCat(p[0], p[1]));
        }
    }
    public void initworms2() {
        for (int[] p : otherTargets) {
            worms2.add(new OtherWorms(p[0], p[1]));
        }
    }

    public void initworms() {
        for (int[] p : wormsTargets) {
            worms.add(new Worms(p[0], p[1]));
        }
    }

    @Override
    public void paint(Graphics g){
      //  int worldCol=0,worldRow=0;
        super.paint(g);
       /* while(worldCol<maxworldcol && worldRow<maxworldrow){
            int tilenum=maptilenum[worldCol][worldRow];
            int worldx=worldCol * tilesize;
            int worldy=worldRow * tilesize;
            int screenx=worldx - chickenx - 400 +screenX ;
           // screenx=0;
            //screeny=350;
            int screeny=worldy - chickeny -230 +screenY;
            if(worldx + tilesize> chickenx - screenx && worldx - tilesize< chickenx+screenx && worldy+tilesize>chickeny-screenY && worldy-tilesize < chickeny+screenY){
                //g.drawImage(tile[tilenum].img5, screenx, screeny,tilesize,tilesize, this);
                 g.drawImage(tile[tilenum].img5, screenx, screeny,tile[tilenum].img5.getWidth()/4,tile[tilenum].img5.getHeight()/4,this);
            }
            g.drawImage(tile[tilenum].img5, screenx,screeny,tilesize,tilesize, this);
            worldCol++;
            if(worldCol==maxworldcol){
                worldCol=0;
                worldRow++;

            }
        }*/
        g.drawImage(img5, 0, bg.y,900,700, this);
        g.drawImage(img6,0,bg2.y2,900,700,this);
        g.drawImage(img,chickenx,chickeny,img.getWidth()/12,img.getHeight()/12,this);
        
        yumurta.removeIf(yum -> yum.getX() >= 800);
        yumurta.removeIf(yum -> yum.getX()<=0);
        try {
            if (checkcollision()) {
                for (Yumurtalar yum : yumurta) {
                    yumurta.remove(yum);
                }
            }
            if (checkcollision2()) {
                for (Yumurtalar yum : yumurta) {
                    yumurta.remove(yum);
                }
            }
            if(catcollision()){
                gameover();
            }
            if(point<0){
                gameover2();
            }

        }catch(java.util.ConcurrentModificationException e){

        }
        g.setFont(label);
        g.setColor(Color.white);
        // g.setFont(new Font(null,Font.BOLD,5));
        g.drawString("LEVEL:" + level,800,20);
        g.setColor(Color.white);
        for(Yumurtalar yum:yumurta){
            g.drawImage(img2,yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20,this);
            //g.drawImage(img2,yum.getX(),yum.getY(),img2.getWidth()/20,img2.getHeight()/20,this);
            //g.fillRect(yum.getX(),yum.getY(),10,20);
        }
        for(Worms worm:worms){
            g.drawImage(img3,worm.getX(),worm.getY(),img3.getWidth()/12,img3.getHeight()/12,this);
        }
        for(OtherWorms worm:worms2){
            g.drawImage(img3,worm.getX(),worm.getY(),img3.getWidth()/20,img3.getHeight()/20,this);
        }
        for(OtherCat cat:cats2){
            g.drawImage(img4,cat.getX(),cat.getY(),img4.getWidth()/8,img4.getHeight()/8,this);
        }
        for(Cat cat:cats){
            g.drawImage(img4,cat.getX(),cat.getY(),img4.getWidth()/10,img4.getHeight()/10,this);

        }
        g.setColor(Color.WHITE);
        g.drawString("SCORE: " + point, 5, 20);
        g.setColor(Color.WHITE);
        //g.drawString("Level: " + level, 830, 15);
    
  
    }
    public void gameover() {
        timer.stop();
        String message="Cat ate you\n"+
                "Game Over!\n"+
                "Your Score:"+ point;
        JOptionPane.showMessageDialog(this,message);
        System.exit(0);
    }
    public void gameover2(){
        timer.stop();
        String message="You lost all of your points\n"+
                       "Game Over!"+
                       "Your Score:"+ point;
        JOptionPane.showMessageDialog(this,message);
        System.exit(0);

    }
    @Override
    public void repaint(){
        super.repaint();
   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            bg.y -= bg.sd;
            bg2.y2 -= bg.sd;
            if (bg.y <= -700) {
                bg.y += 2*700;


            }
            if (bg2.y2 <= -700) {
                bg2.y2 += 2*700;

            }
        for (Yumurtalar yum : yumurta) {
            yum.setX(yum.getX() + yumurtadirx);
        }
        for (Cat cat : cats) {
            cat.setX(cat.getX() + cat.catspeed);
            if(cat.getX()<=0 || cat.getX()>=850){
                cat.catspeed=-cat.catspeed;
            }
        }

      /*  for (int i = 0; i < worms.size(); i++) {

            Worms a = worms.get(i);

            if (a.isVisible()) {
                //a.move();
            } else {
                worms.remove(i);
            }
        }*/
        repaint();

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        kod = e.getKeyCode(); // klavyeden alaca�� harfi ascii tablosuna g�re ald��� i�in integer belirttik

        if (kod == KeyEvent.VK_UP || kod==KeyEvent.VK_W) {
            chickeny-=chickenspeed;
            up=1;
        }
        if (kod == KeyEvent.VK_DOWN || kod == KeyEvent.VK_S) {
            chickeny+=chickenspeed;
            down=1;
        }
        if (kod == KeyEvent.VK_LEFT || kod ==KeyEvent.VK_A) {
            chickenx-=chickenspeed;
            if(chickenx<=0){
                chickenx=0;
            }
            /*if(0<chickenx  && chickenspeed<0){
                chickenspeed=-chickenspeed;
            }*/
            left=1;
        }
        if (kod == KeyEvent.VK_RIGHT || kod == KeyEvent.VK_D) {
            chickenx+=chickenspeed;
            if(chickenx>=830){
                //r=true;
                chickenx=830;
            }
            /*if(chickenx<840 && chickenspeed<0){
                chickenspeed=-chickenspeed;
            }*/

            right=1;
        }
        if(kod == KeyEvent.VK_SPACE){
            yumurta.add(new Yumurtalar(chickenx+50,chickeny+20));
           // egg++;
            space=1;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

