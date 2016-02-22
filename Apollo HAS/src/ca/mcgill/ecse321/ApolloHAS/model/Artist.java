/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.ApolloHAS.model;
import java.util.*;
import java.io.Serializable;
import java.sql.Date;

// line 11 "../../../../../HAS_model.ump"
// line 58 "../../../../../HAS_model.ump"
public class Artist implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Artist Attributes
  private String name;

  //Artist Associations
  private List<Album> album;
  private List<Song> songs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Artist(String aName)
  {
    name = aName;
    album = new ArrayList<Album>();
    songs = new ArrayList<Song>();
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

  public String getName()
  {
    return name;
  }

  public Album getAlbum(int index)
  {
    Album aAlbum = album.get(index);
    return aAlbum;
  }

  public List<Album> getAlbum()
  {
    List<Album> newAlbum = Collections.unmodifiableList(album);
    return newAlbum;
  }

  public int numberOfAlbum()
  {
    int number = album.size();
    return number;
  }

  public boolean hasAlbum()
  {
    boolean has = album.size() > 0;
    return has;
  }

  public int indexOfAlbum(Album aAlbum)
  {
    int index = album.indexOf(aAlbum);
    return index;
  }

  public Song getSong(int index)
  {
    Song aSong = songs.get(index);
    return aSong;
  }

  public List<Song> getSongs()
  {
    List<Song> newSongs = Collections.unmodifiableList(songs);
    return newSongs;
  }

  public int numberOfSongs()
  {
    int number = songs.size();
    return number;
  }

  public boolean hasSongs()
  {
    boolean has = songs.size() > 0;
    return has;
  }

  public int indexOfSong(Song aSong)
  {
    int index = songs.indexOf(aSong);
    return index;
  }

  public static int minimumNumberOfAlbum()
  {
    return 0;
  }

  public Album addAlbum(String aName, Date aDate)
  {
    return new Album(aName, aDate, this);
  }

  public boolean addAlbum(Album aAlbum)
  {
    boolean wasAdded = false;
    if (album.contains(aAlbum)) { return false; }
    Artist existingArtist = aAlbum.getArtist();
    boolean isNewArtist = existingArtist != null && !this.equals(existingArtist);
    if (isNewArtist)
    {
      aAlbum.setArtist(this);
    }
    else
    {
      album.add(aAlbum);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAlbum(Album aAlbum)
  {
    boolean wasRemoved = false;
    //Unable to remove aAlbum, as it must always have a artist
    if (!this.equals(aAlbum.getArtist()))
    {
      album.remove(aAlbum);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAlbumAt(Album aAlbum, int index)
  {  
    boolean wasAdded = false;
    if(addAlbum(aAlbum))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlbum()) { index = numberOfAlbum() - 1; }
      album.remove(aAlbum);
      album.add(index, aAlbum);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAlbumAt(Album aAlbum, int index)
  {
    boolean wasAdded = false;
    if(album.contains(aAlbum))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAlbum()) { index = numberOfAlbum() - 1; }
      album.remove(aAlbum);
      album.add(index, aAlbum);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAlbumAt(aAlbum, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfSongs()
  {
    return 0;
  }

  public Song addSong(String aName, int aDuration, String aGenre, int aTrackNum)
  {
    return new Song(aName, aDuration, aGenre, aTrackNum, this);
  }

  public boolean addSong(Song aSong)
  {
    boolean wasAdded = false;
    if (songs.contains(aSong)) { return false; }
    Artist existingArtist = aSong.getArtist();
    boolean isNewArtist = existingArtist != null && !this.equals(existingArtist);
    if (isNewArtist)
    {
      aSong.setArtist(this);
    }
    else
    {
      songs.add(aSong);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSong(Song aSong)
  {
    boolean wasRemoved = false;
    //Unable to remove aSong, as it must always have a artist
    if (!this.equals(aSong.getArtist()))
    {
      songs.remove(aSong);
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
      if(index > numberOfSongs()) { index = numberOfSongs() - 1; }
      songs.remove(aSong);
      songs.add(index, aSong);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSongAt(Song aSong, int index)
  {
    boolean wasAdded = false;
    if(songs.contains(aSong))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSongs()) { index = numberOfSongs() - 1; }
      songs.remove(aSong);
      songs.add(index, aSong);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSongAt(aSong, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=album.size(); i > 0; i--)
    {
      Album aAlbum = album.get(i - 1);
      aAlbum.delete();
    }
    for(int i=songs.size(); i > 0; i--)
    {
      Song aSong = songs.get(i - 1);
      aSong.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}