package stm.com.embassy;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ConsolateMapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consolate_maps);
        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        position = getIntent().getIntExtra(ConsolateActivity.POSITION, 0);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Resources res = getResources();
        mMap = googleMap;
        String title = getResources().getStringArray(R.array.consolates_item)[position];
        // Add a marker in Sydney and move the camera
        TypedArray latitudes = res.obtainTypedArray(R.array.consolates_lat);
        double lat = latitudes.getFloat(position, 0);
        TypedArray longitudes = res.obtainTypedArray(R.array.consolates_lng);
        double lng = longitudes.getFloat(position, 0);
        LatLng consolate = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions()
                .position(consolate)
                .title(title)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker))
        );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(consolate, 11.0f));
    }
}
