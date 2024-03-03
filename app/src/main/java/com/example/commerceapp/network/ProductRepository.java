package com.example.commerceapp.network;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.commerceapp.data.ProductDao;
import com.example.commerceapp.data.ProductDatabase;
import com.example.commerceapp.model.Product;

import java.util.List;

public class ProductRepository {
    ProductDatabase productDatabase;
    ProductDao productDao;
    private LiveData<List<Product>> productList;

    public ProductRepository(Application application) {
        productDatabase = ProductDatabase.getDatabase(application);
        productDao = productDatabase.studentDao();
        productList = productDao.getProduct();
    }

    public void insertStudent(Product product) {
        ProductDatabase.databaseWriteExecutor.execute(() -> productDao.insert(product));
    }

    public LiveData<List<Product>> getAllProducts() {
        return productList;
    }
}

