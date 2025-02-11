package com.example.koikoi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class EncodeBitmap {
    public  String convertTo64Base(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();
        return Base64.getEncoder().encodeToString(data);
    }

    public Bitmap convertfrom64Base(String base64Code) {
        byte[] decodedString = Base64.getDecoder().decode(base64Code);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
