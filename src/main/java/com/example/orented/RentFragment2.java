package com.example.orented;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class RentFragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rent2, container, false);

        TextView carName = view.findViewById(R.id.car_name);
        TextView carRentPrice = view.findViewById(R.id.car_rent_price);

        Bundle bundle = getArguments();
        String name = bundle.getString("cname");
        String price = bundle.getString("crentprice");

        carName.setText(name);
        carRentPrice.setText(price);

        ImageView carImage = view.findViewById(R.id.car_image);
        if(name.equals("Datsun Go")){
            int id = getResources().getIdentifier("datsungo", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Daihatsu Ayla")){
            int id = getResources().getIdentifier("daihatsuayla", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Honda Brio")){
            int id = getResources().getIdentifier("hondabrio", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Daihatsu Sigra")){
            int id = getResources().getIdentifier("daihatsusigra", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Suzuki Ertiga")){
            int id = getResources().getIdentifier("suzukiertiga", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Toyota Avanza")){
            int id = getResources().getIdentifier("toyotaavanza", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Toyota Innova")){
            int id = getResources().getIdentifier("toyotainnova", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }
        else if(name.equals("Toyota Hiace")){
            int id = getResources().getIdentifier("toyotahiace", "drawable", getContext().getPackageName());
            carImage.setImageResource(id);
        }

        return view;
    }
}
