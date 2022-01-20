package com.example.mypsbb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonShop;
    private Button buttonProfile;
    private Button buttonAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShop = findViewById(R.id.maubelanja);
        buttonShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });

        buttonProfile = findViewById(R.id.editNamaPSBB);
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileActivity();
            }
        });

        buttonAdmin = findViewById(R.id.adminMenu);
        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAdminActivity();
            }
        });
    }

    public void openHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void openProfileActivity() {
        Intent intent = new Intent (this, ProfileUser.class);
        startActivity(intent);
    }

    public void openAdminActivity() {
        Intent intent = new Intent (this, AdminActivity.class);
        startActivity(intent);
    }

}