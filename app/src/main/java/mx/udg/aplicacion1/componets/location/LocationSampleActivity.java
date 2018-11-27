package mx.udg.aplicacion1.componets.location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import butterknife.BindView;
import butterknife.ButterKnife;
import mx.udg.aplicacion1.R;
import mx.udg.aplicacion1.componets.Util.KeysConstants;

public class LocationSampleActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener{

    @BindView(R.id.location) TextView textView;

    @BindView(R.id.progressBarlocation) ProgressBar progressBar;

    FusedLocationProviderClient mFusedLocationProviderClient;

    GoogleApiClient mGoogleApiClient;

    LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_sample);
        ButterKnife.bind(this);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        buildGoogleApiClient();

    }

    private void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.reconnect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int response = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(LocationSampleActivity.this);
        if(response != ConnectionResult.SUCCESS){
            Log.d("MainActivity","Google Play Service Not Available");
            GoogleApiAvailability.getInstance().getErrorDialog(
                    LocationSampleActivity.this
                    ,response,1).show();
        }else{
            if(mGoogleApiClient != null && mFusedLocationProviderClient != null){
                requestLocationUpdates();
            }else{
                buildGoogleApiClient();
            }
            Log.d("MainActivity","Google Play Service Available");
        }
    }

    public void requestLocationUpdates(){
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(2000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mFusedLocationProviderClient.requestLocationUpdates(mLocationRequest,mLocationCallback, Looper.myLooper());
        }else{
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    KeysConstants.LOCATION_PERMISSION_ID);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mFusedLocationProviderClient != null){
            mFusedLocationProviderClient.removeLocationUpdates(mLocationCallback);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    LocationCallback mLocationCallback = new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location : locationResult.getLocations()){
                Log.w("MainActivity","Location "+location.getLatitude()+ " " + location.getLongitude());
                textView.setText(getEmojiByUnicode(0x1F680) + getEmojiByUnicode(0x1F680)+"Location: "
                +location.getLatitude() + location.getLongitude());
                progressBar.setVisibility(View.GONE);
            }
        }
    };


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.w("MainActivity"," onConnected ");
        requestLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.w("MainActivity"," onConnectionSuspended ");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.w("MainActivity"," onConnectionFailed ");
    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case KeysConstants.LOCATION_PERMISSION_ID:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED){
                        onResume();
                    }
                }else{
                    showPopUp();
                }
                return;
            }
        }
    }

    private void showPopUp(){

    }
}
