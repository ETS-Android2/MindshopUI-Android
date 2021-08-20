package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.databinding.ActivityOnboardingBinding;
import net.mindzone.mindshopui.databinding.ActivitySignBinding;

public class onBoarding extends AppCompatActivity {

    ActivityOnboardingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white, null)));
        getSupportActionBar().setTitle("");
        setContentView(view);
    }
}