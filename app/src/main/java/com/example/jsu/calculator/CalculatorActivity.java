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

    String operator, enteredNum;
    double prevNum, currentNum;
    boolean equalLastPressed;

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

        operator = enteredNum = "";
        prevNum = currentNum = 0.0;
        equalLastPressed = false;
    }

    public void buttonClicked(View v){
        Button b = findViewById(v.getId());
        String id = (b.getResources().getResourceName(b.getId())).split("/")[1];

        TextView t = (TextView) findViewById(R.id.resultTextView);

        switch(id) {
            case "additionButton":
                if (!equalLastPressed){
                    calculateResult();
                }
                operator = "+";
                break;
            case "subtractionButton":
                if (!equalLastPressed){
                    calculateResult();
                }
                operator = "-";
                break;
            case "multiplicationButton":
                if (!equalLastPressed){
                    calculateResult();
                }
                operator = "*";
                break;
            case "divisionButton":
                if (!equalLastPressed){
                    calculateResult();
                }
                operator = "/";
                break;
            case "squareRootButton":
                currentNum = Double.valueOf(enteredNum);
                currentNum = Math.sqrt(currentNum);
                enteredNum = Double.toString(currentNum);
                t.setText(enteredNum);
                break;
            case "clearButton":
                operator = enteredNum = "";
                prevNum = currentNum = 0.0;
                t.setText(enteredNum);
                break;
            case "percentButton":
                currentNum = Double.valueOf(enteredNum);
                if (operator.equals("+")){
                    currentNum = prevNum * (currentNum / 100.0);
                }
                else if (operator.equals("*")){
                    currentNum = currentNum / 100.0;
                }
                enteredNum = Double.toString(currentNum);
                t.setText(enteredNum);
                break;
            case "decimalButton":
                enteredNum += ".";
                break;
            case "signButton":
                currentNum = Double.valueOf(enteredNum);
                currentNum = 0 - currentNum;
                enteredNum = Double.toString(currentNum);
                t.setText(enteredNum);
                break;
            case "equalButton":
                calculateResult();
                break;
            default:
                enteredNum = enteredNum + b.getText().toString();
                t.setText(enteredNum);
        }

        equalLastPressed = id.equals("equalButton");
    }

    public void calculateResult(){
        double result = 0.0;

        if (!enteredNum.equals("")){
            currentNum = Double.valueOf(enteredNum);
        }

        switch (operator) {
            case "+":
                result = prevNum + currentNum;
                break;
            case "-":
                result = prevNum - currentNum;
                break;
            case "/":
                result = prevNum / currentNum;
                break;
            case "*":
                result = prevNum * currentNum;
                break;
            default:
                result = currentNum;
        }

        prevNum = result;

        TextView t = (TextView) findViewById(R.id.resultTextView);
        t.setText(Double.toString(result));

        enteredNum = "";
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
