package my.lesson_3.Second;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import my.lesson_3.first.OnSetText;

public class SecondPresenter {

    private OnSetText activity;

    private Single<String> singlable;

    private StringBuffer stringBuffer;
    private SecondModel model;

    public static final String TAG = "Second presenter";


    public SecondPresenter(OnSetText activity) {
        this.activity = activity;
        stringBuffer = new StringBuffer();
        model = new SecondModel();
        singlable = model.getServer();
    }

    public void subscribe() {
        singlable.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            stringBuffer.append(string).append("\n");
            activity.setText(stringBuffer.toString());
            Log.i(TAG, "onSuccess" + Thread.currentThread());
        });
    }
}
