/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package model;

// line 34 "../HAS_model.ump"
// line 73 "../HAS_model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Associations
  private Song song;
  private Room room;
  private Album album;
  private Playlist playlist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(Song aSong, Room aRoom, Album aAlbum, Playlist aPlaylist)
  {
    if (!setSong(aSong))
    {
      throw new RuntimeException("Unable to create Player due to aSong");
    }
    if (!setRoom(aRoom))
    {
      throw new RuntimeException("Unable to create Player due to aRoom");
    }
    if (!setAlbum(aAlbum))
    {
      throw new RuntimeException("Unable to create Player due to aAlbum");
    }
    if (!setPlaylist(aPlaylist))
    {
      throw new RuntimeException("Unable to create Player due to aPlaylist");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Song getSong()
  {
    return song;
  }

  public Room getRoom()
  {
    return room;
  }

  public Album getAlbum()
  {
    return album;
  }

  public Playlist getPlaylist()
  {
    return playlist;
  }

  public boolean setSong(Song aNewSong)
  {
    boolean wasSet = false;
    if (aNewSong != null)
    {
      song = aNewSong;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setRoom(Room aNewRoom)
  {
    boolean wasSet = false;
    if (aNewRoom != null)
    {
      room = aNewRoom;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setAlbum(Album aNewAlbum)
  {
    boolean wasSet = false;
    if (aNewAlbum != null)
    {
      album = aNewAlbum;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setPlaylist(Playlist aNewPlaylist)
  {
    boolean wasSet = false;
    if (aNewPlaylist != null)
    {
      playlist = aNewPlaylist;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    song = null;
    room = null;
    album = null;
    playlist = null;
  }

}