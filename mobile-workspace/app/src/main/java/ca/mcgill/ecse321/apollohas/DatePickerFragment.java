package ca.mcgill.ecse321.apollohas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        // Parse the existing time from the arguments
        Bundle args = getArguments();
        if (args != null) {
            year = args.getInt("year");
            month = args.getInt("month");
            day = args.getInt("day");
        }

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        AddAlbumActivity myActivity = (AddAlbumActivity)getActivity();
        myActivity.setDate(getArguments().getInt("id"), day, month, year);
    }
}
