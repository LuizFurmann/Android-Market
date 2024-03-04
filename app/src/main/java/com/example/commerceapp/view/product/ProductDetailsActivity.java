package com.example.commerceapp.view.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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

        updateView();
        eventClickListener();
    }

    private void eventClickListener(){
        binding.btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
            }
        });
    }

    private void updateView(){
        Intent intent = getIntent();
        if (intent.getParcelableExtra("Product") != null) {
            Product product = (Product) getIntent().getParcelableExtra("Product");
            Product data = product;

            binding.etName.setText(data.getName());
            binding.etPrice.setText(data.getPrice());
            binding.etStock.setText(data.getStock());


//            if (intent.getParcelableExtra("imgProfile") != null) {
//                Owner profile = (Owner) getIntent().getParcelableExtra("imgProfile");
//                Owner image = profile;
//                Glide.with(binding.imgProfile)
//                        .load(profile.getAvatar_url())
//                        .into(binding.imgProfile);
//            }
        }
    }

    private void saveProduct(){
        ProductViewModel viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        Intent intent = getIntent();
        if (intent.getParcelableExtra("Product") != null) {
            Product product = (Product) getIntent().getParcelableExtra("Product");

            String name = binding.etName.getText().toString();
            String price = binding.etPrice.getText().toString();
            String stock = binding.etStock.getText().toString();

            Product model = new Product(name, price, stock);
            model.setProductId(product.getProductId());

            viewModel.update(model);
        }else{
            String name = binding.etName.getText().toString();
            String price = binding.etPrice.getText().toString();
            String stock = binding.etStock.getText().toString();

            Product product = new Product(name, price, stock);
            viewModel.insertProduct(product);
        }

    }
}