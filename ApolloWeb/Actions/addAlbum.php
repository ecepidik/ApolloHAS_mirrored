<?php
require_once'Controller/controller.php';

session_start();

$c =  new controller();
try
{
	$c->createAlbum($_POST['album_name'], $_POST['album_date'], $_POST['album_artist']);
	$_SESSION["errorAlbumName"] = "";
	$_SESSION["errorAlbumDate"] = "";
	$_SESSION["errorAlbumArtist"] = "";
}
catch (Exception $e)
{
	//**GOING TO HAVE TO COME BACK HERE**
	$_SESSION["errorAlbumName"] = $e->getMessage();
}
?>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="refresh" content="0; url=/EventRegistration/" />
	</head>
</html>