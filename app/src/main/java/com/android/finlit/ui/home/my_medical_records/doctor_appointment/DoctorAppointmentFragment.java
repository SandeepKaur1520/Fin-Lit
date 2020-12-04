package com.android.finlit.ui.home.my_medical_records.doctor_appointment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.android.finlit.R;

public class DoctorAppointmentFragment extends Fragment {
    AutoCompleteTextView actv_appointment_type,actv_appointment_state;

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
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_doctor_appointment, container, false);
        actv_appointment_type = root.findViewById(R.id.actv_appointment_type);
        actv_appointment_state = root.findViewById(R.id.actv_appointment_state);

        String[] appointmentType  = new String[] {"Day Surgery", "Emergency", "Inpatient", "Outpatient" ,"Recurring"};
        String[] appointmentState  = new String[] {"Scheduled", "To Be scheduled", "Completed", "Cancelled" ,"Missed"};

        ArrayAdapter<String> appointmentTypeAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, appointmentType);
        ArrayAdapter<String> appointmentStateAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, appointmentState);

        actv_appointment_type.setAdapter(appointmentTypeAdapter);
        actv_appointment_state.setAdapter(appointmentStateAdapter);


        return root;
    }
}