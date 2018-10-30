package com.example.sklechak.measureconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static com.example.sklechak.measureconvert.R.id.txtResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Start typing here....

        //put the icon on the bar.  You don't need to do it if you dont want to
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        // These Three lines basically put the icon on the top bar

        // R.id, R.drawable.  These are all integers.  They all return an integer.. a number returned
        // to do something.  All R values are basically assiged a number

        // now we have to do our connection stuff. basically assigning the buttons and radio shit where to look (link)

        Button convertIt = findViewById(R.id.btn1);
        final EditText convertNum = findViewById(R.id.idMeasureNumber);
        final RadioButton rbIntoCm = findViewById(R.id.rbInToCm);
        final RadioButton rbCmtoIn = findViewById(R.id.rbCmToIn);
        final TextView txtResult = findViewById(R.id.txtResult);

        convertIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat tenth = new DecimalFormat("#.#");
                Double dblMeasure = Double.parseDouble(convertNum.getText().toString());

                Double conversionRate = 2.54;
                Double convertMeasureNum = 0.00;

                if (rbIntoCm.isChecked()) {
                    if (dblMeasure <= 72) {
                        convertMeasureNum = dblMeasure * conversionRate;
                        txtResult.setText(tenth.format(convertMeasureNum)+ " cm");

                    } else {
                        Toast.makeText(MainActivity.this, "Inches must be less than 72.", Toast.LENGTH_LONG).show();
                    }

                }
                if (rbCmtoIn.isChecked()) {
                    if (dblMeasure <= 185) {
                        convertMeasureNum = dblMeasure / conversionRate;
                        txtResult.setText(tenth.format(convertMeasureNum) + " In");

                    } else {
                        Toast.makeText(MainActivity.this, "Centimeters must be less than 185.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
