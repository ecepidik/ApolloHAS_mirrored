

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.InvalidInputException;
import controller.controllerCreateObjects;
import model.Album;
import model.Artist;
import model.HAS;
import model.Song;
import persistence.PersistenceXStream;

public class TestApolloHASAlbumController {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersistenceXStream.setFilename("/HAS/test/HAS.xml");
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
		Artist artist = new Artist("Beyonce");

		controllerCreateObjects aac = new controllerCreateObjects();
		try {
			aac.createAlbum(name, artist, releaseDate, "10");
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

		controllerCreateObjects aac = new controllerCreateObjects(name,releaseDate,artist,error);
		try {
		//	aac.checkVoids();
			//aac.checkFormat();
		//	aac.checkDate();
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}


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
		Artist artist = new Artist("Beyonce");

		String error = null;

		//controllerCreateObjects aac = new controllerCreateObjects(name,releaseDate.toString(),artist.toString(),"0");
		try {//aac.checkVoids();
		//aac.checkFormat();
		//aac.checkDate();
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

	
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
		Artist artist = new Artist("Beyonce");

		String error = null;

	//	controllerCreateObjects aac = new controllerCreateObjects(name,releaseDate.toString(),artist.toString(),"0");
		try {//aac.checkVoids();
		//aac.checkFormat();
		//aac.checkDate();
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		
		assertEquals(0, hs.numberOfAlbum());
	}

	private void checkResultAlbum(String albumName, Date albumReleaseDate, Artist albumArtist, HAS hs1) {
		assertEquals(1, hs1.numberOfAlbum());
		assertEquals(albumName, hs1.getAlbum(0).getName());
		assertEquals(albumReleaseDate.toString(), hs1.getAlbum(0).getDate().toString());
		assertEquals(albumArtist.getName(), hs1.getAlbum(hs1.getAlbum().size()-1).getArtist().getName());
	}

}