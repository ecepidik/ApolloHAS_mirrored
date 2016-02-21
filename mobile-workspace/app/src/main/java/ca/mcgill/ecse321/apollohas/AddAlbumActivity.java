package ca.mcgill.ecse321.apollohas;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.sql.Date;
import java.util.HashMap;

import ca.mcgill.ecse321.ApolloHAS.model.Album;
import ca.mcgill.ecse321.ApolloHAS.model.Song;
import ca.mcgill.ecse321.ApolloHAS.model.Artist;
import ca.mcgill.ecse321.ApolloHAS.model.HAS;

public class AddAlbumActivity extends AppCompatActivity {

    private HashMap<Integer, Album> album;
    private HashMap<Integer, Song> song;
    private HashMap<Integer, Artist> artist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_album);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void createAlbum(View v) {
        TextView tvAlbumName = (TextView) findViewById(R.id.album_name);
        TextView tvArtistName = (TextView) findViewById(R.id.artist_name);
        TextView tvReleaseDate = (TextView) findViewById(R.id.release_date);


        Date eventDate = unbundleDateBundle(getDateFromLabel(tvReleaseDate.getText()));

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
