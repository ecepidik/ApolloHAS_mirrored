package controller;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;


import java.sql.Date;

import model.Album;
import model.Artist;
import model.HAS;
import persistence.PersistenceXStream;

public class createAlbum {
	Album album;
	String name;
	String artistName;
	String releaseDate;
	String inputNumberofSongs;
	int numberOfSongs;



	public createAlbum(String albName,String artName,String RlsDate,String numbOfSongs){

		this.name = albName;
		this.artistName = artName;

		this.releaseDate = RlsDate;

		this.inputNumberofSongs = numbOfSongs;


	}

	public boolean checkVoids() {
		if(name.length()==0 || name.trim().length() == 0){
			return false;
		}
		else if(artistName.length()==0 || artistName.trim().length() == 0){
			return false;
		}

		else if(releaseDate.length()==0 || releaseDate.trim().length() == 0){
			return false;
		}
		else if(inputNumberofSongs.length()==0 || inputNumberofSongs.trim().length() == 0){
			return false;
		}
		return true;
	}

	public boolean checkFormat() {
		int i =0;
		try {
			i  = Integer.parseInt(inputNumberofSongs);

		} catch (NumberFormatException e) {
			return false;
		}		

		numberOfSongs = i;

		return true;
	}

	public boolean checkDate() {

		Artist artist = new Artist(artistName);

		java.sql.Date parsed;
		try {
			parsed = java.sql.Date.valueOf(releaseDate);
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			album = new Album(name,sql,artist);
			artist.addAlbum(album);
		
		} catch (IllegalArgumentException e) {
			return false;
		}
		
		artist.addAlbum(album);
		saveArtist(artist);
		saveAlbum();
		return true;
	}


	private void saveArtist(Artist artist) {
		HAS hs = HAS.getInstance();
		
		hs.addArtist(artist);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}
	
	private void saveAlbum() {
		HAS hs = HAS.getInstance();

		hs.addAlbum(album);

		PersistenceXStream.saveToXMLwithXStream(hs);
	}



}
