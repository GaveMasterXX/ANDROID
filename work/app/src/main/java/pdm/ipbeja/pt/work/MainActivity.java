package pdm.ipbeja.pt.work;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pdm.ipbeja.pt.work.data.db.HealthBoxDatabase;
import pdm.ipbeja.pt.work.data.entity.Meds;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private RecyclerView main_recylcle_view;
    private MainActivity.MainAdpter mainAdpter;
    private LinearLayoutManager linearLayoutManager;

    //Side Bar
    private DrawerLayout drawer;
    private TextView dateText;
    private Calendar c;
    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String abbreviatedMonth, day;

    private static final String TAG = "MainActivity";


    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    private int yearToday = 0;
    private int monthToday = 0;
    private int dayToday = 0;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_recylcle_view = findViewById(R.id.main_recylcle_view);
        mainAdpter = new MainAdpter();
        linearLayoutManager = new LinearLayoutManager(this);

        main_recylcle_view.setAdapter(mainAdpter);
        main_recylcle_view.setLayoutManager(linearLayoutManager);


        //Side Bar
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Date Picker
        c = Calendar.getInstance();
        dateText = (TextView) findViewById(R.id.date);

        abbreviatedMonth = MONTHS[c.get(Calendar.MONTH)];
        day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        dateText.setText(day + " " + abbreviatedMonth);

        this.yearToday = c.get(Calendar.YEAR);
        this.monthToday = c.get(Calendar.MONTH) + 1;
        this.dayToday = c.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Meds> meds = HealthBoxDatabase.getInstance(this).medsDao().getAllMedicines();
        mainAdpter.setData(meds);
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currenDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        this.yearToday = year;
        this.monthToday = month + 1;
        this.dayToday = dayOfMonth;

        dateText.setText(currenDateString);
    }

    /**
     * chama o fragmento que permite escolher a data pertendida
     *
     * @param view
     */
    public void onClickDatePicker(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), "date picker");
    }


    /**
     * Abre a SideBar
     *
     * @param view
     */
    public void onBackPressed(View view) {
        drawer.openDrawer(GravityCompat.START);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                MainActivity.start(this);
                break;

            case R.id.nav_myPills:
                MyMedicinesActivity.start(this);
                break;

            case R.id.nav_addPills:
                InsertMenuActivity.start(this);
                break;

            case R.id.nav_pharmacy:
                MapsActivity.start(this);
                break;

            case R.id.bot_medicine:
                MyMedicinesActivity.start(this);
                break;
        }
        return true;
    }

    /**
     * Este metodo vai para o formulario que adiciona um novo medicamento a base de dados
     *
     * @param view
     */
    public void onClickAddMedicine(View view) {
        InsertMenuActivity.start(this);
    }


    class MainViewHolder extends RecyclerView.ViewHolder {
        Meds meds;

        final ImageView imageView;
        final TextView hours_take;
        final TextView name_pills;
        final Button taken_btn;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_med);
            hours_take = itemView.findViewById(R.id.hour_take);
            name_pills = itemView.findViewById(R.id.pill_name);
            taken_btn = itemView.findViewById(R.id.taken_button);


            taken_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  //  HealthBoxDatabase.getInstance(this).medsDao().updateStatus(meds.getIdMed(),true);
                    taken_btn.setText("tomado");

                    System.out.println("Button as been cliked!!!");

                }
            });
        }

        /**
         * o bind prencher o layot que esta no recycleVeiw
         *
         * @param meds
         */
        public void bind(Meds meds) {
            this.meds = meds;
            name_pills.setText(meds.getName());

            //Verificar se os compremidos foram tomados
            if (meds.isStatus() == false) {
                taken_btn.setText("Tomar");

            } else if (meds.isStatus() == true) {
                taken_btn.setText("Tomado");
            }

            //TODO ADDICIONAR CODIGO PARA IR BUSCAR A FOTO A PASTA DA APP QUE ESTA NA CACHE DO TELEFONE
           String imageURL = meds.getImageURL();
            Bitmap mphoto = BitmapFactory.decodeFile(imageURL);
            Bitmap thumbnail = ThumbnailUtils.extractThumbnail(mphoto,80,80);

            imageView.setImageBitmap(thumbnail);





        }//end method Bind
    }

    private static Bitmap rotateBitmap(int degrees, Bitmap thumbnail) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degrees);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(thumbnail, 120, 120, true);
        Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        return rotatedBitmap;

    }

    /**
     *
     */
    public class MainAdpter extends RecyclerView.Adapter<MainViewHolder> {
        private List<Meds> data = new ArrayList<>();

        private void setData(List<Meds> data) {
            this.data = data;

            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
            Meds meds = data.get(i);
            mainViewHolder.bind(meds);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}
