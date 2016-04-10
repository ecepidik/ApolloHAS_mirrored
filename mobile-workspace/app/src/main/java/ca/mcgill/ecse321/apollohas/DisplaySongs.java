package ca.mcgill.ecse321.apollohas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
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

        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        HAS hs = HAS.getInstance();

        ArrayList<String> songTitles = new ArrayList<String>();

        int i = 0;
        for (Iterator<Song> songs = hs.getSongs().iterator(); songs.hasNext(); i++) {
            Song song = songs.next();
            songTitles.add(song.getName());

        }

        ArrayAdapter<String> songAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songTitles);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(songAdapter);
    }

}
