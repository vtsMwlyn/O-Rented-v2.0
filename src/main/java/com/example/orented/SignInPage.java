package com.example.orented;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_page);

        Button signInButton = findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentus = new Intent(v.getContext(), MainActivity.class);
                String username = ((TextView) findViewById(R.id.inp_username)).getText().toString();
                if(username.equals("")){
                    intentus.putExtra("inpusername", "Guest");
                }
                else {
                    intentus.putExtra("inpusername", username);
                }

                startActivity(intentus);
            }
        });
    }
}
