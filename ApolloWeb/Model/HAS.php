<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-5871cbd modeling language!*/

class HAS
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HAS Associations
  private $player;
  private $room;
  private $song;
  private $album;
  private $playlist;
  private $artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private function __construct()
  {
    $this->player = array();
    $this->room = array();
    $this->song = array();
    $this->album = array();
    $this->playlist = array();
    $this->artist = array();
  }

  public static function getInstance()
  {
    if(self::$theInstance == null)
    {
      self::$theInstance = new HAS();
    }
    return self::$theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getPlayer_index($index)
  {
    $aPlayer = $this->player[$index];
    return $aPlayer;
  }

  public function getPlayer()
  {
    $newPlayer = $this->player;
    return $newPlayer;
  }

  public function numberOfPlayer()
  {
    $number = count($this->player);
    return $number;
  }

  public function hasPlayer()
  {
    $has = $this->numberOfPlayer() > 0;
    return $has;
  }

  public function indexOfPlayer($aPlayer)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->player as $player)
    {
      if ($player->equals($aPlayer))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getRoom_index($index)
  {
    $aRoom = $this->room[$index];
    return $aRoom;
  }

  public function getRoom()
  {
    $newRoom = $this->room;
    return $newRoom;
  }

  public function numberOfRoom()
  {
    $number = count($this->room);
    return $number;
  }

  public function hasRoom()
  {
    $has = $this->numberOfRoom() > 0;
    return $has;
  }

  public function indexOfRoom($aRoom)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->room as $room)
    {
      if ($room->equals($aRoom))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getSong_index($index)
  {
    $aSong = $this->song[$index];
    return $aSong;
  }

  public function getSong()
  {
    $newSong = $this->song;
    return $newSong;
  }

  public function numberOfSong()
  {
    $number = count($this->song);
    return $number;
  }

  public function hasSong()
  {
    $has = $this->numberOfSong() > 0;
    return $has;
  }

  public function indexOfSong($aSong)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->song as $song)
    {
      if ($song->equals($aSong))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getAlbum_index($index)
  {
    $aAlbum = $this->album[$index];
    return $aAlbum;
  }

  public function getAlbum()
  {
    $newAlbum = $this->album;
    return $newAlbum;
  }

  public function numberOfAlbum()
  {
    $number = count($this->album);
    return $number;
  }

  public function hasAlbum()
  {
    $has = $this->numberOfAlbum() > 0;
    return $has;
  }

  public function indexOfAlbum($aAlbum)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->album as $album)
    {
      if ($album->equals($aAlbum))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getPlaylist_index($index)
  {
    $aPlaylist = $this->playlist[$index];
    return $aPlaylist;
  }

  public function getPlaylist()
  {
    $newPlaylist = $this->playlist;
    return $newPlaylist;
  }

  public function numberOfPlaylist()
  {
    $number = count($this->playlist);
    return $number;
  }

  public function hasPlaylist()
  {
    $has = $this->numberOfPlaylist() > 0;
    return $has;
  }

  public function indexOfPlaylist($aPlaylist)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->playlist as $playlist)
    {
      if ($playlist->equals($aPlaylist))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getArtist_index($index)
  {
    $aArtist = $this->artist[$index];
    return $aArtist;
  }

  public function getArtist()
  {
    $newArtist = $this->artist;
    return $newArtist;
  }

  public function numberOfArtist()
  {
    $number = count($this->artist);
    return $number;
  }

  public function hasArtist()
  {
    $has = $this->numberOfArtist() > 0;
    return $has;
  }

  public function indexOfArtist($aArtist)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->artist as $artist)
    {
      if ($artist->equals($aArtist))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfPlayer()
  {
    return 0;
  }

  public function addPlayer($aPlayer)
  {
    $wasAdded = false;
    if ($this->indexOfPlayer($aPlayer) !== -1) { return false; }
    $this->player[] = $aPlayer;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removePlayer($aPlayer)
  {
    $wasRemoved = false;
    if ($this->indexOfPlayer($aPlayer) != -1)
    {
      unset($this->player[$this->indexOfPlayer($aPlayer)]);
      $this->player = array_values($this->player);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addPlayerAt($aPlayer, $index)
  {  
    $wasAdded = false;
    if($this->addPlayer($aPlayer))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfPlayer()) { $index = $this->numberOfPlayer() - 1; }
      array_splice($this->player, $this->indexOfPlayer($aPlayer), 1);
      array_splice($this->player, $index, 0, array($aPlayer));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMovePlayerAt($aPlayer, $index)
  {
    $wasAdded = false;
    if($this->indexOfPlayer($aPlayer) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfPlayer()) { $index = $this->numberOfPlayer() - 1; }
      array_splice($this->player, $this->indexOfPlayer($aPlayer), 1);
      array_splice($this->player, $index, 0, array($aPlayer));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addPlayerAt($aPlayer, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfRoom()
  {
    return 0;
  }

  public function addRoom($aRoom)
  {
    $wasAdded = false;
    if ($this->indexOfRoom($aRoom) !== -1) { return false; }
    $this->room[] = $aRoom;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeRoom($aRoom)
  {
    $wasRemoved = false;
    if ($this->indexOfRoom($aRoom) != -1)
    {
      unset($this->room[$this->indexOfRoom($aRoom)]);
      $this->room = array_values($this->room);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addRoomAt($aRoom, $index)
  {  
    $wasAdded = false;
    if($this->addRoom($aRoom))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfRoom()) { $index = $this->numberOfRoom() - 1; }
      array_splice($this->room, $this->indexOfRoom($aRoom), 1);
      array_splice($this->room, $index, 0, array($aRoom));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveRoomAt($aRoom, $index)
  {
    $wasAdded = false;
    if($this->indexOfRoom($aRoom) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfRoom()) { $index = $this->numberOfRoom() - 1; }
      array_splice($this->room, $this->indexOfRoom($aRoom), 1);
      array_splice($this->room, $index, 0, array($aRoom));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addRoomAt($aRoom, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfSong()
  {
    return 0;
  }

  public function addSong($aSong)
  {
    $wasAdded = false;
    if ($this->indexOfSong($aSong) !== -1) { return false; }
    $this->song[] = $aSong;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeSong($aSong)
  {
    $wasRemoved = false;
    if ($this->indexOfSong($aSong) != -1)
    {
      unset($this->song[$this->indexOfSong($aSong)]);
      $this->song = array_values($this->song);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addSongAt($aSong, $index)
  {  
    $wasAdded = false;
    if($this->addSong($aSong))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfSong()) { $index = $this->numberOfSong() - 1; }
      array_splice($this->song, $this->indexOfSong($aSong), 1);
      array_splice($this->song, $index, 0, array($aSong));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveSongAt($aSong, $index)
  {
    $wasAdded = false;
    if($this->indexOfSong($aSong) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfSong()) { $index = $this->numberOfSong() - 1; }
      array_splice($this->song, $this->indexOfSong($aSong), 1);
      array_splice($this->song, $index, 0, array($aSong));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addSongAt($aSong, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfAlbum()
  {
    return 0;
  }

  public function addAlbum($aAlbum)
  {
    $wasAdded = false;
    if ($this->indexOfAlbum($aAlbum) !== -1) { return false; }
    $this->album[] = $aAlbum;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeAlbum($aAlbum)
  {
    $wasRemoved = false;
    if ($this->indexOfAlbum($aAlbum) != -1)
    {
      unset($this->album[$this->indexOfAlbum($aAlbum)]);
      $this->album = array_values($this->album);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addAlbumAt($aAlbum, $index)
  {  
    $wasAdded = false;
    if($this->addAlbum($aAlbum))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfAlbum()) { $index = $this->numberOfAlbum() - 1; }
      array_splice($this->album, $this->indexOfAlbum($aAlbum), 1);
      array_splice($this->album, $index, 0, array($aAlbum));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveAlbumAt($aAlbum, $index)
  {
    $wasAdded = false;
    if($this->indexOfAlbum($aAlbum) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfAlbum()) { $index = $this->numberOfAlbum() - 1; }
      array_splice($this->album, $this->indexOfAlbum($aAlbum), 1);
      array_splice($this->album, $index, 0, array($aAlbum));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addAlbumAt($aAlbum, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfPlaylist()
  {
    return 0;
  }

  public function addPlaylist($aPlaylist)
  {
    $wasAdded = false;
    if ($this->indexOfPlaylist($aPlaylist) !== -1) { return false; }
    $this->playlist[] = $aPlaylist;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removePlaylist($aPlaylist)
  {
    $wasRemoved = false;
    if ($this->indexOfPlaylist($aPlaylist) != -1)
    {
      unset($this->playlist[$this->indexOfPlaylist($aPlaylist)]);
      $this->playlist = array_values($this->playlist);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addPlaylistAt($aPlaylist, $index)
  {  
    $wasAdded = false;
    if($this->addPlaylist($aPlaylist))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfPlaylist()) { $index = $this->numberOfPlaylist() - 1; }
      array_splice($this->playlist, $this->indexOfPlaylist($aPlaylist), 1);
      array_splice($this->playlist, $index, 0, array($aPlaylist));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMovePlaylistAt($aPlaylist, $index)
  {
    $wasAdded = false;
    if($this->indexOfPlaylist($aPlaylist) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfPlaylist()) { $index = $this->numberOfPlaylist() - 1; }
      array_splice($this->playlist, $this->indexOfPlaylist($aPlaylist), 1);
      array_splice($this->playlist, $index, 0, array($aPlaylist));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addPlaylistAt($aPlaylist, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfArtist()
  {
    return 0;
  }

  public function addArtist($aArtist)
  {
    $wasAdded = false;
    if ($this->indexOfArtist($aArtist) !== -1) { return false; }
    $this->artist[] = $aArtist;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeArtist($aArtist)
  {
    $wasRemoved = false;
    if ($this->indexOfArtist($aArtist) != -1)
    {
      unset($this->artist[$this->indexOfArtist($aArtist)]);
      $this->artist = array_values($this->artist);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addArtistAt($aArtist, $index)
  {  
    $wasAdded = false;
    if($this->addArtist($aArtist))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArtist()) { $index = $this->numberOfArtist() - 1; }
      array_splice($this->artist, $this->indexOfArtist($aArtist), 1);
      array_splice($this->artist, $index, 0, array($aArtist));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveArtistAt($aArtist, $index)
  {
    $wasAdded = false;
    if($this->indexOfArtist($aArtist) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArtist()) { $index = $this->numberOfArtist() - 1; }
      array_splice($this->artist, $this->indexOfArtist($aArtist), 1);
      array_splice($this->artist, $index, 0, array($aArtist));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addArtistAt($aArtist, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->player = array();
    $this->room = array();
    $this->song = array();
    $this->album = array();
    $this->playlist = array();
    $this->artist = array();
  }

}
?>