package persistence;

import java.util.Iterator;

import model.HAS;
import model.Album;
import model.Artist;
import model.Player;
import model.Playlist;
import model.Room;
import model.Song;



public class PersistenceHAS{
	public static void intializeXStream(){
		PersistenceXStream.setFilename("HAS.xml"); 
		PersistenceXStream.setAlias("album", Album.class);
		PersistenceXStream.setAlias("artist", Artist.class); 
		PersistenceXStream.setAlias("player", Player.class); 

		PersistenceXStream.setAlias("room", Room.class);

		PersistenceXStream.setAlias("song", Song.class);
		PersistenceXStream.setAlias("HAS", HAS.class);
		
		}
		
	
	public static void loadHAS() {
		HAS hs = HAS.getInstance();
		PersistenceHAS.intializeXStream();
		HAS hs2 = (HAS) PersistenceXStream.loadFromXMLwithXStream();
		if (hs2 != null) {
		// unfortunately, this creates a second RegistrationManager object, even though it is a singleton
		// copy loaded model into singleton instance of RegistrationManager, because this will be used throughout the application catw
			Iterator <Album> pIt = hs2.getAlbum().iterator();
		
			while (pIt.hasNext()) 
				hs.addAlbum(pIt.next());
			
			Iterator <Song> eIt = hs2.getSong().iterator();
		
			while (eIt.hasNext()) 
				hs.addSong(eIt.next());
			
			Iterator <Artist> rIt = hs2.getArtist().iterator();
			
			while (rIt.hasNext()) 
			hs.addArtist(rIt.next());
			
			Iterator <Playlist> nIt = hs2.getPlaylist().iterator();
			
			while (nIt.hasNext()) 
			hs.addPlaylist(nIt.next());
			
			
			
		}
	}	
	

}
