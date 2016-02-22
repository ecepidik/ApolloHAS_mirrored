<?php
require_once __DIR__.'/../Controller/InputValidator.php';
require_once __DIR__.'/../Persistence/PersistenceApollo.php';
require_once __DIR__.'/../Model/Artist.php';
require_once __DIR__.'/../Model/Album.php';
require_once __DIR__.'/../Model/Song.php';
require_once __DIR__.'/../Model/HAS.php';

class TestControllerApollo extends PHPUnit_Framework_TestCase {
	protected $c;
	protected $pm;
	protected $hs;
	
	protected function setUp() {
		$this->c = new controller();
		$this->pm = new PersistenceApollo();
		$this->hm = $this->pm->loadDataFromStore();
		$this->hm->delete();
		$this->pm->writeDataToStore($this->hm);
	}
	
	protected function tearDown() {
	}
	
	public function testCreateAlbum() {
		$this->assertEquals(0,count($hs->numberOfAlbum()));
		
		$name = "Crazy in Love";
		$date = "2014-10-07";
		$artist = "Beyoncé";
		
		try {
			$this->c->createAlbum($name, $date, $artist);
		} catch (Exception $e) {
			$this->fail();
		}
		
		$this->hs = $this->pm->loadDataFromStore();
		$this->assertEquals(1, count($this->hs->numberOfAlbum()));
		$this->assertEquals($name, $this->hs->getAlbum_index(0)->getName());
		$this->assertEquals($date, $this->hs->getAlbum_index(0)->getDate());
		$this->assertEquals($artist, $this->hs->getAlbum_index(0)->getArtist());
	}
	
	public function testCreateAlbumNull() {
		$this->assertEquals(0,count($hs->numberOfAlbum()));
		
		$name = NULL;
		$date = NULL;
		$artist = NULL;
		
		$error = "";
		
		try {
			$this->c->createAlbum($name, $date, $artist);
		} catch (Exception $e) {
			$error = $e.getMessage();
		}
		
		$this->assertEquals("Album name cannot be empty. Album release date must be specified correctly (YYYY-MM-DD). Album artist cannot be empty.", $error);
		
		$this->hs = $this->pm->loadDataFromStore();
		$this->assertEquals(0, count($this->hs->getAlbum()));
	}
	
	public function testCreateAlbumEmpty() {
		$this->assertEquals(0,count($hs->numberOfAlbum()));
		
		$name = "";
		$date = "";
		$artist = "";
		
		$error = "";
		
		try {
			$this->c->createAlbum($name, $date, $artist);
		} catch (Exception $e) {
			$error = $e.getMessage();
		}
		
		$this->assertEquals("Album name cannot be empty. Album release date must be specified correctly (YYYY-MM-DD). Album artist cannot be empty.", $error);
		
		$this->hs = $this->pm->loadDataFromStore();
		$this->assertEquals(0, count($this->hs->getAlbum()));
	}
	
	public function testCreateAlbumSpaces() {
		$this->assertEquals(0,count($hs->numberOfAlbum()));
		
		$name = " ";
		$date = " ";
		$artist = " ";
		
		$error = "";
		
		try {
			$this->c->createAlbum($name, $date, $artist);
		} catch (Exception $e) {
			$error = $e.getMessage();
		}
		
		$this->assertEquals("Album name cannot be empty. Album release date must be specified correctly (YYYY-MM-DD). Album artist cannot be empty.", $error);
		
		$this->hs = $this->pm->loadDataFromStore();
		$this->assertEquals(0, count($this->hs->getAlbum()));
	}
	
}