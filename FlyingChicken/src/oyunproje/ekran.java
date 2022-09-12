/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oyunproje;

import javax.swing.*;
import java.awt.*;

public class ekran extends JFrame {
       public ekran(String title) throws HeadlessException {
              super(title);
       }
       public static void main(String[] args) {
        
              ekran pencere=new ekran("Flying Chicken Game");
              pencere.setResizable(false);
              pencere.setFocusable(false);
              pencere.setSize(900,700);
              pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              OyunPaneli oyun=new OyunPaneli();
              oyun.requestFocus();
              oyun.addKeyListener(oyun);
              oyun.setFocusable(true);
              oyun.setFocusTraversalKeysEnabled(false);
              oyun.setDoubleBuffered(true);
              pencere.add(oyun);
              pencere.setLocationRelativeTo(null);
              pencere.setVisible(true);
          
              //oyun.startingGame();
       }
}
