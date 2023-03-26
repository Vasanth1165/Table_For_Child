package com.example.tablesforchild;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tablesforchild.databinding.ActivityAnimationBinding;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.tablesforchild.databinding.ActivityAnimationBinding binding = ActivityAnimationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView imageView=findViewById(R.id.imageView);
        imageView.animate().scaleYBy(1).setDuration(5000);
        imageView.animate().scaleXBy(1).setDuration(5000);
        imageView.animate().alpha(0).setDuration(5000);
        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        });



    }
}