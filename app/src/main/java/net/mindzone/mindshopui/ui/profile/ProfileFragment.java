package net.mindzone.mindshopui.ui.profile;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import net.mindzone.mindshopui.BaseFragment;
import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.activities.Account;
import net.mindzone.mindshopui.activities.Orders;
import net.mindzone.mindshopui.activities.Settings;
import net.mindzone.mindshopui.activities.Sign;
import net.mindzone.mindshopui.databinding.FragmentProfileBinding;

public class ProfileFragment extends BaseFragment {

    private ProfileViewModel dashboardViewModel;
    private FragmentProfileBinding binding;
    private Intent intent = new Intent();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.accountBtn.setOnClickListener(this::navigateToAccount);
        binding.ordersBtn.setOnClickListener(this::navigateToOrders);
        binding.settingBtn.setOnClickListener(this::navigateToSettings);
        return root;
    }

    public void navigateToAccount(View view) {
        intent.setClass(getActivity(), Account.class);
        getActivity().startActivity(intent);
    }

    public void navigateToOrders(View view) {
        intent.setClass(getActivity(), Orders.class);
        getActivity().startActivity(intent);
    }

    public void navigateToSettings(View view) {
        intent.setClass(getActivity(), Settings.class);
        getActivity().startActivity(intent);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}