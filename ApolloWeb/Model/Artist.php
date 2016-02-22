<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.23.0-ebfd285 modeling language!*/

class Artist
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Artist Attributes
  private $name;

  //Artist Associations
  private $album;
  private $songs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->album = array();
    $this->songs = array();
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

  public function getSong_index($index)
  {
    $aSong = $this->songs[$index];
    return $aSong;
  }

  public function getSongs()
  {
    $newSongs = $this->songs;
    return $newSongs;
  }

  public function numberOfSongs()
  {
    $number = count($this->songs);
    return $number;
  }

  public function hasSongs()
  {
    $has = $this->numberOfSongs() > 0;
    return $has;
  }

  public function indexOfSong($aSong)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->songs as $song)
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

  public static function minimumNumberOfAlbum()
  {
    return 0;
  }

  public function addAlbumVia($aName, $aDate)
  {
    return new Album($aName, $aDate, $this);
  }

  public function addAlbum($aAlbum)
  {
    $wasAdded = false;
    if ($this->indexOfAlbum($aAlbum) !== -1) { return false; }
    $existingArtist = $aAlbum->getArtist();
    $isNewArtist = $existingArtist != null && $this !== $existingArtist;
    if ($isNewArtist)
    {
      $aAlbum->setArtist($this);
    }
    else
    {
      $this->album[] = $aAlbum;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeAlbum($aAlbum)
  {
    $wasRemoved = false;
    //Unable to remove aAlbum, as it must always have a artist
    if ($this !== $aAlbum->getArtist())
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

  public static function minimumNumberOfSongs()
  {
    return 0;
  }

  public function addSongVia($aName, $aDuration, $aGenre, $aTrackNum)
  {
    return new Song($aName, $aDuration, $aGenre, $aTrackNum, $this);
  }

  public function addSong($aSong)
  {
    $wasAdded = false;
    if ($this->indexOfSong($aSong) !== -1) { return false; }
    $existingArtist = $aSong->getArtist();
    $isNewArtist = $existingArtist != null && $this !== $existingArtist;
    if ($isNewArtist)
    {
      $aSong->setArtist($this);
    }
    else
    {
      $this->songs[] = $aSong;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeSong($aSong)
  {
    $wasRemoved = false;
    //Unable to remove aSong, as it must always have a artist
    if ($this !== $aSong->getArtist())
    {
      unset($this->songs[$this->indexOfSong($aSong)]);
      $this->songs = array_values($this->songs);
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
      if($index > $this->numberOfSongs()) { $index = $this->numberOfSongs() - 1; }
      array_splice($this->songs, $this->indexOfSong($aSong), 1);
      array_splice($this->songs, $index, 0, array($aSong));
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
      if($index > $this->numberOfSongs()) { $index = $this->numberOfSongs() - 1; }
      array_splice($this->songs, $this->indexOfSong($aSong), 1);
      array_splice($this->songs, $index, 0, array($aSong));
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
    foreach ($this->album as $aAlbum)
    {
      $aAlbum->delete();
    }
    foreach ($this->songs as $aSong)
    {
      $aSong->delete();
    }
  }

}
?>