package com.android.finlit.ui.home.my_medical_records.measurement.pulse;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.android.finlit.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PulseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PulseFragment extends Fragment {

    AutoCompleteTextView actv_pulse_units;

    public PulseFragment() {
        // Required empty public constructor
    }

    public static PulseFragment newInstance(String param1, String param2) {
        PulseFragment fragment = new PulseFragment();
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
        View root = inflater.inflate(R.layout.fragment_pulse, container, false);

        actv_pulse_units = root.findViewById(R.id.actv_pulse_units);
        String[] units  = new String[] {"BPM"};

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, units);

        actv_pulse_units.setAdapter(unitsAdapter);

        return root;


    }
}