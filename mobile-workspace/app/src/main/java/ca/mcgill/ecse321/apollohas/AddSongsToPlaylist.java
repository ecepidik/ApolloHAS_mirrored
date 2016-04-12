package ca.mcgill.ecse321.apollohas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerAddsAssociations;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Playlist;
import ca.mcgill.ecse321.HASDesktop.model.Song;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;

public class AddSongsToPlaylist extends AppCompatActivity {
    private HashMap<Integer, Song> songs;
    private HashMap<Integer, Playlist> playlists;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_add_songs_to_playlist);
        loadSongs();
        loadPlaylists();
    }

    private void loadSongs() {
        HAS hs = HAS.getInstance();
        Spinner songSpinner = (Spinner) findViewById(R.id.song_spinner);
        ArrayAdapter<CharSequence> songAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        songAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.songs = new HashMap<Integer, Song>();
        int i = 0;

        for (Iterator<Song> songs = hs.getSongs().iterator(); songs.hasNext(); i++) {
            Song song = songs.next();
            songAdapter.add(song.getName());
            this.songs.put(i, song);
        }
        songSpinner.setAdapter(songAdapter);
    }

    private void loadPlaylists() {
        HAS hs = HAS.getInstance();
        Spinner playlistSpinner = (Spinner) findViewById(R.id.playlist_spinner);
        ArrayAdapter<CharSequence> playlistAdapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        playlistAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.playlists = new HashMap<Integer, Playlist>();
        int i = 0;

        for (Iterator<Playlist> playlists = hs.getPlaylists().iterator(); playlists.hasNext(); i++) {
            Playlist playlist = playlists.next();
            playlistAdapter.add(playlist.getName());
            this.playlists.put(i, playlist);
        }
        playlistSpinner.setAdapter(playlistAdapter);
    }

    public void addSongToPlaylist(View v) {
        PersistenceHAS.loadApolloHASModel();

        final HAS hs = HAS.getInstance();
        controllerCreateObjects cco = new controllerCreateObjects();

        Spinner sSong = (Spinner) findViewById(R.id.song_spinner);
        Song addSong = songs.get(sSong.getSelectedItemPosition());

        Spinner sPlaylist = (Spinner) findViewById(R.id.playlist_spinner);
         Playlist augmentedPlaylist = playlists.get(sPlaylist.getSelectedItemPosition());

        try{
            controllerAddsAssociations caa = new controllerAddsAssociations();
            caa.addSongToPlaylist(augmentedPlaylist, addSong);
        } catch (InvalidInputException e){

        }
    }
}
