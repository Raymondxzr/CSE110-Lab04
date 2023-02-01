package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CounterActivity extends AppCompatActivity {
    private int maxCount;
    private ExecutorService backgroundThreadExecutor = Executors.newSingleThreadExecutor();
    private Future<Void> future;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        Bundle extras = getIntent().getExtras();
        this.maxCount = extras.getInt("max_count");

        TextView counterView = findViewById(R.id.counter_view);
        counterView.setText(String.valueOf(this.maxCount));
    }

    public void OnGoBackClicked(View view) {
        finish();
    }
}