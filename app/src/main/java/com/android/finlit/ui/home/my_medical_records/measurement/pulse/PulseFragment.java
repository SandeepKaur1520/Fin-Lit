package com.android.finlit.ui.home.my_medical_records.measurement.pulse;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.android.finlit.R;
import com.android.finlit.firestore.FirestoreUtils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PulseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PulseFragment extends Fragment {

    AutoCompleteTextView actv_pulse_units;
    private static final String TAG = "PulseFragment";

    TextView tv_date, tv_time;
    Calendar currentCalender,selectedCalendar;
    SimpleDateFormat sdfDate,sdfTime;

    Button btn_save;
    TextInputLayout til_pulse,til_comment,til_units;

    private FirebaseAuth mAuth;


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


        tv_date = root.findViewById(R.id.tv_date);
        tv_time = root.findViewById(R.id.tv_time);


        til_pulse = root.findViewById(R.id.til_pulse);
        til_units = root.findViewById(R.id.til_units);
        til_comment = root.findViewById(R.id.til_comment);

        btn_save = root.findViewById(R.id.btn_save);
        mAuth = FirebaseAuth.getInstance();

        selectedCalendar = Calendar.getInstance();
        currentCalender = selectedCalendar;

        sdfDate = new SimpleDateFormat("dd/MM/yyyy");
        sdfTime =new SimpleDateFormat("hh:mm a");


        tv_date();
        tv_time();

        btn_save();

        return root;

   }

    private void btn_save() {

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pulse  = til_pulse.getEditText().getText().toString();
                String units = actv_pulse_units.getEditableText().toString();
                String  comment = til_comment.getEditText().getText().toString();

                Log.d(TAG, "onClick: "+units);
                Log.d(TAG, "onClick: "+pulse);
                Log.d(TAG, "onClick: "+comment);

                if(validate_data()){
                    Map<String,Object> map_pulse = new HashMap<>();

                    map_pulse.put("pulse",pulse);
                    map_pulse.put("units",units);
                    map_pulse.put("date",selectedCalendar.getTime());
                    map_pulse.put("comment",comment);


                    new FirestoreUtils().uploadUserPulse(mAuth.getCurrentUser(),map_pulse).addOnSuccessListener(new OnSuccessListener() {
                        @Override
                        public void onSuccess(Object o) {
                            Log.d(TAG, "onSuccess: Data Saved ");
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            e.printStackTrace();
                        }
                    });
                }





            }


        });

    }
    private boolean validate_data() {
        boolean validate_status = false;
        til_pulse.setErrorEnabled(false);
        til_units.setErrorEnabled(false);


         if (til_pulse.getEditText().getText().toString().isEmpty()){
             til_pulse.setError("This is mandatory Field");
         }

         if(actv_pulse_units.getEditableText().toString().isEmpty()){
             til_units.setError("Please Select at least one");

         }
         if ( !(til_pulse.getEditText().getText().toString().isEmpty()) && !(actv_pulse_units.getEditableText().toString().isEmpty())){
             validate_status = true;
         }

        return  validate_status;
    }

    private void tv_time() {

        tv_time.setText(sdfTime.format(currentCalender.getTime()));
        final TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                selectedCalendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                selectedCalendar.set(Calendar.MINUTE,minute);
                selectedCalendar.set(Calendar.SECOND,00);
                tv_time.setText(sdfTime.format(selectedCalendar.getTime()));


                Log.d(TAG, "onTimeSet: "+selectedCalendar.getTime());


            }
        },currentCalender.get(Calendar.HOUR_OF_DAY),currentCalender.get(Calendar.MINUTE),false);

        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

    }

    private void tv_date() {
        tv_date.setText(sdfDate.format(currentCalender.getTime()));

        final DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                selectedCalendar.set(year,month,dayOfMonth);

                tv_date.setText(sdfDate.format(selectedCalendar.getTime()));
                Log.d(TAG, "onDateSet: "+selectedCalendar.getTime());
            }
        },currentCalender.get(Calendar.YEAR),currentCalender.get(Calendar.MONTH),currentCalender.get(Calendar.DAY_OF_MONTH));

        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }


}