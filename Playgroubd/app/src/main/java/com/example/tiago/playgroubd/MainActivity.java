package com.example.tiago.playgroubd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private TextView hello;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.hello =  findViewById(R.id.hello_world);
        this.name = findViewById(R.id.name);

    }


    public void onButtonClicked(View view) {
        switch (view.getId()){
            case R.id.left_button:
                counter++;
                break;
            case R.id.right_button:
               counter--;
                break;
        }
        this.hello.setText("" + counter);
    }

    public void onOkClicked(View view) {
        String result = this.name.getText().toString() + " " + this.counter;
        System.out.println(result);

       /* Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result",result);

        startActivity(intent);*/

        ResultActivity.start(this, result);

    }
}
