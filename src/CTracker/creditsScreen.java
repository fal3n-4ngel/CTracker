package CTracker;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class creditsScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creditsScreen frame = new creditsScreen();
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
	public creditsScreen() {
		
		setBounds(100, 100, 788, 591);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CREATED BY");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBackground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.BOLD, 26));
		lblNewLabel_1.setBounds(92, 90, 189, 56);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADITHYA KRISHNAN -8");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(96, 266, 218, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("JESNY JAYAN-26\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(96, 174, 218, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("SREE LEKSHMI-60");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(96, 227, 239, 47);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NITHYA JOSE-48\r\n");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(96, 140, 132, 41);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CHRISTINA MATHEWS-19");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(96, 206, 205, 26);
		contentPane.add(lblNewLabel_5);
	}

}