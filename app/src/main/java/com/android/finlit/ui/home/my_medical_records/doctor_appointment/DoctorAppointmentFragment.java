package com.android.finlit.ui.home.my_medical_records.doctor_appointment;

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

public class DoctorAppointmentFragment extends Fragment {

    private static final String TAG = "DoctorAppointmentFragment";
    AutoCompleteTextView actv_appointment_type, actv_appointment_state;

    TextView tv_date_doctor_appointment_fragment, tv_time_doctor_appointment_fragment;

    Calendar currentCalender,selectedCalendar;
    SimpleDateFormat sdfDate,sdfTime;

    public DoctorAppointmentFragment() {
        // Required empty public constructor
    }

    public static DoctorAppointmentFragment newInstance(String param1, String param2) {
        DoctorAppointmentFragment fragment = new DoctorAppointmentFragment();
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

        View root = inflater.inflate(R.layout.fragment_doctor_appointment, container, false);

        actv_appointment_type = root.findViewById(R.id.actv_appointment_type);
        actv_appointment_state = root.findViewById(R.id.actv_appointment_state);

        initializeAutoCompleteTextViews();

        tv_date_doctor_appointment_fragment = root.findViewById(R.id.tv_date_doctor_appointment_fragment);
        tv_time_doctor_appointment_fragment = root.findViewById(R.id.tv_time_doctor_appointment_fragment);


        selectedCalendar = Calendar.getInstance();
        currentCalender = selectedCalendar;

        sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        sdfTime =new SimpleDateFormat("hh:mm a");



        tv_date_doctor_appointment_fragment();
        tv_time_doctor_appointment_fragment();



        return root;
    }

    private void tv_date_doctor_appointment_fragment() {

        tv_date_doctor_appointment_fragment.setText(sdfDate.format(currentCalender.getTime()));

        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                selectedCalendar.set(year,month,dayOfMonth);

                tv_date_doctor_appointment_fragment.setText(sdfDate.format(selectedCalendar.getTime()));
                Log.d(TAG, "onDateSet: "+selectedCalendar.getTime());
            }
        },currentCalender.get(Calendar.YEAR),currentCalender.get(Calendar.MONTH),currentCalender.get(Calendar.DAY_OF_MONTH));

        tv_date_doctor_appointment_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

    }

    private void tv_time_doctor_appointment_fragment() {

        tv_time_doctor_appointment_fragment.setText(sdfTime.format(currentCalender.getTime()));
        final TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                selectedCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                selectedCalendar.set(Calendar.MINUTE,minute);
                selectedCalendar.set(Calendar.SECOND,00);
                tv_time_doctor_appointment_fragment.setText(sdfTime.format(selectedCalendar.getTime()));


                Log.d(TAG, "onTimeSet: "+selectedCalendar.getTime());


            }
        },currentCalender.get(Calendar.HOUR_OF_DAY),currentCalender.get(Calendar.MINUTE),false);

        tv_time_doctor_appointment_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });
    }

    private void initializeAutoCompleteTextViews() {

        String[] appointmentType = new String[]{"Day Surgery", "Emergency", "Inpatient", "Outpatient", "Recurring"};
        String[] appointmentState = new String[]{"Scheduled", "To Be scheduled", "Completed", "Cancelled", "Missed"};

        ArrayAdapter<String> appointmentTypeAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, appointmentType);
        ArrayAdapter<String> appointmentStateAdapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_menu_popup_item, appointmentState);

        actv_appointment_type.setAdapter(appointmentTypeAdapter);
        actv_appointment_state.setAdapter(appointmentStateAdapter);
    }
}