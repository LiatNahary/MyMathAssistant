package com.example.mymathassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private ToggleButton toggleButtonPosNeg;

    private ImageButton imageButtonReset;
    private ImageButton imageButtonTest;

    private EditText editTextNumberUnitsTopper;
    private EditText editTextNumberTensTopper;
    private EditText editTextNumberHundredsTopper;

    private EditText editTextNumberFstUnits;
    private EditText editTextNumberFstTens;
    private EditText editTextNumberFstHundreds;

    private EditText editTextNumberSndUnits;
    private EditText editTextNumberSndTens;
    private EditText editTextNumberSndHundreds;

    private EditText editTextNumberAnsUnits;
    private EditText editTextNumberAnsTens;
    private EditText editTextNumberAnsHundreds;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        toggleButtonPosNeg = findViewById(R.id.toggleButtonPosNeg);

        imageButtonReset = findViewById(R.id.imageButtonReset);
        imageButtonTest = findViewById(R.id.imageButtonTest);

        editTextNumberUnitsTopper = findViewById(R.id.editTextNumberUnitsTopper);
        editTextNumberTensTopper = findViewById(R.id.editTextNumberTensTopper);
        editTextNumberHundredsTopper = findViewById(R.id.editTextNumberHundredsTopper);

        editTextNumberFstUnits = findViewById(R.id.editTextNumberFstUnits);
        editTextNumberFstTens = findViewById(R.id.editTextNumberFstTens);
        editTextNumberFstHundreds = findViewById(R.id.editTextNumberFstHundreds);

        editTextNumberSndUnits = findViewById(R.id.editTextNumberSndUnits);
        editTextNumberSndTens = findViewById(R.id.editTextNumberSndTens);
        editTextNumberSndHundreds = findViewById(R.id.editTextNumberSndHundreds);

        editTextNumberAnsUnits = findViewById(R.id.editTextNumberAnsUnits);
        editTextNumberAnsTens = findViewById(R.id.editTextNumberAnsTens);
        editTextNumberAnsHundreds = findViewById(R.id.editTextNumberAnsHundreds);





        toggleButtonPosNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        imageButtonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = getNumber(editTextNumberFstUnits, editTextNumberFstTens, editTextNumberFstHundreds);
                int num2 = getNumber(editTextNumberSndUnits, editTextNumberSndTens, editTextNumberSndHundreds);
                int result = getNumber(editTextNumberAnsUnits, editTextNumberAnsTens, editTextNumberAnsHundreds);

                if (toggleButtonPosNeg.isChecked()) {
                    if ((num1 - num2) == result) {
                      openActivityGoodJob();
                    } else {openActivityTryAgain();
                    }
                } else {
                    if ((num1 + num2) == result) {
                        openActivityGoodJob();
                    } else { openActivityTryAgain();
                    }
                }
            }
        });

        imageButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumberUnitsTopper.setText(null);
                editTextNumberTensTopper.setText(null);
                editTextNumberHundredsTopper.setText(null);

                editTextNumberFstUnits.setText(null);
                editTextNumberFstTens.setText(null);
                editTextNumberFstHundreds.setText(null);

                editTextNumberSndUnits.setText(null);
                editTextNumberSndTens.setText(null);
                editTextNumberSndHundreds.setText(null);

                editTextNumberAnsUnits.setText(null);
                editTextNumberAnsTens.setText(null);
                editTextNumberAnsHundreds.setText(null);
            }
        }
        );

    }

        public int getNumber (EditText unitPlace, EditText tensPlace , EditText hundredsPlace){
            int unitsNumber;
            int tensNumber;
            int hundredsNumber;


            if (unitPlace.getText().toString().matches("")) {
                unitsNumber =0;}
            else{unitsNumber = Integer.parseInt(unitPlace.getText().toString());
            }
            if (tensPlace.getText().toString().matches("")) {
                tensNumber =0;}
            else{tensNumber = Integer.parseInt(tensPlace.getText().toString());
            }
            if (hundredsPlace.getText().toString().matches("")) {
                hundredsNumber =0;}
            else{hundredsNumber = Integer.parseInt(hundredsPlace.getText().toString());
            }
            return ((hundredsNumber*100)+(tensNumber *10)+unitsNumber);
    }


    public void openActivityGoodJob (){
        Intent intent = new Intent(this, ActivityGoodJob.class);
        startActivity(intent);
    }

    public void openActivityTryAgain (){
        Intent intent = new Intent(this, ActivityNiceTry.class);
        startActivity(intent);
    }


}
