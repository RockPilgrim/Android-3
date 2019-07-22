package my.lesson_2rxjava.second;

import android.util.Log;

import java.util.concurrent.TimeUnit;

public class SecondSubscriber implements ISecondObserver {

    public static final String TAG = "Subber";

    @Override
    public void getSpam(String name, int num) throws InterruptedException {

        Log.i(TAG, "Magazine: " + name + " customer: " + num +" "+ Thread.currentThread());
        TimeUnit.SECONDS.sleep(1);

    }
}
