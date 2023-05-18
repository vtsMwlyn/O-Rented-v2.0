package com.example.orented;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    String selectedCar = "Car Name";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button rentDatsunGo = view.findViewById(R.id.datsun_go);
        Button rentDaihatsuAyla = view.findViewById(R.id.daihatsu_ayla);
        Button rentHondaBrio = view.findViewById(R.id.honda_brio);
        Button rentDaihatsuSigra = view.findViewById(R.id.daihatsu_sigra);
        Button rentSuzukiErtiga = view.findViewById(R.id.suzuki_ertiga);
        Button rentToyotaAvanza = view.findViewById(R.id.toyota_avanza);
        Button rentToyotaInnova = view.findViewById(R.id.toyota_innova);
        Button rentToyotaHiace = view.findViewById(R.id.toyota_hiace);

        rentDatsunGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Datsun Go";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentDaihatsuAyla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Daihatsu Ayla";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentHondaBrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Honda Brio";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentDaihatsuSigra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Daihatsu Sigra";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentSuzukiErtiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Suzuki Ertiga";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentToyotaAvanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Toyota Avanza";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentToyotaInnova.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Toyota Innova";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        rentToyotaHiace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCar = "Toyota Hiace";
                Bundle bundle = new Bundle();
                bundle.putString("selected", selectedCar);
                getParentFragmentManager().setFragmentResult("reqKey", bundle);
            }
        });

        /*
        Bundle bundle = new Bundle();
        bundle.putString("selected", selectedCar);
        getParentFragmentManager().setFragmentResult("reqKey", bundle);
        */

        return view;
    }
}
