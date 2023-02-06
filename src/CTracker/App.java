package CTracker;
import javax.swing.JFrame;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args)  {
        JFrame ctracker=new JFrame("C Tracker");
        ctracker.setSize(1000,700);
        ctracker.setContentPane(new LoginScreen(ctracker));
        ctracker.setVisible(true);
    }
}
