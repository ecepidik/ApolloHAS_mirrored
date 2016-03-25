package main;




import java.io.IOException;
import java.io.InputStream;

import persistence.PersistenceHAS;
import view.HASViewManager;
import view.PlayMusic;
import view.splashScreen;

public class HAS {
	public static void main(String[] args) {
		/*splashScreen.setup();
		PlayMusic.playSample();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		splashScreen.destroy();
		*/
		HASViewManager.setup();
	

	}


}
