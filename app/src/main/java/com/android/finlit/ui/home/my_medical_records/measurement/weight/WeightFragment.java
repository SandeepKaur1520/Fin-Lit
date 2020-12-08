package com.android.finlit.ui.home.my_medical_records.measurement.weight;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.finlit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeightFragment extends Fragment {

AutoCompleteTextView actv_weight_units;

    private static final String TAG = "WeightFragment";

    TextView tv_date, tv_time;
    Calendar currentCalender,selectedCalendar;
    SimpleDateFormat sdfDate,sdfTime;
    public WeightFragment() {
        // Required empty public constructor
    }


    public static WeightFragment newInstance(String param1, String param2) {
        WeightFragment fragment = new WeightFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_weight, container, false);

        actv_weight_units = root.findViewById(R.id.actv_weight_units);

        String[] units  = new String[] {"Kg","lbs"};

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, units);

        actv_weight_units.setAdapter(unitsAdapter);

        tv_date = root.findViewById(R.id.tv_date);
        tv_time = root.findViewById(R.id.tv_time);

        selectedCalendar = Calendar.getInstance();
        currentCalender = selectedCalendar;

        sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        sdfTime =new SimpleDateFormat("hh:mm a");


        tv_date();
        tv_time();

        return root;
    }

    private void tv_time() {

        tv_time.setText(sdfTime.format(currentCalender.getTime()));
        final TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                selectedCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                selectedCalendar.set(Calendar.MINUTE,minute);
                selectedCalendar.set(Calendar.SECOND,00);
                tv_time.setText(sdfTime.format(selectedCalendar.getTime()));


                Log.d(TAG, "onTimeSet: "+selectedCalendar.getTime());


            }
        },currentCalender.get(Calendar.HOUR_OF_DAY),currentCalender.get(Calendar.MINUTE),false);

        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

    }

    private void tv_date() {
        tv_date.setText(sdfDate.format(currentCalender.getTime()));

        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                selectedCalendar.set(year,month,dayOfMonth);

                tv_date.setText(sdfDate.format(selectedCalendar.getTime()));
                Log.d(TAG, "onDateSet: "+selectedCalendar.getTime());
            }
        },currentCalender.get(Calendar.YEAR),currentCalender.get(Calendar.MONTH),currentCalender.get(Calendar.DAY_OF_MONTH));

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }
}