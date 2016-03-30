package ca.mcgill.ecse321.ApolloHAS.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

<<<<<<< HEAD:HAS Desktop/src/ca/mcgill/ecse321/HASDesktop/model/Room.java
package ca.mcgill.ecse321.HASDesktop.model;

// line 40 "../../../../../HAS_model.ump"
// line 91 "../../../../../HAS_model.ump"
=======


// line 38 "HAS_model.ump"
>>>>>>> origin/master:Apollo HAS/src/ca/mcgill/ecse321/ApolloHAS/model/Room.java
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

<<<<<<< HEAD:HAS Desktop/src/ca/mcgill/ecse321/HASDesktop/model/Room.java
  // line 45 "../../../../../HAS_model.ump"
=======
  // line 43 "HAS_model.ump"
>>>>>>> origin/master:Apollo HAS/src/ca/mcgill/ecse321/ApolloHAS/model/Room.java
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