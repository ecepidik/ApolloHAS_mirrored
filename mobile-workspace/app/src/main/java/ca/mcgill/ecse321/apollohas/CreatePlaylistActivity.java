package ca.mcgill.ecse321.apollohas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;

public class CreatePlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_playlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void createPlaylist(View v) {
        PersistenceHAS phas = new PersistenceHAS();
        phas.loadApolloHASModel();
        final HAS hs = HAS.getInstance();

//        TextView errorMessage = (TextView) findViewById(R.id.error);
//        errorMessage.setText("");

        controllerCreateObjects cco = new controllerCreateObjects();

        TextView tvPlaylistName = (TextView) findViewById(R.id.editText);
        String playlistName = tvPlaylistName.getText().toString();

        try {
            cco.createPlaylist(playlistName);
        } catch (InvalidInputException e) {
//            errorMessage.setText(e.getMessage());
        }

        tvPlaylistName.setText("");
    }

}
