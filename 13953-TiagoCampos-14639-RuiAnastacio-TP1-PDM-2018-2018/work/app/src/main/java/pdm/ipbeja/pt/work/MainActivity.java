package pdm.ipbeja.pt.work;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pdm.ipbeja.pt.work.data.db.HealthBoxDatabase;
import pdm.ipbeja.pt.work.data.entity.HistoricLog;
import pdm.ipbeja.pt.work.data.entity.Medicines;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DatePickerDialog.OnDateSetListener {
    public static final  String HISTORIC_ID="idLog";
    private long historic_id;

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

    private List<Medicines> medicinesList;

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

        historic_id = getIntent().getLongExtra(HISTORIC_ID, 0);

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
        this.monthToday = c.get(Calendar.MONTH)  + 1;
        this.dayToday = c.get(Calendar.DAY_OF_MONTH);

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<HistoricLog> historicLogs = HealthBoxDatabase.getInstance(this).historicLogDao().getAllHistoricLogs();
        this.medicinesList = HealthBoxDatabase.getInstance(this).medicinesDao().getMedicines();
        mainAdpter.setData(historicLogs);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currenDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        this.yearToday = year;
        this.monthToday = month  + 1;
        this.dayToday = dayOfMonth;

        //dateText.setText(currenDateString);
    }

    public void onClickDatePicker(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), "date picker");
    }

    //To open the Side Bar
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

    public void onClickAddMedicine(View view) {
       InsertMenuActivity.start(this);
    }



    class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        HistoricLog historicLog;
        final ImageView imageView;
        final TextView hours_take;
        final TextView name_pills;
        final Button taken_btn;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            itemView.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.image_med);
            hours_take = itemView.findViewById(R.id.hour_take);
            name_pills = itemView.findViewById(R.id.pill_name);
            taken_btn = itemView.findViewById(R.id.taken_button);
        }

        public void bind(HistoricLog historicLog) {
            this.historicLog = historicLog;

            for (int i = 0; i < medicinesList.size(); i++) {
                if(medicinesList.get(i).getIdMed() != 0 ) {
                    int yearStart = Integer.parseInt(medicinesList.get(i).getYearStart());
                    int monthStart = Integer.parseInt(medicinesList.get(i).getMonthStart());
                    int dayStart = Integer.parseInt(medicinesList.get(i).getDayStart());
                    int daystake = Integer.parseInt(medicinesList.get(i).getNumberDaysOfTake());
                    String pillName = medicinesList.get(i).getName();
                    if (yearToday > yearStart || yearToday == yearStart) {//permitir que os medicamentos apenas sejam mostrados no tempo determinado, apagando depois o registo do Historic log
                        if (monthToday >= monthStart) {
                            if (dayToday >= dayStart) {

                                if ((dayToday - dayStart) <= daystake) {
                                    if (medicinesList.get(i).getIdMed() == historicLog.getIdMeds()) {

                                        hours_take.setText(historicLog.getHourLog());
                                        String typeMed = medicinesList.get(i).getTypeMed();
                                        if (typeMed.equals("capsule")) {
                                            imageView.setImageResource(R.drawable.caplpsule);
                                        }


                                    }
                                }
                                name_pills.setText(pillName);
                                taken_btn.setText(historicLog.getStatus());

                            }


                        }
                    }
                }
            }//end for(i)


        }//end method

        @Override
        public void onClick(View v) {

        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    public class MainAdpter extends  RecyclerView.Adapter<MainViewHolder>{
        private List<HistoricLog> data = new ArrayList<>();

        private void setData(List<HistoricLog> data){
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
            HistoricLog historicLog = data.get(i);
            mainViewHolder.bind(historicLog);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
