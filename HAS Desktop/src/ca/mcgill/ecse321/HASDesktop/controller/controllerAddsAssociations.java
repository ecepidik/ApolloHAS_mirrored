package ca.mcgill.ecse321.HASDesktop.controller;

import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.Genre;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Player;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Room;
import ca.mcgill.ecse321.HASDesktop.model.Song;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceXStream;

public class controllerAddsAssociations {
	public controllerAddsAssociations(){
		
	}
	
	public void addSongToPlaylist(Playlist playlist,Song song) throws InvalidInputException {
		HAS manager = HAS.getInstance();
		
		String error = "";
		if(song == null)
			error = error + "Song needs to be selected! ";
		else if(!manager.getSongs().contains(song))
			error = error + "Song does not exist! ";
		if(playlist == null)
			error = error + "Playlist needs to be selected!";
		else if(!manager.getPlaylists().contains(playlist))
			error = error + "Playlist does not exist!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		playlist.addSong(song);
		
		PersistenceXStream.saveToXMLwithXStream(manager);
	}
	
	public void addSongToAlbum(Album album,Song song) throws InvalidInputException {
		HAS manager = HAS.getInstance();
		String error = "";
		if(song == null)
			error = error + "Song needs to exist! ";
		else if(!manager.getSongs().contains(song))
			error = error + "Song does not exist! ";
		if(album == null)
			error = error + "Album needs to be selected!";
		else if(!manager.getAlbums().contains(album))
			error = error + "Album needs to be selected!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		album.addSong(song);

		PersistenceXStream.saveToXMLwithXStream(manager);
	}
	
	public void addGenreToSong(Genre genre,Song song) throws InvalidInputException {
		HAS manager = HAS.getInstance();
		String error = "";
		if(song == null)
			error = error + "Song needs to exist! ";
		else if(!manager.getSongs().contains(song))
			error = error + "Song does not exist! ";
		if(genre == null)
			error = error + "Genre needs to be selected!";
		else if(!manager.getGenres().contains(genre))
			error = error + "Genre needs to be selected!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		song.setGenre(genre);

		PersistenceXStream.saveToXMLwithXStream(manager);
	}
	
	public void addArtistToAlbum(Artist artist, Album album) throws InvalidInputException {
		HAS manager = HAS.getInstance();
		String error = "";
		if(album == null)
			error = error + "Album needs to be selected! ";
		else if(!manager.getAlbums().contains(album))
			error = error + "Album does not exist! ";
		if(artist == null)
			error = error + "Artist needs to exist!";
		else if(!manager.getArtists().contains(artist))
			error = error + "Artist needs to be selected!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		album.setArtist(artist);

		PersistenceXStream.saveToXMLwithXStream(manager);
	}
	
	
	public Player connectAlbumToPlayer(Player player, Album album) throws InvalidInputException {
		HAS manager = HAS.getInstance();
		String error = "";
		if(player == null)
			error = error + "Player needs to exist! ";
		if(album == null)
			error = error + "Album needs to be selected!";
		else if(!manager.getAlbums().contains(album))
			error = error + "Album needs to be selected!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		
		player.addAlbum(album);
		manager.addPlayer(player);
		
		PersistenceXStream.saveToXMLwithXStream(manager);
		return player;
	}
	
	public Player connectSongToPlayer(Player player, Song song) throws InvalidInputException {
		HAS manager = HAS.getInstance();
		String error = "";
		if(player == null)
			error = error + "Player needs to exist! ";
		if(song == null)
			error = error + "Song needs to be selected!";
		else if(!manager.getSongs().contains(song))
			error = error + "Song needs to be selected!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		

		player.addSong(song);
		manager.addPlayer(player);

		PersistenceXStream.saveToXMLwithXStream(manager);
		return player;
	}
	public Player connectPlaylistToPlayer(Player player, Playlist playlist) throws InvalidInputException {
		
		HAS manager = HAS.getInstance();
		String error = "";
		
		if(player == null)
			error = error + "Player needs to exist! ";
		if(playlist == null)
			error = error + "Playlist needs to be selected!";
		else if(!manager.getPlaylists().contains(playlist))
			error = error + "Playlist needs to be selected!";
		error = error.trim();
			
		if(error.length() > 0)
			throw new  InvalidInputException(error);
		
	
		player.addPlaylist(playlist);
		manager.addPlayer(player);

		PersistenceXStream.saveToXMLwithXStream(manager);
		return player;
	}
	public Player connectRoomToPlayer(Player p, Room r){
		HAS manager = HAS.getInstance();
		String error = "";
		
		if(p == null)
			error = error + "Player needs to exist! ";
		if(r == null)
			error = error + "Room needs to be selected!";
		else if(!manager.getPlaylists().contains(r))
			error = error + "Room needs to be selected!";
		error = error.trim();
		
		p.addRoom(r);
		manager.addPlayer(p);
		PersistenceXStream.saveToXMLwithXStream(manager);
		return p;
	}
}
