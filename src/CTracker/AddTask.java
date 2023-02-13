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
    

public class AddTask extends JFrame {

    
    AddTask(){
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
    
    String[] choices1 = {"Discrete Maths","Logic System Design", "Data Structures","Professional Ethics","Sustainable Engineering","Object Oriented Programming"};

    final JComboBox<String> cb1 = new JComboBox<String>(choices1);
    cb1.setBounds(250,105,260,30);
    cb1.setVisible(true);
    panel.add(cb1);

    
    JTitLabel lb3 = new JTitLabel("Details: ");
    lb3.setBounds(60,150,100,40);
    lb3.setVisible(true);

    panel.add(lb3);

    JTextField tf1=new JTextField();
    tf1.setBounds(250,155,260,30);
    tf1.setVisible(true);
    panel.add(tf1);

    JTitLabel lb4 = new JTitLabel("Date: ");
    lb4.setBounds(60,210,160,20);
    lb4.setVisible(true);

    panel.add(lb4);

    JTextField tf2=new JTextField();
    tf2.setBounds(250,205,260,30);
    tf2.setVisible(true);
    panel.add(tf2);


    JTitLabel lb2 = new JTitLabel("Status: ");
    lb2.setBounds(60,250,100,40);
    lb2.setVisible(true);

    panel.add(lb2);

    String[] choices2 = {"Ongoing","Pending"};

    final JComboBox<String> cb2 = new JComboBox<String>(choices2);
    cb2.setBounds(250,255,260,30);
    cb2.setVisible(true);
    panel.add(cb2);

    JUserButton btn2 = new JUserButton("Submit");
    btn2.setBounds(200,350,150,50);
    btn2.setVisible(true);
    panel.add(btn2);

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