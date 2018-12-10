package com.example.blue.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainClassList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class_list);

        Button btnNext = findViewById(R.id.btnNext);

        final Switch swCertAssoc = findViewById(R.id.swCertAssoc);
        final Spinner spnCert = findViewById(R.id.spnCert);
        final Spinner spnMajor = findViewById(R.id.spnMajor);
        final TextView txtMajor = findViewById(R.id.txtMajor);
        final TextView txtCert = findViewById(R.id.txtC);
        final EditText txtFirstName = findViewById(R.id.txtFirstName);
        final EditText txtLastName  = findViewById(R.id.txtLastName);
        final EditText txtPhone  = findViewById(R.id.txtPhone);
        final Spinner spnMonth = findViewById(R.id.spnMonth);
        final EditText txtDay  = findViewById(R.id.txtDay);
        final EditText txtYear  = findViewById(R.id.txtYear);

        swCertAssoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swCertAssoc.isChecked()){
                    spnCert.setVisibility(View.GONE);
                    txtCert.setVisibility(View.GONE);
                    spnMajor.setVisibility(View.VISIBLE);
                    txtMajor.setVisibility(View.VISIBLE);
                }
                else{
                    spnCert.setVisibility(View.VISIBLE);
                    txtCert.setVisibility(View.VISIBLE);
                    spnMajor.setVisibility(View.GONE);
                    txtMajor.setVisibility(View.GONE);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckData()){
                    Intent nextScreen = new Intent(MainClassList.this, ChooseClass.class);
                    nextScreen.putExtra("txtFirstName", txtFirstName.getText().toString());
                    nextScreen.putExtra("txtLastName", txtLastName.getText().toString());
                    nextScreen.putExtra("txtPhone", txtPhone.getText().toString());
                    String birthDate = spnMonth.getSelectedItem().toString() + " " + txtDay.getText().toString() + " " + txtYear.getText().toString();
                    nextScreen.putExtra("txtBirthDate", birthDate.toString());

                    if(spnCert.getVisibility() == View.VISIBLE){
                        nextScreen.putExtra("isDegreeCert","Degree");
                        nextScreen.putExtra("degreeCert", spnCert.getSelectedItem().toString());
                    }
                    else {
                        nextScreen.putExtra("isDegreeCert", "Major");
                        nextScreen.putExtra("degreeCert", spnMajor.getSelectedItem().toString());
                    }

                    startActivity(nextScreen);
                }
            }
        });

    }

    boolean CheckData(){
        EditText txtFirstName = findViewById(R.id.txtFirstName);
        EditText txtLastName  = findViewById(R.id.txtLastName);
        EditText txtPhone  = findViewById(R.id.txtPhone);
        EditText txtDay  = findViewById(R.id.txtDay);
        EditText txtYear  = findViewById(R.id.txtYear);

        if(txtFirstName.getText().toString().isEmpty()){
            txtFirstName.setError("Missing Name");
            txtFirstName.requestFocus();
            return false;
        }
        if(txtLastName.getText().toString().isEmpty()){
            txtLastName.setError("Missing Name");
            txtLastName.requestFocus();
            return false;
        }
        if(txtPhone.getText().toString().isEmpty()){
            txtPhone.setError("Missing Phone Number");
            txtPhone.requestFocus();
            return false;
        }
        if(txtDay.getText().toString().isEmpty()){
            txtDay.setError("Missing Birth Date");
            txtDay.requestFocus();
            return false;
        }
        if(txtYear.getText().toString().isEmpty()){
            txtYear.setError("Missing Birth Date");
            txtYear.requestFocus();
            return false;
        }

        return true;

    }

}
