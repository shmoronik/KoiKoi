package com.example.koikoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {

    EditText uNameInput; EditText passInput; EditText cPassInput; EditText emailInput;
    String uName; String pass; String cPass; String email;
    InputValidation inputVal; Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // input validator setup
        inputVal = new InputValidation();
        // user input fields setup
        uNameInput = (EditText) findViewById(R.id.editTextUName);
        passInput = (EditText) findViewById(R.id.editTextPass);
        cPassInput = (EditText) findViewById(R.id.editTextCPass);
        emailInput = (EditText) findViewById(R.id.editTextEmail);
    }

    public boolean isUser() {
        // user input values setup
        uName = uNameInput.getText().toString();
        pass = passInput.getText().toString();
        cPass = cPassInput.getText().toString();
        email = emailInput.getText().toString();
        // user input value checks
        if (!inputVal.isVuName(uName)) {
            toast = Toast.makeText(this, "username is too short", Toast.LENGTH_LONG);
            toast.show();
        }
        else if(!inputVal.isVPass(pass)) {
            toast = Toast.makeText(this, "password is too short", Toast.LENGTH_LONG);
            toast.show();
        }
        else if(!pass.equals(cPass)) {
            toast = Toast.makeText(this, "reinputted password is different from password", Toast.LENGTH_LONG);
            toast.show();
        }
        else if(!inputVal.isVEmail(email)) {
            toast = Toast.makeText(this, "invalid email inputted", Toast.LENGTH_LONG);
            toast.show();
        }
        else
            return true;
        return false;
    }

    public void signup(View view) {
        Intent i;
        i = new Intent(this, MainActivity.class);
        if (isUser())
            // WIP add user too database
            startActivity(i);
    }

    public void returnMain(View view) {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}