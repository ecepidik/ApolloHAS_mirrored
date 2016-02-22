<?php
class TestPersistenceApollo extends PHPUnit_Framework_TestCase {
	protected $pm;
	
	protected function setUp() {
		$this->pm = new PersistenceApollo();
	}
	
	protected function tearDown() {
	}
	
	public function testPersistence () {
		$hs = HAS::getInstance();
		$album = new Album("Crazy in Love", 2014-10-07, "Beyoncé");
		
		$this->pm->writeDataToStore($hs);
		
		$hs->delete();
		
		$this->assertEquals(0, count($hs->numberOfAlbum()));
		
		$hs = $this->pm->loadDataFromStore();
		
		$this->assertEquals(1, count($hs->numberOfAlbum()));
		$aAlbum = $rm->getAlbum_index(0);
		$this->assertEquals(("Crazy in Love"), getAlbum());
	}
}