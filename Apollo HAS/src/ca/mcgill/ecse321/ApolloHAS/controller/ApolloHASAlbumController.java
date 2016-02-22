package ca.mcgill.ecse321.ApolloHAS.controller;

import java.sql.Date;

import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;
import ca.mcgill.ecse321.ApolloHAS.persistence.PersistenceXStream;

public class ApolloHASAlbumController {
	
	public ApolloHASAlbumController(){
	}
	
	public Artist createArtist(String name) {
		Artist artist = new Artist(name);
		HAS manager = HAS.getInstance();
		manager.addArtist(artist);
		PersistenceXStream.saveToXMLwithXStream(manager);
		
		return artist;
	}
	
	public Album createAlbum(String name, Date date, Artist artist) {
		Album album = new Album(name, date, artist);
		HAS manager = HAS.getInstance();
		manager.addAlbum(album);
		PersistenceXStream.saveToXMLwithXStream(manager);
		
		return album;
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