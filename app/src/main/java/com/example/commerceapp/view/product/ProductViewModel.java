package com.example.commerceapp.view.product;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.commerceapp.model.Product;
import com.example.commerceapp.network.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository productRepository;
    private final LiveData<List<Product>> listLiveData;

    public ProductViewModel(Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        listLiveData = productRepository.getAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {
        return listLiveData;
    }

    public void insertProduct(Product student) {
        productRepository.insertProduct(student);
    }
}