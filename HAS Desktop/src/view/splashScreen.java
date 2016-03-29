package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class splashScreen {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void setup() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splashScreen window = new splashScreen();
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
	public splashScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame("TitleLess JFrame");
		frame.setResizable(false);
		frame.setBounds(100, 100, 100, 100);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth()/2);
		int ySize = ((int) tk.getScreenSize().getHeight()/2);
		frame.setSize(xSize,ySize);
		
		frame.setUndecorated(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel imagelbl = new JLabel("New label");
		imagelbl.setBounds(0, 0, xSize, ySize);
		imagelbl.setIcon(new ImageIcon("splash.jpg"));
		frame.getContentPane().add(imagelbl);
		
		
	}
	public static void destroy(){
		frame.dispose();
	}
}
