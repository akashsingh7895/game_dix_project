package com.avssolutiion.autoheadshot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.avssolutiion.autoheadshot.databinding.ActivityActiviteDoneBinding;

public class ActiviteDoneActivity extends AppCompatActivity {

    ActivityActiviteDoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityActiviteDoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActiviteDoneActivity.this,MainActivity.class));
            }
        });



    }
}