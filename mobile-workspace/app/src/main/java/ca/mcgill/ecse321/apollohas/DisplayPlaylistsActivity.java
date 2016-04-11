package ca.mcgill.ecse321.apollohas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.persistence.*;

public class DisplayPlaylistsActivity extends AppCompatActivity {
    private HashMap<Integer, Playlist> playlists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_playlists);

        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        HAS hs = HAS.getInstance();

        ArrayList<String> playlistNames = new ArrayList<String>();

        int i=0;
        for (Iterator<Playlist> playlists =hs.getPlaylists().iterator(); playlists.hasNext(); i++) {
            Playlist playlist = playlists.next();
            playlistNames.add(playlist.getName());
        }

        ArrayAdapter<String> playlistAdapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, playlistNames);

        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(playlistAdapter);
    }

    public void goCreatePlaylistPage(View v) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), CreatePlaylistActivity.class));
    }

}
