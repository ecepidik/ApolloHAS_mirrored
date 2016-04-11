package ca.mcgill.ecse321.HASDesktop.controller;

import java.sql.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;


import java.sql.Date;

import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Player;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Room;
import ca.mcgill.ecse321.HASDesktop.model.Song;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.Genre;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceXStream;

public class controllerCreateObjects {
	Album album;
	Artist artist;
	Song song;
	Playlist playlist;
	public controllerCreateObjects(){


	}

	public controllerCreateObjects(String name2, Date releaseDate2, Artist artist2, String error) {


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

	
		Album alb;

		alb = new Album(albName,date,art);
		art.addAlbum(alb);
		HAS hs = HAS.getInstance();
		this.album = alb;
		hs.addAlbum(alb);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}
	public void createSong(String name,int duration, int trackNum,Genre genre) throws InvalidInputException {
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");

		if(name.length()==0 || name.trim().length() == 0){
			throw e;
		}
		else if(duration < 0){
			throw e;
		}


		else if(trackNum < 0){
			throw e;
		}
		
		InvalidInputException eNum = new InvalidInputException("Incorrect Track Number Format!");
		
		if(trackNum<0){
			throw eNum;
		}

		InvalidInputException eTime = new InvalidInputException("Incorrect Time Format");
		Song aSong;
		try {
			aSong = new Song(name, duration, trackNum,genre);
		} catch (Exception e2 ) {
			throw eTime;
		}
		HAS hs = HAS.getInstance();
		this.song = aSong;
		hs.addSong(aSong);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}
	
	public void createArtist(String artName)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Must enter a name!");
		if(artName.length()==0||artName.trim().length()==0)
			throw e;		
		Artist artist = new Artist(artName);
		HAS hs = HAS.getInstance();
		for (int i = 0; i < hs.getArtists().size(); i++) {
			if(hs.getArtist(i).getName()==artist.getName())
			{
				artist=hs.getArtist(i);
			}
		}		
		this.artist = artist;
		hs.addArtist(artist);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}
	
	public void createPlaylist (String name)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");
		if(name.length() == 0|| name.trim().length() == 0){
			throw e;
		}
		Playlist playlist = new Playlist(name);
		HAS hs = HAS.getInstance();

		this.playlist = playlist;
		hs.addPlaylist(playlist);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}
	
	public void createRoom (String name,int volume,boolean mute)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");
		if(name.length() == 0|| name.trim().length() == 0){
			throw e;
		}
		
		Room room = new Room(name,volume,mute);
		HAS hs = HAS.getInstance();
		for (int i = 0; i < hs.getRooms().size(); i++) {
			if(hs.getRoom(i).getName()==room.getName())
			{
				room=hs.getRoom(i);
			}
		}	
		hs.addRoom(room);
		PersistenceXStream.saveToXMLwithXStream(hs);
	}
	
	public void createGenre (String name)throws InvalidInputException{
		InvalidInputException e = new InvalidInputException("Cannot have empty fields!");
		if(name.length() == 0|| name.trim().length() == 0){
			throw e;
		}
		Genre genre = new Genre(name);
		HAS hs = HAS.getInstance();
		hs.addGenre(genre);
		PersistenceXStream.saveToXMLwithXStream(hs);

	}
	
	public Player createPlayer() {
		Player p = new Player();
		HAS hs= HAS.getInstance();
		hs.addPlayer(p);
		PersistenceXStream.saveToXMLwithXStream(hs);
		return p;
	}
	public Album getAlbum(){
		return this.album;
		
	}
	public Song getSong(){
		return this.song;
		
	}
}
