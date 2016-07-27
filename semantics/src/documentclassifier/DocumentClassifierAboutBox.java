package documentclassifier;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ApplicationActionMap;
import org.jdesktop.application.ApplicationContext;
import org.jdesktop.application.ResourceMap;

public class DocumentClassifierAboutBox extends JDialog
{
  private static final long serialVersionUID = 1L;
  private JLabel appAuthorLabel;
  private JButton closeButton;

  public DocumentClassifierAboutBox(Frame paramFrame)
  {
    super(paramFrame);
    initComponents();
    getRootPane().setDefaultButton(this.closeButton);
  }

  @Action
  public void closeAboutBox()
  {
    setVisible(false);
  }

  private void initComponents()
  {
    this.closeButton = new JButton();
    JLabel localJLabel1 = new JLabel();
    JLabel localJLabel2 = new JLabel();
    JLabel localJLabel3 = new JLabel();
    JLabel localJLabel4 = new JLabel();
    JLabel localJLabel5 = new JLabel();
    JLabel localJLabel6 = new JLabel();
    JLabel localJLabel7 = new JLabel();
    this.appAuthorLabel = new JLabel();
    setDefaultCloseOperation(2);
    ResourceMap localResourceMap = ((DocumentClassifierApp)Application.getInstance(DocumentClassifierApp.class)).getContext().getResourceMap(DocumentClassifierAboutBox.class);
    setTitle(localResourceMap.getString("title", new Object[0]));
    setModal(true);
    setName("aboutBox");
    setResizable(false);
    ApplicationActionMap localApplicationActionMap = ((DocumentClassifierApp)Application.getInstance(DocumentClassifierApp.class)).getContext().getActionMap(DocumentClassifierAboutBox.class, this);
    this.closeButton.setAction(localApplicationActionMap.get("closeAboutBox"));
    this.closeButton.setName("closeButton");
    localJLabel1.setFont(localJLabel1.getFont().deriveFont(localJLabel1.getFont().getStyle() | 0x1, localJLabel1.getFont().getSize() + 4));
    localJLabel1.setText(localResourceMap.getString("Application.title", new Object[0]));
    localJLabel1.setName("appTitleLabel");
    localJLabel2.setFont(localJLabel2.getFont().deriveFont(localJLabel2.getFont().getStyle() | 0x1));
    localJLabel2.setText(localResourceMap.getString("versionLabel.text", new Object[0]));
    localJLabel2.setName("versionLabel");
    localJLabel3.setText(localResourceMap.getString("Application.version", new Object[0]));
    localJLabel3.setName("appVersionLabel");
    localJLabel4.setFont(localJLabel4.getFont().deriveFont(localJLabel4.getFont().getStyle() | 0x1));
    localJLabel4.setText(localResourceMap.getString("authorLabel.text", new Object[0]));
    localJLabel4.setName("authorLabel");
    localJLabel5.setText(localResourceMap.getString("Application.homepage", new Object[0]));
    localJLabel5.setName("appHomepageLabel");
    localJLabel6.setText(localResourceMap.getString("appDescLabel.text", new Object[0]));
    localJLabel6.setName("appDescLabel");
    localJLabel7.setIcon(localResourceMap.getIcon("imageLabel.icon"));
    localJLabel7.setName("imageLabel");
    this.appAuthorLabel.setText(localResourceMap.getString("appAuthorLabel.text", new Object[0]));
    this.appAuthorLabel.setName("appAuthorLabel");
    GroupLayout localGroupLayout = new GroupLayout(getContentPane());
    getContentPane().setLayout(localGroupLayout);
    localGroupLayout.setHorizontalGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(localGroupLayout.createSequentialGroup().addComponent(localJLabel7).addGap(18, 18, 18).addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(localJLabel1).addComponent(localJLabel6, -1, -1, 32767).addComponent(this.closeButton, GroupLayout.Alignment.TRAILING).addGroup(localGroupLayout.createSequentialGroup().addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(localJLabel2).addComponent(localJLabel4)).addGap(19, 19, 19).addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(localJLabel5).addComponent(localJLabel3).addComponent(this.appAuthorLabel)).addGap(13, 13, 13))).addContainerGap()));
    localGroupLayout.setVerticalGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(localJLabel7, -2, 192, 32767).addGroup(localGroupLayout.createSequentialGroup().addContainerGap().addComponent(localJLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(localJLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(localJLabel2).addComponent(localJLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(localGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(localJLabel4).addComponent(localJLabel5).addComponent(this.appAuthorLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, 32767).addComponent(this.closeButton).addContainerGap()));
    pack();
  }
}

/* Location:           D:\piyush code\semantic search\DocumentClassifier\DocumentClassifier\DocumentClassifier - Copy.jar
 * Qualified Name:     documentclassifier.DocumentClassifierAboutBox
 * JD-Core Version:    0.6.2
 */