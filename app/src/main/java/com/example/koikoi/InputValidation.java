package com.example.koikoi;

public class InputValidation {
    // username check
    public boolean isVuName(String uName) {
        return uName != null && uName.length() >= 3;
    }

    // password check
    public boolean isVPass(String pass) {
        return pass != null && pass.length() >= 6;
    }

    // email check
    public boolean isVEmail(String email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}