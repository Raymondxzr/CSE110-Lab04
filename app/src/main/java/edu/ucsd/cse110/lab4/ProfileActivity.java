package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    public void ExitProfileClicked(View view) {
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();

//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.clear();
//        editor.apply();

    }

    public void loadProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        TextView myTextView = (TextView) findViewById(R.id.editTextTextName);
        String storedName = preferences.getString("Name","Name");
        TextView myTextViewStatus = (TextView) findViewById(R.id.editTextTextStatus);
        String storedStatus = preferences.getString("Status", "Status");
        myTextView.setText(storedName);
        myTextViewStatus.setText(storedStatus);

    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView myTextView = (TextView) findViewById(R.id.editTextTextName);
        editor.putString("Name", myTextView.getText().toString());
        TextView myTextViewStatus = (TextView) findViewById(R.id.editTextTextStatus);
        editor.putString("Status", myTextViewStatus.getText().toString());
        editor.apply();
    }

//    public void onExitClicked(View view) {
//        finish();
//    }
}