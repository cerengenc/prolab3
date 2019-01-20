
package prolab3;
import static java.lang.System.exit;
import javax.swing.JFrame;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Prolab3{

    public static void main(String[] args) {
         
                sekil s=new sekil();               

                                s.setBackground(Color.black);
                                        
                               JFrame jf = new JFrame("Izgara Ekranı");
                               
                               jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                               jf.setSize(700,700);
                                jf.setLocationByPlatform(true);
                                jf.setLocationRelativeTo(null);
                           
                                jf.add(s);
                               jf.setVisible(true);
                              
        
        }
    }

