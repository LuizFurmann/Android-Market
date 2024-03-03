package com.example.commerceapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.commerceapp.R;
import com.example.commerceapp.view.product.ProductViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    private void setupViewModel(){

    }

    private void setupRecyclerView(){

    }
}