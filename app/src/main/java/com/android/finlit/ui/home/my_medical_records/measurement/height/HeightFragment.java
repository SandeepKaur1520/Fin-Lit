package com.android.finlit.ui.home.my_medical_records.measurement.height;

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
 * Use the {@link HeightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeightFragment extends Fragment {

AutoCompleteTextView actv_height_units;
    public HeightFragment() {
        // Required empty public constructor
    }

    public static HeightFragment newInstance(String param1, String param2) {
        HeightFragment fragment = new HeightFragment();
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
        View root =  inflater.inflate(R.layout.fragment_height, container, false);

        actv_height_units = root.findViewById(R.id.actv_height_units);
        String[] units  = new String[] {"feet inches", "cm"};

        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<>(getContext(),  R.layout.dropdown_menu_popup_item, units);

        actv_height_units.setAdapter(unitsAdapter);
        return root;

    }
}