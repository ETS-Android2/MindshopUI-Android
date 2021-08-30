package net.mindzone.mindshopui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.RecyclerViewAdapters.CartRecyclerViewAdapter;
import net.mindzone.mindshopui.databinding.ActivityMycartBinding;
import net.mindzone.mindshopui.models.MyCartItems;


public class MyCart extends AppCompatActivity implements CartRecyclerViewAdapter.ItemClickListener {
    CartRecyclerViewAdapter cartRecyclerViewAdapter;
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
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            int position = viewHolder.getAdapterPosition();
            Toast.makeText(MyCart.this, "The following Item has been removed " + myCartItems.get(position).title, Toast.LENGTH_SHORT).show();
            myCartItems.remove(position);
            cartRecyclerViewAdapter.notifyDataSetChanged();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            Drawable mIcon = getResources().getDrawable(R.drawable.trash, null);
            ColorDrawable
                    mBackground = new ColorDrawable(getResources().getColor(R.color._E41A4A, null));
            View itemView = viewHolder.itemView;
            if (dX < 0) {
                mIcon.setBounds(itemView.getRight() + ((int) dX) > 860 ? itemView.getRight() + ((int) dX) : 860,
                        itemView.getTop() + 120, itemView.getRight(), itemView.getBottom() - 120);
                mBackground.setBounds(itemView.getRight() + ((int) dX),
                        itemView.getTop(), itemView.getRight(), itemView.getBottom());
            } else { // view is unSwiped
                mIcon.setBounds(0, 0, 0, 0);
                mBackground.setBounds(0, 0, 0, 0);
            }
            mBackground.draw(c);
            mIcon.draw(c);
        }
    };

    private void constructRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        orders_recyclerView = binding.myCartRecyclerView;
        orders_recyclerView.setLayoutManager(layoutManager);

        cartRecyclerViewAdapter = new CartRecyclerViewAdapter(this, myCartItems);
        cartRecyclerViewAdapter.setClickListener(this);
        new ItemTouchHelper(simpleItemTouchCallback).attachToRecyclerView(orders_recyclerView);
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

