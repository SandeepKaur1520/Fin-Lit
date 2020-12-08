package com.android.finlit.ui.home.my_medical_records.laboratory_test;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.finlit.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LaboratoryTestFragment extends Fragment {

    private static final String TAG = "LaboratoryTestFragment";
    TextView tv_date_lab_fragment,tv_time_lab_fragment;

    Calendar currentCalender,selectedCalendar;
    SimpleDateFormat sdfDate,sdfTime;

    public LaboratoryTestFragment() {
        // Required empty public constructor
    }

    public static LaboratoryTestFragment newInstance(String param1, String param2) {
        LaboratoryTestFragment fragment = new LaboratoryTestFragment();
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
        View root =  inflater.inflate(R.layout.fragment_laboratory_test, container, false);

        tv_date_lab_fragment = root.findViewById(R.id.tv_date_lab_fragment);
        tv_time_lab_fragment = root.findViewById(R.id.tv_time_lab_fragment);

        selectedCalendar = Calendar.getInstance();
        currentCalender = selectedCalendar;

        sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        sdfTime =new SimpleDateFormat("hh:mm a");

        tv_date_lab_fragment();
        tv_time_lab_fragment();

        return root;
    }

    private void tv_date_lab_fragment() {

        tv_date_lab_fragment.setText(sdfDate.format(currentCalender.getTime()));

        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                selectedCalendar.set(year,month,dayOfMonth);

                tv_date_lab_fragment.setText(sdfDate.format(selectedCalendar.getTime()));
                Log.d(TAG, "onDateSet: "+selectedCalendar.getTime());
            }
        },currentCalender.get(Calendar.YEAR),currentCalender.get(Calendar.MONTH),currentCalender.get(Calendar.DAY_OF_MONTH));

        tv_date_lab_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }

    private void tv_time_lab_fragment() {

        tv_time_lab_fragment.setText(sdfTime.format(currentCalender.getTime()));
        final TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                selectedCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                selectedCalendar.set(Calendar.MINUTE,minute);
                selectedCalendar.set(Calendar.SECOND,00);
                tv_time_lab_fragment.setText(sdfTime.format(selectedCalendar.getTime()));


                Log.d(TAG, "onTimeSet: "+selectedCalendar.getTime());


            }
        },currentCalender.get(Calendar.HOUR_OF_DAY),currentCalender.get(Calendar.MINUTE),false);

        tv_time_lab_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
    }
}