<?php
require_once'Controller/controller.php';

session_start();

$target_dir = "ApolloWeb/uploads/";
$target_file = $target_dir . basename($file_name);
$audioFileType = pathinfo($target_file, PATHINFO_EXTENSION);
if(isset($_FILES['audio']))
{
	$errors= array();
	$file_name = $_FILES['audio']['name'];
	$file_size =$_FILES['audio']['size'];
	$file_tmp =$_FILES['audio']['tmp_name'];
	$file_type=$_FILES['audio']['type'];
	$file_ext=strtolower(end(explode('.',$_FILES['audio']['name'])));

	$expensions= array("wav","mp3","mp4","m4a","aiff","aac","m4p","wma");

	if(in_array($file_ext,$expensions)=== false)
	{
		$errors[]="Extension not allowed. Please choose an appropriate audio file.";
	}

	if($file_size > 128000001)
	{
		$errors[]='Audio file too large. Must be less than 128 MB.';
	}
	
	if(file_exists($target_file))
	{
		$errors[]='Audio file was already uploaded.';
	}

	if(empty($errors)==true)
	{
		move_uploaded_file($file_name, $target_file);
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
		echo "File uploaded";
	}
	else
	{
		print_r($errors);
	}
}
?>
