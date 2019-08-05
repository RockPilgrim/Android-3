package my.lesson_6.colors;

import android.util.Log;

public class Green {

    public Green() {
        Log.i(this.toString(), "Created");
    }

    public String  show() {
//        Log.i(this.toString(), "green");
        return this.toString() + " green";
    }
}
