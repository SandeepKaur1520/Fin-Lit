package com.android.finlit.ui.home.my_medical_records;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.finlit.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyMedicalRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyMedicalRecordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    NavController navController;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyMedicalRecordFragment() {
        // Required empty public constructor
    }

       public static MyMedicalRecordFragment newInstance(String param1, String param2) {
        MyMedicalRecordFragment fragment = new MyMedicalRecordFragment();

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
        final View root =  inflater.inflate(R.layout.fragment_my_medical_record, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        FloatingActionButton floatingActionButton = root.findViewById(R.id.fab_my_medical_records);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_navigation_my_medical_records_to_navigation_add_event);

            }
        });
        return root;
    }
}