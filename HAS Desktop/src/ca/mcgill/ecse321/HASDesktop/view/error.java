package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class error {

	private JFrame frame;
	public String errorMessage;
	/**
	 * Launch the application.
	 */
	public static void setup(String string) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					error window = new error(string);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public error(String string) {
		initialize(string);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String string) {
		this.errorMessage = string;
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 846, 267);
		frame.getContentPane().setLayout(null);
		
		JLabel errorLabel = new JLabel(errorMessage);
		errorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(-2, 16, 826, 106);
		frame.getContentPane().add(errorLabel);
		
		JLabel OKlbl = new JLabel("Ok");
		OKlbl.setBackground(new Color(0, 0, 0));
		OKlbl.setOpaque(true);
		OKlbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				OKlbl.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				OKlbl.setBackground(Color.black);
			}
		});
		OKlbl.setHorizontalAlignment(SwingConstants.CENTER);
		OKlbl.setFont(new Font("Tahoma", Font.PLAIN, 40));
		OKlbl.setForeground(new Color(255, 255, 255));
		OKlbl.setBounds(-2, 138, 826, 129);
		frame.getContentPane().add(OKlbl);
	}
}
