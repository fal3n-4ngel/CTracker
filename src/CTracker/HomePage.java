package CTracker;
import java.sql.ResultSet;
import CTracker.util.Connector;
import CTracker.util.styles;
import CTracker.components.todoblock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;
import CTracker.util.globals;

public class HomePage extends JPanel{
    public JFrame parentFrame = null; 
    public JPanel centerpane;
    public JScrollPane centerbar; 
    
    
    HomePage(JFrame parentFrame,String user){
        this.parentFrame=parentFrame;
        buttonEvent obj = new buttonEvent();
        
        
        setLayout(null);

        JPanel userPanel=new JPanel();
        userPanel.setLayout(null);
        userPanel.setBackground(new Color(255, 255, 255));
        userPanel.setBounds(0,0,300,700);

        // Profile Image
        JLabel ProfileImage = new JLabel(); 
        ImageIcon imageIcon = new ImageIcon("images/account.png"); 
        Image image = imageIcon.getImage();  
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        ProfileImage.setIcon(imageIcon); 
        Dimension size =ProfileImage.getPreferredSize();
        ProfileImage.setBounds(70, 50, size.width, size.height);

        //user name
        JUserLabel userNameLabel=new JUserLabel(user);
        userNameLabel.setBounds(75, 205,150, 50);

        // the Nuttons
        JUserButton addButton = new JUserButton("New");
        addButton.setBounds(80, 300,120, 50);
        addButton.addActionListener(obj);
        JUserButton creditButton = new JUserButton("Credits");
        creditButton.setBounds(80, 400,120, 50);
        JUserButton helpButton = new JUserButton("Help");
        helpButton.setBounds(80, 500,120, 50);


        userPanel.add(userNameLabel);
        userPanel.add(addButton);
        userPanel.add(creditButton);
        userPanel.add(helpButton);
        userPanel.add(ProfileImage);
        add(userPanel);


        JPanel labelpanel=new JPanel();
        int color[]=new int[]{ 255,255,255}; 
        labelpanel.setOpaque(true);
        labelpanel.setLayout(new GridLayout(1,5));
        labelpanel.setBorder(new styles(20, color));
        labelpanel.add(new JTitLabel("Subject"));
        labelpanel.add(new JTitLabel("Details"));
        labelpanel.add(new JTitLabel("Date"));
        labelpanel.add(new JTitLabel("Progress"));
        labelpanel.add(new JTitLabel("     Delete"));
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
        centerpane.setBounds(320,0,650,700);
        add(centerpane);  

    }
    
    class buttonEvent implements ActionListener{
        buttonEvent(){}
        public void actionPerformed(ActionEvent e){
            JFrame addTask = new AddTask();
            addTask.setVisible(true);
            
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
        globals.rse= Con.execute("SELECT * FROM Todos");
        System.out.print("Done");
        globals.c=0;
        while(globals.rse.next()!=false){
            globals.c++;
        }
        globals.rse= Con.execute("SELECT * FROM Todos");
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