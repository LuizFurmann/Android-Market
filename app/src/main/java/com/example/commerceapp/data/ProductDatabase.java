package com.example.commerceapp.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.commerceapp.model.Product;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao studentDao();

    private static volatile ProductDatabase productDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ProductDatabase getDatabase(final Context context) {
        if (productDatabase == null) {
            synchronized (ProductDatabase.class) {
                if (productDatabase == null) {
                    productDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                    ProductDatabase.class, "student_database")
                            .build();
                }
            }
        }
        return productDatabase;
    }
}