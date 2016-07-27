
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sony
 */
public class LoginPage extends JPanel{
    private ImageIcon ic= new ImageIcon("C:\\Users\\Sony\\Desktop\\security\\login.jpeg");
    private JLabel img= new JLabel(ic);
    private JLabel title;
    private JLabel title2;
    private JLabel label4;
    private JTextField textBox4;
    private JLabel label5;
    private JPasswordField textBox5;
    private JButton login;
    private Dashboard dash=new Dashboard();
    public LoginPage(){
        title= new JLabel("Word Sense Disambiguation         ");
        title2= new JLabel("Using Data Mining Algorithms...........               ");
        label4 = new JLabel("Enter Username  ");
        label5 = new JLabel("Enter Password  ");
        
        textBox4= new JTextField();
        textBox5= new JPasswordField();
        Font f = new Font("arial", Font.ITALIC, 14);
        textBox4.setFont(f);
        textBox4.setCaretColor(Color.black);
        textBox4.setColumns(10);
        textBox5.setFont(f);
        textBox5.setCaretColor(Color.black);
        textBox5.setColumns(10);
        login= new JButton("Login to Application");
        login.addActionListener(new LoginButtonListner());
        dash.setVisible(false);
        add(img);
        add(title);
        
        add(title2);
        
        add(label4);
        add(textBox4);
        add(label5);
        add(textBox5);
        add(login);
        add(dash);
        setPreferredSize(new Dimension(300, 400));
        setBackground(Color.orange);

    }
    
            private class LoginButtonListner implements ActionListener {

                    public void actionPerformed(ActionEvent event){
                    
                       if(textBox4.getText().equals("admin")&&textBox5.getText().equals("admin")){
                            
                            dash.setVisible(true);
                            label4.setVisible(false);
                            label5.setVisible(false);
                            textBox4.setVisible(false);
                            textBox5.setVisible(false);
                            login.setVisible(false);
                       }
                    
                    }
                    
            }
            
            public static void main(String[] args) {
      JFrame frame = new JFrame ("Compare");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocation(400, 100);
      frame.setTitle("Contextual Meaning Search");
      frame.getContentPane().add(new LoginPage());
      frame.pack();
      frame.setVisible(true);
	}

}
