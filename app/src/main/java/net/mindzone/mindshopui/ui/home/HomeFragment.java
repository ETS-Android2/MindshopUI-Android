package net.mindzone.mindshopui.ui.home;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import net.mindzone.mindshopui.BaseFragment;
import net.mindzone.mindshopui.Popups.ItemPopupBottomSheet;
import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.RecyclerViewAdapters.ProductsRecyclerViewAdapter;
import net.mindzone.mindshopui.activities.MyCart;
import net.mindzone.mindshopui.activities.Sign;
import net.mindzone.mindshopui.RecyclerViewAdapters.MyRecyclerViewAdapter;
import net.mindzone.mindshopui.databinding.FragmentHomeBinding;
import net.mindzone.mindshopui.models.Category;
import net.mindzone.mindshopui.models.Product;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements MyRecyclerViewAdapter.ItemClickListener, ProductsRecyclerViewAdapter.ItemClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    ProductsRecyclerViewAdapter adapter_salesItems;
    ArrayList<String> categories = Category.getCategories();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        setHasOptionsMenu(true);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.chartBtn.setOnClickListener(this::cartBTNClicked);
        ConstructRecyclerViews();
        return root;
    }

    public void ConstructRecyclerViews() {

        //        Construction of First RecyclerView which contain the buttons
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = binding.productsRecylerView;
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(getContext(), categories);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

//        Construction of Second RecyclerView which are the sales discount cards
        ArrayList<Product> products_sale = Product.getProducts();
        LinearLayoutManager layoutManagerRC2
                = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView_SalesItems = binding.itemsRecylerView;
        recyclerView_SalesItems.setLayoutManager(layoutManagerRC2);
        adapter_salesItems = new ProductsRecyclerViewAdapter(getContext(), products_sale);
        adapter_salesItems.setClickListener(this);
        recyclerView_SalesItems.setAdapter(adapter_salesItems);
    }

    public void cartBTNClicked(View v) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), MyCart.class);
        getActivity().startActivity(intent);
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
        if (view.getId() == R.id.btn_forProducts) {
            MaterialButton selectedBTN = (MaterialButton) recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.btn_forProducts);
            for (int i = 0; i < categories.size(); i++) {
                MaterialButton button_List = (MaterialButton) recyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.btn_forProducts);
                if (button_List.getText().equals(selectedBTN.getText())) {
                    selectedBTN.setBackgroundColor(getResources().getColor(R.color.black, null));
                    selectedBTN.setTextColor(getResources().getColor(R.color.white, null));
                } else {
                    button_List.setBackgroundColor(getResources().getColor(R.color.white, null));
                    button_List.setTextColor(getResources().getColor(R.color.black, null));
                }
            }
        } else {
            ItemPopupBottomSheet itemPopupBottomSheet = new ItemPopupBottomSheet();
            itemPopupBottomSheet.show(getChildFragmentManager(), "itemPopupBottomSheet");
        }
    }
}