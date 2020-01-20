package com.leoss.listproducts_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.leoss.listproducts_android.EXTRA_NAME";
    public static final String EXTRA_DESCRIPTION = "com.leoss.listproducts_android.EXTRA_DESCRIPTION";
    public static final String EXTRA_BARCODE = "com.leoss.listproducts_android.EXTRA_BARCODE";
    public static final String EXTRA_SUPPLIER = "com.leoss.listproducts_android.EXTRA_SUPPLIER";

    private EditText editTextName;
    private EditText editTextDescription;
    private EditText editTextBarcode;
    private EditText editTextSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        editTextName = findViewById(R.id.edit_product_name);
        editTextDescription = findViewById(R.id.edit_product_description);
        editTextBarcode = findViewById(R.id.edit_product_barcode);
        editTextSupplier = findViewById(R.id.edit_product_supplier);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add product");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_product:
                saveProduct();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveProduct() {
        String name = editTextName.getText().toString();
        String description = editTextDescription.getText().toString();
        String barcode = editTextBarcode.getText().toString();
        String supplier = editTextSupplier.getText().toString();

        if (name.trim().isEmpty()
                || description.trim().isEmpty()
                || barcode.trim().isEmpty()
                || supplier.trim().isEmpty()) {
            Toast.makeText(this, "Please provide all data", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_BARCODE, barcode);
        data.putExtra(EXTRA_SUPPLIER, supplier);

        setResult(RESULT_OK, data);
        finish();
    }
}
