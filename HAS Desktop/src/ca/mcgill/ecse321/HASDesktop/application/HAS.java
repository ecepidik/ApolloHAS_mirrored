package ca.mcgill.ecse321.HASDesktop.application;

import java.io.IOException;
import java.io.InputStream;

import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;
import ca.mcgill.ecse321.HASDesktop.view.HASViewManager;
import ca.mcgill.ecse321.HASDesktop.view.PlayMusic;
import ca.mcgill.ecse321.HASDesktop.view.splashScreen;

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
