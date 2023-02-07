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
import CTracker.App.*;
import CTracker.HomeScreen.*;

public class HomeScreen extends JPanel{
    public JFrame parentFrame = null;
    HomeScreen(JFrame parentFrame){
        setLayout(new GridBagLayout());
        JLabel l1=new JLabel("Home Screen");
        add(l1);

        JPanel HomePanel=new JPanel();
        HomePanel.setLayout(new BoxLayout(HomePanel,BoxLayout.Y_AXIS));
        add(HomePanel);
    }
}
