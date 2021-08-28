package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.RecyclerViewAdapters.MyRecyclerViewAdapter;
import net.mindzone.mindshopui.RecyclerViewAdapters.OrdersRecylcerViewAdapter;
import net.mindzone.mindshopui.models.OrderModel;

import java.util.ArrayList;

public class Orders extends AppCompatActivity implements  OrdersRecylcerViewAdapter.ItemClickListener {
    OrdersRecylcerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white, null)));
        getSupportActionBar().setTitle("Orders");
        initRecylcerView();
    }

    public void initRecylcerView() {
        ArrayList<OrderModel> Orders = OrderModel.getOrders();
        Orders.addAll(OrderModel.getOrders());
        Orders.addAll(OrderModel.getOrders());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView orders_recyclerView = findViewById(R.id.orders_RecyclerView);
        orders_recyclerView.setLayoutManager(layoutManager);
        adapter = new OrdersRecylcerViewAdapter(this, Orders);
        adapter.setClickListener(this);
        orders_recyclerView.setAdapter(adapter);

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d("Test","Click on Order Item = "+position);
    }
}