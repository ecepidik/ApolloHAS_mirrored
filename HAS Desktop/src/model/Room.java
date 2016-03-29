/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package model;

// line 28 "../HAS_model.ump"
// line 68 "../HAS_model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String name;
  private int volume;
  private boolean mute;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName, int aVolume, boolean aMute)
  {
    name = aName;
    volume = aVolume;
    mute = aMute;
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

  public boolean setVolume(int aVolume)
  {
    boolean wasSet = false;
    volume = aVolume;
    wasSet = true;
    return wasSet;
  }

  public boolean setMute(boolean aMute)
  {
    boolean wasSet = false;
    mute = aMute;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getVolume()
  {
    return volume;
  }

  public boolean getMute()
  {
    return mute;
  }

  public void delete()
  {}


  public String toString()
  {
	 return name;
  }
}