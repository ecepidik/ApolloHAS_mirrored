<?php
require_once __DIR__.'/../Controller/InputValidator.php';
require_once __DIR__.'/../Persistence/PersistenceApollo.php';
require_once __DIR__.'/../Model/Artist.php';
require_once __DIR__.'/../Model/Album.php';
require_once __DIR__.'/../Model/Song.php';
require_once __DIR__.'/../Model/HAS.php';

class controller
{
	public function createAlbum($album_name, $album_date, $album_artist)
	{
		// 1. Validate input
		$name = InputValidator::validate_input($album_name);
		$date = InputValidator::validate_input($album_date);
		$artist = InputValidator::validate_input($album_artist);
		$error = "";
		if($name==null || strlen($name == 0))
		{
			$error .= "Album name cannot be empty. ";
		}
		if($date == null || strlen($date)==0 || strtotime($date)==false)
		{
			$error .= "Album release date must be specified correctly (YYYY-MM-DD).";
		}
		
		else 
		{
			// 2. Load all of the data
			$pm = new PersistenceApollo();
			$has = $pm->loadDataFromStore();
			
			// 3. Add new album
			$album = new Album($name);
			$has->addAlbum($album);
			
		}
	}
}