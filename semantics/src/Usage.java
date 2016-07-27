import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import semantics.Compare;

public class Usage extends JPanel{

    private JButton compare;
    private JLabel label1;
    private JTextField textBox1;
    private JLabel label2;
    private JTextField textBox2;
    private JLabel label3;
    private JTextField textBox3;
    private JTextArea result;
//    private JLabel label4;
//    private JTextField textBox4;
//    private JLabel label5;
//    private JPasswordField textBox5;
//    private JButton login;
//    private JLabel message;
    public Usage() {
        
//        label4 = new JLabel("Enter Username  ");
//        label5 = new JLabel("Enter Password  ");
//        textBox4= new JTextField();
//        textBox5= new JPasswordField();
//        message=new JLabel("Please enter Correct Username & Passoword");
        label1 = new JLabel("Sentence");
        label2 = new JLabel("Find Meaning of  ");
        label3 = new JLabel("Contextual Word");
        textBox3= new JTextField();
        textBox1= new JTextField();
        textBox2= new JTextField();
        result= new JTextArea();
        compare= new JButton("Search for meaning");
        compare.addActionListener(new CompareButtonListner());
        
//        login= new JButton("Login to Application");
//        login.addActionListener(new LoginButtonListner());
        
        Font f = new Font("arial", Font.BOLD, 15);

        textBox1.setFont(f);
        textBox1.setCaretColor(Color.black);
        textBox1.setColumns(20);
        textBox2.setFont(f);
        textBox2.setCaretColor(Color.black);
        textBox2.setColumns(10);
        textBox3.setFont(f);
        textBox3.setCaretColor(Color.black);
        textBox3.setColumns(10);
//        textBox4.setFont(f);
//        textBox4.setCaretColor(Color.black);
//        textBox4.setColumns(10);
//        textBox5.setFont(f);
//        textBox5.setCaretColor(Color.black);
//        textBox5.setColumns(10);
        result.setFont(f);
        result.setCaretColor(Color.black);
        result.setColumns(25);
        result.setRows(10);
        result.setLineWrap(true);
        
        //message.setVisible(false);
        label1.setVisible(true);
        label2.setVisible(true);
        label3.setVisible(true);
        result.setVisible(true);
        textBox1.setVisible(true);
        textBox2.setVisible(true);
        textBox3.setVisible(true);
        compare.setVisible(true);
        result.setEditable(true);
//        message.setForeground(Color.red);
//        add(message);
//        add(label4);
//        add(textBox4);
//        add(label5);
//        add(textBox5);
//        add(login);
        add(label1);
        add(textBox1);
        add(label2);
        add(textBox2);
        add(label3);
        add(textBox3);
        add(compare);
        add(result);
        
        setPreferredSize(new Dimension(320, 400));
        setBackground(Color.orange);
    }
    
    
	/**
	 * @param args
	 */
	public void showUsage() {
      JFrame frame = new JFrame ("Compare");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocation(400, 100);
      frame.setTitle("Contextual Meaning Search");
      frame.getContentPane().add(new Usage());

      frame.pack();
      frame.setVisible(true);
	}

//        private class LoginButtonListner implements ActionListener {
//
//        public void actionPerformed(ActionEvent event){
//         
//            if(textBox4.getText().equals("admin")&&textBox5.getText().equals("admin")){
//        label1.setVisible(true);
//        label2.setVisible(true);
//        label3.setVisible(true);
//        result.setVisible(true);
//        textBox1.setVisible(true);
//        textBox2.setVisible(true);
//        textBox3.setVisible(true);
//        compare.setVisible(true);
//        textBox4.setVisible(false);
//        textBox5.setVisible(false);
//        label5.setVisible(false);
//        label4.setVisible(false);
//        login.setVisible(false);
//        message.setVisible(false);
//
//            }else{
//                textBox4.setText("");
//                textBox5.setText("");
//                message.setVisible(true);
//
//            }
//        }
//        }
    private class CompareButtonListner implements ActionListener {

        public void actionPerformed(ActionEvent event){
            try {
                //        String a = "I am sitting near the bank of river.";
                //	String b = "Bank interest rate are going down.";
                     String a = textBox1.getText();
                     String b = textBox2.getText();
                     String c = textBox3.getText();
                       // Compare c = new Compare(a, b);
                       // System.out.println("Similarity between the sentences\n-" + a + "\n-"
                       //                         + b + "\n is: " + c.getResult());
                       // result.setText("Similarity between the sentences\n-" + a + "\n-"
                       //                         + b + "\n is: " + c.getResult());    
               
                if(a.contains(c)){
                   if(a.contains(b)){
           //            message.setVisible(false);
                   result.setText(SemanticSearch.getNoun(a,b,c));
                   }else{
             //          message.setVisible(true);
               //        message.setText("The contextual word is not present in sentence");
                   }
               }else{
                 //      message.setVisible(true);
                   //    message.setText("The word is not present in sentence");
               }
                      
            } catch (Exception ex) {
                Logger.getLogger(Usage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
