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
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;


import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.persistence.*;

public class DisplayAlbums extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_albums);

        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        HAS hs = HAS.getInstance();

        expListView = (ExpandableListView) findViewById(R.id.expandableListView);

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        ArrayList<String> albumNames = new ArrayList<>();
        int i = 0;
        for (Iterator<Album> albums = hs.getAlbums().iterator(); albums.hasNext(); i++) {
            Album album = albums.next();
            listDataHeader.add(album.getName()+" - "+ album.getArtist().getName());
            List<String> songNames = new ArrayList<String>();
            int k = 0;
            for (Iterator<Song> songs = album.getSongs().iterator(); songs.hasNext(); k++) {
                Song song = songs.next();
                songNames.add(song.getName());
            }
            listDataChild.put(album.getName()+" - "+ album.getArtist().getName(), songNames);
        }

        listAdapter = new ExpandableListAdapter(this,listDataHeader,listDataChild);
        expListView.setAdapter(listAdapter);

    }

    public void goCreateAlbumPage(View v) {
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), CreateAlbum.class));
    }
    public void goMainActivityPage(View v) {
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class ));
    }
}
