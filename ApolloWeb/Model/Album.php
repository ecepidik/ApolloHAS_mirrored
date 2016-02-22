<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-ebfd285 modeling language!*/

class Album
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Album Attributes
  private $name;
  private $date;

  //Album Associations
  private $song;
  private $artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aDate, $aArtist)
  {
    $this->name = $aName;
    $this->date = $aDate;
    $this->song = array();
    $didAddArtist = $this->setArtist($aArtist);
    if (!$didAddArtist)
    {
      throw new Exception("Unable to create album due to artist");
    }
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

  public function setDate($aDate)
  {
    $wasSet = false;
    $this->date = $aDate;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getDate()
  {
    return $this->date;
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

  public function getArtist()
  {
    return $this->artist;
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

  public function setArtist($aArtist)
  {
    $wasSet = false;
    if ($aArtist == null)
    {
      return $wasSet;
    }
    
    $existingArtist = $this->artist;
    $this->artist = $aArtist;
    if ($existingArtist != null && $existingArtist != $aArtist)
    {
      $existingArtist->removeAlbum($this);
    }
    $this->artist->addAlbum($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->song = array();
    $placeholderArtist = $this->artist;
    $this->artist = null;
    $placeholderArtist->removeAlbum($this);
  }

}
?>