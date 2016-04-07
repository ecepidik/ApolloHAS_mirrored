package ca.mcgill.ecse321.apollohas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.persistence.*;

public class DisplaySongs extends AppCompatActivity {
    private HashMap<Integer, Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_songs);
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

        private void loadSongs() {
            HAS hs = HAS.getInstance();
            TextView tvSongs = (TextView) findViewById(R.id.songs_list);
            tvSongs.setText("");

            this.songs = new HashMap<Integer, Song>();
            int i = 0;

            for (Iterator <Song> songs = hs.getSongs().iterator(); songs.hasNext(); i++) {
                Song song = songs.next();
                tvSongs.setText(song.getName());
            }
        }

}
