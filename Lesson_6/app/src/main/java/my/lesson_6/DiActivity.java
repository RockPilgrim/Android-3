package my.lesson_6;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import my.lesson_6.colors.Green;
import my.lesson_6.colors.Red;

public class DiActivity extends AppCompatActivity {

    public static final String TAG = "DiActivity";
    private Green green;
    private Red red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init();
    }

    private void init() {
        green = new Green();
        red = new Red(green);
        Log.i(TAG, green.show());
    }
}
