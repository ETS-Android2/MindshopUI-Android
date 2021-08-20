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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.mindzone.mindshopui.BaseFragment;
import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.activities.Sign;
import net.mindzone.mindshopui.constants.MyRecyclerViewAdapter;
import net.mindzone.mindshopui.databinding.FragmentHomeBinding;
import net.mindzone.mindshopui.models.Product;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements MyRecyclerViewAdapter.ItemClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    MyRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setHasOptionsMenu(true);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ArrayList<String> Products = (new Product()).getBTNProducts();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = binding.productsRecylerView;
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(getContext(), Products);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onItemClick(View view, int position) {
        view.getBackground().setTint(view.getResources().getColor(R.color.black, null));
        Log.d("Test", "The selected Item " + adapter.getItem(position));
    }
}