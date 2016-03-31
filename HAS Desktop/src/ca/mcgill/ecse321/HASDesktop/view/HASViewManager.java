package ca.mcgill.ecse321.HASDesktop.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceXStream;

import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import ca.mcgill.ecse321.HASDesktop.org.eclipse.wb.swing.*;
import java.awt.Component;

public class HASViewManager {

	private JFrame frmApollo;
	private JList listView;

	/**
	 * Launch the application.
	 */
	public static void setup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HASViewManager window = new HASViewManager();
					window.frmApollo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HASViewManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApollo = new JFrame();
		frmApollo.setResizable(false);
		frmApollo.setTitle("Apollo");
		frmApollo.setBounds(100, 100, 1090, 701);
		frmApollo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApollo.getContentPane().setLayout(new BoxLayout(frmApollo.getContentPane(), BoxLayout.X_AXIS));


		PersistenceHAS.loadApolloHASModel();
		final HAS hs = HAS.getInstance();
		String[] albumNames = new String[hs.getAlbums().size()];
		DefaultListModel listmodel = new DefaultListModel();
		for (int i = 0; i < hs.getAlbums().size(); i++) {
			albumNames[i] = hs.getAlbum(i).getName();
			listmodel.addElement(hs.getAlbum(i).getName());
		}


		final JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmApollo.getContentPane().add(panel);
		panel.setLayout(null);

		Panel panel_2 = new Panel();
		panel_2.setBounds(850, 0, 234, 661);
		panel_2.setBackground(Color.BLACK);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel Roomslbl = new JLabel("Rooms");
		Roomslbl.setBounds(0, 16, 194, 38);
		panel_2.add(Roomslbl);
		Roomslbl.setForeground(Color.WHITE);
		Roomslbl.setBackground(Color.WHITE);
		Roomslbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 44));

		final JLabel lblCreateRoom = new JLabel("New Room");
		lblCreateRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCreateRoom.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblCreateRoom.setBackground(Color.BLACK);
			}
		});

		lblCreateRoom.setBackground(Color.BLACK);
		lblCreateRoom.setOpaque(true);
		lblCreateRoom.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreateRoom.setForeground(Color.WHITE);
		lblCreateRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateRoom.setBounds(0, 70, 219, 48);
		panel_2.add(lblCreateRoom);

		this.listView = new JList(listmodel);
		listView.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		listView.setAlignmentX(Component.RIGHT_ALIGNMENT);

		JScrollPane scrollPane = new JScrollPane(this.listView);
		scrollPane.setBounds(198, 82, 654, 277);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panel.add(scrollPane);


		listView.setForeground(new Color(240, 255, 255));
		listView.setFont(new Font("Segoe UI Light", Font.PLAIN, 28));
		listView.setBackground(new Color(25, 25, 112).darker().darker().darker().darker());
		listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listView.setBounds(198, 105, 654, 259);



		final JLabel lblListType = new JLabel("Albums");
		lblListType.setBounds(198, 0, 654, 86);
		lblListType.setOpaque(true);
		lblListType.setBackground(new Color(56,45,56).darker().darker());
		lblListType.setHorizontalTextPosition(SwingConstants.CENTER);
		lblListType.setHorizontalAlignment(SwingConstants.CENTER);
		lblListType.setForeground(Color.WHITE);
		lblListType.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 44));
		panel.add(lblListType);

		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 0, 202, 661);
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(160, 82, 45));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel Librarylbl = new JLabel("Library");
		Librarylbl.setBounds(15, 16, 169, 54);
		panel_1.add(Librarylbl);
		Librarylbl.setForeground(Color.WHITE);
		Librarylbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 44));

		JSeparator separator = new JSeparator();
		separator.setBounds(15, 68, 169, 25);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(18, 267, 166, 29);
		panel_1.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 426, 169, 57);
		panel_1.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(15, 615, 169, 46);
		panel_1.add(separator_3);

		final JLabel lblCreatePlaylists = new JLabel("Create Playlist");
		lblCreatePlaylists.setBounds(0, 557, 196, 57);
		lblCreatePlaylists.setOpaque(true);
		lblCreatePlaylists.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreatePlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCreatePlaylists.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblCreatePlaylists.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				AddPlaylist.setup();
			}
		});
		lblCreatePlaylists.setBackground(Color.BLACK);
		lblCreatePlaylists.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatePlaylists.setForeground(Color.WHITE);
		panel_1.add(lblCreatePlaylists);

		final JLabel lblPlaylists = new JLabel("Playlists");
		lblPlaylists.setBounds(0, 499, 196, 57);
		lblPlaylists.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPlaylists.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPlaylists.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblListType.setText("Playlists");
				String[] playlistNames = new String[hs.getPlaylists().size()];
				for (int i = 0; i < hs.getPlaylists().size(); i++) {
					playlistNames[i] = hs.getPlaylist(i).getName();
					for (int j = 0; j < hs.getPlaylist(i).getSongs().size(); j++) {
						playlistNames[i]  += " \t"+hs.getPlaylist(i).getSong(j).getName();
					}
				}
				listView.setListData(playlistNames);

				panel.revalidate();
				panel.repaint();
			}
		});
		lblPlaylists.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPlaylists.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaylists.setBackground(Color.BLACK);
		lblPlaylists.setOpaque(true);
		lblPlaylists.setForeground(Color.WHITE);
		panel_1.add(lblPlaylists);

		final JLabel lblAddSongs = new JLabel("Add Songs");
		lblAddSongs.setBounds(0, 368, 196, 57);
		lblAddSongs.setOpaque(true);
		lblAddSongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddSongs.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e){
				lblAddSongs.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				AddSongWithoutAlbum.setup(null);
			}
		});
		lblAddSongs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddSongs.setForeground(Color.WHITE);
		lblAddSongs.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddSongs.setBackground(Color.BLACK);
		panel_1.add(lblAddSongs);

		final JLabel lblSongs = new JLabel("Songs");
		lblSongs.setBounds(0, 312, 196, 57);
		lblSongs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSongs.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e){
				lblSongs.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblListType.setText("Songs");
				String[] songNames = new String[hs.getSongs().size()];
				for (int i = 0; i < hs.getSongs().size(); i++) {
					songNames[i] = hs.getSong(i).getName();

				}
				listView.setListData(songNames);

				panel.revalidate();
				panel.repaint();
			}
		});
		lblSongs.setOpaque(true);
		lblSongs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSongs.setForeground(Color.WHITE);
		lblSongs.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblSongs.setBackground(Color.BLACK);
		panel_1.add(lblSongs);

		final JLabel lblAddAlbums = new JLabel("Add Albums");
		lblAddAlbums.setBounds(0, 208, 196, 57);
		lblAddAlbums.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddAlbums.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblAddAlbums.setBackground(Color.BLACK);
			}
			public void mouseReleased(MouseEvent e) {
				AddAlbum.setup(panel);
			}
		});
		lblAddAlbums.setOpaque(true);
		lblAddAlbums.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAlbums.setForeground(Color.WHITE);
		lblAddAlbums.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAddAlbums.setBackground(Color.BLACK);
		panel_1.add(lblAddAlbums);

		final JLabel lblAlbums = new JLabel("Albums");
		lblAlbums.setBounds(0, 150, 196, 57);
		lblAlbums.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAlbums.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblAlbums.setBackground(Color.BLACK);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblListType.setText("Albums");
				String[] albumNames = new String[hs.getAlbums().size()];
				for (int i = 0; i < hs.getAlbums().size(); i++) {
					albumNames[i] = hs.getAlbum(i).getName();
					for (int j = 0; j < hs.getAlbum(i).getSongs().size(); j++) {
						albumNames[i] += hs.getAlbum(i).getSong(i);
					}
				}
				listView.setListData(albumNames);

				panel.revalidate();
				panel.repaint();

			}
		});
		lblAlbums.setOpaque(true);
		lblAlbums.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlbums.setForeground(Color.WHITE);
		lblAlbums.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAlbums.setBackground(Color.BLACK);
		panel_1.add(lblAlbums);

		final JLabel lblNewArtist = new JLabel("New Artist");
		lblNewArtist.setBackground(Color.BLACK);
		lblNewArtist.setOpaque(true);
		lblNewArtist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewArtist.setBackground(Color.LIGHT_GRAY.darker());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewArtist.setBackground(Color.black);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				AddArtist.setup();
			}
		});
		lblNewArtist.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewArtist.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewArtist.setForeground(Color.WHITE);
		lblNewArtist.setBounds(0, 86, 196, 54);
		panel_1.add(lblNewArtist);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(198, 352, 661, 309);
		panel_3.setBackground(new Color(56,45,56).darker().darker().darker());
		panel.add(panel_3);
		frmApollo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmApollo.getContentPane(), panel, panel_2, Roomslbl, scrollPane, listView, lblListType, panel_1, Librarylbl, separator, separator_1, separator_2, separator_3, lblCreatePlaylists, lblPlaylists, lblAddSongs, lblSongs, lblAddAlbums, lblAlbums, panel_3}));

	}
}
