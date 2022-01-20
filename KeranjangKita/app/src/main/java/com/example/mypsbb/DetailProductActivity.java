package com.example.mypsbb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailProductActivity extends AppCompatActivity {

    ProductList selectedProduct;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        name = findViewById(R.id.name);

        Intent intent = getIntent();
        if (intent.hasExtra("Product")) {
            selectedProduct = (ProductList)intent.getSerializableExtra("Product");
            name.setText(selectedProduct.getTextView1());
        }
    }
}