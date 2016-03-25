package controller;

import model.Album;
import model.HAS;
import model.Playlist;
import model.Song;
import persistence.PersistenceXStream;

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
