package CTracker;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.sql.ResultSet;
import CTracker.util.Connector;
import CTracker.util.styles;
import CTracker.components.todoblock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import java.awt.Font;

public class HomeScreen extends JPanel{
    public JFrame parentFrame = null;
    ResultSet rs=null;
    int c;
    public JPanel centerpane;
    public JScrollPane centerbar;
    HomeScreen(JFrame parentFrame,String user){
        setLayout(null);
        
        Connector Con=new Connector();
        try{
            rs= Con.execute("SELECT * FROM Todos");
            System.out.print("Done");
            c=0;
            while(rs.next()!=false){
                c++;
            }
            rs= Con.execute("SELECT * FROM Todos");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        JPanel userpanel=new JPanel();        
        userpanel.setOpaque(false);
        
        userpanel.setBackground(new Color(255, 255, 255));
        userpanel.setBounds(0,0,300,700);
        add(userpanel);

        JPanel midpanel1=new JPanel();        
        midpanel1.setOpaque(true);
        midpanel1.setBackground(new Color(255, 255, 255));
        midpanel1.setBounds(0,0,300,700);
        add(midpanel1);

        JPanel labelpanel=new JPanel();
        labelpanel.setOpaque(true);
        labelpanel.setLayout(new GridLayout(1,5));
        labelpanel.setBorder(new styles(20, 255255255));
        labelpanel.add(new JTitLabel("Subject"));
        labelpanel.add(new JTitLabel("Details"));
        labelpanel.add(new JTitLabel("Start Date"));
        labelpanel.add(new JTitLabel("Progress"));
        labelpanel.setBackground(new Color(255, 255, 255));

        JPanel midpanel=new JPanel();
        midpanel.setSize(600, 10);
        midpanel.setBackground(new Color(255, 255, 255));
        centerpane=new JPanel();
        centerpane.setOpaque(true);
        centerpane.setLayout(new BoxLayout(centerpane, BoxLayout.Y_AXIS));
        centerpane.add(labelpanel);
        centerpane.add(panecreator(5));
        centerpane.add(midpanel);
        centerpane.setBorder(null);
        centerpane.setBounds(300,0,680,700);
        add(centerpane);   
    }


    public JScrollPane panecreator(int val){

        JPanel panel=new JPanel();
        JScrollPane centerbar;
        panel.setBackground(new Color(255, 255, 255));
        centerbar=new JScrollPane(panel);

        try{
            ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,0,10));
            centerbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            centerbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
            centerbar.getViewport();
            centerbar.setLayout(new ScrollPaneLayout());
            centerbar.setBorder(null);
            if(c<5){
                ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,10,10));
            }
            else{
                ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(c,1,10,10));
            }
            while(rs.next()!=false){
                ((JPanel)centerbar.getViewport().getView()).add(new todoblock(700, 75,rs));}
            }
        catch(Exception e){
            System.out.println(e);
        }
        return centerbar;
    }   
}

class JTitLabel extends JLabel {
    JTitLabel(String content){
        setText(content);
        setForeground(Color.BLACK);
        setBackground(new Color(255, 255, 255));
        setOpaque(false);
        setFont(new Font("Verdana", Font.PLAIN, 20));
        setPreferredSize(new Dimension(50, 50));
    }
}