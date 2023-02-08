package CTracker.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CTracker.util.styles;




public class todoblock extends JPanel{

    public JButton delete;
    public todoblock block;
    public ResultSet todoss;

    public String field1,field2,field3,field4;

    public todoblock (int width,int height,ResultSet todoss) throws SQLException{
        this.block=this;
        this.todoss=todoss;


        System.out.print("1");
        field1=todoss.getString("subject");
        field2=todoss.getString("desc");
        field3=todoss.getString("datej");
        field4=todoss.getString("Status");

        setBorder(new styles(20, 0x000000));
        setOpaque(false);
        setPreferredSize(new Dimension(width,height));
        setLayout(new GridLayout(1,4));

        JLabel subjectPane=new JLabel(field1);
        subjectPane.setForeground(Color.white);

        JLabel descPane=new JLabel(field2);
        descPane.setForeground(Color.white);

        JLabel datejPane=new JLabel(field3);
        datejPane.setForeground(Color.white);

        JLabel statusPane=new JLabel(field4);
        statusPane.setForeground(Color.white);
        add(subjectPane);
        add(descPane);
        add(datejPane);
        add(statusPane);
    }

}