package net.mindzone.mindshopui.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.models.Product;

import java.util.List;


public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsRecyclerViewAdapter.ViewHolder> {

    private List<Product> Products;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public ProductsRecyclerViewAdapter(Context context, List<Product> products) {
        this.mInflater = LayoutInflater.from(context);
        this.Products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Product productItem = Products.get(position);
        holder.productPrice.setText(productItem.price+"");
        holder.price_afterDiscount.setText(productItem.price_afterDiscount+"");
        holder.discount.setText(productItem.discount + "%");
        holder.title.setText(productItem.title);
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productPrice, price_afterDiscount, discount, title;

        ViewHolder(View itemView) {
            super(itemView);
            productPrice = itemView.findViewById(R.id.product_price);
            price_afterDiscount = itemView.findViewById(R.id.product_price_afterdiscount);
            discount = itemView.findViewById(R.id.discount_Value);
            title = itemView.findViewById(R.id.product_name);
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