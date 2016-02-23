package ca.mcgill.ecse321.ApolloHAS.controller;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;
import ca.mcgill.ecse321.ApolloHAS.model.Song;
import ca.mcgill.ecse321.ApolloHAS.persistence.PersistenceXStream;

public class TestApolloHASAlbumController {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersistenceXStream.setFilename("test"+File.separator+"ca"+File.separator+"mcgill"+File.separator+"ecse321"+File.separator+"ApolloHAS"+File.separator+"controller"+File.separator+"data.xml");
		PersistenceXStream.setAlias("album", Album.class);
		PersistenceXStream.setAlias("song", Song.class);
		PersistenceXStream.setAlias("hs", HAS.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		HAS hs = HAS.getInstance();
		hs.delete();
	}

	@Test
	public void testCreateAlbum() {
		HAS hs = HAS.getInstance();
		
		assertEquals(0, hs.numberOfAlbum());
		
		String name = "Crazy in Love";
		Calendar c  = Calendar.getInstance();
		c.set(2014, 10, 07);
		Date releaseDate = new Date(c.getTimeInMillis());
		Artist artist = new Artist("Beyoncé");
		
		ApolloHASAlbumController aac = new ApolloHASAlbumController();
		try {
			aac.createAlbum(name, releaseDate, artist);
		} catch (InvalidInputException e) {
			fail();
		}
		
		checkResultAlbum(name, releaseDate, artist, hs);
		
		HAS hs1 = (HAS) PersistenceXStream.loadFromXMLwithXStream();
		
		checkResultAlbum(name, releaseDate, artist, hs1);
	}
	
	@Test
	public void testCreateAlbumNull() {
		HAS hs = HAS.getInstance();
		
		assertEquals(0, hs.numberOfAlbum());
		
		String name = null;
		Date releaseDate = null;
		Artist artist = null;
		
		String error = null;
		
		ApolloHASAlbumController aac = new ApolloHASAlbumController();
		try {
			aac.createAlbum(name, releaseDate, artist);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("Album name cannot be empty! Release date cannot be empty! Artist cannot be empty! ", error);
		
		assertEquals(0, hs.numberOfAlbum());
	}
	
	@Test
	public void testCreateAlbumEmpty() {
		HAS hs = HAS.getInstance();
		
		assertEquals(0, hs.numberOfAlbum());
		
		String name = "";
		Calendar c  = Calendar.getInstance();
		c.set(2014, 10, 07);
		Date releaseDate = new Date(c.getTimeInMillis());
		Artist artist = new Artist("Beyoncé");
		
		String error = null;
		
		ApolloHASAlbumController aac = new ApolloHASAlbumController();
		try {
			aac.createAlbum(name, releaseDate, artist);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("Album name cannot be empty! ", error);
		
		assertEquals(0, hs.numberOfAlbum());
	}
	
	@Test
	public void testCreateAlbumSpaces() {
		HAS hs = HAS.getInstance();
		
		assertEquals(0, hs.numberOfAlbum());
		
		String name = " ";
		Calendar c  = Calendar.getInstance();
		c.set(2014, 10, 07);
		Date releaseDate = new Date(c.getTimeInMillis());
		Artist artist = new Artist("Beyoncé");
		
		String error = null;
		
		ApolloHASAlbumController aac = new ApolloHASAlbumController();
		try {
			aac.createAlbum(name, releaseDate, artist);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("Album name cannot be empty! ", error);
		
		assertEquals(0, hs.numberOfAlbum());
	}
	
	private void checkResultAlbum(String albumName, Date albumReleaseDate, Artist albumArtist, HAS hs1) {
		assertEquals(1, hs1.numberOfAlbum());
		assertEquals(albumName, hs1.getAlbum(0).getName());
		assertEquals(albumReleaseDate.toString(), hs1.getAlbum(0).getDate().toString());
		assertEquals(albumArtist.getName(), hs1.getAlbum(0).getArtist().getName());
	}

}
