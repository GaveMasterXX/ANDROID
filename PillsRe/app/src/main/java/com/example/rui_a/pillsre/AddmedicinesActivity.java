package com.example.rui_a.pillsre;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v13.view.DragStartHelper;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.view.View.OnClickListener;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class AddmedicinesActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, OnClickListener {
    private TextView timeText;
    private TextView numberText;
    private TextView medicineNameText;

    private int N = 3; // total number of textviews to add
    private int numberselect = 0;
    private int lastNumber = 0;
    //private TextView[] myTextViews; // create an empty array;
    //private List<TextView> myTextViews= new ArrayList<TextView>();
    private LinearLayout layout;
    private Spinner spinner;
    private int past;
    private TextView argPicker;

    final TextView[] myTextViews = new TextView[N]; // create an empty array;

    private int start = 0;

    //To BD
    private String numberOfDays;
    private String medicineName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmedicines);




        spinner = (Spinner) findViewById(R.id.spinner_hours);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hours, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        numberText = (TextView) findViewById(R.id.numberPicker);
        timeText = (TextView) findViewById(R.id.name_time);
        medicineNameText = (TextView)  findViewById(R.id.medicineName);
        layout = (LinearLayout) findViewById(R.id.layout);


        settingAlarm();
        cancelAlarm();
    }

    @Override
    protected void onStart() {
        super.onStart();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String text = spinner.getSelectedItem().toString();
                String[] splitStr = text.split("\\s+");
                //Toast.makeText(AddmedicinesActivity.this, splitStr[0], Toast.LENGTH_SHORT).show();
                numberselect = Integer.parseInt(splitStr[0]);
                // myTextViews = new TextView[N];

                layout.removeAllViews();

                /*
                int count = 0;
                while (myTextViews.size() > count) {
                    if (past - 1< count){
                        myTextViews.remove(count);
                    }
                    //System.out.println(myTextViews.get(count));
                    count++;
                }

                */
                addHours();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }

    void addHours(){

        for (int i = 0; i < numberselect; i++) {
            // create a new textview
            final TextView rowTextView = new TextView(this);

            // set some properties of rowTextView or something
            //rowTextView.setText("This is row #" + i);
            rowTextView.setTextSize(18);
            rowTextView.setTextColor(Color.parseColor("#1E90FF"));

            rowTextView.setText("00:00");

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,10,10,10);
            rowTextView.setLayoutParams(params);


            rowTextView.setOnClickListener(this);
            // add the textview to the linearlayout
            layout.addView(rowTextView);


            // save a reference to the textview for later
            myTextViews[i] = rowTextView;

        }
        //String s = myTextViews[0].getText().toString();
        //Toast.makeText(AddmedicinesActivity.this, s, Toast.LENGTH_SHORT).show();
        lastNumber = numberselect;
        start++;
    }



    @Override
    public void onClick(View arg) {
        //((TextView)arg).setText("My text on click");
        DialogFragment timePiker = new TimePickerFragment();
        timePiker.show(getSupportFragmentManager(), "time picker");

        argPicker = (TextView) arg;
        //System.out.println("mmmmmmmmmmmmmm" + myTextViews[0].getText());
        //((TextView)arg).setText(HourOfDayTicker + ":" + minutePicker);
    }



    @Override
    public void onTimeSet(TimePicker timePicker, int HourOfDay, int minute) {
        ((TextView)argPicker).setText(HourOfDay + ":" + minute);
    }

    private  void setNumberPickerDialog(){
        NumberPicker myNumberPicker = new NumberPicker(this);
        myNumberPicker.setMaxValue(10);
        myNumberPicker.setMinValue(1);
        NumberPicker.OnValueChangeListener myValChangedListener = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int olVal, int newVal) {
                if (newVal == 1)
                numberText.setText(newVal + " dia");
                else{
                    numberText.setText(newVal + " dias");
                }
            }
        };
        myNumberPicker.setOnValueChangedListener(myValChangedListener);
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(myNumberPicker);
        builder.setTitle("Dias de Toma");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        builder.show();
    }

    public void onClickPickNumber(View view) {
        setNumberPickerDialog();
    }

    public void onClickAddMedicine(View view) {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        Integer.toString(calendar.get(Calendar.YEAR));
        Integer.toString(calendar.get(Calendar.MONTH + 1));
        Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));

        medicineName = medicineNameText.getText().toString();
        numberOfDays = numberText.getText().toString();

        int number = Integer.valueOf(numberText.getText().toString()) - 1;
        for (int i = 0; i < number; i++) {
            myTextViews[1].getText().toString();
        }
    }


    public void settingAlarm(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 01);

        Intent myIntent = new Intent(getApplicationContext(), NotificationHelper.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getApplicationContext(), 1, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        //alarmManager.set(AlarmManager.RTC, now.getTimeInMillis(), pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

    }

    public void cancelAlarm(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent myIntent = new Intent(getApplicationContext(), NotificationHelper.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                getApplicationContext(), 1, myIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.cancel(pendingIntent);
    }
}
