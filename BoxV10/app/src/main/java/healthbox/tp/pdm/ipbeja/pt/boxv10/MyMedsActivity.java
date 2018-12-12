package healthbox.tp.pdm.ipbeja.pt.boxv10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MyMedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_meds);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Meus Medicamentos");
        toolbar.setNavigationIcon(R.drawable.ic_format_align_justify_black);
        setSupportActionBar(toolbar);
    }
}
