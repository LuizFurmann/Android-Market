package com.example.commerceapp.network;

import android.app.Application;
import android.os.AsyncTask;

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

    public void insertProduct(Product product) {
        ProductDatabase.databaseWriteExecutor.execute(() -> productDao.insert(product));
    }

    // creating a method to update data in database.
    public void update(Product product) {
        new UpdateCourseAsyncTask(productDao).execute(product);
    }

    // creating a method to delete the data in our database.
    public void delete(Product product) {
        new DeleteCourseAsyncTask(productDao).execute(product);
    }

    // we are creating a async task method to update our course.
    private static class UpdateCourseAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao productDao;
        private UpdateCourseAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... models) {
            // below line is use to update
            // our modal in dao.
            productDao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete course.
    private static class DeleteCourseAsyncTask extends AsyncTask<Product, Void, Void> {
        private ProductDao productDao;

        private DeleteCourseAsyncTask(ProductDao productDao) {
            this.productDao = productDao;
        }

        @Override
        protected Void doInBackground(Product... models) {
            productDao.delete(models[0]);
            return null;
        }
    }

    public LiveData<List<Product>> getAllProducts() {
        return productList;
    }
}

