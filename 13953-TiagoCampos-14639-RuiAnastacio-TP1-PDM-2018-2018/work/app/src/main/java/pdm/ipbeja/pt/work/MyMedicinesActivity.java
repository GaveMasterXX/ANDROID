package pdm.ipbeja.pt.work;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pdm.ipbeja.pt.work.data.db.HealthBoxDatabase;
import pdm.ipbeja.pt.work.data.entity.Medicines;

public class MyMedicinesActivity extends AppCompatActivity {

    public static final String MEDICINE_ID = "idMeds";
    private long medicineId;

    private RecyclerView my_meds;
    private MedicinesAdpter medicinesAdpter;
    private LinearLayoutManager linearLayoutManager;



  public static void start(Context context) {
      Intent starter = new Intent(context, MyMedicinesActivity.class);
      context.startActivity(starter);
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_medicines);

        medicineId = getIntent().getLongExtra(MEDICINE_ID, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Meus Medicamentos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        my_meds = findViewById(R.id.my_meds); // achar o id da recicle View
        medicinesAdpter = new MedicinesAdpter();
        linearLayoutManager = new LinearLayoutManager(this);

        my_meds.setAdapter(medicinesAdpter);
        my_meds.setLayoutManager(linearLayoutManager);
      //  createMedicine();
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Medicines> medicines = HealthBoxDatabase.getInstance(this).medicinesDao().getMedicines();
        medicinesAdpter.setData(medicines);

    }

    /*public void createMedicine() {
      String name = "Cgripo";
      String typeMed = "Compremido";
      String dayStart ="7";
      String monthStart = "12";
      String yearStart = "2018";
      String daysOfTake = "6";

        // Mesmo que não exista foto, não há problema em guardar null no campo dos bytes! Tratamos o caso de ser null quando utilizarmos a foto
        HealthBoxDatabase.getInstance(this).medicinesDao().insert(new Medicines( 0, name,typeMed , dayStart, monthStart, yearStart, daysOfTake));
        List<Medicines> medicines = HealthBoxDatabase.getInstance(this).medicinesDao().getMedicines();
        medicinesAdpter.setData(medicines);

    }*/


    class MedicinesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
       Medicines medicines;

       final TextView textView;
       final ImageView imageView;

        public MedicinesViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            textView = itemView.findViewById(R.id.nameMed);
            imageView = itemView.findViewById(R.id.imageMed);
        }

        private void bind(Medicines medicines){
            this.medicines = medicines;
            textView.setText(medicines.getName());
            String typeMed =  medicines.getTypeMed();
            if(typeMed.equals("capsule")){
                imageView.setImageResource(R.drawable.caplpsule);
            }

            //TODO FAZER A PARTE DO TIPO DE MEDICAMENTO E A IMAGEM CORRESPONDENTE A CADA UM

        }

        @Override
        public void onClick(View view) {
            //TODO click curto, faz algo

        }

        @Override
        public boolean onLongClick(View v) {
            //TODO CLICK LONGO FAZ OUTRA COISA
            return false;
        }
    }


    class MedicinesAdpter extends RecyclerView.Adapter<MedicinesViewHolder>{
       private List<Medicines> data = new ArrayList<>();

       private void setData(List<Medicines> data){
           this.data = data;
           notifyDataSetChanged();
       }

        @NonNull
        @Override
        public MedicinesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
           View view = LayoutInflater.from(viewGroup.getContext()) .inflate(R.layout.meds_layout, viewGroup, false);
           return new MedicinesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MedicinesViewHolder medicinesViewHolder, int i) {
            Medicines medicines = data.get(i);
            medicinesViewHolder.bind(medicines);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
