package CTracker;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import CTracker.util.Connector;
import CTracker.util.styles;
import CTracker.App.*;
import CTracker.HomeScreen.*;
import CTracker.components.todoblock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;



public class HomeScreen extends JPanel{
    public JFrame parentFrame = null;
    ResultSet rs=null;
    public JPanel centerpane;
    public JScrollPane centerbar;
    HomeScreen(JFrame parentFrame,String user){


        Connector Con=new Connector();
        try{
            rs= Con.execute("SELECT * FROM Todos");
            System.out.print("Done"); 

        }
        catch(Exception ex){
            ex.printStackTrace();
        }


        setLayout(new BorderLayout(30,5));


        JPanel labelpanel=new JPanel();
        labelpanel.setBorder(new styles(20, 0x000000));
        labelpanel.setOpaque(false);
        labelpanel.setLayout(new GridLayout(1,4));


        labelpanel.add(new JLabel("Subject"));
        labelpanel.add(new JLabel("Details"));
        labelpanel.add(new JLabel("Start Date"));
        labelpanel.add(new JLabel("Progress"));
        
 
        centerpane=new JPanel();
        centerpane.setOpaque(false);
        centerpane.setLayout(new BoxLayout(centerpane, BoxLayout.Y_AXIS));
        centerpane.add(labelpanel);
        centerpane.add(panecreator(5));
        centerpane.setBorder(null);
        add(centerpane,BorderLayout.CENTER);   
    }


    public JScrollPane panecreator(int val){
        JPanel panel=new JPanel();
        JScrollPane centerbar;
        panel.setBackground(new Color(0x101010));
        centerbar=new JScrollPane(panel);

        try{
            ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,0,10));
        centerbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        centerbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        centerbar.getViewport().setBackground(new Color(0x101010));
        centerbar.setLayout(new ScrollPaneLayout());
        centerbar.setBorder(null);
        ((JPanel)centerbar.getViewport().getView()).add(new todoblock(500, 75,rs));

        // obj.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
    finally{
        return centerbar;
    }
    
    
    } 

    
}







