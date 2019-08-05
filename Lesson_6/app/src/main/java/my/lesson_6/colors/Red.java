package my.lesson_6.colors;

import android.util.Log;

public class Red {

    public static final String TAG = "Red";


    public Red(Green green) {
        Log.i(TAG, green.show());
    }
}
