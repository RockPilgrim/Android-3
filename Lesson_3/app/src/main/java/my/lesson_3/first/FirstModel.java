package my.lesson_3.first;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class FirstModel {

    public static final String TAG = "Model";
    private StringBuffer modelString;
    private ArrayList<String> messageList;

    public FirstModel() {
        messageList = new ArrayList<>();
        messageList.add("-Hello!");
        messageList.add("-How are you?");
        messageList.add("-Buy magazine");
        messageList.add("-Plz");
        messageList.add("-Buy");
        messageList.add("-Please buy it!");
        messageList.add("-Buy this magazine");
        messageList.add("-Are u still here?");
        messageList.add("-So BUY!");

        modelString = new StringBuffer();
    }

    public Observable<String> getServer() {
        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                int i = 0;
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    emitter.onNext(messageList.get(i));
                    i++;
                    if (i >= messageList.size()) {
                        i = 2;
                    }
                }
            } catch (InterruptedException e) {
                Log.e(TAG, "Interrupted");
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }
}
