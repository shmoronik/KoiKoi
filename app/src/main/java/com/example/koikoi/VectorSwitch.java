package com.example.koikoi;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.VectorDrawable;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

public class VectorSwitch {

    public void customVector(ImageView imageView, int vectorResId) {
        // Load the original LayerDrawable
        LayerDrawable originalDrawable = (LayerDrawable) ContextCompat.getDrawable(imageView.getContext(), R.drawable.card_front);

        // Create a new independent instance
        LayerDrawable drawableCopy = (LayerDrawable) originalDrawable.getConstantState().newDrawable().mutate();

        // Find and replace the vector layer
        Drawable vectorDrawable = ContextCompat.getDrawable(imageView.getContext(), vectorResId);
        if (vectorDrawable != null) {
            drawableCopy.setDrawableByLayerId(R.id.CardImage, vectorDrawable);
        }

        // Apply the modified LayerDrawable to the ImageView
        imageView.setImageDrawable(drawableCopy);
    }
}
