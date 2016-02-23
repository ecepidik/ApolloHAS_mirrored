/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.ApolloHAS.model;
import java.io.Serializable;
import java.util.*;

// line 22 "../../../../../HAS_model.ump"
// line 84 "../../../../../HAS_model.ump"
public class Playlist implements Serializable 
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Playlist Attributes
  private String name;

  //Playlist Associations
  private List<Song> song;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Playlist(String aName)
  {
    name = aName;
    song = new ArrayList<Song>();
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

  public void delete()
  {
    song.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}