package com.example.koikoi;

// login + checks
// logout

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Dialog d; InputValidation inputVal;
    EditText emailInput; EditText passInput;
    String email; String pass;
    FirebaseConnector fCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_login);
        // input validator setup
        inputVal = new InputValidation();
        // user input fields setup
        emailInput = d.findViewById(R.id.editEmail);
        passInput = d.findViewById(R.id.editPass);
        fCon = new FirebaseConnector();
    }

    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_login).setVisible(fCon.isUser());
        menu.findItem(R.id.action_user).setVisible(!fCon.isUser());
        return true;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID= item.getItemId();
        if (itemID==R.id.action_login)
            OpenLogin();
        if (itemID==R.id.action_user)
            OpenUser();
        if (itemID==R.id.action_settings)
            OpenSettings();
        if (itemID==R.id.action_exit)
            OpenExit();
        return super.onOptionsItemSelected(item);
    }

    private void OpenExit() {
        this.finishAffinity();
    }

    public void login(View view) {
        // user input values setup
        email = emailInput.getText().toString();
        pass = passInput.getText().toString();
        // user input value checks
        if(!inputVal.isVEmail(email))
            emailInput.setError("invalid email inputted");
        else if(!inputVal.isVuName(pass))
            passInput.setError("password is too short");
        else
            fCon.login(email, pass, this);
    }

    private void OpenLogin() {
        d.show();
        d.setCancelable(true);
    }

    private void OpenUser() {
        Intent i = new Intent(this, UserActivity.class);
        startActivity(i);
    }

    private void OpenSettings() {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    public void hub(View view) {
        Intent i = new Intent(this, HubActivity.class);
        startActivity(i);
    }

    public void signup(View view) {
        Intent i;
        i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }
}