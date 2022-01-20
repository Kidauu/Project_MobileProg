package com.example.mypsbb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<ProductList> mProductList;
    private Context context;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView mProductView;
        public TextView mText1;
        public TextView mText2;

        public CardView itemDetail;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mProductView = itemView.findViewById(R.id.imageBox);
            mText1 = itemView.findViewById(R.id.judulProduk);
            mText2 = itemView.findViewById(R.id.subProduk);
            itemDetail = itemView.findViewById(R.id.itemDetail);

        }
    }

    public ProductAdapter(ArrayList<ProductList> productList, Context context) {
        mProductList = productList;
        this.context = context;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View i = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ProductViewHolder pvh = new ProductViewHolder(i);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        ProductList currentItem = mProductList.get(position);

        holder.mProductView.setImageResource(currentItem.getImageProductResource());
        holder.mText1.setText(currentItem.getTextView1());
        holder.mText2.setText(currentItem.getTextView2());
        holder.itemDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                intent.putExtra("Product", currentItem);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }
}
