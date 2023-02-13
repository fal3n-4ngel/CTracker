package CTracker;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import CTracker.util.Connector;
import CTracker.components.todoblock;
import java.awt.GridLayout;
import CTracker.util.globals;

public class AddTask extends JFrame {
    public static JComboBox<String> cb1;
    public static JTextField tf1;
    public static JTextField tf2;
    public static JComboBox<String> cb2;
    public String user;
    public JScrollPane centerbar;
    public JFrame parentFrame;
    buttonEvent obj = new buttonEvent();
    
    
    AddTask(String username,JScrollPane centerbar,JFrame parentFrame){
        this.centerbar=centerbar;
        setTitle("Add TAsk");
        setBounds(300, 100, 600, 500);
        this.parentFrame=parentFrame;
        this.user=username;
        this.setBackground(Color.WHITE);
        this.setSize(600, 500);
        this.setResizable(false);

    JPanel panel = new JPanel();
    this.add(panel);
    panel.setSize(400,400);    
    panel.setBackground(Color.white);
    panel.setVisible(true);    
    panel.setLayout(null);

    JTitLabel lb1 = new JTitLabel("Subject: ");
    lb1.setBounds(60,100,100,40);
    lb1.setVisible(true);

    panel.add(lb1);
    
    String[] choices1 = {"Discrete Maths","Logic System", "Data Structures","Professional Ethics","Sustainable Engineering","OOP Java"};

    cb1 = new JComboBox<String>(choices1);
    cb1.setBounds(250,105,260,30);
    cb1.setVisible(true);
    panel.add(cb1);

    
    JTitLabel lb3 = new JTitLabel("Details: ");
    lb3.setBounds(60,150,100,40);
    lb3.setVisible(true);

    panel.add(lb3);

    tf1=new JTextField();
    tf1.setBounds(250,155,260,30);
    tf1.setVisible(true);
    panel.add(tf1);

    JTitLabel lb4 = new JTitLabel("Date: ");
    lb4.setBounds(60,210,160,20);
    lb4.setVisible(true);

    panel.add(lb4);

    tf2=new JTextField();
    tf2.setBounds(250,205,260,30);
    tf2.setVisible(true);
    panel.add(tf2);


    JTitLabel lb2 = new JTitLabel("Status: ");
    lb2.setBounds(60,250,100,40);
    lb2.setVisible(true);

    panel.add(lb2);

    String[] choices2 = {"Ongoing","Pending"};

    cb2 = new JComboBox<String>(choices2);
    cb2.setBounds(250,255,260,30);
    cb2.setVisible(true);
    panel.add(cb2);

    JUserButton btn2 = new JUserButton("Submit");
    btn2.setBounds(200,350,150,50);
    btn2.setVisible(true);
    btn2.addActionListener(obj);
    panel.add(btn2);

    }

    class buttonEvent implements ActionListener{
        buttonEvent(){}
        public void actionPerformed(ActionEvent e){
            Connector Con=new Connector();
    try{
        globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+user+"'");
        System.out.print("Done");
        globals.c=0;
        while(globals.rse.next()!=false){
            globals.c++;
        }
        globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+user+"'");
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
            String subject=cb1.getSelectedItem().toString();
            String details=tf1.getText();
            String date=tf2.getText();
            String status =cb2.getSelectedItem().toString();
            
            globals.c++;
            try{
                
                
                parentFrame.revalidate();
                parentFrame.repaint();
                parentFrame.getContentPane().setVisible(false);
                Con.execute("Insert into todos('userid','subject','desc','date','status') values('"+user+"','"+subject +"','"+details+"','"+date+"','"+status+"')");
                parentFrame.setVisible(true);
                parentFrame.setContentPane(new loading());
                parentFrame.getContentPane().setVisible(false);
                parentFrame.setContentPane(new HomePage(parentFrame, user));
                parentFrame.getContentPane().setVisible(true);
                setVisible(false);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    public JScrollPane panecreator(int val){
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout());
        JScrollPane centerbar;
        panel.setBackground(new Color(255, 255, 255));
        centerbar=new JScrollPane(panel);
        Connector Con=new Connector();
        try{
            globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+user+"'");
            System.out.print("Done");
            globals.c=0;
            while(globals.rse.next()!=false){
                globals.c++;
            }
            globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+user+"'");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,0,10));
            centerbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            centerbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);       
            centerbar.setBorder(null);
            if(globals.c<5){
                ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,10,10));
            }
            else{
                ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(globals.c,1,10,10));
            }
            while(globals.rse.next()!=false){
                ((JPanel)centerbar.getViewport().getView()).add(new todoblock(600, 75,globals.rse,centerbar,parentFrame));}
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

class JUserLabel extends JLabel {
    JUserLabel(String content){
        setText(content);
        setForeground(new Color(18,61,104,255));
        setBackground(new Color(255, 255, 255));
        setOpaque(false);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
        setPreferredSize(new Dimension(50, 50));
    }
}

class RoundedBorder extends LineBorder {

    private int radius;
    RoundedBorder(Color c, int thickness, int radius) {
        super(c, thickness, true);
        this.radius = radius;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        // adapted code of LineBorder class
        if ((this.thickness > 0) && (g instanceof Graphics2D)) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            Color oldColor = g2d.getColor();
            g2d.setColor(this.lineColor);

            Shape outer;
            Shape inner;

            int offs = this.thickness;
            int size = offs + offs;
            outer = new RoundRectangle2D.Float(x, y, width, height, 0, 0);
            inner = new RoundRectangle2D.Float(x + offs, y + offs, width - size, height - size, radius, radius);
            Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
            path.append(outer, false);
            path.append(inner, false);
            g2d.fill(path);
            g2d.setColor(oldColor);
        }
    }
}


class JUserButton extends JButton{
    JUserButton(String content){
        setText(content);
        setBorder(new RoundedBorder(new Color(255, 255, 255),1,20));
        setForeground(new Color(18,61,104,255));
        setBackground(new Color(68,217,182,255));
        setFont(new Font("Century", Font.PLAIN, 18));
        
    }
}