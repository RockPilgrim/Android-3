package my.lesson_4;

import android.util.Log;

import com.squareup.picasso.Picasso;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class Presenter {

    public static final String TAG = "Presenter";
    private ISetFace setFace;
    private ServerConnector connector;

    public Presenter(ISetFace setFace) {
        this.setFace = setFace;
        connector = new ServerConnector();
    }

    public void theyNeedJake() {
        Observable<UserGithub> observable = connector.connectToServer("JakeWharton");

        Disposable trouble = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            sendFace(user.getFaceWhartonUrl());
        }, throwable -> {
            Log.e(TAG, "Trouble");
        });

    }

    public void sendFace(String url) {
        Picasso.get()
                .load(url)
                .into(setFace.getFaceWhartonToSet());
    }

}
