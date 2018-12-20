package com.example.task24;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double varA;
    double varB;
    double varC;
    double discr;
    Double x1;
    Double x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextA = findViewById(R.id.editText);
        final EditText editTextB = findViewById(R.id.editText2);
        final EditText editTextC = findViewById(R.id.editText3);
        final Button button = findViewById(R.id.button);
        final TextView result = findViewById(R.id.textView3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                varA = Double.parseDouble(editTextA.getText().toString());
                varB = Double.parseDouble(editTextB.getText().toString());
                varC = Double.parseDouble(editTextC.getText().toString());

                discr = (varB * varB) - (4.0 * varA * varC);

                if (varA == 0 && varB == 0 && varC == 0) result.setText("Любое число");

                else if (varA == 0 && varB == 0 && varC != 0) result.setText("Корней нет");

                else if (varA != 0 && varB == 0 && varC != 0) {
                    if ((varC * -1.0) / varA >= 0) {
                        x1 = Math.sqrt((varC * -1.0) / varA);
                        result.setText(x1.toString());
                    } else result.setText("Корней нет");

                }

                else if (varA != 0 && varB == 0 && varC == 0) {
                    x1 = 0.0;
                    result.setText(x1.toString());
                }

                else if (varA == 0 && varB != 0) {
                    x1 = (varC - varC * 2) / varB;
                    result.setText(x1.toString());
                }

                else if (discr > 0) {
                    x1 = ((varB - (varB * 2)) + Math.sqrt(discr)) / (varA * 2);
                    x2 = ((varB - (varB * 2)) - Math.sqrt(discr)) / (varA * 2);
                    result.setText(x1.toString() + " и " + x2.toString());
                }

                else if (discr == 0) {
                    x1 = (varB - (varB * 2)) / (varA * 2);
                    result.setText(x1.toString());
                }

                else if (discr < 0) result.setText("Корней нет");

            }
        });
    }
}
