package com.example.mymathassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ActivityGoodJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_good_job);

        ImageButton exitButton = findViewById(R.id.exit_button);

        Animation testAnimation = AnimationUtils.loadAnimation(this, R.anim.test_animation);

        ImageView imageViewResult = findViewById(R.id.imageViewResult2);

        imageViewResult.setAnimation(testAnimation);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }

        });

    }

    public void openActivity () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}