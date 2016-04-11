package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerAddsAssociations;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Player;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Room;
import ca.mcgill.ecse321.HASDesktop.model.Song;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AddPlayer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void setup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlayer frame = new AddPlayer();
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
	public AddPlayer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 675, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(4,4,25));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblConnectToRoom = new JLabel("Connect to Room :");
		lblConnectToRoom.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblConnectToRoom.setBackground(new Color(0, 0, 0));
		lblConnectToRoom.setOpaque(true);
		lblConnectToRoom.setForeground(new Color(255, 255, 255));
	
		lblConnectToRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectToRoom.setBounds(163, 81, 327, 95);
		contentPane.add(lblConnectToRoom);
		
		final JComboBox<Playlist> playlistsComboBox = new JComboBox<Playlist>();
		playlistsComboBox.setBounds(15, 16, 147, 37);
		contentPane.add(playlistsComboBox);
		
		final JComboBox<Song> songsComboBox = new JComboBox<Song>();
		songsComboBox.setBounds(15, 109, 147, 37);
		contentPane.add(songsComboBox);
		
		final JComboBox<Album> albComboBox = new JComboBox<Album>();
		albComboBox.setBounds(15, 192, 147, 37);
		contentPane.add(albComboBox);
		
		final JComboBox<Room> roomComboBox = new JComboBox<Room>();
		roomComboBox.setBounds(491, 109, 147, 37);
		contentPane.add(roomComboBox);
		
		HAS hs = HAS.getInstance();
		for (int i = 0; i < hs.getAlbums().size();i++) {
			albComboBox.addItem(hs.getAlbum(i));
		}
		for (int i = 0; i < hs.getSongs().size();i++) {
			songsComboBox.addItem(hs.getSong(i));
		}
		for (int i = 0; i < hs.getPlaylists().size();i++) {
			playlistsComboBox.addItem(hs.getPlaylist(i));
		}
		for (int i = 0; i < hs.getRooms().size();i++) {
			roomComboBox.addItem(hs.getRoom(i));
		}
		lblConnectToRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				controllerCreateObjects cco = new controllerCreateObjects();
				controllerAddsAssociations caa = new controllerAddsAssociations();
				
				try {
					Player p = cco.createPlayer();
					Player p1  = caa.connectAlbumToPlayer(p, (Album)albComboBox.getSelectedItem());
					Player p2 =caa.connectPlaylistToPlayer(p1, (Playlist)playlistsComboBox.getSelectedItem());
					Player p3= caa.connectSongToPlayer(p2, (Song)songsComboBox.getSelectedItem());
					Player p4=caa.connectRoomToPlayer(p3, (Room) roomComboBox.getSelectedItem());
					
				} catch (InvalidInputException e1) {
					error.setup(e1.getMessage());
				}
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblConnectToRoom.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblConnectToRoom.setBackground(Color.BLACK);
			}
		});
	}
}
