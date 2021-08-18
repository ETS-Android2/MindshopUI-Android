package net.mindzone.mindshopui.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import net.mindzone.mindshopui.BaseFragment;
import net.mindzone.mindshopui.activities.Sign;
import net.mindzone.mindshopui.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.btnMain.setOnClickListener(this::btnClicked);
        return root;
    }

    public void btnClicked(View v) {
        Log.d("Test","Moving to Signin");
        Intent intent = new Intent();
        intent.setClass(getActivity(), Sign.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}