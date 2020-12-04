package com.android.finlit.ui.home.my_medical_records.measurement.sugar_level;

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
 * Use the {@link SugarLevelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SugarLevelFragment extends Fragment {

AutoCompleteTextView actv_sugar_level_units;

    public SugarLevelFragment() {
        // Required empty public constructor
    }

    public static SugarLevelFragment newInstance(String param1, String param2) {
        SugarLevelFragment fragment = new SugarLevelFragment();
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
        View root = inflater.inflate(R.layout.fragment_sugar_level, container, false);

        actv_sugar_level_units = root.findViewById(R.id.actv_sugar_level_units);

        String[] units  = new String[] {"mmol/l","mg/dl"};

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, units);

        actv_sugar_level_units.setAdapter(unitsAdapter);

        return root;

    }
}