package au.edu.jcu.cp3406.stopwatch;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private Handler handler;
    private boolean isRunning;
    private Stopwatch stopwatch;
    private Button toggle;
    private TextView display;
    private int speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        toggle = findViewById(R.id.toggle);

        isRunning = false;
        if (savedInstanceState == null) {
            stopwatch = new Stopwatch();
        } else {
            stopwatch = new Stopwatch(savedInstanceState.getInt("hours"),
                                      savedInstanceState.getInt("minutes"),
                                      savedInstanceState.getInt("seconds"));
            boolean running = savedInstanceState.getBoolean("running");
            speed = savedInstanceState.getInt("speed");
            if (running) {
                enableStopwatch();
            }
        }
        display.setText(stopwatch.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("hours", stopwatch.getHours());
        outState.putInt("minutes", stopwatch.getMinutes());
        outState.putInt("seconds", stopwatch.getSeconds());
        outState.putBoolean("running", isRunning);
        outState.putInt("speed", speed);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isRunning) {
            enableStopwatch();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        disableStopwatch();
    }

    public void settingsClicked(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, SettingsActivity.SETTINGS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SettingsActivity.SETTINGS_REQUEST) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    speed = data.getIntExtra("speed", 500);
                }
            }
        }
    }

    private void enableStopwatch(){
        isRunning = true;
        toggle.setText(R.string.stop);
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    stopwatch.tick();
                    handler.postDelayed(this, speed);
                }
                display.setText(stopwatch.toString());
            }
        });
    }

    private void disableStopwatch(){
        isRunning = false;
        toggle.setText(R.string.start);
    }

    public void buttonClicked(View view) {
        if (!isRunning) {
            enableStopwatch();
        } else {
            disableStopwatch();
        }
    }
}
