package com.android.finlit.ui.home.my_medical_records.measurement.blood_pressure;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.android.finlit.R;


public class BloodPressureFragment extends Fragment {

    AutoCompleteTextView actv_lower_bound_units,actv_upper_bound_units;



    public BloodPressureFragment() {
        // Required empty public constructor
    }

    public static BloodPressureFragment newInstance(String param1, String param2) {
        BloodPressureFragment fragment = new BloodPressureFragment();
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
        View root =  inflater.inflate(R.layout.fragment_blood_pressure, container, false);

        actv_lower_bound_units = root.findViewById(R.id.actv_lower_bound_units);
        actv_upper_bound_units = root.findViewById(R.id.actv_upper_bound_units);


        String[] units  = new String[] {"mmHg", "bar", "Pa", "atm" ,"Torr","lbf/in\u00B2"};

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, units);

        actv_lower_bound_units.setAdapter(unitsAdapter);
        actv_upper_bound_units.setAdapter(unitsAdapter);

        return root;
    }
}