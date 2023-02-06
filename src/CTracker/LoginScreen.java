package CTracker;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import CTracker.util.Connector;


public class LoginScreen extends JPanel {
    LoginScreen(){
        

        setLayout(new GridBagLayout());
        
        JPanel LoginContainer=new JPanel();
        LoginContainer.setLayout(new BoxLayout(LoginContainer,BoxLayout.Y_AXIS));
        JLabel Llog=new JLabel("Log In");
        LoginContainer.add(Llog);

        JPanel LoginContainerUser=new JPanel();
        LoginContainerUser.setLayout(new BoxLayout(LoginContainerUser,BoxLayout.X_AXIS));
        JLabel Luser=new JLabel("UserName:");
        LoginContainerUser.add(Luser);
        JTextField tUser=new JTextField(20);
        LoginContainerUser.add(tUser);

        JPanel LoginContainerPass=new JPanel();
        LoginContainerPass.setLayout(new BoxLayout(LoginContainerPass,BoxLayout.X_AXIS));
        JLabel Lpass=new JLabel("Password:");
        LoginContainerPass.add(Lpass);
        JTextField t1=new JTextField(20);
        LoginContainerPass.add(t1);

        JButton b1= new JButton("Log In");
    

        LoginContainer.add(LoginContainerUser);
        LoginContainer.add(LoginContainerPass);
        LoginContainer.add(b1);
        add(LoginContainer);
    }
    
  
}
