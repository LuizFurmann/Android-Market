package com.example.commerceapp.view.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.commerceapp.R;
import com.example.commerceapp.databinding.ActivityProductDetailsBinding;
import com.example.commerceapp.model.Product;

public class ProductDetailsActivity extends AppCompatActivity {

    private ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
            }
        });
    }

    private void saveProduct(){
        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        Integer productId = 0;
        String name = binding.etName.getText().toString();
        String price = binding.etPrice.getText().toString();
        String stock = binding.etStock.getText().toString();

        Product product = new Product(name, price, stock);

        viewModel.insertProduct(product);
    }
}