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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HubActivity extends AppCompatActivity {
    Dialog d;
    Globals g = (Globals)getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
        // friends list dialog
        d = new Dialog(this);
        d.setContentView(R.layout.dialog_friends);
        // friends list recycler
        ArrayList<Friend> friends = new ArrayList<>();
        for(int i=1; i<15; i++){
            friends.add(new Friend("Friend "+i, (int)(Math.random()*100), (int)(Math.random()*100)));
        }
        RecyclerView recyclerView = d.findViewById(R.id.recyclerViewFriends);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID= item.getItemId();
        if (itemID==R.id.action_user)
            OpenLogin();
        if (itemID==R.id.action_settings)
            OpenSettings();
        if (itemID==R.id.action_exit)
            OpenExit();
        return super.onOptionsItemSelected(item);
    }

    public void Flist(View view) {
        d.show();
        d.setCancelable(true);
    }

    private void OpenExit() {
        this.finishAffinity();
    }

    private void OpenLogin() {
        Intent i;
        i=new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    private void OpenSettings() {
        Intent i;
        i=new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    private void Invited(View view) {
        CharSequence text = " invited";
        int duration = Toast.LENGTH_SHORT;
        Toast t;
        t=Toast.makeText(this, text, duration);
        t.show();
    }

}