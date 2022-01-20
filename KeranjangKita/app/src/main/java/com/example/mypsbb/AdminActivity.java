package com.example.mypsbb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    private Button createDatabase;
    private Button editDatabase;
    private Button deleteDatabase;
    private Button findDatabase;
    private Button adminLeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        createDatabase = findViewById(R.id.buttonCreate);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openToastActivity();
            }
        });

        editDatabase = findViewById(R.id.buttonEdit);
        editDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openToastActivity();
            }
        });

        deleteDatabase = findViewById(R.id.buttonDelete);
        deleteDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openToastActivity();
            }
        });

        findDatabase = findViewById(R.id.buttonCari);
        findDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openToastActivity();
            }
        });

        adminLeave = findViewById(R.id.buttonLeave);
        adminLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

    public void openToastActivity() {
        Toast.makeText(this, "SQL.function.db in Maintenance", Toast.LENGTH_SHORT).show();
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}