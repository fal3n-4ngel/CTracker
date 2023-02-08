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

public class tempRun extends JPanel {
    public JTextField cmd=null;
    
    tempRun() {
        buttonEvent obj= new buttonEvent();
        setLayout(new GridBagLayout()); 
        JPanel LoginContainer=new JPanel();
        LoginContainer.setLayout(new BoxLayout(LoginContainer,BoxLayout.Y_AXIS));
        JLabel Llog=new JLabel("Query Executor");
        LoginContainer.add(Llog);
        JButton b1= new JButton("Execute");
        b1.addActionListener(obj);
        LoginContainer.add(b1);
        add(LoginContainer);
    }

class buttonEvent implements ActionListener{
        buttonEvent(){}
        public void actionPerformed(ActionEvent e){
            Connector Con=new Connector();
            try{
                ResultSet rs= Con.execute("SELECT * FROM Todos");
                while(rs.next()){
                    System.out.println("Subject="+rs.getString("Subject"));
                }
                System.out.print("Done"); 

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
        }
    }
}

