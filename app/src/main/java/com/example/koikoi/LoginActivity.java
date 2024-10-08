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

    Button btnback;
    EditText editText;
    Globals g = (Globals) getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnback = (Button) findViewById(R.id.btnBack);
        editText = (EditText) findViewById(R.id.editText);
        btnback.setText(getString(R.string.underlined_dynamic_text, "return"));
    }

    public boolean isUser() {
        // code will check if username and password are in the user database
        return true;
    }

    public void login(View view) {
        Intent i;
        i = new Intent(this, HubActivity.class);
        boolean isUser = isUser();
        if (isUser) {
            g.setUName(editText.getText().toString());
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
