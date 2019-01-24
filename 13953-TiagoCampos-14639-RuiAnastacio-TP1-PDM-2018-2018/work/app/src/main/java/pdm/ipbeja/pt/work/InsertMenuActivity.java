package pdm.ipbeja.pt.work;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class InsertMenuActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, InsertMenuActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Inserir Medicamentos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void addManualMedicines(View view) {
        startActivity(new Intent(this, AddmedicinesActivity.class));
    }
}
