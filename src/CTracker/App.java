package CTracker;
import javax.swing.JFrame;
import CTracker.*;
import CTracker.HomePage.*;
public class App {  
    public static void main(String[] args)  {
        JFrame ctracker=new JFrame("C Tracker");
        ctracker.setSize(1000,700);
        ctracker.setContentPane(new HomePage(ctracker, "username"));
        ctracker.setResizable(false);
        ctracker.setVisible(true);
    }
}
