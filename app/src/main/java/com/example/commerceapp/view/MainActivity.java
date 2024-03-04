package com.example.commerceapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.commerceapp.R;
import com.example.commerceapp.databinding.ActivityMainBinding;
import com.example.commerceapp.model.Product;
import com.example.commerceapp.view.product.ProductAdapter;
import com.example.commerceapp.view.product.ProductDetailsActivity;
import com.example.commerceapp.view.product.ProductViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private RecyclerView recyclerView;
    private ProductViewModel productViewModel;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        setupViewModel();
        binding.btnNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupViewModel(){
        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        viewModel.getAllProducts().observe(this, data -> {
            if (data != null) {
                ProductAdapter adapter = new ProductAdapter((ArrayList<Product>) data);
                adapter.context = this;
                binding.rvProducts.setLayoutManager(new LinearLayoutManager(this));
                binding.rvProducts.setAdapter(adapter);
            }
        });
    }

//    private void setupRecyclerView(){
//        RecyclerView recyclerView = findViewById(R.id.rvProducts);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        productAdapter = new ProductAdapter();
//        productAdapter.context = this;
//        recyclerView.setAdapter(usuarioAdapter);
//
//    }
}