package controller;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Album;
import model.Artist;
import model.HAS;
import model.Song;
import persistence.PersistenceXStream;

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
