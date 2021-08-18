package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.databinding.ActivitySignBinding;

public class Sign extends AppCompatActivity {

    ActivitySignBinding binding;
    PageState pageState = PageState.signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.eyeBTN.setOnClickListener(this::eyeBTNClicked);
        binding.forgetPassword.setOnClickListener(this::forgotPW);
        setContentView(view);
    }

    public void eyeBTNClicked(View v) {
        if(binding.passwordEditText.getInputType() == 129){
            binding.passwordEditText.setInputType(1);
            binding.eyeBTN.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.eye_nc,0);
        }else{
            binding.eyeBTN.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.eye_crossed,0);
            binding.passwordEditText.setInputType(129);
        }
    }

    public void forgotPW(View v) {
        binding.textViewSign.setText("Forgot Password");
        binding.emailEditText.setHint("Enter E-mail…");
         LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) binding.emailCard.getLayoutParams();
         layoutParams.setMargins(90,100,90,0);
        binding.emailCard.setLayoutParams(layoutParams);
        binding.nameCard.setVisibility(View.GONE);
        binding.passwordCard.setVisibility(View.GONE);
    }
}
enum PageState{
    signIn,
    signUp,
    forgetPW
}