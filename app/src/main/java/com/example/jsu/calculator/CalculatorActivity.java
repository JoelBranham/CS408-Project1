package com.example.jsu.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    String operator;
    double prevNum, currentNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        operator = "";
        prevNum = currentNum = 0.0;
    }

    public void buttonClicked(View v){
        Button b = findViewById(v.getId());
        String id = (b.getResources().getResourceName(b.getId())).split("/")[1];

        TextView t = (TextView) findViewById(R.id.resultTextView);
        t.setText(id);

        switch(id) {
            case "squareRootButton":
                break;
            case "clearButton":
                operator = "";
                prevNum = currentNum = 0.0;
                break;
            case "divisionButton":
                break;
            case "percentButton":
                break;
            case "multiplicationButton":
                break;
            case "subtractionButton":
                operator = "-";
                break;
            case "decimalButton":
                break;
            case "additionButton":
                operator = "+";
                break;
            case "signButton":
                break;
            case "equalButton":
                calculateResult();
                break;
            default:
                Button numberButton = findViewById(v.getId());
                prevNum = currentNum;
                currentNum = Double.valueOf(numberButton.getText().toString());
        }
    }





    public void calculateResult(){
        double result = 0.0;
        switch(operator){
            case "+":
                result = prevNum + currentNum;
                break;
            case "-":
                result = prevNum - currentNum;
                break;
        }

        TextView t = (TextView) findViewById(R.id.resultTextView);
        t.setText(Double.toString(result));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
