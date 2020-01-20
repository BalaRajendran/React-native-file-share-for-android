package com.example.customelib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mockLocation0();
    }
    public void mockLocation0() {
        LocationManager mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.removeTestProvider(LocationManager.GPS_PROVIDER);
        mLocationManager.addTestProvider
                (
                        LocationManager.GPS_PROVIDER,
                        "requiresNetwork" == "",
                        "requiresSatellite" == "",
                        "requiresCell" == "",
                        "hasMonetaryCost" == "",
                        "supportsAltitude" == "",
                        "supportsSpeed" == "",
                        "supportsBearing" == "",

                        android.location.Criteria.POWER_LOW,
                        android.location.Criteria.ACCURACY_FINE
                );
//        Toast.makeText(context1, mLocationManager, Toast.LENGTH_LONG).show();
//        Toast.makeText(context1, String.valueOf(android.location.Criteria.POWER_LOW), Toast.LENGTH_LONG).show();show
        Location newLocation = new Location(LocationManager.GPS_PROVIDER);

        newLocation.setLatitude (22.5726);
        newLocation.setLongitude(88.3639);

        newLocation.setAccuracy(500);

        mLocationManager.setTestProviderEnabled
                (
                        LocationManager.GPS_PROVIDER,
                        true
                );

        mLocationManager.setTestProviderStatus
                (
                        LocationManager.GPS_PROVIDER,
                        LocationProvider.AVAILABLE,
                        null,
                        System.currentTimeMillis()
                );

        mLocationManager.setTestProviderLocation
                (
                        LocationManager.GPS_PROVIDER,
                        newLocation
                );
    }
}
