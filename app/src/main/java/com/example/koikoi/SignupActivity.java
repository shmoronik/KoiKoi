package com.example.koikoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText uNameInput; EditText passInput; EditText cPassInput; EditText emailInput;
    String uName; String pass; String cPass; String email; User user;
    InputValidation inputVal;
    FirebaseConnector fCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // input validator setup
        inputVal = new InputValidation();
        // user input fields setup
        uNameInput = findViewById(R.id.editTextUName);
        passInput = findViewById(R.id.editTextPass);
        cPassInput = findViewById(R.id.editTextCPass);
        emailInput = findViewById(R.id.editTextEmail);
    }

    public void signup(View view) {
        fCon = new FirebaseConnector();
        // user input values setup
        uName = uNameInput.getText().toString();
        pass = passInput.getText().toString();
        cPass = cPassInput.getText().toString();
        email = emailInput.getText().toString();
        // user input value checks
        if(!inputVal.isVEmail(email))
            emailInput.setError("invalid email inputted");
        else if(!inputVal.isVuName(uName))
            uNameInput.setError("username is too short");
        else if(!inputVal.isVPass(pass))
            passInput.setError("password is too short");
        else if(!pass.equals(cPass))
            cPassInput.setError("reInputted password is different from password");
        else {
            user = new User(email, uName);
            fCon.register(email, pass, user, getApplicationContext());
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void returnMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

}