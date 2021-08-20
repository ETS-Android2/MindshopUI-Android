package net.mindzone.mindshopui.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import net.mindzone.mindshopui.BaseFragment;
import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.activities.Sign;
import net.mindzone.mindshopui.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setHasOptionsMenu(true);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.homepage_menuicon, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bellBTN:
                Log.d("Test", "Bell Icon clicked");
                return true;
            case R.id.cartBTN:
                Intent intent = new Intent();
                intent.setClass(getActivity(), Sign.class);
                getActivity().startActivity(intent);
                Log.d("Test", "Cart Icon clicked");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}