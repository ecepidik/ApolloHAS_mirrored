/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package model;
import java.util.*;
import java.sql.Time;
import java.sql.Date;

// line 41 "../HAS_model.ump"
// line 78 "../HAS_model.ump"
public class HAS
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static HAS theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HAS Associations
  private List<Player> player;
  private List<Room> room;
  private List<Song> song;
  private List<Album> album;
  private List<Playlist> playlist;
  private List<Artist> artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private HAS()
  {
    player = new ArrayList<Player>();
    room = new ArrayList<Room>();
    song = new ArrayList<Song>();
    album = new ArrayList<Album>();
    playlist = new ArrayList<Playlist>();
    artist = new ArrayList<Artist>();
  }

  public static HAS getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new HAS();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Player getPlayer(int index)
  {
    Player aPlayer = player.get(index);
    return aPlayer;
  }

  public List<Player> getPlayer()
  {
    List<Player> newPlayer = Collections.unmodifiableList(player);
    return newPlayer;
  }

  public int numberOfPlayer()
  {
    int number = player.size();
    return number;
  }

  public boolean hasPlayer()
  {
    boolean has = player.size() > 0;
    return has;
  }

  public int indexOfPlayer(Player aPlayer)
  {
    int index = player.indexOf(aPlayer);
    return index;
  }

  public Room getRoom(int index)
  {
    Room aRoom = room.get(index);
    return aRoom;
  }

  public List<Room> getRoom()
  {
    List<Room> newRoom = Collections.unmodifiableList(room);
    return newRoom;
  }

  public int numberOfRoom()
  {
    int number = room.size();
    return number;
  }

  public boolean hasRoom()
  {
    boolean has = room.size() > 0;
    return has;
  }

  public int indexOfRoom(Room aRoom)
  {
    int index = room.indexOf(aRoom);
    return index;
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

  public Playlist getPlaylist(int index)
  {
    Playlist aPlaylist = playlist.get(index);
    return aPlaylist;
  }

  public List<Playlist> getPlaylist()
  {
    List<Playlist> newPlaylist = Collections.unmodifiableList(playlist);
    return newPlaylist;
  }

  public int numberOfPlaylist()
  {
    int number = playlist.size();
    return number;
  }

  public boolean hasPlaylist()
  {
    boolean has = playlist.size() > 0;
    return has;
  }

  public int indexOfPlaylist(Playlist aPlaylist)
  {
    int index = playlist.indexOf(aPlaylist);
    return index;
  }

  public Artist getArtist(int index)
  {
    Artist aArtist = artist.get(index);
    return aArtist;
  }

  public List<Artist> getArtist()
  {
    List<Artist> newArtist = Collections.unmodifiableList(artist);
    return newArtist;
  }

  public int numberOfArtist()
  {
    int number = artist.size();
    return number;
  }

  public boolean hasArtist()
  {
    boolean has = artist.size() > 0;
    return has;
  }

  public int indexOfArtist(Artist aArtist)
  {
    int index = artist.indexOf(aArtist);
    return index;
  }

  public static int minimumNumberOfPlayer()
  {
    return 0;
  }

  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (player.contains(aPlayer)) { return false; }
    player.add(aPlayer);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (player.contains(aPlayer))
    {
      player.remove(aPlayer);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPlayerAt(Player aPlayer, int index)
  {  
    boolean wasAdded = false;
    if(addPlayer(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayer()) { index = numberOfPlayer() - 1; }
      player.remove(aPlayer);
      player.add(index, aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerAt(Player aPlayer, int index)
  {
    boolean wasAdded = false;
    if(player.contains(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayer()) { index = numberOfPlayer() - 1; }
      player.remove(aPlayer);
      player.add(index, aPlayer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerAt(aPlayer, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfRoom()
  {
    return 0;
  }

  public boolean addRoom(Room aRoom)
  {
    boolean wasAdded = false;
    if (room.contains(aRoom)) { return false; }
    room.add(aRoom);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRoom(Room aRoom)
  {
    boolean wasRemoved = false;
    if (room.contains(aRoom))
    {
      room.remove(aRoom);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRoomAt(Room aRoom, int index)
  {  
    boolean wasAdded = false;
    if(addRoom(aRoom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoom()) { index = numberOfRoom() - 1; }
      room.remove(aRoom);
      room.add(index, aRoom);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoomAt(Room aRoom, int index)
  {
    boolean wasAdded = false;
    if(room.contains(aRoom))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoom()) { index = numberOfRoom() - 1; }
      room.remove(aRoom);
      room.add(index, aRoom);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoomAt(aRoom, index);
    }
    return wasAdded;
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

  public static int minimumNumberOfAlbum()
  {
    return 0;
  }

  public boolean addAlbum(Album aAlbum)
  {
    boolean wasAdded = false;
    if (album.contains(aAlbum)) { return false; }
    album.add(aAlbum);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAlbum(Album aAlbum)
  {
    boolean wasRemoved = false;
    if (album.contains(aAlbum))
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

  public static int minimumNumberOfPlaylist()
  {
    return 0;
  }

  public boolean addPlaylist(Playlist aPlaylist)
  {
    boolean wasAdded = false;
    if (playlist.contains(aPlaylist)) { return false; }
    playlist.add(aPlaylist);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlaylist(Playlist aPlaylist)
  {
    boolean wasRemoved = false;
    if (playlist.contains(aPlaylist))
    {
      playlist.remove(aPlaylist);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPlaylistAt(Playlist aPlaylist, int index)
  {  
    boolean wasAdded = false;
    if(addPlaylist(aPlaylist))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlaylist()) { index = numberOfPlaylist() - 1; }
      playlist.remove(aPlaylist);
      playlist.add(index, aPlaylist);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlaylistAt(Playlist aPlaylist, int index)
  {
    boolean wasAdded = false;
    if(playlist.contains(aPlaylist))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlaylist()) { index = numberOfPlaylist() - 1; }
      playlist.remove(aPlaylist);
      playlist.add(index, aPlaylist);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlaylistAt(aPlaylist, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfArtist()
  {
    return 0;
  }

  public boolean addArtist(Artist aArtist)
  {
    boolean wasAdded = false;
    if (artist.contains(aArtist)) { return false; }
    artist.add(aArtist);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArtist(Artist aArtist)
  {
    boolean wasRemoved = false;
    if (artist.contains(aArtist))
    {
      artist.remove(aArtist);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addArtistAt(Artist aArtist, int index)
  {  
    boolean wasAdded = false;
    if(addArtist(aArtist))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArtist()) { index = numberOfArtist() - 1; }
      artist.remove(aArtist);
      artist.add(index, aArtist);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArtistAt(Artist aArtist, int index)
  {
    boolean wasAdded = false;
    if(artist.contains(aArtist))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArtist()) { index = numberOfArtist() - 1; }
      artist.remove(aArtist);
      artist.add(index, aArtist);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArtistAt(aArtist, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    player.clear();
    room.clear();
    song.clear();
    album.clear();
    playlist.clear();
    artist.clear();
  }

}