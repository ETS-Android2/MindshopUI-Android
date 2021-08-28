package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.RecyclerViewAdapters.CartRecyclerViewAdapter;
import net.mindzone.mindshopui.RecyclerViewAdapters.MyRecyclerViewAdapter;
import net.mindzone.mindshopui.RecyclerViewAdapters.OrdersRecylcerViewAdapter;
import net.mindzone.mindshopui.models.Category;
import net.mindzone.mindshopui.models.MyCartItems;
import net.mindzone.mindshopui.models.OrderModel;

import java.util.ArrayList;

public class MyCart extends AppCompatActivity implements CartRecyclerViewAdapter.ItemClickListener {

    CartRecyclerViewAdapter cartRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white, null)));
        getSupportActionBar().setTitle("My Cart");
        setContentView(R.layout.activity_mycart);
        ArrayList<OrderModel> Orders = OrderModel.getOrders();
        ArrayList<MyCartItems> myCartItems = MyCartItems.getItemsCart();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView orders_recyclerView = findViewById(R.id.myCartRecyclerView);
        orders_recyclerView.setLayoutManager(layoutManager);

        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(this, myCartItems);
        cartRecyclerViewAdapter.setClickListener(this);
        orders_recyclerView.setAdapter(cartRecyclerViewAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}