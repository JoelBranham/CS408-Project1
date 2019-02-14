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

public class CalculatorActivity extends AppCompatActivity {


    double result, currentNum;
    String currentOperator;


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

        double result = currentNum = 0.0;
    }

    public void buttonClicked(View v){
        String id = Integer.toString(v.getId());

        switch(id){
            case "squareRootButton": currentOperator = id;
                break;
            case "clearButton": currentOperator = id;
                break;
            case "divisionButton": currentOperator = id;
                break;
            case "percentButton": currentOperator = id;
                break;
            case "multiplicationButton": currentOperator = id;
                break;
            case "subtractionButton": currentOperator = id;
                break;
            case "decimalButton":
                break;
            case "additionButton":
                break;
            case "equalButton": calculateResult();
                break;
            default:
                Button numberButton = findViewById(v.getId());
                int buttonValue = Integer.valueOf(numberButton.getText().toString());
        }

//        TextView t = (TextView) findViewById(R.id.resultTextView);
//        t.setText(id);

    }

    public void calculateResult(){

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
