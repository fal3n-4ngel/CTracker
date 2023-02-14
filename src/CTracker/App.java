package CTracker;
import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        JFrame ctracker = new JFrame("C Tracker");
        ctracker.setSize(1150,700);
        LoginScreen sc = new LoginScreen(ctracker);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sc.createLogin();
            }
        });
    }
}