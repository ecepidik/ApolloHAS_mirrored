package ca.mcgill.ecse321.apollohas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.ApolloHAS.controller.ApolloHASAlbumController;
import ca.mcgill.ecse321.ApolloHAS.controller.InvalidInputException;
import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;
import ca.mcgill.ecse321.ApolloHAS.model.Song;

public class AddSongToAlbum extends AppCompatActivity {

    private HashMap<Integer, Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_song_to_album);
    }

    private void refreshData() {
        HAS manager = HAS.getInstance();

        this.songs = new HashMap<Integer, Song>();
        int i = 0;
        for (Iterator<Song> songs = manager.getSong().iterator(); songs.hasNext(); i++) {
            Song song = songs.next();
            this.songs.put(i, song);
        }
    }

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

    public void addSong(View v) {
        ApolloHASAlbumController hasc = new ApolloHASAlbumController();

        TextView tvSongName = (TextView) findViewById(R.id.song_name);
        String songName = tvSongName.getText().toString();

        TextView tvDuration = (TextView) findViewById(R.id.duration);
        int duration = Integer.parseInt(tvDuration.getText().toString());

        TextView tvGenre = (TextView) findViewById(R.id.genre);
        String genre = tvGenre.getText().toString();

        TextView tvTrackNumber = (TextView) findViewById(R.id.track_number);
        int trackNumber = Integer.parseInt(tvTrackNumber.getText().toString());

        TextView tvSongArtistName = (TextView) findViewById(R.id.song_artist_name);
        String SongArtistName = tvSongArtistName.toString();
        Artist artist = hasc.createArtist(SongArtistName);

        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");
        try {
            hasc.createSong(songName, duration, genre, trackNumber, artist);
        } catch (InvalidInputException e) {
            errorMessage.setText(e.getMessage());
        }
        refreshData();
    }


}
