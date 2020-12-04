package com.android.finlit.ui.home.my_medical_records.measurement.weight;

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
 * Use the {@link WeightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeightFragment extends Fragment {

AutoCompleteTextView actv_weight_units;
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


        return root;
    }
}