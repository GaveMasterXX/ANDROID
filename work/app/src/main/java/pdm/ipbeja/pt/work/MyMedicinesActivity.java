package pdm.ipbeja.pt.work;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ThumbnailUtils;
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
import pdm.ipbeja.pt.work.data.entity.Meds;

public class MyMedicinesActivity extends AppCompatActivity {


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
        List<Meds> meds = HealthBoxDatabase.getInstance(this).medsDao().getAllMedicines();
        medicinesAdpter.setData(meds);

    }


    class MedicinesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
       Meds meds;

       final TextView textView;
       final ImageView imageView;

        public MedicinesViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            textView = itemView.findViewById(R.id.nameMed);
            imageView = itemView.findViewById(R.id.imageMed);
        }

        private void bind(Meds Meds){
            this.meds = meds;
            textView.setText(meds.getName());



            //TODO FAZER A PARTE DO TIPO DE MEDICAMENTO E A IMAGEM CORRESPONDENTE A CADA UM


            Bitmap mphoto = BitmapFactory.decodeFile(meds.getImageURL());
            Bitmap thumbnail = ThumbnailUtils.extractThumbnail(mphoto,120,120);

            //Roda a Thumbnail para colocar na ImageView
            //Bitmap rotatedThumbnail = rotateBitmap(90, thumbnail);

            //Põe o Thumbnail na ImageView
            imageView.setImageBitmap(thumbnail);


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

    private static Bitmap rotateBitmap(int degrees, Bitmap thumbnail) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(thumbnail, 80, 80, true);
        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        return rotatedBitmap;

    }


    class MedicinesAdpter extends RecyclerView.Adapter<MedicinesViewHolder>{
       private List<Meds> data = new ArrayList<>();

       private void setData(List<Meds> data){
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
            Meds Meds = data.get(i);
            medicinesViewHolder.bind(Meds);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    public void openDetalisOnClicked(View view){
        MedsDetailsActivity.start(this);
    }
}
