package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerAddsAssociations;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.controller.createSong;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.Genre;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SwingConstants;

public class AddSongWithAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxtFld;
	private JTextField GenreTxtFld;
	private JTextField trkNumTxtFld;
	private static Album album;

	/**
	 * Launch the application.
	 */
	public static void setup(Album alb) {
		
		album=alb;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSongWithAlbum frame = new AddSongWithAlbum();
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
	public AddSongWithAlbum() {
		setUndecorated(false);
		setTitle("Add Songs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 278);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112).darker().darker().darker());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JSpinner duration = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor startTimeEditor = new JSpinner.DateEditor(duration, "mm:ss"); 
		duration.setEditor(startTimeEditor);
		duration.setSize(200, 200);
		contentPane.add(duration);
		 
		
		nameTxtFld = new JTextField();
		nameTxtFld.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Song Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(new Color(255, 255, 255));
		
		JLabel Genrelbl = new JLabel("Genre");
		Genrelbl.setForeground(new Color(255, 255, 255));
		
		JLabel trackNumberlbl = new JLabel("Track Number");
		trackNumberlbl.setForeground(new Color(255, 255, 255));
		
		GenreTxtFld = new JTextField();
		GenreTxtFld.setColumns(10);
		

		trkNumTxtFld = new JTextField();
		trkNumTxtFld.setColumns(10);
		
		final JLabel lblSave = new JLabel("Save");
		lblSave.setBackground(new Color(0, 0, 0));
		lblSave.setOpaque(true);
		lblSave.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSave.setHorizontalAlignment(SwingConstants.CENTER);
		lblSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				controllerCreateObjects cco = new controllerCreateObjects();
				try{
//					Calendar calendar = Calendar.getInstance();
//					calendar.setTime((Date) duration.getValue());
//					calendar.set(2000, 1, 1);
//					Time startTime = new Time(calendar.getTime().getTime());
					cco.createSong(nameTxtFld.getText(),60,Integer.parseInt((trkNumTxtFld.getText())),new Genre("Rap"));
					controllerAddsAssociations caa = new controllerAddsAssociations();
					caa.addSongToAlbum(album, cco.getSong());
				}catch(InvalidInputException e){
					error.setup(e.getMessage());
				
				}
				
				nameTxtFld.setText("");

				GenreTxtFld.setText("");
				trkNumTxtFld.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSave.setBackground(Color.LIGHT_GRAY.darker());
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblSave.setBackground(Color.black);
			}
		});
		lblSave.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSave.setForeground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDuration)
									.addGap(119))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(98)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nameTxtFld, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
								.addComponent(duration, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
						.addComponent(lblSave, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Genrelbl, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(trackNumberlbl)
									.addGap(79)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(trkNumTxtFld, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
								.addComponent(GenreTxtFld, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(nameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDuration)
						.addComponent(duration, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Genrelbl)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(GenreTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(trackNumberlbl)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(trkNumTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(243))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
