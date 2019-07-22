package my.lesson_2rxjava.third;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ThirdPresenter {

    private static final String TAG = "ThirdPresenter";
    private OnSetText activity;
    private Observable stringObservable;
    private Disposable disposable;
    private StringBuffer modelString;


    public ThirdPresenter(OnSetText activity) {
        this.activity = activity;
        stringObservable = ThirdPresenter.this.getObservable();
        modelString = new StringBuffer();
    }

    public void subscribe() {
        stringObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                ThirdPresenter.this.disposable = disposable;
            }

            @Override
            public void onNext(String text) {
                activity.setText(text);
                Log.i(TAG, "onNext " + Thread.currentThread());
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, e.getMessage());
            }

            @Override
            public void onComplete() {
                activity.setText("Done");

            }
        });
    }

    private Observable<String> getObservable() {
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 1; i <= 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        modelString.append("-Buy magazine\n");
                        Log.i(TAG, "Magazine say: " +"-Buy magazine "+ Thread.currentThread().getName() );
                        emitter.onNext(modelString.toString());
                    }
                } catch (InterruptedException e) {
                    Log.e(TAG, "Interrupted");
                }
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }

    public void unsubscribe() {
        disposable.dispose();
    }
}
