package ca.mcgill.ecse321.apollohas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerAddsAssociations;
import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;

public class AddMusicToRoom extends AppCompatActivity {
    private HashMap<Integer, Album> albums;
    private HashMap<Integer, Playlist> playlists;
    private HashMap<Integer, Song> songs;
    private HashMap<Integer, Room> rooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music_to_room);
        loadAlbums();
        loadPlaylists();
        loadSongs();
        loadRooms();
    }

    private void loadAlbums() {
        //Initialize the data in the participant spinner
        HAS hs = HAS.getInstance();
        Spinner spinnerAlbums = (Spinner) findViewById(R.id.album_spinner);
        ArrayAdapter<CharSequence> albumAdapter = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        albumAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.albums = new HashMap<Integer, Album>();
        int i = 0;

        for (Iterator<Album> albums = hs.getAlbums().iterator(); albums.hasNext(); i++) {
            Album album = albums.next();
            albumAdapter.add(album.getName());
            this.albums.put(i, album);
        }
        spinnerAlbums.setAdapter(albumAdapter);
    }

    private void loadSongs() {
        //Initialize the data in the participant spinner
        HAS hs = HAS.getInstance();
        Spinner spinnerSongs = (Spinner) findViewById(R.id.song_spinner);
        ArrayAdapter<CharSequence> songAdapter = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        songAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.songs = new HashMap<Integer, Song>();
        int i = 0;

        for (Iterator<Song> songs = hs.getSongs().iterator(); songs.hasNext(); i++) {
            Song song = songs.next();
            songAdapter.add(song.getName());
            this.songs.put(i, song);
        }
        spinnerSongs.setAdapter(songAdapter);
    }

    private void loadPlaylists() {
        //Initialize the data in the participant spinner
        HAS hs = HAS.getInstance();
        Spinner spinnerPlaylists = (Spinner) findViewById(R.id.playlist_spinner);
        ArrayAdapter<CharSequence> playlistAdapter = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        playlistAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.playlists = new HashMap<Integer, Playlist>();
        int i = 0;

        for (Iterator<Playlist> playlists = hs.getPlaylists().iterator(); playlists.hasNext(); i++) {
            Playlist playlist = playlists.next();
            playlistAdapter.add(playlist.getName());
            this.playlists.put(i, playlist);
        }
        spinnerPlaylists.setAdapter(playlistAdapter);
    }
    private void loadRooms() {
        //Initialize the data in the participant spinner
        HAS hs = HAS.getInstance();
        Spinner spinnerRooms = (Spinner) findViewById(R.id.room_spinner);
        ArrayAdapter<CharSequence> roomAdapter = new
                ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
        roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.rooms = new HashMap<Integer, Room>();
        int i = 0;

        for (Iterator<Room> rooms = hs.getRooms().iterator(); rooms.hasNext(); i++) {
            Room room = rooms.next();
            roomAdapter.add(room.getName());
            this.rooms.put(i, room);
        }
        spinnerRooms.setAdapter(roomAdapter);
    }

    public void connectSongToRoom(View v) throws InvalidInputException {
        Spinner sSong = (Spinner) findViewById(R.id.song_spinner);
        Song assignSong = songs.get(sSong.getSelectedItemPosition());

        Spinner sRoom = (Spinner) findViewById(R.id.room_spinner);
        Room assignRoom = rooms.get(sRoom.getSelectedItemPosition());

        PersistenceHAS.loadApolloHASModel();
        final HAS hs = HAS.getInstance();
        controllerAddsAssociations caa = new controllerAddsAssociations();

        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");
        try {
            caa.connectSongToRoom(assignRoom, assignSong);
        }catch (InvalidInputException e){
            errorMessage.setText(e.getMessage());
        }
    }

    public void connectPlaylistToRoom(View v) throws InvalidInputException {
        Spinner sPlaylist = (Spinner) findViewById(R.id.playlist_spinner);
        Playlist assignPlaylist = playlists.get(sPlaylist.getSelectedItemPosition());

        Spinner sRoom = (Spinner) findViewById(R.id.room_spinner);
        Room assignRoom = rooms.get(sRoom.getSelectedItemPosition());

        PersistenceHAS.loadApolloHASModel();
        final HAS hs = HAS.getInstance();
        controllerAddsAssociations caa = new controllerAddsAssociations();

        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");
        try {
            caa.connectPlaylistToRoom(assignRoom, assignPlaylist);
        }catch (InvalidInputException e){
            errorMessage.setText(e.getMessage());
        }
    }

    public void connectAlbumToRoom(View v) throws InvalidInputException {
        Spinner sAlbum = (Spinner) findViewById(R.id.album_spinner);
        Album assignAlbum = albums.get(sAlbum.getSelectedItemPosition());

        Spinner sRoom = (Spinner) findViewById(R.id.room_spinner);
        Room assignRoom = rooms.get(sRoom.getSelectedItemPosition());

        PersistenceHAS.loadApolloHASModel();
        final HAS hs = HAS.getInstance();
        controllerAddsAssociations caa = new controllerAddsAssociations();

        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");
        try {
            caa.connectAlbumToRoom(assignRoom, assignAlbum);
        }catch (InvalidInputException e){
            errorMessage.setText(e.getMessage());
        }
    }

}
