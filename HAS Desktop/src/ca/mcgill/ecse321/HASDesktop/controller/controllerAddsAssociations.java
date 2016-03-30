package ca.mcgill.ecse321.HASDesktop.controller;

import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Song;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceXStream;

public class controllerAddsAssociations {
	public controllerAddsAssociations(){
		
	}
	public void addSongToPlaylist(Playlist playlist,Song song)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Must Choose Inputs");
		if(playlist == null || song == null){
			throw e;
		}
		playlist.addSong(song);
		savePlaylist(playlist);
	}
	private void savePlaylist(Playlist playlist) {
		HAS hs = HAS.getInstance();
		hs.addPlaylist(playlist);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}

}
