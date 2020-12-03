package com.android.finlit.ui.home.my_medical_records.measurement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.finlit.R;

public class MeasurementFragment extends Fragment {

    Button btn_blood_pressure,btn_pulse,btn_sugar_level,btn_height,btn_weight;

    public MeasurementFragment() {
        // Required empty public constructor
    }

    public static MeasurementFragment newInstance(String param1, String param2) {
        MeasurementFragment fragment = new MeasurementFragment();
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
        View root =  inflater.inflate(R.layout.fragment_measurement, container, false);

        btn_blood_pressure = root.findViewById(R.id.btn_blood_pressure);
        btn_pulse = root.findViewById(R.id.btn_pulse);
        btn_sugar_level = root.findViewById(R.id.btn_sugar_level);
        btn_height = root.findViewById(R.id.btn_height);
        btn_weight = root.findViewById(R.id.btn_weight);


        btn_blood_pressure();
        btn_pulse();
        btn_sugar_level();
        btn_height();
        btn_weight();



        return root;
    }

    private void btn_weight() {
        btn_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_measurement_to_navigation_weight);
            }
        });

    }


    private void btn_blood_pressure() {
        btn_blood_pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_measurement_to_navigation_blood_pressure);
            }
        });

    }


    private void btn_pulse() {
        btn_pulse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_measurement_to_navigation_pulse);
            }
        });
    }


    private void btn_sugar_level() {
        btn_sugar_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_measurement_to_navigation_sugar_level);
            }
        });
    }


    private void btn_height() {
        btn_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_measurement_to_navigation_height);
            }
        });
    }


}