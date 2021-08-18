package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import net.mindzone.mindshopui.databinding.ActivitySignBinding;

public class Sign extends AppCompatActivity {

    ActivitySignBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}