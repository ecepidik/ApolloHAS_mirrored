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
import model.Playlist;
import model.Song;
import persistence.PersistenceXStream;

public class controllerCreateObjects {
	Album album;
	Artist artist;
	Song song;
	Playlist playlist;
	//	String name;
	//	String artistName;
	//	String releaseDate;
	//	String inputNumberofSongs;
	//	int numberOfSongs;



	public controllerCreateObjects(){
		//
		//		this.name = albName;
		//		this.artistName = artName;
		//
		//		this.releaseDate = RlsDate;
		//
		//		this.inputNumberofSongs = numbOfSongs;
		//
		//
	}

	public controllerCreateObjects(String name2, Date releaseDate2, Artist artist2, String error) {
		//		this.name = name2;
		//		this.releaseDate = null;
		//		this.artistName = null;
		//		this.inputNumberofSongs = error;
	}

	public void createAlbum(String albName,Artist art,Date date,String numbOfSongs)throws InvalidInputException, NumberFormatException {
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");
		boolean correctFormat = true;
		if(albName == null||albName.length()==0 || albName.trim().length() == 0){
			throw e;
		}
		else if(art == null){

			throw e;
		}
		else if(date==null){
			throw e;
		}
		else if(numbOfSongs.length()==0 || numbOfSongs.trim().length() == 0||numbOfSongs == null){

			throw e;
		}
		InvalidInputException eNum;
		int i =0;
		try {
			i  = Integer.parseInt(numbOfSongs);
		} catch (NumberFormatException e1) {
			throw eNum= new InvalidInputException("Incorrect Song Number Format!");
		}		


		InvalidInputException eDate;

	
		Album album;

		album = new Album(albName,date,art);
		art.addAlbum(album);
		
		saveArtist(art);
		saveAlbum(album);

	}
	public void createSong(Album alb, Artist artist, String name,Time duration, String genre, String trackNum) throws InvalidInputException {
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");

		if(name.length()==0 || name.trim().length() == 0){
			throw e;
		}
		else if(duration==null){
			throw e;
		}

		else if(genre.length()==0 || genre.trim().length() == 0){
			throw e;
		}
		else if(trackNum.length()==0 || trackNum.trim().length() == 0){
			throw e;
		}
		InvalidInputException eNum = new InvalidInputException("Incorrect Track Number Format!");
		int trackNumber =0;
		try {
			trackNumber  = Integer.parseInt(trackNum);

		} catch (NumberFormatException e1) {
			throw eNum;
		}
		if(trackNumber<0){
			throw eNum;
		}

		InvalidInputException eTime = new InvalidInputException("Incorrect Time Format");
		Song aSong;
		Album album = alb;
		try {
			aSong = new Song(name, duration, genre, trackNumber, artist);
		} catch (Exception e2 ) {
			throw eTime;
		}

		album.addSong(aSong);
		album.addSongAt(aSong,trackNumber);

		saveSong(aSong);
		saveAlbum(alb);
	}
	
	public void createArtist(String artName)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Must enter a name!");
		if(artName.length()==0||artName.trim().length()==0)
			throw e;
		Artist artist = new Artist(artName);
		saveArtist(artist);
	}
	
	public void createPlaylist (String name)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");
		if(name.length() == 0|| name.trim().length() == 0){
			throw e;
		}
		Playlist playlist = new Playlist(name);
		savePlaylist(playlist);
	}
	private void savePlaylist(Playlist playlist) {
		HAS hs = HAS.getInstance();
		this.playlist=playlist;
		hs.addPlaylist(playlist);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}

	private void saveSong(Song aSong) {

		HAS hs = HAS.getInstance();
		this.song = aSong;
		hs.addSong(aSong);

		PersistenceXStream.saveToXMLwithXStream(hs);

	}


	private void saveArtist(Artist artist) {
		HAS hs = HAS.getInstance();
		this.artist = artist;
		hs.addArtist(artist);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}

	private void saveAlbum(Album alb) {
		HAS hs = HAS.getInstance();
		this.album = alb;
		hs.addAlbum(alb);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}


	public Artist getArtist(){
		return this.artist;
	}
	public Album getAlbum(){
		return this.album;
	}



}
