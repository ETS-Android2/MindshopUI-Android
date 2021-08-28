package net.mindzone.mindshopui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;



import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.databinding.ActivitySignBinding;

public class Sign extends AppCompatActivity {

    ActivitySignBinding binding;
    PageState pageState = PageState.signIn;
    DisplayMetrics displayMetrics = new DisplayMetrics();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.signin_action_btn, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) binding.emailCard.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 20, layoutParams.rightMargin, layoutParams.bottomMargin);
        binding.emailCard.setLayoutParams(layoutParams);
        if (R.id.acion_btn == item.getItemId()) {
            if (pageState.equals(PageState.signIn)) {
                pageState = PageState.signUp;
                item.setTitle("SIGN UP");
                binding.textViewSign.setText("Sign In");
                setCardsVisibility(View.GONE, View.VISIBLE, View.VISIBLE);
            } else {
                pageState = PageState.signIn;
                item.setTitle("SIGN IN");
                binding.textViewSign.setText("Sign Up");
                setCardsVisibility(View.VISIBLE, View.VISIBLE, View.VISIBLE);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        binding = ActivitySignBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color._E41A4A, null)));
        getSupportActionBar().setTitle("");
        binding.eyeBTN.setOnClickListener(this::eyeBTNClicked);
        binding.topElement.getLayoutParams().height = height / 5;
        binding.forgetPassword.setOnClickListener(this::forgotPW);
        binding.btnMain.setOnClickListener(this::siginBTNClicked);
        setContentView(view);
    }

    public void eyeBTNClicked(View v) {
        if (binding.passwordEditText.getInputType() == 129) {
            binding.passwordEditText.setInputType(1);
            binding.eyeBTN.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_nc, 0);
        } else {
            binding.eyeBTN.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eye_crossed, 0);
            binding.passwordEditText.setInputType(129);
        }
    }

    public void siginBTNClicked(View v) {
        Log.d("Test", "Sign btn clicked");
    }

    public void forgotPW(View v) {
        binding.textViewSign.setText("Forgot Password");
        binding.emailEditText.setHint("Enter E-mail…");
        binding.btnMain.setText("Send Password");
        pageState = PageState.forgetPW;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) binding.emailCard.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, 100, layoutParams.rightMargin, layoutParams.bottomMargin);
        binding.emailCard.setLayoutParams(layoutParams);
        setCardsVisibility(View.GONE, View.GONE, View.VISIBLE);
    }

    public void setCardsVisibility(Integer nameCard, Integer passwordCard, Integer emailCard) {
        binding.nameCard.setVisibility(nameCard);
        binding.passwordCard.setVisibility(passwordCard);
        binding.emailCard.setVisibility(emailCard);
    }
}

enum PageState {
    signIn,
    signUp,
    forgetPW
}