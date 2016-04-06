package ca.mcgill.ecse321.apollohas;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.controller.*;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;

public class AddAlbumActivity extends AppCompatActivity {

    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser";

    private HashMap<Integer, Album> albums;
    private HashMap<String, Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);

    }


    private void refreshData() {
        HAS manager = HAS.getInstance();
        Spinner spinnerAlbum = (Spinner) findViewById(R.id.albumspinner);
        ArrayAdapter<CharSequence> albumAdapter = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        albumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.albums = new HashMap<Integer, Album>();
        int i = 0;
        for (Iterator<Album> albums = manager.getAlbum().iterator(); albums.hasNext(); i++) {
            Album album = albums.next();
            albumAdapter.add(album.getName());
            this.albums.put(i, album);
        }
        spinnerAlbum.setAdapter(albumAdapter);

        this.artists = new HashMap<String, Artist>();
        int k = 0;
        for (Iterator<Artist> artists = manager.getArtist().iterator(); artists.hasNext(); i++) {
            Artist artist = artists.next();
//            artistAdapter.add(artist.getName());
            this.artists.put(k, artist);
        }
        //spinnerAlbum.setAdapter(albumAdapter);
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

    public void addAlbum(View v) {

        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        final HAS hs = HAS.getInstance();
        String[] albumNames = new String[hs.getAlbums().size()];

        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");

        controllerCreateObjects cco = new controllerCreateObjects();

        TextView tvAlbumName = (TextView) findViewById(R.id.album_name);
        String albumName = tvAlbumName.getText().toString();

        //creates an artist while creating an album
        TextView tvArtistName = (TextView) findViewById(R.id.artist_name);
        String artistName = tvArtistName.toString();
        Artist artist = null;
        if(artists.containsKey(artistName) == false) {
            try {
                cco.createArtist(artistName);
            } catch (InvalidInputException e) {
                errorMessage.setText(e.getMessage());
            }
        }
        artist = artists.get(artistName);

        TextView tvReleaseDate = (TextView) findViewById(R.id.release_date);
        Date releaseDate = unbundleDateBundle(getDateFromLabel(tvReleaseDate.getText()));

        TextView tvNumSongs = (TextView) findViewById(R.id.num_songs);
        String num_songs = tvNumSongs.toString();

        try {
            cco.createAlbum(albumName, artist, releaseDate, num_songs);
            Album album = cco.getAlbum();
            goAddSongToAlbumPage(v, album);
        } catch (InvalidInputException e) {
            errorMessage.setText(e.getMessage());
        }
        refreshData();
    }

    public void goAddSongToAlbumPage(View v, Album album) {
        Intent intent = new Intent(getApplicationContext(), AddSongToAlbum.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("album",  (Serializable) album);
        intent.putExtras(mBundle);
        startActivity(intent);
    }

    public void showDatePickerDialog(View v) {
        TextView tf = (TextView) v;
        Bundle args = getDateFromLabel(tf.getText());
        args.putInt("id", v.getId());

        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private Bundle getDateFromLabel(CharSequence text) {
        Bundle rtn = new Bundle();
        String comps[] = text.toString().split("-");
        int day = 1;
        int month = 1;
        int year = 1;
        if (comps.length == 3) {
            day = Integer.parseInt(comps[0]);
            month = Integer.parseInt(comps[1]);
            year = Integer.parseInt(comps[2]);
        }
        rtn.putInt("day", day);
        rtn.putInt("month", month - 1);
        rtn.putInt("year", year);
        return rtn;
    }

    public void setDate(int id, int d, int m, int y) {
        TextView tv = (TextView) findViewById(id);
        tv.setText(String.format("%02d-%02d-%04d", d, m + 1, y));
    }

    public Date unbundleDateBundle (Bundle inputDate){
        int unbundleDay = inputDate.getInt("day");
        int unbundleMonth = inputDate.getInt("month");
        int unbundleYear = inputDate.getInt("year");

        Date date = new Date(unbundleDay,unbundleMonth,unbundleYear);
        return date;
    }
}
