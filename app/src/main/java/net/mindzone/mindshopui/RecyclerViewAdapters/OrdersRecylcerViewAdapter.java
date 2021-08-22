package net.mindzone.mindshopui.RecyclerViewAdapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.models.OrderModel;

import java.util.List;
import java.util.Random;


public class OrdersRecylcerViewAdapter extends RecyclerView.Adapter<OrdersRecylcerViewAdapter.ViewHolder> {

    private List<OrderModel> Orders;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public OrdersRecylcerViewAdapter(Context context, List<OrderModel> orders) {
        this.mInflater = LayoutInflater.from(context);
        this.Orders = orders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.order_itemlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        OrderModel orderItem = Orders.get(position);
        holder.order_id.setText("Order " + orderItem.id);
        holder.order_state.setText(orderItem.orderStatus);
        holder.pendingTag.setVisibility(orderItem.isPending ? View.VISIBLE : View.GONE);
        String colorString = randomColorHex();
        holder.order_circle.setCardBackgroundColor(Color.parseColor(colorString));
    }

    private String randomColorHex() {
        Random random = new Random();
        int nextInt = random.nextInt(0xffffff + 1);
        return String.format("#%06x", nextInt);
    }

    @Override
    public int getItemCount() {
        return Orders.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView order_id, order_state;
        RelativeLayout pendingTag;
        CardView order_circle;

        ViewHolder(View itemView) {
            super(itemView);
            order_id = itemView.findViewById(R.id.order_id);
            order_state = itemView.findViewById(R.id.order_state);
            pendingTag = itemView.findViewById(R.id.pendingTag);
            order_circle = itemView.findViewById(R.id.order_circle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}