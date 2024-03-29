package ro.sapi.retrofitloginregistration.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ro.sapi.retrofitloginregistration.API.APIService;
import ro.sapi.retrofitloginregistration.R;
import ro.sapi.retrofitloginregistration.API.RetrofitClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSignIn, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSignIn = (Button) findViewById(R.id.buttonSignIn);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);

        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignIn) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (view == buttonSignUp) {
            startActivity(new Intent(this, RegistrationActivity.class));

        }
    }
}
