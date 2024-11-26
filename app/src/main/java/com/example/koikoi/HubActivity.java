package com.example.koikoi;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HubActivity extends AppCompatActivity {
    Dialog b; Dialog d; Toast toast; InputValidation inputVal; FirebaseConnector fCon;
    EditText emailInput; EditText passInput;
    String email; String pass;
    //SharedPreferences sharedPreferences = getSharedPreferences("GenPrefs", MODE_PRIVATE);
    //SharedPreferences.Editor editor = sharedPreferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        // login page dialog
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_login);
        // input validator setup
        inputVal = new InputValidation();
        // user input fields setup
        emailInput = d.findViewById(R.id.editEmail);
        passInput = d.findViewById(R.id.editPass);
        // friends list dialog
        b = new Dialog(this);
        b.setContentView(R.layout.dialog_friends);
        // friends list recycler
        ArrayList<Friend> friends = new ArrayList<>();
        for(int i=1; i<15; i++){
            friends.add(new Friend("Friend "+i, (int)(Math.random()*100), (int)(Math.random()*100)));
        }
        RecyclerView recyclerView = b.findViewById(R.id.recyclerViewFriends);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        FriendsAdapter friendsAdapter = new FriendsAdapter(friends);
        recyclerView.setAdapter(friendsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_login).setVisible(fCon.isUser());
        menu.findItem(R.id.action_user).setVisible(!fCon.isUser());
        return true;
    }*/

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

    /*public void login(View view) {
        // user input values setup
        email = emailInput.getText().toString();
        pass = passInput.getText().toString();
        // user input value checks
        if (!inputVal.isVUser(email, pass)) {
            fCon.login(email, pass, this);
        }
        else
            d.hide();
    }*/

    public void Flist(View view) {
        b.show();
        b.setCancelable(true);
    }

    public void OpenGame(View view) {
        startActivity(new Intent(this, GameActivity.class));
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

    private void OpenSettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    private void OpenUser() {
        startActivity(new Intent(this, UserActivity.class));
    }

    public void signup(View view) {
        startActivity(new Intent(this, SignupActivity.class));
    }

    public void Invited(View view) {
        // WIP add username of invite target
        toast = Toast.makeText(this, "friend invited", Toast.LENGTH_LONG);
        toast.show();
    }
}