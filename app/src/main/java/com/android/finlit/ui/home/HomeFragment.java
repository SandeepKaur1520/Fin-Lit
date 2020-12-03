package com.android.finlit.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.finlit.R;

public class HomeFragment extends Fragment {
    NavController navController;

    ImageButton ib_medical_emergency, ib_symptom_diaganosis, ib_my_medical_records, ib_find_a_doctor, ib_covid_19;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ib_medical_emergency = root.findViewById(R.id.ib_medical_emergency);
        ib_symptom_diaganosis = root.findViewById(R.id.ib_symptom_diaganosis);
        ib_my_medical_records = root.findViewById(R.id.ib_my_medical_records);
        ib_find_a_doctor = root.findViewById(R.id.ib_find_a_doctor);
        ib_covid_19 = root.findViewById(R.id.ib_covid_19);

        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        ib_medical_emergency();
        ib_symptom_diaganosis();
        ib_my_medical_records();
        ib_find_a_doctor();
        ib_covid_19();


        return root;
    }

    private void ib_covid_19() {
        ib_covid_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                navController.navigate(R.id.action_navigation_home_to_navigation_covid);

                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_navigation_covid);
            }
        });
    }

    private void ib_find_a_doctor() {
        ib_find_a_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_navigation_home_to_navigation_find_doctor);
            }
        });
    }

    private void ib_my_medical_records() {
        ib_my_medical_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_navigation_home_to_navigation_my_medical_records);
            }
        });
    }

    private void ib_symptom_diaganosis() {
        ib_symptom_diaganosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_navigation_home_to_navigation_symptom_diagonosis);
            }
        });
    }

    private void ib_medical_emergency() {
        ib_medical_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_navigation_home_to_navigation_medical_emergency);
            }
        });
    }


}