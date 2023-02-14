package CTracker.screens;
import CTracker.util.Connector;
import CTracker.util.styles;
import CTracker.components.todoblock;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import CTracker.util.globals;

public class HomePage extends JPanel{
    public JFrame parentFrame = null; 
    public JPanel centerpane;
    public JScrollPane centerbar;
    public String user; 
    
    
    public HomePage(JFrame parentFrame,String user){
        this.parentFrame=parentFrame;
        this.user=user;
        globals.user=user;
        buttonEvent obj = new buttonEvent();
        buttonCreditEvent obj1 = new buttonCreditEvent();
        buttonHelpEvent obj2 = new buttonHelpEvent();
        
        setLayout(null);

        JPanel userPanel=new JPanel();
        userPanel.setLayout(null);
        userPanel.setBackground(new Color(255, 255, 255));
        userPanel.setBounds(0,0,300,700);

        // Profile Image
        JLabel ProfileImage = new JLabel(); 
        ImageIcon imageIcon = new ImageIcon("images/account.png"); 
        Image image = imageIcon.getImage();  
        Image newimg = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(newimg);
        ProfileImage.setIcon(imageIcon); 
        Dimension size =ProfileImage.getPreferredSize();
        ProfileImage.setBounds(70, 50, size.width, size.height);

        //user name
        JUserLabel userNameLabel=new JUserLabel(user);
        userNameLabel.setBounds(75, 205,150, 50);

        // the Nuttons
        JUserButton addButton = new JUserButton("New");
        addButton.setBounds(80, 300,120, 50);
        addButton.addActionListener(obj);
        JUserButton creditButton = new JUserButton("Credits");
        creditButton.setBounds(80, 400,120, 50);
        creditButton.addActionListener(obj2);
        JUserButton helpButton = new JUserButton("Help");
        helpButton.setBounds(80, 500,120, 50);
        helpButton.addActionListener(obj1);


        userPanel.add(userNameLabel);
        userPanel.add(addButton);
        userPanel.add(creditButton);
        userPanel.add(helpButton);
        userPanel.add(ProfileImage);
        add(userPanel);


        JPanel labelpanel=new JPanel();
        int color[]=new int[]{ 255,255,255}; 
        labelpanel.setOpaque(true);
        labelpanel.setLayout(new GridLayout(1,5));
        labelpanel.setBorder(new styles(20, color));
        labelpanel.add(new JTitLabel("Subject"));
        labelpanel.add(new JTitLabel("Details"));
        labelpanel.add(new JTitLabel("Date"));
        labelpanel.add(new JTitLabel("Progress"));
        labelpanel.add(new JTitLabel("     Delete"));
        labelpanel.setBackground(new Color(255, 255, 255));

        JPanel midpanel=new JPanel();
        midpanel.setSize(600, 10);
        midpanel.setBackground(new Color(255, 255, 255));
        centerpane=new JPanel();
        centerpane.setOpaque(true);
        centerpane.setLayout(new BoxLayout(centerpane, BoxLayout.Y_AXIS));
        centerpane.add(labelpanel);
        centerpane.add(panecreator(5));
        centerpane.add(midpanel);
        centerpane.setBorder(null);
        centerpane.setBounds(320,0,800,700);
        add(centerpane);  

    }
    
    class buttonEvent implements ActionListener{
        buttonEvent(){}
        public void actionPerformed(ActionEvent e){
            JFrame addTask = new AddTask(user,centerbar,parentFrame);
            addTask.setVisible(true);
            
        }
    }

    class buttonCreditEvent implements ActionListener{
        buttonCreditEvent(){}
        public void actionPerformed(ActionEvent e){
            JFrame help = new helpScreen();
            help.setVisible(true);
            
        }
    }
    class buttonHelpEvent implements ActionListener{
        buttonHelpEvent(){}
        public void actionPerformed(ActionEvent e){
            JFrame credit = new creditsScreen();
            credit.setVisible(true);
            
        }
    }

public JScrollPane panecreator(int val){
    JPanel panel=new JPanel();
    panel.setLayout(new GridLayout());
    JScrollPane centerbar;
    panel.setBackground(new Color(255, 255, 255));
    centerbar=new JScrollPane(panel);
    Connector Con=new Connector();
    try{
        globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+user+"'");
        System.out.print("Done");
        globals.c=0;
        while(globals.rse.next()!=false){
            globals.c++;
        }
        globals.rse= Con.execute("SELECT * FROM Todos WHERE userid='"+user+"'");
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
    try{
        ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,0,10));
        centerbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        centerbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);       
        centerbar.setBorder(null);
        if(globals.c<5){
            ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(5,1,10,10));
        }
        else{
            ((JPanel)centerbar.getViewport().getView()).setLayout(new GridLayout(globals.c,1,10,10));
        }
        while(globals.rse.next()!=false){
            ((JPanel)centerbar.getViewport().getView()).add(new todoblock(600, 75,globals.rse,centerbar,parentFrame));}
        }
    catch(Exception e){
        System.out.println(e);
    }
    return centerbar;
}   
}

