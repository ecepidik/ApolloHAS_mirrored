<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-ebfd285 modeling language!*/

class Song
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Song Attributes
  private $name;
  private $duration;
  private $genre;
  private $trackNum;

  //Song Associations
  private $artist;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aDuration, $aGenre, $aTrackNum, $aArtist)
  {
    $this->name = $aName;
    $this->duration = $aDuration;
    $this->genre = $aGenre;
    $this->trackNum = $aTrackNum;
    $didAddArtist = $this->setArtist($aArtist);
    if (!$didAddArtist)
    {
      throw new Exception("Unable to create song due to artist");
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

  public function setDuration($aDuration)
  {
    $wasSet = false;
    $this->duration = $aDuration;
    $wasSet = true;
    return $wasSet;
  }

  public function setGenre($aGenre)
  {
    $wasSet = false;
    $this->genre = $aGenre;
    $wasSet = true;
    return $wasSet;
  }

  public function setTrackNum($aTrackNum)
  {
    $wasSet = false;
    $this->trackNum = $aTrackNum;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getDuration()
  {
    return $this->duration;
  }

  public function getGenre()
  {
    return $this->genre;
  }

  public function getTrackNum()
  {
    return $this->trackNum;
  }

  public function getArtist()
  {
    return $this->artist;
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
      $existingArtist->removeSong($this);
    }
    $this->artist->addSong($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderArtist = $this->artist;
    $this->artist = null;
    $placeholderArtist->removeSong($this);
  }

}
?>