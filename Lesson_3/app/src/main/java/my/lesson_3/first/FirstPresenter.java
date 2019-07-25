package my.lesson_3.first;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class FirstPresenter {

    private static final String TAG = "FirstPresenter";
    private OnSetText activity;
    private Observable<String> observable;
    private Disposable disposable;
    private StringBuffer stringBuffer;

    private FirstModel model;


    public FirstPresenter(OnSetText activity) {
        this.activity = activity;
        stringBuffer = new StringBuffer();
        model = new FirstModel();
        observable = model.getServer();
    }

    public void subscribe() {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
                    stringBuffer.append(s + "\n");
                    activity.setText(stringBuffer.toString());
                    Log.i(TAG, "onNext " + Thread.currentThread());
                }, e -> {
                    Log.i(TAG, e.getMessage());
                }, () -> {
                    activity.setText("Done");
                }, disposable1 -> {
                    disposable = disposable1;
                }
        );
    }

    public void unsubscribe() {
        disposable.dispose();
    }
}
