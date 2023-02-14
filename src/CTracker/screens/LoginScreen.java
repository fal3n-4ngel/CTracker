package CTracker.screens;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import CTracker.util.Connector;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import static javax.swing.JOptionPane.*;

public class LoginScreen extends JPanel implements ActionListener {

    public JFrame parentFrame = null;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JUserButton loginButton;

    public LoginScreen(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void createLogin() {
        this.setBackground(Color.GREEN);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        parentFrame.add(this);

        // left panel
        JPanel lleftPanel = new JPanel();
        lleftPanel.add(new MyLabel(700,1000, Color.CYAN, Color.GREEN, Color.WHITE, Color.CYAN));
    
       this.add(lleftPanel);
        leftPanel(lleftPanel);

        //login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setBackground(Color.WHITE);
       
        this.add(loginPanel);
        rightPanel(loginPanel);

        parentFrame.setVisible(true);

    }

    public  void leftPanel(JPanel panel) {
        try {
            
       
  
          
            Dimension size = new Dimension(600,1000);
         
            panel.setPreferredSize(size);
            panel.setMinimumSize(size);
            panel.setMaximumSize(size);
            // panel.setSize(size);
            JLabel appName = new JLabel("CTracker");
            appName.setFont(new Font("Century", Font.PLAIN, 100));
           appName.setForeground(Color.WHITE);
           appName.setBounds(100, 400,400, 400);
           // panel.add(appName);
     panel.setForeground(Color.GREEN);
           
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void rightPanel(JPanel panel) {
        
       
       
        final int LEFT_MARGIN = 80;
        final int TOP_MARGIN = 180+30;
        panel.setLayout(null);
        JUserLabel login = new JUserLabel("Login");
        
        login.setBounds( LEFT_MARGIN+100, 34,700,200);
        login.setFont(new Font("Century", Font.PLAIN, 60));
      
        panel.add(login);
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(LEFT_MARGIN+50, TOP_MARGIN, 80, 25);
        panel.add(userLabel);
     
        userText = new JTextField(20);
        userText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        userText.setBounds(LEFT_MARGIN+50, TOP_MARGIN +40, 260, 30);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(LEFT_MARGIN+50, TOP_MARGIN + 80, 80, 30);
        panel.add(passwordLabel);
        passwordText = new JPasswordField(20);
        passwordText.setBounds(LEFT_MARGIN +50, TOP_MARGIN + 120, 260, 30);
        passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        panel.add(passwordText);
        loginButton = new JUserButton("Login");
        loginButton.setBounds(LEFT_MARGIN+120 , TOP_MARGIN + 200, 105, 40);
        panel.add(loginButton);
        loginButton.addActionListener(this);
    }

    public static String encode(String Text)  {
        try {
            // convert the text to UTF-8
            byte[] textBytes = Text.getBytes(StandardCharsets.UTF_8);

            // hash the password input and convert to base64 code
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            return new String(
                    Base64.getEncoder().encode(hash.digest(textBytes)));
       } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void actionPerformed(ActionEvent e) {
      //  if (e.getSource() == loginButton) { if??
            Connector Con = new Connector();
            try {

                ResultSet rs = Con.execute("SELECT PASS FROM Users WHERE NAME='" + userText.getText() + "'");
                if (rs.next() == false) {
                    System.out.println("New User");
                    Con.execute("INSERT INTO Users('name','pass') VALUES('" + userText.getText() +"','"+ encode(passwordText.getText()) + "')");
                    showMessageDialog(null, "Creatin a new User", "NEW USER", ERROR_MESSAGE);
                    parentFrame.getContentPane().setVisible(false);
                    parentFrame.setContentPane(new HomePage(parentFrame, userText.getText()));
                    return;
                }
                // hash the password
                String pasw = encode(new String(passwordText.getPassword()));
                // System.out.println(pasw);
                if (rs.getString("PASS").equals(pasw)) {
                    System.out.println("Logged In");
                    parentFrame.getContentPane().setVisible(false);
                    parentFrame.setContentPane(new HomePage(parentFrame, userText.getText()));

                    return;
                } else {
                    System.out.println("Wrong PassWord");
                    showMessageDialog(null, "Wrong password!", "Error", ERROR_MESSAGE);
                    return;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
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
        setForeground(Color.WHITE);
        setBackground(new Color(68,217,182,255));
        setFont(new Font("Century", Font.PLAIN, 18));
        
    }
}
 class MyLabel extends JLabel{
    private BufferedImage image0;
    private BufferedImage image1;
    private BufferedImage image2;
    private Color noColor = new Color(255, 255, 255, 0);
    private int size;
    public MyLabel(int size,int size1, Color leftTop, Color rightTop, Color leftBottom, Color rightBottom){
        super();
        image0 = getTwoWayGradient(size, rightTop,leftBottom);
        image1 = getLeftGradient(size, leftTop);
        image2 = getRightGradient(size, rightBottom);
        this.size = size;
        this.setPreferredSize(new Dimension(size, size1));
    }

    private BufferedImage getTwoWayGradient(int size,Color rightTop,Color leftBottom) {
        image0 = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image0.createGraphics();
        GradientPaint twoColorGradient = new GradientPaint(size, 0f, rightTop, 0, size, leftBottom);
        g2d.setPaint(twoColorGradient);
        g2d.fillRect(0, 0, size, size);
        return image0;
    }

    private BufferedImage getLeftGradient(int size, Color RED) {
        image1 = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image1.createGraphics();
        float radius = size;
        float[] dist = {0f, 1.0f};
        Point2D center = new Point2D.Float(0, 0);
        Color[] colors2 = {RED, noColor};
        RadialGradientPaint two = new RadialGradientPaint(center, radius, dist, colors2);
        g2d.setPaint(two);
        g2d.fillRect(0, 0, size, size);
        return image1;
    }

    private BufferedImage getRightGradient(int size, Color CYAN) {
        image2 = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image2.createGraphics();
        float radius = size;
        float[] dist = {0f, 1.0f};
        Point2D center = new Point2D.Float(size, size);
        Color[] colors2 = {CYAN, noColor};
        RadialGradientPaint three = new RadialGradientPaint(center, radius, dist, colors2);
        g2d.setPaint(three);
        g2d.fillRect(0, 0, size, size);
        return image2;
    }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(image0, 0, 0, null);
        g.drawImage(image2, 0, 0, null);
        g.drawImage(image1, 0, 0, null);
    }
}