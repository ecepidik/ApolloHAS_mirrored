<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-ebfd285 modeling language!*/

class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Associations
  private $song;
  private $room;
  private $album;
  private $playlist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aSong, $aRoom, $aAlbum, $aPlaylist)
  {
    if (!$this->setSong($aSong))
    {
      throw new Exception("Unable to create Player due to aSong");
    }
    if (!$this->setRoom($aRoom))
    {
      throw new Exception("Unable to create Player due to aRoom");
    }
    if (!$this->setAlbum($aAlbum))
    {
      throw new Exception("Unable to create Player due to aAlbum");
    }
    if (!$this->setPlaylist($aPlaylist))
    {
      throw new Exception("Unable to create Player due to aPlaylist");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getSong()
  {
    return $this->song;
  }

  public function getRoom()
  {
    return $this->room;
  }

  public function getAlbum()
  {
    return $this->album;
  }

  public function getPlaylist()
  {
    return $this->playlist;
  }

  public function setSong($aNewSong)
  {
    $wasSet = false;
    if ($aNewSong != null)
    {
      $this->song = $aNewSong;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function setRoom($aNewRoom)
  {
    $wasSet = false;
    if ($aNewRoom != null)
    {
      $this->room = $aNewRoom;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function setAlbum($aNewAlbum)
  {
    $wasSet = false;
    if ($aNewAlbum != null)
    {
      $this->album = $aNewAlbum;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function setPlaylist($aNewPlaylist)
  {
    $wasSet = false;
    if ($aNewPlaylist != null)
    {
      $this->playlist = $aNewPlaylist;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->song = null;
    $this->room = null;
    $this->album = null;
    $this->playlist = null;
  }

}
?>