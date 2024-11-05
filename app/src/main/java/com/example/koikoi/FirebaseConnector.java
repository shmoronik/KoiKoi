package com.example.koikoi;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseConnector {
    private static FirebaseAuth mAuth;

    public static FirebaseAuth getMAuth(){
        if (mAuth == null)
            mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    public void register(String email, String pass, Context context) {
        getMAuth().createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(context, "user created successfully", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, MainActivity.class));
                }
                else
                    Toast.makeText(context, "Error, " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
