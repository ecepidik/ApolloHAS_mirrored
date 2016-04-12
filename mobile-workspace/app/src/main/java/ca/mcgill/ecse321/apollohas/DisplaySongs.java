package ca.mcgill.ecse321.apollohas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.persistence.*;

public class DisplaySongs extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private HashMap<Integer, Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_songs);


        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        HAS hs = HAS.getInstance();

        ArrayList<String> songTitles = new ArrayList<String>();

        int i = 0;
        for(Iterator<Album> albums = hs.getAlbums().iterator(); albums.hasNext(); i++) {
            Album album = albums.next();
            String artistName = album.getArtist().getName();
            int k = 0;
            for (Iterator<Song> songs = album.getSongs().iterator(); songs.hasNext(); k++) {
                Song song = songs.next();
                songTitles.add(song.getName() + " - " + album.getName());

            }
        }


        ArrayAdapter<String> songAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songTitles);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Button button=(Button)findViewById(R.id.play_song);
        button.setVisibility(View.VISIBLE);

    }

    public void goMainActivityPage(View v) {
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
