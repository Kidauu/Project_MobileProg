package com.example.mypsbb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class ProfileUser extends AppCompatActivity {

    private TextView profileText;
    private EditText profileEdit;
    private Button profileButton;
    private Button profileSaveButton;
    private Switch switchProfile;

    public static final String SHARED_PREFERENCES = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCHPROBE = "switchProbe";

    private String teksto;
    private boolean toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        profileText = (TextView) findViewById(R.id.judulNama);
        profileEdit = (EditText) findViewById(R.id.editNama);
        profileButton = (Button) findViewById(R.id.simpanNama);
        profileSaveButton = (Button) findViewById(R.id.simpanData);
        switchProfile = (Switch) findViewById(R.id.switchProbe);

        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileText.setText(profileEdit.getText().toString());
            }
        });

        profileSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifikasiData();
            }
        });

        loadNama();
        updatePenyimpanan();
    }

    public void verifikasiData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, profileText.getText().toString());
        editor.putBoolean(SWITCHPROBE, switchProfile.isChecked());

        editor.apply();

        Toast.makeText(this, "Data Anda telah tersimpan!", Toast.LENGTH_SHORT).show();
    }

    public void loadNama() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        teksto = sharedPreferences.getString(TEXT, "");
        toggleButton = sharedPreferences.getBoolean(SWITCHPROBE, false);
    }

    public void updatePenyimpanan() {
        profileText.setText(teksto);
        switchProfile.setChecked(toggleButton);
    }

}