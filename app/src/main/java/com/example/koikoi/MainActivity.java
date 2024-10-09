package com.example.koikoi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Dialog d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_signup);
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
        if (itemID==R.id.action_settings)
            OpenSettings();
        if (itemID==R.id.action_exit)
            OpenExit();
        return super.onOptionsItemSelected(item);
    }

    private void OpenExit() {
        this.finishAffinity();
    }

    private void OpenLogin() {
        d.show();
        d.setCancelable(true);
    }

    private void OpenSettings() {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    public void hub(View view) {
        Intent i = new Intent(this, HubActivity.class);
        startActivity(i);
    }
}