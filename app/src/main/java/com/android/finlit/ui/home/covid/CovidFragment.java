package com.android.finlit.ui.home.covid;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.finlit.R;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CovidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CovidFragment extends Fragment {

    private static final String TAG = "CovidFragment";
    TextView tv_total_deaths,tv_total_recovered,tv_total_confirmed;


    public CovidFragment() {
        // Required empty public constructor
    }

    public static CovidFragment newInstance(String param1, String param2) {
        CovidFragment fragment = new CovidFragment();
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
        View root = inflater.inflate(R.layout.fragment_covid, container, false);

        tv_total_confirmed = root.findViewById(R.id.tv_total_confirmed);
        tv_total_deaths = root.findViewById(R.id.tv_total_deaths);
        tv_total_recovered = root.findViewById(R.id.tv_total_recovered);

        String url = getActivity().getString(R.string.COVID_API_BASE_URL);

        AndroidNetworking.get(url).build().getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    Log.d(TAG, "onResponse: "+response);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                        tv_total_confirmed.setText(NumberFormat.getIntegerInstance().format(response.getJSONObject("confirmed").getInt("value")));

                        tv_total_deaths.setText(NumberFormat.getIntegerInstance().format(response.getJSONObject("deaths").getInt("value")));
                        tv_total_recovered.setText(NumberFormat.getIntegerInstance().format(response.getJSONObject("recovered").getInt("value")));
                    }else{
                        tv_total_confirmed.setText(response.getJSONObject("confirmed").getString("value"));
                        tv_total_deaths.setText(response.getJSONObject("deaths").getString("value"));
                        tv_total_recovered.setText(response.getJSONObject("recovered").getString("value"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });


        return root;
    }
}