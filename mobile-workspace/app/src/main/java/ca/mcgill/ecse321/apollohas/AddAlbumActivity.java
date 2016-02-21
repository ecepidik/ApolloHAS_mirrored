package ca.mcgill.ecse321.apollohas;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Song;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;
import ca.mcgill.ecse321.ApolloHAS.controller.*;

public class AddAlbumActivity extends AppCompatActivity {

    private ArrayList<Album> albums;
    private HashMap<Integer, Song> songs;
    private HashMap<Integer, Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);
    }

//    private void refreshData() {
//        //Initialize the data in the participant spinner
//        HAS has = HAS.getInstance();
//        Spinner spinnerAlbum = (Spinner) findViewById(R.id.albumspinner);
//        ArrayAdapter<CharSequence> albumAdapter = new
//                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
//        albumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        this.albums = new HashMap<Integer, Album>();
//
//        int i = 0;
//
//        for (Iterator<Album> albums = has.getAlbum().iterator(); albums.hasNext(); i++) {
//            Album album = albums.next();
//            albumAdapter.add(album.getName());
//            this.albums.put(i, album);
//            //this.participants.put(p.getName(), p);
//        }
//        spinnerAlbum.setAdapter(albumAdapter);
//    }


    public void addAlbum(View v) {
        TextView tvAlbumName = (TextView) findViewById(R.id.album_name);
        String albumName = tvAlbumName.getText().toString();
        TextView tvArtistName = (TextView) findViewById(R.id.artist_name);

        TextView tvSongNum = (TextView) findViewById(R.id.number_songs);

        TextView tvReleaseDate = (TextView) findViewById(R.id.release_date);
        Date releaseDate = unbundleDateBundle(getDateFromLabel(tvReleaseDate.getText()));

        ApolloHASAlbumController newAlbum = new ApolloHASAlbumController(albumName,tvReleaseDate.toString(), tvArtistName.toString(),tvSongNum.toString());

        //albums.add(newAlbum);

    }

    public void addSong2Album(View v) {

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
