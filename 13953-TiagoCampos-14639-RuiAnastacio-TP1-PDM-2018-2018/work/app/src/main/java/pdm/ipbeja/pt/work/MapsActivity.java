package pdm.ipbeja.pt.work;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import pdm.ipbeja.pt.work.data.db.HealthBoxDatabase;
import pdm.ipbeja.pt.work.data.entity.Pharmarcy;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static void start(Context context) {
        Intent starter = new Intent(context, MapsActivity.class);
        // starter.putExtra();
        context.startActivity(starter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        HealthBoxDatabase.getInstance(this).pharmarcyDao().insert(new Pharmarcy(0,"Farmácia Holon Beja", "Praça Diogo Fernandes de Beja, 7800-487 Beja",
                "00:00 - 09:00", "284 341 282", "38.013113", "-7.864778"));
        HealthBoxDatabase.getInstance(this).pharmarcyDao().insert(new Pharmarcy(0,"Farmácia Oliveira", "R. Zeca Afonso 30, 7800-522 Beja",
                "09:00-20:00", "284 323 819", "38.006879", "-7.869390"));
        HealthBoxDatabase.getInstance(this).pharmarcyDao().insert(new Pharmarcy(0,"Farmácia Santos", "R. de Santo Andre 3, 7800-296 Beja",
                "09:00-20:00", "284 389 331", "38.019520", "-7.867037"));
        HealthBoxDatabase.getInstance(this).pharmarcyDao().insert(new Pharmarcy(0,"Farmácia Palma", "R. Dom Frei Manuel do Cenaculo 2, 7800-052 Beja",
                "09:00-20:00", "284 322 498", "38.014442", "-7.858669"));

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
        mMap = googleMap;

        List<Pharmarcy> pharmarcyList = HealthBoxDatabase.getInstance(this).pharmarcyDao().getAllPharmarcy(); //devolve a lista de medicamentos4


        for (int i = 0; i < 4; i++) {
            String name = pharmarcyList.get(i).getName();
            double latitude = Double.parseDouble(pharmarcyList.get(i).getLatitude());
            double longitude =Double.parseDouble(pharmarcyList.get(i).getLongitude());

            LatLng sydney = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(sydney).title(name));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 14));
        }
    }
}