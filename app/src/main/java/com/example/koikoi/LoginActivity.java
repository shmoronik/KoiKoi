package com.example.koikoi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public boolean isUser() {
        // code will check if username and password are in the user database
        return true;
    }

    public void login(View view) {
        Intent i;
        i = new Intent(this, HubActivity.class);
        if (isUser()) {
            startActivity(i);
        }
    }

    public void signup(View view) {
        Intent i;
        i = new Intent(this, SignupActivity.class);
        startActivity(i);
    }

    public void back(View view) {
        Intent i;
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
