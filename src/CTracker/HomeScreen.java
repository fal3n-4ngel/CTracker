package CTracker;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeScreen extends JPanel{
    public JFrame parentFrame = null;
    HomeScreen(JFrame parentFrame){
        JLabel l1=new JLabel("Home");
        add(l1);
    }
}
