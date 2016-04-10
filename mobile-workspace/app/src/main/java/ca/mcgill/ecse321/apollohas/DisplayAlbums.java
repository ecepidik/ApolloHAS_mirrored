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
import java.util.Iterator;

import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;

public class DisplayAlbums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_albums);

        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        HAS hs = HAS.getInstance();

        ArrayList<String> albumNames = new ArrayList<>();
        int i = 0;
        for (Iterator<Album> albums = hs.getAlbums().iterator(); albums.hasNext(); i++) {
            Album album = albums.next();
            albumNames.add(album.getName());
        }

        ArrayAdapter<String> albumAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,albumNames);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(albumAdapter);
    }

    public void goCreateAlbumPage(View v) {
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), CreateAlbum.class));
    }
}
