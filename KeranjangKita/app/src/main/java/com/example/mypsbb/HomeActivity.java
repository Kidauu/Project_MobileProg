package com.example.mypsbb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView clRecyclerView;
    private RecyclerView.Adapter clAdapter;
    private RecyclerView.LayoutManager clLayoutManager;

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ArrayList<ProductList> productList = new ArrayList<>();
        productList.add(new ProductList(R.drawable.ic_photo, "Sabun Mandi", "IDR10,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Pasta Gigi", "IDR27,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Shampoo", "IDR35,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Handuk Mandi", "IDR12,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Indomie Goreng Box", "IDR100,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Indomie Kuah Box", "IDR100,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Sikat Toilet", "IDR5,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Sabun Cuci Muka", "IDR45,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Charger Type-C", "IDR35,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "USB Flashdrive 2GB", "IDR30,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Payung", "IDR25,000"));
        productList.add(new ProductList(R.drawable.ic_photo, "Hand Sanitizer", "IDR9,000"));

        clRecyclerView = findViewById(R.id.recyclerViewProduct);
        clRecyclerView.setHasFixedSize(true);
        clLayoutManager = new LinearLayoutManager(this);
        clAdapter = new ProductAdapter(productList, this);

        clRecyclerView.setLayoutManager(clLayoutManager);
        clRecyclerView.setAdapter(clAdapter);

        initNavigationDrawer();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initNavigationDrawer(){
        DrawerLayout drawerLayout = findViewById(R.id.drawerNavLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, (R.string.Open), (R.string.Close));
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        NavigationView navView = findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.hamItem1:{
                    Intent intent = new Intent (this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                }
                case R.id.hamItem2:{
                    Intent intent = new Intent (this, ProfileUser.class);
                    startActivity(intent);
                    finish();
                    break;
                }
                case R.id.hamItem3:{
                    Toast.makeText(this, "Show Cart Function", Toast.LENGTH_LONG).show();
                    break;
                }
                case R.id.hamItem4:{
                    Intent intent = new Intent (this, AboutActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                }
                case R.id.hamItem5:{
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                }
            }
            return true;
        });

    }
}