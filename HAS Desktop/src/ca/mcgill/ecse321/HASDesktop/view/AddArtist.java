package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddArtist extends JFrame {

	private JPanel contentPane;
	private JTextField artTxtField;

	/**
	 * Launch the application.
	 */
	public static void setup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddArtist frame = new AddArtist();
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
	public AddArtist() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblArtistName.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistName.setBounds(15, 16, 398, 20);
		contentPane.add(lblArtistName);
		
		artTxtField = new JTextField();
		artTxtField.setBounds(15, 52, 398, 26);
		contentPane.add(artTxtField);
		artTxtField.setColumns(10);
		
		JLabel lblCreateArtist = new JLabel("Create Artist");
		lblCreateArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			lblCreateArtist.setBackground(Color.LIGHT_GRAY.darker());
			}
			public void mouseExited(MouseEvent arg0) {
				lblCreateArtist.setBackground(Color.black);
			}
				
			public void mouseReleased(MouseEvent arg0) {
				controllerCreateObjects cco = new controllerCreateObjects();
				try {
					cco.createArtist(artTxtField.getText());
					dispose();
				} catch (InvalidInputException e) {
					error.setup(e.getMessage());
				}
				
			}
				
		});
		lblCreateArtist.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCreateArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateArtist.setBounds(0, 94, 428, 34);
		contentPane.add(lblCreateArtist);
	}
}
