package my.lesson_7.mockito;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class Presenter {


    public static final String TAG = "Presenter";

    public String getUserName() {
        final String[] login = new String[1];
        Disposable disposable = ServerConnector.requestServer("JakeWharton")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.i(TAG, user.getLogin());
                    login[0] = user.getLogin();
                }, throwable -> Log.e(TAG, "Error"));
        return login[0];
    }
}
