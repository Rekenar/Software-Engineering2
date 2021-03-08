package com.example.einzelprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    EditText inputField;
    TextView outputField;
    String answer;
    Button calculateButton;
    Button tCPButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = (EditText)findViewById(R.id.inputField);
        outputField = (TextView) findViewById(R.id.outputField);
        calculateButton = (Button) findViewById(R.id.calc);
        tCPButton = (Button) findViewById(R.id.getInfo);

        calculateButton.setOnClickListener((View v)-> {
            alternateQuersumme();
        });

        tCPButton.setOnClickListener((View v) -> {
            Thread thread = startThread();
            thread.start();
        });
    }

    public void send(){
        TCPConnection tcp = new TCPConnection("se2-isys.aau.at", 53212);

        tcp.writeLine(inputField.getText().toString());
        answer = tcp.readLine();

        outputField.setText(answer);
    }

    public Thread startThread(){
        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    send();
                }catch (Exception e){
                    answer = "crashed";
                }
            }
        };
        return thread;
    }

    public void alternateQuersumme(){
        String mNr = inputField.getText().toString();
        AlternateQuersumme aq = new AlternateQuersumme();
        int[] array = new int[mNr.length()];

        aq.stringToIntArray(mNr, array);

        int sum = aq.alternateQuersummeForward(array);

        setEditTextOutputAufgabe2(sum);
    }

    /**
     * Output the results
     * @param sum
     */
    public void setEditTextOutputAufgabe2(int sum){
        if(sum%2 == 0){
            outputField.setText("Even? True\nSum: " + sum);
        }else{
            outputField.setText("Even? False\nSum: " + sum);
        }
    }
}