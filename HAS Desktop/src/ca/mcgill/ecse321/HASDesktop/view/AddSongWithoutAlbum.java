package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.HAS;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddSongWithoutAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField SngNameTxt;
	private JTextField TrackNumTxt;
	private JTextField GenreTxt;

	/**
	 * Launch the application.
	 */
	public static void setup(String args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSongWithoutAlbum frame = new AddSongWithoutAlbum();
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
	public AddSongWithoutAlbum() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(7, 7, 37));
		panel.setBounds(0, 0, 428, 363);
		contentPane.add(panel);
		
		JSpinner DurationSpinner = new JSpinner(new SpinnerDateModel());
		DurationSpinner.setBounds(200, 183, 223, 32);
		JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(DurationSpinner, "mm:ss"); 
		DurationSpinner.setEditor(startTimeEditor);
	
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(20, 183, 61, 20);
		lblDuration.setForeground(Color.WHITE);
		
		JLabel lblSongName = new JLabel("Song Name");
		lblSongName.setBounds(20, 151, 82, 20);
		lblSongName.setForeground(Color.WHITE);
		
		SngNameTxt = new JTextField();
		SngNameTxt.setBounds(200, 148, 223, 26);
		SngNameTxt.setColumns(10);
		
		JLabel lblSave = new JLabel("Save");
		lblSave.setBounds(0, 296, 438, 67);
		
		lblSave.setOpaque(true);
		lblSave.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.setForeground(Color.WHITE);
		lblSave.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSave.setBackground(Color.BLACK);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(20, 224, 174, 20);
		lblGenre.setForeground(Color.WHITE);
		
		JLabel lblTarckNum = new JLabel("Track Number");
		lblTarckNum.setBounds(20, 260, 101, 20);
		lblTarckNum.setForeground(Color.WHITE);
		
		TrackNumTxt = new JTextField();
		TrackNumTxt.setBounds(200, 265, 223, 26);
		TrackNumTxt.setColumns(10);
		
		GenreTxt = new JTextField();
		GenreTxt.setBounds(200, 225, 223, 26);
		GenreTxt.setColumns(10);
		JComboBox<Album> albComboBox  = new JComboBox();
		albComboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
	
	
	
	
		
		albComboBox.setBounds(200, 21, 223, 50);
		HAS hs = HAS.getInstance();
		
		for (int i = 0; i < hs.getAlbum().size();i++) {
			albComboBox.addItem(hs.getAlbum(i));
		}
		
	
	


		JLabel lblAlbumNames = new JLabel("Album Name");
		lblAlbumNames.setBounds(20, 36, 93, 20);
		lblAlbumNames.setForeground(Color.WHITE);
		
		JLabel lblArtistNames = new JLabel("Artist Names");
		lblArtistNames.setBounds(20, 95, 91, 20);
		lblArtistNames.setForeground(Color.WHITE);
		panel.setLayout(null);
		panel.add(lblAlbumNames);
		panel.add(albComboBox);
		panel.add(lblArtistNames);
		panel.add(lblSongName);
		panel.add(SngNameTxt);
		panel.add(lblDuration);
		panel.add(DurationSpinner);
		panel.add(lblGenre);
		panel.add(GenreTxt);
		panel.add(lblTarckNum);
		panel.add(TrackNumTxt);
		panel.add(lblSave);
		
		JLabel lblArtist = new JLabel("");
		lblArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtist.setForeground(Color.WHITE);
		lblArtist.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblArtist.setBounds(200, 87, 223, 45);
		panel.add(lblArtist);
		albComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Album alb = (Album) albComboBox.getSelectedItem();
				Artist art = alb.getArtist();
				
				lblArtist.setText(art.toString());
				}
		});

		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSave.setBackground(Color.LIGHT_GRAY.darker());
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblSave.setBackground(Color.black);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerCreateObjects song = new controllerCreateObjects();
				try{
					Calendar calendar = Calendar.getInstance();
					calendar.setTime((Date) DurationSpinner.getValue());
					calendar.set(2000, 1, 1);
					Time startTime = new Time(calendar.getTime().getTime());
					Album alb = (Album) albComboBox.getSelectedItem();
					Artist art = alb.getArtist();
					song.createSong((Album)albComboBox.getSelectedItem(),art,SngNameTxt.getText(),startTime,GenreTxt.getText(),TrackNumTxt.getText());
					
					SngNameTxt.setText("");

					GenreTxt.setText("");
					TrackNumTxt.setText("");
					
				}catch(InvalidInputException e1){
					error.setup(e1.getMessage());
				}
				
			}
		});
		
	}
}
