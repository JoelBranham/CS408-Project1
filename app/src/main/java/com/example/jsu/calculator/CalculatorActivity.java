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

    public enum Operator {
        CLEAR,
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        CHANGE_SIGN,
        SQUAREROOT;
    };


    String enteredNum;
    Operator lastOperator;
    double prevNum, currentNum;
    boolean repeatOperation;

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

        lastOperator = Operator.CLEAR;
        enteredNum = "";
        prevNum = currentNum = 0.0;
        repeatOperation = true;
    }

    public void buttonClicked(View v){
        Button b = findViewById(v.getId());
        String id = (b.getResources().getResourceName(b.getId())).split("/")[1];

        TextView t = (TextView) findViewById(R.id.resultTextView);

        String displayNum = t.getText().toString();

        switch(id) {
            case "additionButton":
                if (repeatOperation){
                    calculateResult();
                }
                lastOperator = Operator.ADDITION;
                break;
            case "subtractionButton":
                if (repeatOperation){
                    calculateResult();
                }
                lastOperator = Operator.SUBTRACTION;
                break;
            case "multiplicationButton":
                if (repeatOperation){
                    calculateResult();
                }
                lastOperator = Operator.MULTIPLICATION;
                break;
            case "divisionButton":
                if (repeatOperation){
                    calculateResult();
                }
                lastOperator = Operator.DIVISION;
                break;
            case "decimalButton":
                enteredNum += ".";
                break;
            case "squareRootButton":
                if (!repeatOperation){
                    lastOperator = Operator.SQUAREROOT;
                }
                if (t.getText().equals("")){
                    currentNum = 0.0;
                }
                else{
                    currentNum = Math.sqrt(Double.valueOf(displayNum));
                }
                enteredNum = Double.toString(currentNum);
                t.setText(Double.toString(currentNum));
                break;
            case "percentButton":
                currentNum = Double.valueOf(displayNum);
                if (lastOperator == Operator.CLEAR){
                    currentNum = 0.0;
                }
                else if (lastOperator == Operator.ADDITION){
                    currentNum = prevNum * (currentNum / 100.0);
                }
                else if (lastOperator == Operator.MULTIPLICATION){
                    currentNum = currentNum / 100.0;
                }
                enteredNum = Double.toString(currentNum);
                t.setText(enteredNum);
                break;
            case "signButton":
                if (!repeatOperation){
                    lastOperator = Operator.CHANGE_SIGN;
                }
                currentNum = 0 - Double.valueOf(displayNum);
                enteredNum = Double.toString(currentNum);
                t.setText(enteredNum);
                break;
            case "clearButton":
                lastOperator = Operator.CLEAR;
                prevNum = currentNum = 0.0;
                enteredNum = "";
                t.setText(Double.toString(currentNum));
                break;
            case "equalButton":
                calculateResult();
                break;
            default:
                enteredNum = enteredNum + b.getText().toString();
                t.setText(enteredNum);
        }

        repeatOperation = !id.equals("equalButton");
    }

    public void calculateResult(){
        double result = 0.0;

        TextView t = (TextView) findViewById(R.id.resultTextView);
        enteredNum = t.getText().toString();

        if (repeatOperation && !enteredNum.equals("")){
            currentNum = Double.valueOf(enteredNum);
        }

        switch (lastOperator) {
            case ADDITION:
                result = prevNum + currentNum;
                break;
            case SUBTRACTION:
                result = prevNum - currentNum;
                break;
            case DIVISION:
                result = prevNum / currentNum;
                break;
            case MULTIPLICATION:
                result = prevNum * currentNum;
                break;
            default:
                result = currentNum;
        }

        prevNum = result;

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
