package com.android.finlit.ui.home.my_medical_records;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.finlit.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddEventFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEventFragment extends Fragment {
    static String TAG = "AddEventFragment";
    Button btn_disease, btn_doctor_appointment, btn_laboratory_test, btn_medication, btn_measurement;


    public AddEventFragment() {

    }


    public static AddEventFragment newInstance(String param1, String param2) {
        AddEventFragment fragment = new AddEventFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_add_event, container, false);


        btn_disease = root.findViewById(R.id.btn_disease);
        btn_doctor_appointment = root.findViewById(R.id.btn_doctor_appointment);
        btn_measurement = root.findViewById(R.id.btn_measurement);
        btn_laboratory_test = root.findViewById(R.id.btn_lab_test);
        btn_medication = root.findViewById(R.id.btn_medication);


        btn_disease();
        btn_doctor_appointment();
        btn_medication();
        btn_measurement();
        btn_laboratory_test();

        return root;
    }

    private void btn_medication() {
        btn_medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_add_event_to_navigation_medication);
            }
        });
    }

    private void btn_measurement() {
        btn_measurement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_add_event_to_navigation_measurement);
            }
        });
    }

    private void btn_laboratory_test() {
        btn_laboratory_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_add_event_to_navigation_laboratory_test);
            }
        });
    }

    private void btn_doctor_appointment() {
        btn_doctor_appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_add_event_to_navigation_doctor_appointment);
            }
        });
    }

    private void btn_disease() {
        btn_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_add_event_to_navigation_disease);
            }
        });
    }


}