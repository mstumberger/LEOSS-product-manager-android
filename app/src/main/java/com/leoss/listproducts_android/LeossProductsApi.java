package com.leoss.listproducts_android;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeossProductsApi {

    @GET("api/products")
    Call<List<Product>> getProducts();
}
