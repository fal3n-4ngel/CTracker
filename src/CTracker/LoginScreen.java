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

public class LoginScreen extends JPanel {
    public JTextField tUser=null;
    public JTextField tpass=null;
    public JFrame parentFrame = null;

    LoginScreen(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        buttonEvent obj= new buttonEvent();
        setLayout(new GridBagLayout());
        
        JPanel LoginContainer=new JPanel();
        LoginContainer.setLayout(new BoxLayout(LoginContainer,BoxLayout.Y_AXIS));
        JLabel Llog=new JLabel("Log In");
        LoginContainer.add(Llog);

        JPanel LoginContainerUser=new JPanel();
        LoginContainerUser.setLayout(new BoxLayout(LoginContainerUser,BoxLayout.X_AXIS));
        JLabel Luser=new JLabel("UserName:");
        LoginContainerUser.add(Luser);
        tUser=new JTextField(20);
        LoginContainerUser.add(tUser);

        JPanel LoginContainerPass=new JPanel();
        LoginContainerPass.setLayout(new BoxLayout(LoginContainerPass,BoxLayout.X_AXIS));
        JLabel Lpass=new JLabel("Password:");
        LoginContainerPass.add(Lpass);
        tpass=new JTextField(20);
        LoginContainerPass.add(tpass);

        JButton b1= new JButton("Log In");
        b1.addActionListener(obj);
        LoginContainer.add(LoginContainerUser);
        LoginContainer.add(LoginContainerPass);
        LoginContainer.add(b1);
        add(LoginContainer);
    }

class buttonEvent implements ActionListener{
        buttonEvent(){}
        public void actionPerformed(ActionEvent e){
            Connector Con=new Connector();
            try{
                ResultSet rs= Con.execute("SELECT PASS FROM USERS WHERE NAME='"+tUser.getText()+"'");
                if(rs.next()==false){
                    System.out.println("New User");
                    return;
                }
                if(rs.getString("PASS").equals(tpass.getText())){
                    System.out.println("Logged In");
                    parentFrame.getContentPane().setVisible( false );
                    parentFrame.setContentPane(new HomePage(parentFrame,tUser.getText()));
                    
                    return;
                }
                else{
                    System.out.println("Wrong PassWord");
                    return;
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
    }
}
