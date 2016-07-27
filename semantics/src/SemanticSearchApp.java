/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.dnd.Autoscroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.didion.jwnl.JWNLException; //used wordnet dictionary

/**
 *
 * @author Sony
 */


public class SemanticSearchApp extends JPanel {

    private Random gen;
    private int randomNum;
    private String str = new String("Aeroplane");
    private JButton push;
    private JLabel label;
    //private JLabel label2;
    private JTextArea textArea;
    private JTextField textBox2;
    //private JPanel extPanel=new JPanel();
    //-----------------------------------------------------------------
    //  Constructor: Sets up the GUI.
    //-----------------------------------------------------------------

    public SemanticSearchApp() {

        //ImageIcon ic= new ImageIcon("C:\\Users\\Sony\\Desktop\\security\\locker.jpeg");
        //label2= new JLabel(ic);
        //label2.setBounds(0,0,1000,400);
        //extPanel.setOpaque(false);
        setBounds(0, 0, 1000, 400);
        push = new JButton("Get Meanings");
        push.addActionListener(new SemanticSearchApp.ButtonListener());

        label = new JLabel("Enter Word:");
        Font f = new Font("arial", Font.ITALIC, 14);
        textBox2=new JTextField("input");
        textBox2.setFont(f);
        textBox2.setCaretColor(Color.black);
        textBox2.setColumns(20);
        
        textArea=new JTextArea("Result");
        textArea.setFont(f);
        textArea.setCaretColor(Color.black);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setAutoscrolls(true);
        textArea.setRows(20);
        textArea.setColumns(50);
        textArea.setName("Meanings");   
      //  add(label2);
        add(textArea); 
        add(label);
        add(textBox2);
        add(push);
        //label2.add(extPanel);
        
        //setSize(800, 800);
        setBackground(Color.CYAN);
        
    }
public void showSearch() {
      JFrame frame = new JFrame ("Compare");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocation(400, 100);
      frame.setTitle("Contextual Meaning Search");
      frame.getContentPane().add(new SemanticSearchApp());

      frame.pack();
      frame.setVisible(true);
	}
    //*****************************************************************
    //  Represents a listener for button push (action) events.
    //*****************************************************************
    private class ButtonListener implements ActionListener {
        //--------------------------------------------------------------
        //  Updates the counter and label when the button is pushed.
        //--------------------------------------------------------------

        public void actionPerformed(ActionEvent event) {
            SemanticSearch semanticObj= new SemanticSearch();
            StringBuilder strBuild =new StringBuilder();
            try {
                
                if( !(Pattern.matches("^[a-zA-Z]+$", textBox2.getText())))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a valid word");
                }else{                  
                strBuild = semanticObj.getMean(textBox2.getText());
                String str = strBuild.toString();
                textArea.setText(str); 
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SemanticSearchApp.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }


}
