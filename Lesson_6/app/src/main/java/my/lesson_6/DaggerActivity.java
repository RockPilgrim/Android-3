package my.lesson_6;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import my.lesson_6.colors.Green;
import my.lesson_6.R;
import my.lesson_6.colors.Red;
import my.lesson_6.dagger.app.App;

public class DaggerActivity extends AppCompatActivity {

    public static final String TAG = "DaggerActivity";
    @Inject
    public Green green;
    @Inject
    public Red red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        App.getAppComponent().inject(this);
        Log.i(TAG, green.show());
    }
}
