/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/



// line 1 "HAS_model.ump"
// line 50 "HAS_model.ump"
public class Song
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Song Attributes
  private String name;
  private int duration;
  private String genre;
  private int trackNum;

  //Song Associations
  private Artist artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Song(String aName, int aDuration, String aGenre, int aTrackNum, Artist aArtist)
  {
    name = aName;
    duration = aDuration;
    genre = aGenre;
    trackNum = aTrackNum;
    boolean didAddArtist = setArtist(aArtist);
    if (!didAddArtist)
    {
      throw new RuntimeException("Unable to create song due to artist");
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

  public boolean setDuration(int aDuration)
  {
    boolean wasSet = false;
    duration = aDuration;
    wasSet = true;
    return wasSet;
  }

  public boolean setGenre(String aGenre)
  {
    boolean wasSet = false;
    genre = aGenre;
    wasSet = true;
    return wasSet;
  }

  public boolean setTrackNum(int aTrackNum)
  {
    boolean wasSet = false;
    trackNum = aTrackNum;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getDuration()
  {
    return duration;
  }

  public String getGenre()
  {
    return genre;
  }

  public int getTrackNum()
  {
    return trackNum;
  }

  public Artist getArtist()
  {
    return artist;
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
      existingArtist.removeSong(this);
    }
    artist.addSong(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Artist placeholderArtist = artist;
    this.artist = null;
    placeholderArtist.removeSong(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "duration" + ":" + getDuration()+ "," +
            "genre" + ":" + getGenre()+ "," +
            "trackNum" + ":" + getTrackNum()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "artist = "+(getArtist()!=null?Integer.toHexString(System.identityHashCode(getArtist())):"null")
     + outputString;
  }
}