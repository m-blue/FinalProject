package com.example.blue.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    String firstName = "";
    String lastName = "";
    String phone = "";
    String birthDate = "";
    String isDegreeCert = "";
    String degreeCert = "";
    String class1 = "";
    String selected1 = "";
    String class2 = "";
    String selected2 = "";
    String class3 = "";
    String selected3 = "";
    String class4 = "";
    String selected4 = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            firstName = extras.getString("txtFirstName");
            lastName = extras.getString("txtLastName");
            phone = extras.getString("txtPhone");
            birthDate = extras.getString("txtBirthDate");
            isDegreeCert = extras.getString("isDegreeCert");
            degreeCert = extras.getString("degreeCert");
            class1 = extras.getString("Class1");
            selected1 = extras.getString("Selected1");
            class2 = extras.getString("Class2");
            selected2 = extras.getString("Selected2");
            class3 = extras.getString("Class3");
            selected3 = extras.getString("Selected3");
            class4 = extras.getString("Class4");
            selected4 = extras.getString("Selected4");
        }

        final TextView txtStudent = findViewById(R.id.txtStudent);
        final TextView txtPhone = findViewById(R.id.txtPhone);
        final TextView txtBirthDate = findViewById(R.id.txtBirth);
        final TextView txtDegreePlan = findViewById(R.id.txtDegree);
        final TextView txtMajor = findViewById(R.id.txtMajor);
        final TextView txtClassSchedule = findViewById(R.id.txtSchedule);

        txtStudent.setText(firstName + " " + lastName);
        txtPhone.setText(phone);
        txtBirthDate.setText(birthDate);
        txtDegreePlan.setText(isDegreeCert);
        txtMajor.setText(degreeCert);

        StringBuilder ClassSchedule = new StringBuilder(250);

        if(!class1.equals("")){
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n");
        }
        if(!class2.equals("")){
            ClassSchedule.append((class2 ) + "\n" + selected2 + "\n\n");
        }
        if(!class3.equals("")){
            ClassSchedule.append((class3 ) + "\n" + selected3 + "\n\n");
        }
        if(!class4.equals("")){
            ClassSchedule.append((class4 ) + "\n" + selected4 + "\n\n");
        }

        txtClassSchedule.setText(ClassSchedule);

    }
}
