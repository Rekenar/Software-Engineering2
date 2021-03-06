package com.example.einzelprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber;
    TextView editTextOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = (EditText)findViewById(R.id.editTextNumber);
        editTextOutput = (TextView) findViewById(R.id.textView);
    }

    public void send(View v){
        editTextOutput.setText(editTextNumber.getText());
    }

    public void sort(View v){
        String mNr = editTextNumber.getText().toString();
        int[] array = new int[mNr.length()];

        stringToIntArray(mNr, array);

        int sum = alternateQuersummeForward(array);

        setEditTextOutputAufgabe2(sum);
    }

    /**
     * Convert the String Input to an int array
     * @param mNr
     * @param array
     */
    public void stringToIntArray(String mNr, int[] array){
        for(int i = 0; i < mNr.length(); i++){
            array[i] = Integer.parseInt(String.valueOf(mNr.charAt(i)));
        }
    }

    /**
     * Form the alternating cross sum
     * @param array
     * @return
     */
    public int alternateQuersummeForward(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length;i++){
            if(i % 2 == 0){
                sum+=array[array.length-1-i];
            }else{
                sum-=array[array.length-1-i];
            }
        }
        return sum;
    }

    /**
     * Output the results
     * @param sum
     */
    public void setEditTextOutputAufgabe2(int sum){
        if(sum%2 == 0){
            editTextOutput.setText("Even" + " " + sum);
        }else{
            editTextOutput.setText("Uneven" + " " + sum);
        }
    }
}