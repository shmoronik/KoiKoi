package com.example.koikoi;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HubActivity extends AppCompatActivity implements IFirebase{
    Dialog b; Dialog d; Dialog l; InputValidation inputVal; FirebaseConnector fCon;
    EditText emailInput; EditText passInput; EditText lNameInput; EditText lPassInput;
    String email; String pass; User cUser; String lName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        fCon = new FirebaseConnector();
        fCon.readUData(this);
        fCon.readLobbies(this);
        // login page dialog
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_login);
        // input validator setup
        inputVal = new InputValidation();
        // user input fields setup
        emailInput = d.findViewById(R.id.editEmail);
        passInput = d.findViewById(R.id.editPass);
        // lobby dialog
        b = new Dialog(this);
        b.setContentView(R.layout.dialog_lobbies);
        l = new Dialog(this);
        l.setContentView(R.layout.dialog_lobbysetup);
        // lobby input fields setup
        lNameInput = l.findViewById(R.id.editTextLobbyName);
        lPassInput = l.findViewById(R.id.editTextLobbyPass);
        //
        RecyclerView recyclerView = b.findViewById(R.id.recyclerViewLobbies);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(fCon.isUser())
            getMenuInflater().inflate(R.menu.menu_user, menu);
        else
            getMenuInflater().inflate(R.menu.menu_guest, menu);
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
        String lID = Integer.toString(new Random().nextInt(999999));
        startActivity(new Intent(this, GameActivity.class).putExtra("key", lID));
        GameState gs = new GameState("cUser.getuName()", "privatetest", lID);
        fCon.createLobby(gs, this);
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

    public void createLobby(View view) {
        b.hide();
        l.show();
        l.setCancelable(true);
    }

    @Override
    public void uDataCallback(User user) {
        cUser = user;
    }

    @Override
    public void lobbyDataCallback(ArrayList<GameState> lobbies) {
        RecyclerView recyclerView = b.findViewById(R.id.recyclerViewLobbies);
        LobbyAdapter lobbyAdapter = new LobbyAdapter(lobbies);
        recyclerView.setAdapter(lobbyAdapter);
    }

    public void lobbyUpload(View view) {
        lName = lNameInput.getText().toString();
        String lID = Integer.toString(new Random().nextInt(999999));
        GameState gs = new GameState(cUser.getuName() ,lName, lID);
        gs.RoundSetup();
        fCon.createLobby(gs, this);
    }
}