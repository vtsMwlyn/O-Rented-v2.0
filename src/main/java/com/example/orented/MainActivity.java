package com.example.orented;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
    private ArrayList<Vehicle> availableVehicleList = new ArrayList<Vehicle>();

    Lessor carOwner = new Lessor("L000", "Car Owner", "Car Owner", "2002-01-01", "A City", "089900001111", "carowner@mail.com");

    Vehicle datsunGo = new Vehicle("V001", "Go", "Datsun", 5, 5, "Manual", carOwner, 200000);
    Vehicle daihatsuAyla = new Vehicle("V002", "Ayla", "Daihatsu", 5, 5, "Auto", carOwner, 200000);
    Vehicle hondaBrio = new Vehicle("V003", "Brio", "Honda", 5, 5, "Manual", carOwner, 200000);
    Vehicle daihatsuSigra = new Vehicle("V004", "Sigra", "Daihatsu", 7, 5, "Auto", carOwner, 300000);
    Vehicle toyotaAvanza = new Vehicle("V005", "Avanza", "Toyota", 7, 5, "Manual", carOwner, 300000);
    Vehicle suzukiErtiga = new Vehicle("V006", "Ertiga", "Suzuki", 7, 5, "Auto", carOwner, 300000);
    Vehicle toyotaInnova = new Vehicle("V007", "Innova", "Toyota", 5, 5, "Manual", carOwner, 300000);
    Vehicle toyotaHiace = new Vehicle("V008", "Hiace", "Toyota", 16, 5, "Manual", carOwner, 600000);

    Vehicle carToRent = null;
    String selectedCar = "Car Name";
    String rentConfirmation = "None";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = findViewById(R.id.username);
        Intent intentus = getIntent();
        username.setText(intentus.getStringExtra("inpusername") + "!");

        initiateObjects();

        BottomNavigationView bottomMenu = findViewById(R.id.bottom_menu);
        bottomMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Fragment selectedFragment = null;

                switch(item.getItemId()){
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        fm.setFragmentResultListener("reqKey", MainActivity.this, new FragmentResultListener() {
                            @Override
                            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                                selectedCar = result.getString("selected");
                            }
                        });

                        break;

                    case R.id.nav_history:
                        selectedFragment = new HistoryFragment();

                        break;

                    case R.id.nav_rent:
                        Bundle bundle = generateCarDataBundle();
                        selectedFragment = new RentFragment();
                        selectedFragment.setArguments(bundle);

                        break;
                }

                ft.replace(R.id.fragment_container, selectedFragment).commit();

                return false;
            }
        });

        bottomMenu.setSelectedItemId(R.id.nav_home);

        Button logOutButton = findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentus2 = getIntent();
                setResult(RESULT_OK, intentus2);
                finish();
            }
        });
    }

    void initiateObjects(){
        vehicleList.add(datsunGo);
        vehicleList.add(daihatsuAyla);
        vehicleList.add(hondaBrio);
        vehicleList.add(daihatsuSigra);
        vehicleList.add(toyotaAvanza);
        vehicleList.add(suzukiErtiga);
        vehicleList.add(toyotaInnova);
        vehicleList.add(toyotaHiace);

        for(Vehicle v : vehicleList){
            if(v.checkAvailability() == 1){
                availableVehicleList.add(v);
            }
        }

    }

    Bundle generateCarDataBundle(){
        Bundle b = new Bundle();

        for(Vehicle v : vehicleList){
            if(v.getFullName().equals(selectedCar)){
                carToRent = v;
                break;
            }
        }

        if(carToRent == null){
            b.putString("cname", selectedCar);
            b.putString("crentprice", "0K / Day");
            b.putString("cseat", "n Seats");
            b.putString("ccontrol", "Control");
            b.putString("cdoor", "n Doors");
        }
        else {
            b.putString("cname", carToRent.getFullName());
            b.putString("crentprice", ((int)(carToRent.getPrice() / 1000)) + "K / Day");
            b.putString("cseat", carToRent.getSeat() + " Seats");
            b.putString("ccontrol", carToRent.getControl());
            b.putString("cdoor", carToRent.getDoor() + " Doors");
        }

        return b;
    }
}