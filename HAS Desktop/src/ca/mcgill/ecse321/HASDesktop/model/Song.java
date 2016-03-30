/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.HASDesktop.model;

// line 2 "../../../../../HAS_model.ump"
// line 65 "../../../../../HAS_model.ump"
public class Song
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Song Attributes
  private String name;
  private int duration;
  private int trackNum;

  //Song Associations
  private Genre genre;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Song(String aName, int aDuration, int aTrackNum, Genre aGenre)
  {
    name = aName;
    duration = aDuration;
    trackNum = aTrackNum;
    if (!setGenre(aGenre))
    {
      throw new RuntimeException("Unable to create Song due to aGenre");
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

  public int getTrackNum()
  {
    return trackNum;
  }

  public Genre getGenre()
  {
    return genre;
  }

  public boolean setGenre(Genre aNewGenre)
  {
    boolean wasSet = false;
    if (aNewGenre != null)
    {
      genre = aNewGenre;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    genre = null;
  }

  // line 8 "../../../../../HAS_model.ump"
   public void updateInfo(){
    
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "duration" + ":" + getDuration()+ "," +
            "trackNum" + ":" + getTrackNum()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "genre = "+(getGenre()!=null?Integer.toHexString(System.identityHashCode(getGenre())):"null")
     + outputString;
  }
}