package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.InvalidInputException;
import controller.controllerAddsAssociations;
import controller.controllerCreateObjects;
import model.Album;
import model.HAS;
import model.Playlist;
import model.Song;

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
		setContentPane(contentPane);

		HAS hs = HAS.getInstance();

		JLabel lblChooseSongs = new JLabel("Choose Songs");
		lblChooseSongs.setBounds(20, 176, 388, 20);
		lblChooseSongs.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblAddSong = new JLabel("Add Song to Playlist");
		lblAddSong.setBounds(20, 240, 403, 64);
	
		lblAddSong.setHorizontalAlignment(SwingConstants.CENTER);

		JComboBox<Song> songComboBox = new JComboBox();
		songComboBox.setBounds(20, 205, 388, 26);

		for(int i=0;i<hs.getSong().size();i++){
			songComboBox.addItem(hs.getSong(i));
		}

		playlistName = new JTextField();
		playlistName.setBounds(216, 13, 192, 26);
		playlistName.setColumns(10);

		JLabel lblPlaylistName = new JLabel("PlayList Name");
		lblPlaylistName.setBounds(20, 16, 190, 20);

		JLabel lblCreatePlaylist = new JLabel("Create Playlist");
		lblCreatePlaylist.setBounds(20, 48, 388, 55);

		JComboBox<Playlist> playlistComboBox = new JComboBox();
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
					for (int i = 0; i < hs.getPlaylist().size(); i++) {

						playlistComboBox.addItem(hs.getPlaylist(i));
					}
				} catch (InvalidInputException e) {
					error.setup(e.getMessage());
				}
			}
		});

		playlistComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				playlistComboBox.removeAllItems();
				for (int i = 0; i < hs.getPlaylist().size(); i++) {
					
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
				} catch (InvalidInputException e1) {
					// TODO Auto-generated catch block
					error.setup(e1.getMessage());
				}
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
