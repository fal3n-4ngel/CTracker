package CTracker.components;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import CTracker.screens.HomePage;
import CTracker.screens.loading;
import CTracker.util.Connector;
import CTracker.util.styles;
import CTracker.util.globals;

public class todoblock extends JPanel{
    public JButton delete;
    public todoblock block;
    public ResultSet todoss;
    public String field1,field2,field3,field4,field5;
    public JScrollPane centerbar;
    public JFrame parentFrame;
    public todoblock (int width,int height,ResultSet todoss,JScrollPane centerbar,JFrame parentFrame) throws SQLException{
        this.block=this;
        this.centerbar=centerbar;
        this.todoss=todoss;
        this.parentFrame=parentFrame;
        buttonEvent obj= new buttonEvent();
        field1=todoss.getString("subject");
        field2=todoss.getString("desc");
        field3=todoss.getString("date");
        field4=todoss.getString("Status");
        field5=todoss.getString("rowid");

        int color[]=new int[]{ 65, 71, 70}; 
        setBorder(new styles(20, color));
        setOpaque(false);
        setLayout(new GridLayout(1,5));
        JLabel subjectPane=new JLabel(field1);
        subjectPane.setForeground(Color.white);
        JLabel descPane=new JLabel(field2);
        descPane.setForeground(Color.white);
        JLabel datejPane=new JLabel(field3);
        datejPane.setForeground(Color.white);
        JLabel statusPane=new JLabel(field4);
        statusPane.setForeground(Color.white);


        JButton DeleteImage = new JButton(); 
        DeleteImage.setOpaque(false);
        DeleteImage.setContentAreaFilled(false);
        DeleteImage.setBorderPainted(false);
        DeleteImage.setSize(10,10);
        ImageIcon imageIcon = new ImageIcon("images/delete.png"); 
        Image image = imageIcon.getImage();  
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        DeleteImage.setIcon(imageIcon); 
        DeleteImage.addActionListener(obj);
        add(subjectPane);
        add(descPane);
        add(datejPane);
        add(statusPane);
        add(DeleteImage);
    }

    class buttonEvent implements ActionListener{
        buttonEvent(){}
        public void actionPerformed(ActionEvent e){
            Connector Con=new Connector();
            try{
                Con.execute("DELETE FROM todos WHERE rowid="+field5);
                
                try{
                    globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+globals.user+"'");
                    System.out.print("Done");
                    globals.c=0;
                    while(globals.rse.next()!=false){
                        globals.c++;
                    }
                    globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+globals.user+"'");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                
                }
                
                ((JPanel)centerbar.getViewport().getView()).remove(block);
                centerbar.revalidate();
                centerbar.repaint();
                parentFrame.setContentPane(new loading());
                parentFrame.getContentPane().setVisible(false);
                parentFrame.setContentPane(new HomePage(parentFrame, globals.user));
                parentFrame.getContentPane().setVisible(true);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
    }
}

