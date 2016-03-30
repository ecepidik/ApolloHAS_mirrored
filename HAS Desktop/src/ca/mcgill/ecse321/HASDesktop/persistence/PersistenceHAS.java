package ca.mcgill.ecse321.HASDesktop.persistence;

import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.Player;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Room;
import ca.mcgill.ecse321.HASDesktop.model.Song;


public class PersistenceHAS {
	
	private static void initializeXStream() {
		PersistenceXStream.setFilename("data.xml");
		PersistenceXStream.setAlias("album", Album.class);
		PersistenceXStream.setAlias("artist", Artist.class);
		PersistenceXStream.setAlias("HAS", HAS.class);
		PersistenceXStream.setAlias("player", Player.class);
		PersistenceXStream.setAlias("playlist", Playlist.class);
		PersistenceXStream.setAlias("room", Room.class);
		PersistenceXStream.setAlias("song", Song.class);
	}
	
	public static void loadApolloHASModel() {
		HAS has = HAS.getInstance();
		PersistenceHAS.initializeXStream();
		HAS has2 = (HAS) PersistenceXStream.loadFromXMLwithXStream();
		if(has2 != null) {
			Iterator<Song> songIt = has2.getSongs().iterator();
			while(songIt.hasNext())
				has.addSong(songIt.next());
			
			Iterator<Album> albumIt = has2.getAlbums().iterator();
			while(albumIt.hasNext())
				has.addAlbum(albumIt.next());
			
			Iterator<Playlist> playListIt = has2.getPlaylists().iterator();
			while(playListIt.hasNext())
				has.addPlaylist(playListIt.next());
			
			Iterator<Artist> artistIt = has2.getArtists().iterator();
			while(artistIt.hasNext())
				has.addArtist(artistIt.next());
			
			Iterator<Player> playerIt = has2.getPlayers().iterator();
			while(playerIt.hasNext())
				has.addPlaylist(playListIt.next());
			
			Iterator<Room> roomIt = has2.getRooms().iterator();
			while(roomIt.hasNext())
				has.addRoom(roomIt.next());
		}
		
		
	}

}
