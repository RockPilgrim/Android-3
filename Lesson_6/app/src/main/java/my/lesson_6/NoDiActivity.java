package my.lesson_6;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import my.lesson_6.colors.Green;
import my.lesson_6.colors.White;

public class NoDiActivity extends AppCompatActivity {

    private Green green;
    private White white;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init();
    }

    private void init() {
        green = new Green();
        white = new White();
        Log.i("NoDiActivity", green.show());
    }
}
