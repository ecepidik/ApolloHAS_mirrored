<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF 8">
		<title>APOLLO</title>
		<style>
			.error {color: #FF0000;}
		</style>
	</head>
<body>
<?php 
require_once "Model/Album.php";
require_once "Model/Song.php";
require_once "Model/Artist.php";
require_once 'Model/HAS.php';
require_once 'Persistence/PersistenceApollo.php';

session_start();

//Retrieve data from the model
$pm = new PersistenceApollo();
$has = $pm->loadDataFromStore();

?>    
      <form action="upload.php" method="POST" enctype="multipart/form-data">
         <input type="file" name="music"  id="audio"/>
         <input type="submit" value="Upload Song" name="submit"/>
      </form>
      
   </body>
</html>