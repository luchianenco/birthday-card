package com.luchianenco.happybirthday;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] imageResources = {
            R.drawable.happybirthday,
            R.drawable.happybirthday_1,
            R.drawable.happy
    };

    int activeImage = 0;
    int animationActive = 0;

    public void onImageClick(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.splash);

        activeImage++;
        if (activeImage > (imageResources.length - 1)) {
            activeImage = 0;
        }

        imageView.setImageResource(imageResources[activeImage]);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init typefaces
        Typeface mediumRoboto = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
        Typeface lightRoboto = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");

        // define views by id
        TextView textTextView = (TextView) findViewById(R.id.wishText);
        TextView titleTextView = (TextView) findViewById(R.id.wishTitle);
        LinearLayout iconsLayout = (LinearLayout) findViewById(R.id.icons);

        // apply typefaces to views
        titleTextView.setTypeface(mediumRoboto);
        textTextView.setTypeface(lightRoboto);

        // animate views
        titleTextView.animate().alpha(1f).setDuration(700);
        textTextView.animate().alpha(1f).setDuration(700);
        if (iconsLayout != null) {
            iconsLayout.animate().alpha(1f).setDuration(700);
        }
    }
}
