package my.lesson_6.colors;

import android.util.Log;

public class White {

    public static final String TAG = "White";
    private Green green;

    public White() {
        green = new Green();
        Log.i(TAG, green.show());
    }
}
