
import documentclassifier.DocumentClassifierApp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Sony
 */
public class Dashboard extends JPanel{
    
    JButton mod1;
    JButton mod2;
    JButton mod3;
    
    public Dashboard(){
    
    JButton mod1=new JButton("Word Search        ");
    JButton mod2=new JButton("Sentence Search    ");
    JButton mod3=new JButton("Document Clustering");
        
        
        mod1.addActionListener(new ModListener());
        mod2.addActionListener(new ModListenerS());
        mod3.addActionListener(new ModListenerD());
        
        add(mod1);
        add(mod2);
        add(mod3);
        
         setPreferredSize(new Dimension(320, 400));
        setBackground(Color.orange);
    }
    
    private class ModListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            new SemanticSearchApp().showSearch();
        }
        
    }
    
    private class ModListenerS implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            new Usage().showUsage();
        }
        
    }
    
    private class ModListenerD implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            new DocumentClassifierApp().cluster(null);
        }
        
    }
    
    public void showDashboard(){
        
        JFrame frame = new JFrame ("Compare");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setLocation(400, 100);
      frame.setTitle("Contextual Meaning Search");
      frame.getContentPane().add(new Dashboard());

      frame.pack();
      frame.setVisible(true);
    }
}
