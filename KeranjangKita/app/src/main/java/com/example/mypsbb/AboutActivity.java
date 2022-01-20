package com.example.mypsbb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class AboutActivity extends AppCompatActivity {

    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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