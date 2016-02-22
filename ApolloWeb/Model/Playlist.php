<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-ebfd285 modeling language!*/

class Playlist
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Playlist Attributes
  private $name;

  //Playlist Associations
  private $song;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->song = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
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

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->song = array();
  }

}
?>