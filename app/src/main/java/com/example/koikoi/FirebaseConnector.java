package com.example.koikoi;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConnector {
    private static FirebaseAuth mAuth;
    private static FirebaseDatabase dBase;
    private static DatabaseReference dRef;

    public static FirebaseAuth getMAuth(){
        if (mAuth == null)
            mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    public static FirebaseDatabase getdBase() {
        if(dBase == null) {
            dBase = FirebaseDatabase.getInstance("https://koikoi-4d98d-default-rtdb.firebaseio.com");
        }
        return dBase;
    }

    public static DatabaseReference getReference(String ref) {
        dRef = getdBase().getReference(ref);
        return dRef;
    }

    public void login(String email, String pass, Context context) {
        getMAuth().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "Signed in", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, context.getClass()));
                }
                else
                    Toast.makeText(context, "username or password are incorrect", Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean isUser() {
        return getMAuth().getCurrentUser() != null;
    }

    public void logout() {
        getMAuth().signOut();
    }

    public void saveRBase(User user, Context context) {
        // thank you random student from a few years ago
        user.setuId(getMAuth().getCurrentUser().getUid());
        getReference("users").child(user.getuId()).setValue(user);
        Toast.makeText(context, "user created successfully", Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, MainActivity.class));
    }

    public void register(String email, String pass, User user, Context context) {
        getMAuth().createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    saveRBase(user, context);
                }
                else
                    Toast.makeText(context, "Error, " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
