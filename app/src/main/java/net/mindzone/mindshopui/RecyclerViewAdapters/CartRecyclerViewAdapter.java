package net.mindzone.mindshopui.RecyclerViewAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import net.mindzone.mindshopui.R;
import net.mindzone.mindshopui.models.MyCartItems;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    private List<MyCartItems> myCartItems;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public CartRecyclerViewAdapter(Context context, List<MyCartItems> myCartItems) {
        this.mInflater = LayoutInflater.from(context);
        this.myCartItems = myCartItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.mycart_rcitems, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyCartItems item = myCartItems.get(position);
        holder.itemTitle.setText(item.title);
        holder.itemColor.setText("Color : " + item.color);
        holder.itemSize.setText("Size :" + item.size);
        holder.itemPrice.setText("$" + item.price);
        holder.itemCount.setText(item.count + "");
        holder.subTotal.setText("Sub Total : $" + item.count * item.price);

        holder.addIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.count++;
                holder.itemCount.setText(item.count + "");
                holder.subTotal.setText("Sub Total : $" + item.count * item.price);
            }
        });
        holder.minusIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.count > 0) {
                    item.count--;
                    holder.itemCount.setText(item.count + "");
                    holder.subTotal.setText("Sub Total : $" + item.count * item.price);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myCartItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemTitle, itemColor, itemSize, itemPrice, subTotal, itemCount;
        MaterialButton minusIcon, addIcon;

        ViewHolder(View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemColor = itemView.findViewById(R.id.itemColor);
            itemSize = itemView.findViewById(R.id.itemSize);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            subTotal = itemView.findViewById(R.id.subTotal);
            itemCount = itemView.findViewById(R.id.itemCount);
            minusIcon = itemView.findViewById(R.id.minusIcon);
            addIcon = itemView.findViewById(R.id.addIcon);
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