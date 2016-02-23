/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.ApolloHAS.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

// line 16 "../../../../../HAS_model.ump"
// line 63 "../../../../../HAS_model.ump"
public class Album implements Serializable 
{
	

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Album Attributes
  private String name;
  private Date date;

  //Album Associations
  private List<Song> song;
  private Artist artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Album(String aName, Date aDate, Artist aArtist)
  {
    name = aName;
    date = aDate;
    song = new ArrayList<Song>();
    boolean didAddArtist = setArtist(aArtist);
    if (!didAddArtist)
    {
      throw new RuntimeException("Unable to create album due to artist");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Date getDate()
  {
    return date;
  }

  public Song getSong(int index)
  {
    Song aSong = song.get(index);
    return aSong;
  }

  public List<Song> getSong()
  {
    List<Song> newSong = Collections.unmodifiableList(song);
    return newSong;
  }

  public int numberOfSong()
  {
    int number = song.size();
    return number;
  }

  public boolean hasSong()
  {
    boolean has = song.size() > 0;
    return has;
  }

  public int indexOfSong(Song aSong)
  {
    int index = song.indexOf(aSong);
    return index;
  }

  public Artist getArtist()
  {
    return artist;
  }

  public static int minimumNumberOfSong()
  {
    return 0;
  }

  public boolean addSong(Song aSong)
  {
    boolean wasAdded = false;
    if (song.contains(aSong)) { return false; }
    song.add(aSong);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSong(Song aSong)
  {
    boolean wasRemoved = false;
    if (song.contains(aSong))
    {
      song.remove(aSong);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSongAt(Song aSong, int index)
  {  
    boolean wasAdded = false;
    if(addSong(aSong))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSong()) { index = numberOfSong() - 1; }
      song.remove(aSong);
      song.add(index, aSong);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSongAt(Song aSong, int index)
  {
    boolean wasAdded = false;
    if(song.contains(aSong))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSong()) { index = numberOfSong() - 1; }
      song.remove(aSong);
      song.add(index, aSong);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSongAt(aSong, index);
    }
    return wasAdded;
  }

  public boolean setArtist(Artist aArtist)
  {
    boolean wasSet = false;
    if (aArtist == null)
    {
      return wasSet;
    }

    Artist existingArtist = artist;
    artist = aArtist;
    if (existingArtist != null && !existingArtist.equals(aArtist))
    {
      existingArtist.removeAlbum(this);
    }
    artist.addAlbum(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    song.clear();
    Artist placeholderArtist = artist;
    this.artist = null;
    placeholderArtist.removeAlbum(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "artist = "+(getArtist()!=null?Integer.toHexString(System.identityHashCode(getArtist())):"null")
     + outputString;
  }
}