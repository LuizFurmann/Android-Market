package com.example.commerceapp.view.product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.commerceapp.R;
import com.example.commerceapp.model.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.StudentViewHolder> {
    ArrayList<Product> productArrayList;
    public Context context;

    public ProductAdapter(ArrayList<Product> students) {
        this.productArrayList = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_product, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Product currentPosition = productArrayList.get(position);

        holder.productName.setText(currentPosition.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context, ProductDetailsActivity.class);
                myIntent.putExtra("Product", currentPosition);
                context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView productName;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }

        private void findViews() {
            productName = itemView.findViewById(R.id.tvProductName);
        }
    }
}
