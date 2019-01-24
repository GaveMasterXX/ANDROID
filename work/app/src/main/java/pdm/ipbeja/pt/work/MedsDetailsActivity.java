package pdm.ipbeja.pt.work;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MedsDetailsActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MedsDetailsActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meds_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detalhes dos Medicamentos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
