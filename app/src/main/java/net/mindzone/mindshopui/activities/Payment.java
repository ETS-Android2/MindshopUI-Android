package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.databinding.ActivityPaymentBinding;

public class Payment extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white, null)));
        getSupportActionBar().setTitle("Payment & Shipping");
        setContentView(R.layout.activity_payment);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.buyNowBTN.setOnClickListener(this::buyNowAction);
    }

    public void buyNowAction(View v) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.BottomSheetDialogTheme);
        View bottomSheetView = LayoutInflater.from(this).inflate(R.layout.confirmation_popup, binding.getRoot().findViewById(R.id.main_container));
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}