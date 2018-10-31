package com.example.tiago.playgroubd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static String EXTRA_RESULT = "result";

    private TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String result = getIntent().getStringExtra(EXTRA_RESULT);

        txtResult = findViewById(R.id.txt_result);
        txtResult.setText(result);
    }
    
    public static void start(Context context, String result) {
        Intent starter = new Intent(context, ResultActivity.class);
        starter.putExtra( EXTRA_RESULT, result);
        context.startActivity(starter);
    }
}
