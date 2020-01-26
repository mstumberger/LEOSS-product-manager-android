package com.leoss.listproducts_android;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Product.class, version = 1)
public abstract class ProductsDatabase extends RoomDatabase {
    private static ProductsDatabase instance;

    public abstract ProductDao productDao();

    public static synchronized ProductsDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProductsDatabase.class, "products_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
