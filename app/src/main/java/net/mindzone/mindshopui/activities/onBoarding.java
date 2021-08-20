package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.databinding.ActivityOnboardingBinding;
import net.mindzone.mindshopui.databinding.ActivitySignBinding;

public class onBoarding extends AppCompatActivity {

    ActivityOnboardingBinding binding;
    private Integer currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        init();
        setContentView(view);
    }

    protected void init() {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white, null)));
        getSupportActionBar().setTitle("");
        binding.skipBtn.setOnClickListener(this::SkipAction);
        binding.nextBtn.setOnClickListener(this::NextAction);

    }

    public void SkipAction(View v) {
        Log.d("Trace", "Skip btn clicked");
    }

    public void NextAction(View v) {
        if (currentPage < binding.bubblesID.getChildCount()) {
            for (int i = 0; i < binding.bubblesID.getChildCount(); i++) {
                binding.bubblesID.getChildAt(i).setBackgroundResource(i==currentPage?R.drawable.layout_roundercorner:R.drawable.circle);
                binding.bubblesID.getChildAt(i).getLayoutParams().width = (i==currentPage? 60:20);
                binding.bubblesID.getChildAt(i).getBackground().setTint(v.getResources().getColor(i==currentPage?R.color._E41A4A:R.color._C4C4C4, null));
            }
            currentPage++;
        }
    }
}