package com.example.mapfragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MapActivity  extends AppCompatActivity {

    private static final String TAG = "MapActivity";
    private Boolean permission=false;
    private final  String FINE_PERMISSION = Manifest.permission.ACCESS_FINE_LOCATION;
    private final String COARSE_PERMISSION = Manifest.permission.ACCESS_COARSE_LOCATION;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.map_activity);

    }

    public void getPermissionMethod(){

        String[] permissions={FINE_PERMISSION,COARSE_PERMISSION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), FINE_PERMISSION)== PackageManager.PERMISSION_GRANTED) {

            Log.d(TAG, "getPermissionMethod: Pemission Granted");
            permission=true;
        }else{

            ActivityCompat.requestPermissions(this,permissions,1);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


    }
}
