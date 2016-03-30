package ca.mcgill.ecse321.ApolloHAS.controller;

import java.sql.Date;

import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.Genre;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;
import ca.mcgill.ecse321.ApolloHAS.model.Player;
import ca.mcgill.ecse321.ApolloHAS.model.Song;
import ca.mcgill.ecse321.ApolloHAS.persistence.PersistenceXStream;
import ca.mcgill.ecse321.ApolloHAS.controller.InvalidInputException;

public class ApolloHASAlbumController {
	
	public ApolloHASAlbumController(){
	}
	
	public Artist createArtist(String name) {
//		if (name == null || name.trim().length() == 0)
//			throw new InvalidInputException("Artist name cannot be empty!");
//		
		Artist artist = new Artist(name);
		HAS manager = HAS.getInstance();
		manager.addArtist(artist);
		PersistenceXStream.saveToXMLwithXStream(manager);
		
		return artist;
	}
	
	public void createSong(String name, int duration, Genre genre, int trackNum, Artist artist) throws InvalidInputException{
		String error = "";
		if(name == null || name.trim().length() == 0)
			error = error + "Song name cannot be empty! ";
		if(duration < 0)
			error = error + "Duration is not a valid input! ";
//		if(name == null || genre.trim().length() == 0)
//			error = error + "Genre cannot be empty! ";
		if(artist == null)
			error = error + "Artist cannot be empty! ";
		if(trackNum < 0)
			error = error + "Track number is not a valid input! ";
		error = error.trim();
		if(error.length() > 0)
			throw new InvalidInputException(error);
		
		Song song = new Song(name, duration, trackNum, genre);
		HAS manager = HAS.getInstance();
		manager.addSong(song);
		PersistenceXStream.saveToXMLwithXStream(manager);
		
	}
	
	public Album createAlbum(String name, Date date, Artist artist) throws InvalidInputException {
		String error = "";
		if(name == null || name.trim().length() == 0)
			error = error + "Album name cannot be empty! ";
		if(date == null)
			error = error + "Release date cannot be empty! ";
		if(artist == null)
			error = error + "Artist cannot be empty! ";
		error = error.trim();
		if(error.length() > 0)
			throw new InvalidInputException(error);
		
		Album album = new Album(name, date, artist);
		HAS manager = HAS.getInstance();
		manager.addAlbum(album);
		PersistenceXStream.saveToXMLwithXStream(manager);
		
		return album;
	}	
	
	public void addSongsToAlbum(Song song, Album album) //throws InvalidInputException
	{
		HAS manager = HAS.getInstance();
		
//		String error = "";
//		if(song == null)
//			error = error + "Song needs to be selected for registration! ";
//		else if(!manager.getSong().contains(song))
//			error = error + "Album does not exist! ";
//		if(album == null)
//			error = error + "Album needs to be selected for registration!";
//		else if(!manager.getAlbum().contains(album))
//			error = error + "Album does not exist!";
//		error = error.trim();
//		if(error.length() > 0)
//			throw new  InvalidInputException(error);
		
		Player p = new Player();
		manager.addPlayer(p);
		PersistenceXStream.saveToXMLwithXStream(manager);
	}
	
}
	
//	Album album;
//	String name;
//	String artistName;
//	String releaseDate;
//	String inputNumberofSongs;
//	int numberOfSongs;
//
//	public ApolloHASAlbumController(String albName,String artName,String RlsDate,String numbOfSongs){
//		this.name = albName;
//		this.artistName = artName;
//
//		this.releaseDate = RlsDate;
//
//		this.inputNumberofSongs = numbOfSongs;
//
//	}
//
//	public boolean checkVoids() {
//		if(name.length()==0 || name.trim().length() == 0){
//			return false;
//		}
//		else if(artistName.length()==0 || artistName.trim().length() == 0){
//			return false;
//		}
//		else if(releaseDate.length()==0 || releaseDate.trim().length() == 0){
//			return false;
//			}
//		else if(inputNumberofSongs.length()==0 || inputNumberofSongs.trim().length() == 0){
//			return false;
//			}
//		return true;
//		}
//
//	public boolean checkFormat() {
//		int i =0;
//		try {
//			i  = Integer.parseInt(inputNumberofSongs);
//			
//		} catch (NumberFormatException e) {
//			return false;
//		}		
//		
//		numberOfSongs = i;
//		
//		return true;
//	}
//	public boolean checkDate() {
//
//		Artist artist = new Artist(artistName);
//		java.sql.Date parsed;
//		try {
//			parsed = java.sql.Date.valueOf(releaseDate);
//			java.sql.Date sql = new java.sql.Date(parsed.getTime());
//			album = new Album(name,sql,artist);
//			artist.addAlbum(album);
//		
//		} catch (IllegalArgumentException e) {
//			return false;
//		}
//			
//		artist.addAlbum(album);
//		saveArtist(artist);
//		saveAlbum();
//		return true;
//	}
//
//
//	private void saveArtist(Artist artist) {
//		HAS hs = HAS.getInstance();
//			
//		hs.addArtist(artist);
//		PersistenceXStream.saveToXMLwithXStream(hs);
//		}
//		
//	private void saveAlbum() {
//		HAS hs = HAS.getInstance();
//		
//		hs.addAlbum(album);
//
//		PersistenceXStream.saveToXMLwithXStream(hs);
//		}
//
//	}