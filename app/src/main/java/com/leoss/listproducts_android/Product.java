package com.leoss.listproducts_android;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String description;

    private String addedAt;

    private String supplier;

    private String barcode;

    public Product(String name, String description, String addedAt, String supplier, String barcode) {
        this.name = name;
        this.description = description;
        this.addedAt = addedAt;
        this.supplier = supplier;
        this.barcode = barcode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getBarcode() {
        return barcode;
    }
}
