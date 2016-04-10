package ca.mcgill.ecse321.apollohas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import ca.mcgill.ecse321.HASDesktop.persistence.*;
import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.controller.*;

public class CreateSong extends AppCompatActivity {

    private HashMap<Integer, Album> albums;
    private HashMap<Integer, Artist> artists;
    private HashMap<Integer, Song> songs;
    private ArrayList<Song> albumSongs;
//    private Artist artist;
//    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_create_song);
//        Artist artist = (Artist)getIntent().getSerializableExtra(CreateAlbum.SER_KEY);
//        Album album = (Album)getIntent().getSerializableExtra(CreateAlbum.SER_KEY);
//        this.artist = artist;
//        this.album = album;
        loadAlbums();
    }

//    private void refreshData() {
//        HAS manager = HAS.getInstance();
//
//        ApolloHASAlbumController ac = new ApolloHASAlbumController();
//
//        this.songs = new HashMap<Integer, Song>();
//        int i = 0;
//        for (Iterator<Song> songs = manager.getSong().iterator(); songs.hasNext(); i++) {
//            Song song = songs.next();
//            this.songs.put(i, song);
//            ac.addSongToAlbum(song, this.album);
//
//        }
//    }

    private void loadAlbums() {
        //Initialize the data in the participant spinner
        HAS hs = HAS.getInstance();
        Spinner spinnerAlbums = (Spinner) findViewById(R.id.albumspinner);
        ArrayAdapter<CharSequence> albumAdapter = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        albumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.albums = new HashMap<Integer, Album>();
        int i = 0;

        for (Iterator<Album> albums = hs.getAlbums().iterator(); albums.hasNext(); i++) {
            Album album = albums.next();
            albumAdapter.add(album.getName());
            this.albums.put(i, album);
        }
        spinnerAlbums.setAdapter(albumAdapter);
    }

//    private void loadArtists() {
//        //Initialize the data in the participant spinner
//        HAS hs = HAS.getInstance();
//        Spinner spinnerArtists = (Spinner) findViewById(R.id.artistspinner);
//        ArrayAdapter<CharSequence> artistAdapter = new
//                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
//        artistAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        this.artists = new HashMap<Integer, Artist>();
//        int i = 0;
//
//        for (Iterator<Artist> artists = hs.getArtists().iterator(); artists.hasNext(); i++) {
//            Artist artist = artists.next();
//            artistAdapter.add(artist.getName());
//            this.artists.put(i, artist);
//        }
//        spinnerArtists.setAdapter(artistAdapter);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createSong(View v) {
        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");

        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();

        final HAS hs = HAS.getInstance();
        controllerCreateObjects cco = new controllerCreateObjects();

        TextView tvSongName = (TextView) findViewById(R.id.song_name);
        String songName = tvSongName.getText().toString();

        TextView tvDuration = (TextView) findViewById(R.id.duration);
        int duration = 0;
        try {
            duration = Integer.parseInt(tvDuration.getText().toString());

        } catch (NumberFormatException e)  {
            errorMessage.setText(e.getMessage());
        }


        TextView tvGenre = (TextView) findViewById(R.id.genre);
        Genre genre = new Genre(tvGenre.getText().toString());
        List<Genre> genres = hs.getGenres();

        if(genres.contains(genre) == false) {
            try {
                cco.createGenre(tvGenre.getText().toString());
            } catch (InvalidInputException e) {
                errorMessage.setText(e.getMessage());
           }
        }

        TextView tvTrackNumber = (TextView) findViewById(R.id.track_number);
        int trackNumber = 0;
        try {
            trackNumber = Integer.parseInt(tvTrackNumber.getText().toString());

        } catch (NumberFormatException e)  {
            errorMessage.setText(e.getMessage());
        }

        Spinner sAlbum = (Spinner) findViewById(R.id.albumspinner);
        Album assignAlbum = albums.get(sAlbum.getSelectedItemPosition());

       try {
           cco.createSong(songName, duration, trackNumber, genre);
           controllerAddsAssociations caa = new controllerAddsAssociations();
           caa.addSongToAlbum(assignAlbum, cco.getSong());

        } catch (InvalidInputException e) {
            errorMessage.setText(e.getMessage());
        }
        tvTrackNumber.setText("");
        tvDuration.setText("");
        tvGenre.setText("");
        tvSongName.setText("");
    }
}
