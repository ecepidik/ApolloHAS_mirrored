package ca.mcgill.ecse321.apollohas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.model.*;
import ca.mcgill.ecse321.HASDesktop.persistence.*;

public class ViewAndAddSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_add_songs);
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

    //PersistenceHAS.loadApolloHASModel();
    HAS hs = HAS.getInstance();
    String[] albumNames = new String[hs.getAlbums().size()];

}