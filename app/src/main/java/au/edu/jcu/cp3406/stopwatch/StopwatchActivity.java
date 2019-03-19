package au.edu.jcu.cp3406.stopwatch;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {
    private Handler handler;
    private boolean isRunning;
    Stopwatch stopwatch = new Stopwatch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        display = findViewById(R.id.display);
//        toggle = findViewById(R.id.toggle);
//
//        isRunning = false;
//        if (savedInstanceState == null) {
//            stopwatch = new Stopwatch();
//        } else {
//            stopwatch = // Something here
//            boolean running = savedInstanceState.getBoolean("running");
//            if (running) {
//                enableStopwatch();
//            }
//            // Something here
//        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("stopwatch", stopwatch.toString());
        outState.putBoolean("running", isRunning);
    }

//    public void settingsClicked(View view) {
//        Intent intent = // Something here
//        startActivityForResult(intent, SettingsActivity.SETTING_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == SettingsActivity.SETTINGS_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                if (data != null) {
//                    speed = data.getIntExtra("speed", 1000);
//                }
//            }
//        }
//    }

    private void enableStopwatch(){
        isRunning = true;
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (isRunning) {
                    stopwatch.tick();

                    handler.postDelayed(this, 1);
                }
                ((TextView) findViewById(R.id.display)).setText(stopwatch.toString());
            }
        });

    }

    private void disableStopwatch(){
        isRunning = false;
    }

    public void buttonClicked(View view) {
        if (!isRunning) {
            enableStopwatch();
        } else {
            disableStopwatch();
        }
    }
}
