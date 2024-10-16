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
    Dialog b; Dialog d;
    //SharedPreferences sharedPreferences = getSharedPreferences("GenPrefs", MODE_PRIVATE);
    //SharedPreferences.Editor editor = sharedPreferences.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        // login page dialog
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_login);
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
        /*if (sharedPreferences.getString("Uname", "").isEmpty()) {
            menu.findItem(R.id.action_login).setVisible(true);
            menu.findItem(R.id.action_user).setVisible(false);
        }
        else {
            menu.findItem(R.id.action_login).setVisible(false);
            menu.findItem(R.id.action_user).setVisible(true);
        }*/
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

    public void login(View view) {
        //editor.putString("Uname", ((EditText)d.findViewById(R.id.editUname)).getText().toString());
        d.hide();
    }

    public void Flist(View view) {
        b.show();
        b.setCancelable(true);
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

    private void OpenUser() {
        Intent i = new Intent(this, UserActivity.class);
        startActivity(i);
    }

    private void Invited(View view) {
        CharSequence text = " invited";
        int duration = Toast.LENGTH_LONG;
        Toast t = Toast.makeText(this, text, duration);
        t.show();
    }
}