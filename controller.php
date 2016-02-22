<?php
require_once __DIR__.'/../Controller/InputValidator.php';
require_once __DIR__.'/../Persistence/PersistenceApollo.php';
require_once __DIR__.'/../Model/Artist.php';
require_once __DIR__.'/../Model/Album.php';
require_once __DIR__.'/../Model/Song.php';
require_once __DIR__.'/../Model/HAS.php';

class controller
{
	public function __construct()
	{
	}
	
	public function createSong($song_name, $song_duration, $song_genre, $song_num, $song_artist)
	{
		// 1. Validate input
		$name = InputValidator::validate_input($song_name);
		$duration = InputValidator::validate_input($song_duration);
		$genre = InputValidator::validate_input($song_genre);
		$position = InputValidator::validate_input($song_num);
		$artist = InputValidator::validate_input($song_artist);
		$error = "";
		if($name == null || strlen($name)==0)
		{
			$error .= "Song name cannot be empty. ";
		}
		//**might be mistake here (strtotime($duration)??)**
		if($duration == null || strlen($duration)==0 || strtotime($duration)==false)
		{
			$error .= "Song duration must be specified correctly (MM:SS). ";
		}
		if($genre == null || strlen($genre)==0)
		{
			$error .= "Song genre cannot be empty";
		}
		if($position == null || strlen($position)==0 || ctype_digit($position)==false)
		{
			$error .= "Song position is invalid. ";
		}
		if($artist == null || strlen($artist)==0)
		{
			$error .= "Song artist cannot be empty.";
		}
		if($error != "")
		{
			throw new Exception($error);
		}
		else
		{
			// 2. Load all of the data
			$pm = new PersistenceApollo();
			$has = $pm->loadDataFromStore();
			
			// 3. Add new song and artist
			$songArtist = new Artist($artist);
			$song = new Song($name, $duration, $genre, $position, $songArtist);
			$has->addSong($song);
			
			// 4. Write all of the data
			$pm->writeDataToStore($has);
		}
			
	
	}
	
	public function createAlbum($album_name, $album_date, $album_artist)
	{
		// 1. Validate input
		$name = InputValidator::validate_input($album_name);
		$date = InputValidator::validate_input($album_date);
		$artist = InputValidator::validate_input($album_artist);
		$error = "";
		if($name==null || strlen($name)==0)
		{
			$error .= "Album name cannot be empty. ";
		}
		if($date == null || strlen($date)==0 || strtotime($date)==false)
		{
			$error .= "Album release date must be specified correctly (YYYY-MM-DD). ";
		}
		if($artist == null || strlen($artist)==0)
		{
			$error .= "Album artist cannot be empty.";
		}
		if($error != "")
		{
			throw new Exception($error);
		}
		else 
		{
			// 2. Load all of the data
			$pm = new PersistenceApollo();
			$has = $pm->loadDataFromStore();
			
			// 3. Add new album and artist
			$albumArtist = new Artist($artist);
			$album = new Album($name, date('Y-m-d', strtotime($date)), $albumArtist);
			$has->addAlbum($album);
			
			// 4. Write all of the data
			$pm->writeDataToStore($has);
			
			
		}
	}
}