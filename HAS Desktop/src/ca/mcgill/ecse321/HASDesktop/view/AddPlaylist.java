package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerAddsAssociations;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Song;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

public class AddPlaylist extends JFrame {

	private JPanel contentPane;
	private JTextField playlistName;

	/**
	 * Launch the application.
	 */
	public static void setup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlaylist frame = new AddPlaylist();
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
	public AddPlaylist() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(4,4,25));
		setContentPane(contentPane);

		final HAS hs = HAS.getInstance();

		JLabel lblChooseSongs = new JLabel("Choose Songs");
		lblChooseSongs.setForeground(new Color(255, 255, 255));
		lblChooseSongs.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblChooseSongs.setBounds(20, 176, 388, 20);
		lblChooseSongs.setHorizontalAlignment(SwingConstants.CENTER);

		final JLabel lblAddSong = new JLabel("Add Song to Playlist");
		lblAddSong.setBackground(new Color(0, 0, 0));
		lblAddSong.setOpaque(true);
		lblAddSong.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblAddSong.setForeground(new Color(255, 255, 255));
		lblAddSong.setBounds(0, 240, 428, 69);
	
		lblAddSong.setHorizontalAlignment(SwingConstants.CENTER);

		final JComboBox<Song> songComboBox = new JComboBox();
		songComboBox.setBounds(20, 205, 388, 26);

		for(int i=0;i<hs.getSongs().size();i++){
			songComboBox.addItem(hs.getSong(i));
		}

		playlistName = new JTextField();
		playlistName.setBounds(216, 13, 192, 26);
		playlistName.setColumns(10);

		JLabel lblPlaylistName = new JLabel("PlayList Name");
		lblPlaylistName.setForeground(new Color(255, 255, 255));
		lblPlaylistName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlaylistName.setBounds(20, 16, 190, 20);

		final JLabel lblCreatePlaylist = new JLabel("Create Playlist");
		lblCreatePlaylist.setBackground(new Color(0, 0, 0));
		lblCreatePlaylist.setOpaque(true);
		lblCreatePlaylist.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCreatePlaylist.setForeground(new Color(255, 255, 255));
		lblCreatePlaylist.setBounds(0, 48, 428, 55);

		final JComboBox<Playlist> playlistComboBox = new JComboBox();
		playlistComboBox.setBounds(20, 134, 388, 26);

		lblCreatePlaylist.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatePlaylist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				controllerCreateObjects cco = new controllerCreateObjects();
				try {
					cco.createPlaylist(playlistName.getText());
					playlistName.setEditable(false);
					playlistComboBox.removeAllItems();
					for (int i = 0; i < hs.getPlaylists().size(); i++) {

						playlistComboBox.addItem(hs.getPlaylist(i));
					}
				} catch (InvalidInputException e) {
					error.setup(e.getMessage());
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			lblCreatePlaylist.setBackground(Color.LIGHT_GRAY.darker());
			}

			@Override
			public void mouseExited(MouseEvent e) {
			lblCreatePlaylist.setBackground(Color.BLACK);
			}
		});

		playlistComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playlistComboBox.removeAllItems();
				for (int i = 0; i < hs.getPlaylists().size(); i++) {
					
					playlistComboBox.addItem(hs.getPlaylist(i));
				}
			}
		});
		lblAddSong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Playlist p = (Playlist) playlistComboBox.getSelectedItem();
				Song s = (Song) songComboBox.getSelectedItem();
				controllerAddsAssociations caa = new controllerAddsAssociations();
				try {
					caa.addSongToPlaylist(p, s);
				} catch (InvalidInputException e1){
					error.setup(e1.getMessage());
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddSong.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAddSong.setBackground(Color.BLACK);
			}
		});
		
		JLabel lblChoosePlaylist = new JLabel("Choose Playlist");
		lblChoosePlaylist.setBounds(20, 112, 388, 20);
		lblChoosePlaylist.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setLayout(null);
		contentPane.add(lblAddSong);
		contentPane.add(playlistComboBox);
		contentPane.add(lblCreatePlaylist);
		contentPane.add(lblPlaylistName);
		contentPane.add(playlistName);
		contentPane.add(lblChooseSongs);
		contentPane.add(songComboBox);
		contentPane.add(lblChoosePlaylist);
	}
}
