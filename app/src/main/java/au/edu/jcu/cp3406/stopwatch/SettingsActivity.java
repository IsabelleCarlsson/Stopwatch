package au.edu.jcu.cp3406.stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {
    final int SETTINGS_REQUEST = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

//    public void doneClicked(View view) {
//        // Something
//        // here
//
//        Intent intent = new Intent();
//        intent.putExtra("speed", speed);
//        setResult(RESULT_OK, intent);
//        finish();
//    }
}
