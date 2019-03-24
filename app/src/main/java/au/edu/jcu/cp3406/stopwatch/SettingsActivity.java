package au.edu.jcu.cp3406.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    static final int SETTINGS_REQUEST = 1000;
    private static int savedProgress = 500;
    private SeekBar speedSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        speedSlider = findViewById(R.id.speed);

        speedSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // Unused
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this, "Speed set to: " +
                speedSlider.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        savedProgress = speedSlider.getProgress();
    }

    @Override
    protected void onResume() {
        super.onResume();
        speedSlider.setProgress(savedProgress);
    }

    public void doneClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("speed", speedSlider.getProgress());
        setResult(RESULT_OK, intent);
        finish();
    }
}
