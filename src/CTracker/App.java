package CTracker;
import javax.swing.JFrame;
public class App {  
    public static void main(String[] args)  {
        JFrame ctracker=new JFrame("C Tracker");
        ctracker.setSize(1150,700);
        ctracker.setContentPane(new HomePage(ctracker, "username"));
        ctracker.setResizable(false);
        ctracker.setVisible(true);
    }
}
