package CTracker.screens;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class helpScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helpScreen frame = new helpScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public helpScreen() {
		setBackground(UIManager.getColor("Button.disabledForeground"));
		setForeground(new Color(128, 128, 128));
		setBounds(100, 100, 799, 650);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>\r\n\r\nOur App  is suitable for students and\r\n any individual who would like to make the most out of their time. There are only 24 hours a day. Our app will make each minute count! \r\nWith our app, you can quickly add tasks and plan each day effectively \r\nOur help center includes everything you need to know. Read up so you can get the most possible out of our app’s experience!\r\nYou’ve got this!\r\n\r\n\r\n\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(25, 32, 698, 282);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ABOUT THE APP");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Verdana Pro Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(25, 57, 260, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Why this app?...............  \r\n                              It’s a FREE to-do list, calendar\r\n and reminders app; all-in-one. \r\nPeople use this app to add & track tasks, set reminders, \r\ncreate smart lists, plan their day  – minus the typical hassle & costs");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(24, 248, 699, 186);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FAQs (\r\nYour top questions answered)");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Verdana Pro Black", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(25, 262, 522, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<html>\r\nHow can this app help me get my tasks done?...................\r\nWe live in a very task oriented society where success is dependent on completing tons of tasks everyday. In this overloaded world, it is easy to feel overwhelmed and bogged down by the plethora of things we need to do. That’s where our app steps in – helping people take control, manage their busy lives, and feel good while doing it.\r\n");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(25, 408, 713, 105);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("<html>\r\nIs my account data secure?....................\r\nAll of the data from your account is securely stored on our hosted servers and cannot be accessed by unauthorized parties.");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(24, 508, 699, 105);
		contentPane.add(lblNewLabel_5);
	}
}