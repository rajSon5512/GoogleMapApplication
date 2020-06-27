package com.example.mapfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button press_me;

    public static final int ERROR_DIALOG_REQUEST = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isServicesOK()){
            init();
        }
    }

    public void init(){
        press_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);

            }
        });
    }


    public boolean isServicesOK(){

        Log.d(TAG, "isServicesOK: checking google service is ok");

        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

        if(available== ConnectionResult.SUCCESS){

            Log.d(TAG, "isServicesOK: Google Play Service is Working.");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){

            Log.d(TAG, "isServicesOK: some error but it can solvable ...!!!");
            Dialog dialog=GoogleApiAvailability.getInstance().getErrorDialog(this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map request...!!!", Toast.LENGTH_SHORT).show();
        }

    return false;
    }

}