/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.HASDesktop.model;

import java.io.Serializable;

// line 40 "../../../../../HAS_model.ump"
// line 91 "../../../../../HAS_model.ump"
public class Room implements Serializable
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

  // line 45 "../../../../../HAS_model.ump"
   public void updateInfo(){
    
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "volume" + ":" + getVolume()+ "," +
            "mute" + ":" + getMute()+ "]"
     + outputString;
  }
}