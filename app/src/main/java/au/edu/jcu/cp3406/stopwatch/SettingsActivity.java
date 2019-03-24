package au.edu.jcu.cp3406.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    static final int SETTINGS_REQUEST = 1000;
    SeekBar simpleSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        simpleSeekBar = findViewById(R.id.speed);

        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // Auto-generated method
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this, "Seek bar progress is:" +
                simpleSeekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void doneClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("speed", simpleSeekBar.getProgress());
        setResult(RESULT_OK, intent);
        finish();
    }
}
