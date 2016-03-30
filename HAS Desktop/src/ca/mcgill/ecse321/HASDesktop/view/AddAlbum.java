package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

public class AddAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField albTxtFld;
	private JLabel lblNumbofSongs;
	private JTextField numbOfSongsTxtFld;
	private static JPanel panel;
	private JLabel lblCreateAlbum;
	private SpringLayout springLayout;
	/**
	 * Launch the application.
	 */
	public static void setup(JPanel panelIN) {
		panel = panelIN;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAlbum frame = new AddAlbum();
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
	public AddAlbum() {
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setTitle("Add Album");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 708, 388);
		contentPane = new JPanel();
		
		SqlDateModel model = new SqlDateModel();
		Properties p  = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl albDatePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		HAS hs = HAS.getInstance();
		
		JComboBox<Artist> artistComboBox = new JComboBox();
		for (int i = 0; i < hs.getArtists().size(); i++) {
			artistComboBox.addItem(hs.getArtist(i));
		}


		
		
		springLayout = (SpringLayout) albDatePicker.getLayout();
		springLayout.putConstraint(SpringLayout.WEST, albDatePicker.getJFormattedTextField(), 0, SpringLayout.WEST, albDatePicker);
		
		contentPane.setBackground(new Color(25, 25, 112).darker());
		
		setContentPane(contentPane);
		
		JLabel lblAlbumName = new JLabel("Album Name");
		lblAlbumName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlbumName.setForeground(new Color(255, 255, 255));
		lblAlbumName.setBackground(Color.PINK);
		
		albTxtFld = new JTextField();
		albTxtFld.setColumns(10);
		
		JLabel lblArtistName = new JLabel("Artist Name");
		lblArtistName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblArtistName.setForeground(new Color(255, 255, 255));
		lblArtistName.setBackground(new Color(0, 0, 0));
		
		JLabel lblReleaseDate = new JLabel("Release Date");
		lblReleaseDate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblReleaseDate.setForeground(new Color(255, 255, 255));
		lblReleaseDate.setBackground(new Color(0, 0, 0));
		
		lblNumbofSongs = new JLabel("Number of Songs");
		lblNumbofSongs.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNumbofSongs.setForeground(new Color(255, 255, 255));
		
		numbOfSongsTxtFld = new JTextField();
		numbOfSongsTxtFld.setColumns(10);
		
		lblCreateAlbum = new JLabel("Create Album");
		lblCreateAlbum.setBackground(new Color(0, 0, 0));
		lblCreateAlbum.setOpaque(true);
		lblCreateAlbum.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCreateAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAlbum.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCreateAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerCreateObjects album = new controllerCreateObjects();
				boolean passed=true;
				try{
					album.createAlbum(albTxtFld.getText(), (Artist) artistComboBox.getSelectedItem(),
							 (java.sql.Date)albDatePicker.getModel().getValue(),numbOfSongsTxtFld.getText());
				} catch (InvalidInputException e1){
					error.setup(e1.getMessage()); 
					passed = false;
					
				}	
				if(passed){
					Artist art = album.getArtist();
					Album alb = album.getAlbum();
					contentPane.setOpaque(false);
					AddSongWithAlbum.setup(alb,art);
					}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCreateAlbum.setBackground(Color.LIGHT_GRAY.darker());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblCreateAlbum.setBackground(Color.black);
			}
		});
		lblCreateAlbum.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblAlbumName)
					.addGap(137)
					.addComponent(albTxtFld, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblArtistName)
					.addGap(150)
					.addComponent(artistComboBox, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblReleaseDate)
					.addGap(135)
					.addComponent(albDatePicker, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNumbofSongs)
					.addGap(86)
					.addComponent(numbOfSongsTxtFld, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
				.addComponent(lblCreateAlbum, GroupLayout.PREFERRED_SIZE, 702, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAlbumName)
						.addComponent(albTxtFld, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArtistName)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(artistComboBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReleaseDate)
						.addComponent(albDatePicker, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumbofSongs)
						.addComponent(numbOfSongsTxtFld, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblCreateAlbum, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
