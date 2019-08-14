package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = editText.findViewById(R.id.txt_working_hours);
                String txtEditText = editText.getText().toString();

                int workingHours = Integer.parseInt(txtEditText);
                int extraHours;
                int salary;
                int hourly = 5;
                int overtimeSalary;

                if (0 < workingHours && workingHours <= 60) {
                    if (workingHours <= 40) {
                        salary = workingHours * hourly;
                        Toast.makeText(MainActivity.this, "" + salary, Toast.LENGTH_SHORT).show();
                    }
                    else if (workingHours > 40) {
                        extraHours = workingHours - 40;
                        overtimeSalary = extraHours <= 10 ? (hourly * 2) * extraHours : (hourly * 3) * extraHours;
                        salary = (workingHours * hourly) + overtimeSalary;
                        Toast.makeText(MainActivity.this, "" + salary, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Horas laborales no válidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
