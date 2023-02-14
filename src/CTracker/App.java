package CTracker;
import javax.swing.JFrame;

import CTracker.screens.LoginScreen;

public class App {
    public static JFrame ctracker;
    public static void main(String[] args) {
        ctracker = new JFrame("C Tracker");
        ctracker.setSize(1150,700);
        ctracker.setResizable(false);
        LoginScreen sc = new LoginScreen(ctracker);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                sc.createLogin();
            }
        });
    }
}