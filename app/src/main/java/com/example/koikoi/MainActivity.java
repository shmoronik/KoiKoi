package com.example.koikoi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Dialog d; Toast toast; InputValidation inputVal;
    EditText uNameInput; EditText passInput;
    String uName; String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_login);
        // input validator setup
        inputVal = new InputValidation();
        // user input fields setup
        uNameInput = (EditText) d.findViewById(R.id.editUname);
        passInput = (EditText) d.findViewById(R.id.editPass);
    }

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
        uName = uNameInput.getText().toString();
        pass = passInput.getText().toString();
        // user input value checks
        if (!inputVal.isVUser(uName, pass)) {
            toast = Toast.makeText(this, "username or password are incorrect", Toast.LENGTH_LONG);
            toast.show();
        }
        else
            d.hide();
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