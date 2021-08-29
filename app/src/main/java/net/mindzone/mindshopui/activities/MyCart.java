package net.mindzone.mindshopui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.RecyclerViewAdapters.CartRecyclerViewAdapter;
import net.mindzone.mindshopui.databinding.ActivityMycartBinding;
import net.mindzone.mindshopui.models.MyCartItems;


public class MyCart extends AppCompatActivity implements CartRecyclerViewAdapter.ItemClickListener {

    CartRecyclerViewAdapter cartRecyclerViewAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView orders_recyclerView;
    ActivityMycartBinding binding;
    ArrayList<MyCartItems> myCartItems = MyCartItems.getItemsCart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white, null)));
        getSupportActionBar().setTitle("My Cart");
        binding = ActivityMycartBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.checkoutBTN.setOnClickListener(this::goToPaymentPage);
        setContentView(view);
        constructRecyclerView();
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
//        itemTouchHelper.attachToRecyclerView(orders_recyclerView);
    }

//    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
//
//            final int position = viewHolder.getAdapterPosition();
//
//            switch (direction) {
//                case ItemTouchHelper.LEFT:
//                    myCartItems.remove(position);
//                    cartRecyclerViewAdapter.notifyItemRemoved(position);
//                    break;
//            }
//        }
//
//        @Override
//        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
//            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
//                    .addBackgroundColor(ContextCompat.getColor(MyCart.this, R.color._FBBA32))
//                    .addActionIcon(R.drawable.trash)
//                    .create()
//                    .decorate();
//
//            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//        }
//    };


    private void constructRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        orders_recyclerView = binding.myCartRecyclerView;
        swipeRefreshLayout = binding.swipeRefreshLayout;
        orders_recyclerView.setLayoutManager(layoutManager);

        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(this, myCartItems);
        cartRecyclerViewAdapter.setClickListener(this);
        orders_recyclerView.setAdapter(cartRecyclerViewAdapter);
    }

    public void goToPaymentPage(View v) {
        Intent intent = new Intent(MyCart.this, Payment.class);
        this.startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d("Test", "Click on the following item in cart " + myCartItems.get(position).toString());
    }
}

