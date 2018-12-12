package pdm.ipbeja.pt.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Main");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void myMedsOnClicked(View view) {
        InsertMenuActivity.start(this);
    }

    public void openMap(View view) {
        MapsActivity.start(this);
    }

    public void openMedicine(View view) {
        MyMedicinesActivity.start(this);
    }
}
