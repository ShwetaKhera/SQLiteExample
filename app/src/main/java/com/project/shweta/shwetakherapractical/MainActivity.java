package com.project.shweta.shwetakherapractical;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText first_name, last_name, dob;
    private Button btn_submit;

    private String mfirst_name, mlast_name, mdob;

    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_submit = findViewById(R.id.button_submit);
        first_name = findViewById(R.id.editText_firstname);
        last_name = findViewById(R.id.editText_lastname);
        dob = findViewById(R.id.editText_dob);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(first_name.getText().toString().equals("")
                   && last_name.getText().toString().equals("")
                   && dob.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter one or more fields", Toast.LENGTH_LONG).show();
                }
                else {
                    mfirst_name = first_name.getText().toString();
                    mlast_name = last_name.getText().toString();
                    mdob = dob.getText().toString();


                    dbManager = new DBManager(MainActivity.this);
                    dbManager.open();
                    dbManager.insert(mfirst_name, mlast_name, mdob);
                    dbManager.close();

                    Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(intent);
                }
            }
        });

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dob.setInputType(InputType.TYPE_NULL);

                // Get Current Date
                int mYear, mMonth, mDay;
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
}
