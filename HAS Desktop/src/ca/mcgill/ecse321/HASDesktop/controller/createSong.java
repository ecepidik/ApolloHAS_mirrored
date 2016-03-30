package ca.mcgill.ecse321.HASDesktop.controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Artist;
import ca.mcgill.ecse321.HASDesktop.model.Player;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Room;
import ca.mcgill.ecse321.HASDesktop.model.Song;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceXStream;

public class createSong {
//	private Artist artist;
//	private Album album;
//	private String songName;
//	
//	private String durationString;
//	java.util.Date duration;
//	private String genre;
//	
//	private int trackNumber;
//	private String trackString;
//	Song aSong;
	
	public createSong(){
//		this.artist = artist;
//		this.songName = name;
//		this.durationString = duration;
//		this.genre = genre;
//		this.trackString = trackNum;
//		this.album = alb;
		
	}
	

	private void saveAlbum(Album album) {
		HAS hs = HAS.getInstance();
		
		hs.addAlbum(album);
		
		PersistenceXStream.saveToXMLwithXStream(hs);
	}

	
}
