package ca.mcgill.ecse321.apollohas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import ca.mcgill.ecse321.HASDesktop.controller.InvalidInputException;
import ca.mcgill.ecse321.HASDesktop.controller.controllerAddsAssociations;
import ca.mcgill.ecse321.HASDesktop.controller.controllerCreateObjects;
import ca.mcgill.ecse321.HASDesktop.model.Album;
import ca.mcgill.ecse321.HASDesktop.model.Genre;
import ca.mcgill.ecse321.HASDesktop.model.HAS;
import ca.mcgill.ecse321.HASDesktop.persistence.PersistenceHAS;

public class CreateRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

    }

    public void createRoom(View v) {
        TextView errorMessage = (TextView) findViewById(R.id.error);
        errorMessage.setText("");

        PersistenceHAS.loadApolloHASModel();

        final HAS hs = HAS.getInstance();
        controllerCreateObjects cco = new controllerCreateObjects();

        TextView tvRoomName = (TextView) findViewById(R.id.song_name);
        String RoomName = tvRoomName.getText().toString();

        SeekBar sbVolume = (SeekBar) findViewById(R.id.volume);
        int volume = 50;
        try {
            volume = sbVolume.getProgress();
        } catch (NumberFormatException e) {
            errorMessage.setText(e.getMessage());
        }

        Switch sMuted = (Switch) findViewById(R.id.muteVolume);
        boolean muted = sMuted.isChecked();

        try {
            cco.createRoom(RoomName, volume, muted);

        } catch (InvalidInputException e) {
            errorMessage.setText(e.getMessage());
        }
        tvRoomName.setText("");
    }
    public void goMainActivityPage(View v) {
        Button button =(Button) v;
        startActivity(new Intent(getApplicationContext(), MainActivity.class ));
    }

}
