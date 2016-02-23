package ca.mcgill.ecse321.ApolloHAS.persistence;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;
import ca.mcgill.ecse321.ApolloHAS.model.Song;

public class TestPersistenceApolloHAS {

	@Before
	public void setUp() throws Exception {
		HAS hs = HAS.getInstance();
		
		String name = "Crazy in Love";
		Calendar c  = Calendar.getInstance();
		c.set(2014, 10, 07);
		Date releaseDate = new Date(c.getTimeInMillis());
		Artist artist = new Artist("Beyoncé");
		
		String name1 = "Relapse";
		Calendar c1  = Calendar.getInstance();
		c.set(2009, 12, 21);
		Date releaseDate1 = new Date(c1.getTimeInMillis());
		Artist artist1 = new Artist("Eminem");
		
		Album a1 = new Album(name, releaseDate, artist);
		Album a2 = new Album(name1, releaseDate1, artist1);
		
		hs.addAlbum(a1);
		hs.addAlbum(a2);
	}

	@After
	public void tearDown() throws Exception {
		HAS hs = HAS.getInstance();
		hs.delete();
	}

	@Test
	public void test() {
		HAS hs = HAS.getInstance();
		PersistenceXStream.setFilename("test"+File.separator+"ca"+File.separator+"mcgill"+File.separator+"ecse321"+File.separator+"ApolloHAS"+File.separator+"persistence"+File.separator+"data.xml");
		PersistenceXStream.setAlias("album", Album.class);
		PersistenceXStream.setAlias("song", Song.class);
		PersistenceXStream.setAlias("hs", HAS.class);
		if (!PersistenceXStream.saveToXMLwithXStream(hs))
			fail("Could not save file.");
		
		hs.delete();
		assertEquals(0, hs.numberOfAlbum());
		
		hs = (HAS) PersistenceXStream.loadFromXMLwithXStream();
		if (hs == null)
			fail("Could not load file.");
		
		Calendar c  = Calendar.getInstance();
		c.set(2014, 10, 07);
		Date releaseDate = new Date(c.getTimeInMillis());
		Calendar c1  = Calendar.getInstance();
		c.set(2009, 12, 21);
		Date releaseDate1 = new Date(c1.getTimeInMillis());
		
		assertEquals(2, hs.numberOfAlbum());
		assertEquals("Crazy in Love", hs.getAlbum(0).getName());
		assertEquals("Relapse", hs.getAlbum(1).getName());
		assertEquals("Beyoncé", hs.getAlbum(0).getArtist());
		assertEquals("Eminem", hs.getAlbum(1).getArtist());
		assertEquals(releaseDate.toString(), hs.getAlbum(0).getDate().toString());
		assertEquals(releaseDate1.toString(), hs.getAlbum(1).getDate().toString());
	}

}
